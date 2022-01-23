package homework_19;

import homework_19.annotations.Blocked;
import homework_19.base.Accountable;
import homework_19.base.IndividualPerson;
import homework_19.base.JuridicalPerson;
import homework_19.exceptions.NoPermissionException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.*;
import java.math.BigDecimal;


public class MainProgram {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println();
        System.out.println("----------------------Reflection with JuridicalPerson----------------------");
        Class<JuridicalPerson> juridicalPersonClass = JuridicalPerson.class;//Создание объекта типа Class
        Field[] declaredFields = juridicalPersonClass.getDeclaredFields();
        System.out.println("Получение объявленных полей объекта:");
        printInfo(declaredFields);
        Method[] declaredMethods = juridicalPersonClass.getDeclaredMethods();
        System.out.println("Получение объявленных методов объекта:");
        printInfo(declaredMethods);
        Constructor<?>[] constructors = juridicalPersonClass.getConstructors();
        System.out.println("Получение конструктора объекта:");
        printInfo(constructors);
        Class<? super JuridicalPerson> superclass = juridicalPersonClass.getSuperclass();
        System.out.println("Получение базового класса объекта:");
        System.out.println(superclass + "\n");
        JuridicalPerson juridicalPerson = (JuridicalPerson) constructors[0].newInstance(new BigDecimal(200_000), "James", "Bond", "MI7");

        System.out.println("Создан объект: " + juridicalPerson);
        Field organizationPrivateField = declaredFields[3];
        organizationPrivateField.setAccessible(true);
        organizationPrivateField.set(juridicalPerson, "MI6");
        System.out.println("Объект после изменения закрытого поля: " + juridicalPerson);
        Method deposit = juridicalPersonClass.getDeclaredMethod("depositForJuridicalPersons", BigDecimal.class, Boolean.class);
        deposit.invoke(juridicalPerson, new BigDecimal(3_000), true);
        System.out.println("Объект после изменения закрытого поля: " + juridicalPerson);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("------------------------Reflection with IndividualPerson------------------------");
        Class<IndividualPerson> individualPersonClass = IndividualPerson.class;
        Field[] declaredFields1 = individualPersonClass.getDeclaredFields();
        System.out.println("Получение объявленных полей объекта:");
        printInfo(declaredFields1);
        Method[] declaredMethods1 = individualPersonClass.getDeclaredMethods();
        System.out.println("Получение объявленных методов объекта:");
        printInfo(declaredMethods1);
        Constructor<?>[] constructors1 = individualPersonClass.getConstructors();
        System.out.println("Получение конструктора объекта:");
        printInfo(constructors);
        Class<? super IndividualPerson> superclass1 = individualPersonClass.getSuperclass();
        System.out.println("Получение базового класса объекта:");
        System.out.println(superclass1 + "\n");
        IndividualPerson individualPerson = (IndividualPerson) constructors1[0].newInstance(new BigDecimal(19_000), "Mister", "Bean");
        System.out.println("Создан объект: " + individualPerson);
        Field moneyPrivateField = declaredFields1[0];
        moneyPrivateField.setAccessible(true);
        moneyPrivateField.set(individualPerson, new BigDecimal(20_000));
        System.out.println("Объект после изменения закрытого поля: " + individualPerson);
        System.out.println();
        System.out.println("----------------------Dynamical Proxy with JuridicalPerson----------------------");
        Accountable accountable = (Accountable) Proxy.newProxyInstance(Accountable.class.getClassLoader(),
                new Class[]{Accountable.class},
                new ProxyBlocked(juridicalPerson));

        accountable.depositForJuridicalPersons(new BigDecimal(100_000), true);
        accountable.withdrawForJuridicalPersons(new BigDecimal(50_000), null);
        System.out.println("Объект прокси: " + accountable);
        System.out.println("Исходный объект: " + juridicalPerson);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("----------------------Dynamical Proxy with IndividualPerson---------------------");
        Accountable accountable1 = (Accountable) Proxy.newProxyInstance(Accountable.class.getClassLoader(),
                new Class[]{Accountable.class},
                new ProxyBlocked(individualPerson));
        try {
            accountable1.depositForIndividualPersons(new BigDecimal(5_000));
            accountable1.withdrawForIndividualPersons(new BigDecimal(2_000));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Объект прокси: " + accountable1);
        System.out.println("Исходный объект: " + individualPerson);
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void printInfo(Object[] array) {
        for (Object item : array) {
            System.out.println(item);
        }
        System.out.println();
    }

    @AllArgsConstructor
    public static class ProxyBlocked implements InvocationHandler {

        private final Accountable origin;

        @Override
        @SneakyThrows
        public Object invoke(Object proxy, Method method, Object[] args) {
            Object result = null;
            try {
                Method declaredMethod = origin.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
                Parameter[] parameters = declaredMethod.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    Parameter parameter = parameters[i];
                    Blocked annotation = parameter.getAnnotation(Blocked.class);
                    if (args[i] == null) {
                        args[i] = annotation.flag();
                    }
                }
                Blocked annotation = declaredMethod.getAnnotation(Blocked.class);
                if (annotation != null) {
                    throw new NoPermissionException("No permission");
//                    System.out.println("В доступе операции отказано!");
//                    return null;
                }
                result = declaredMethod.invoke(origin, args);

            } catch (Exception e) {
                System.out.println(e.getCause().getMessage());
            }
            return result;
        }
    }
}
