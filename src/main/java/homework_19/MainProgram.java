package homework_19;

import homework_19.Annotations.Blocked;
import homework_19.Base.Accountable;
import homework_19.Base.JuridicalPerson;
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
        Method deposit = juridicalPersonClass.getDeclaredMethod("deposit", BigDecimal.class, Boolean.class);
        deposit.invoke(juridicalPerson, new BigDecimal(3_000), true);
        System.out.println("Объект после изменения закрытого поля: " + juridicalPerson);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println();
        System.out.println("----------------------Dynamical Proxy with JuridicalPerson----------------------");
        Accountable accountable = (Accountable) Proxy.newProxyInstance(Accountable.class.getClassLoader(),
                new Class[]{Accountable.class},
                new ProxyBlocked(juridicalPerson));

        accountable.deposit(new BigDecimal(100_000), null);
//        accountable.withdraw(new BigDecimal(50_000),null);
        System.out.println("Объект прокси: " + accountable);
        System.out.println("Исходный объект: " + juridicalPerson);
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
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Method declaredMethod = origin.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes());
            Parameter[] parameters = declaredMethod.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                Blocked annotation = parameter.getAnnotation(Blocked.class);
                if (args[i] == null) {
                    args[i] = annotation.flag();
                }
            }
            return declaredMethod.invoke(origin, args);
        }
    }
}
