package homework_13;

import java.util.*;

public class MainProgram {
    public static void main(String[] args) {
        Employee obj1 = new Employee("Nikola Tesla", 2);
        Employee obj2 = new Employee("James Maxwell", 7);
        Employee obj3 = new Employee("Maria Curie", 5);
        Employee obj4 = new Employee("Thomas Edison", 5);
        Employee obj5 = new Employee("Max Planck", 8);
        Employee obj6 = new Employee("Albert Einstein", 9);

        Collection<Employee> workersList = new ArrayList<>();

        workersList.add(obj1);
        workersList.add(obj2);
        workersList.add(obj3);
        workersList.add(obj4);
        workersList.add(obj5);
        workersList.add(obj6);

        printEmployeeIterator(workersList, 5);
        System.out.println();
        System.out.println(workersList);
        System.out.println();

        deleteOddsEmployeeFromTheEnd(workersList);
        //deletesEvenEmployeeFromTheEnd(workersList);

        System.out.println(workersList);

    }

    /**
     * @param employees      коллекция типа Employee.
     * @param workExperience опыт работы в годах по григорианскому или юлианскому календарю.
     */
    static void printEmployeeIterator(Collection<Employee> employees, int workExperience) {
        System.out.println("Трудовой стаж в " + workExperience + " лет(года) имеют следующие работники:");
        for (Iterator<Employee> items = employees.iterator(); items.hasNext(); ) {
            Employee peoples = items.next();
            if (peoples.getWorkExperience() == workExperience) {
                System.out.println(peoples);
            }
        }
    }

    /**
     * @param employees коллекция типа Employee.
     *                  Метод удаляет в коллекции объекты с нечетным индексом, запуская ListIterator с конца этой коллекции.
     */
    static void deleteOddsEmployeeFromTheEnd(Collection<Employee> employees) {
        ArrayList<Employee> peoples = (ArrayList<Employee>) employees;//работников преобразую в ArrayList чтобы добраться до ListIterator()
        for (ListIterator<Employee> candidate = peoples.listIterator(peoples.size()); candidate.hasPrevious(); ) {
            Employee people = candidate.previous();
            if (candidate.nextIndex() % 2 != 0) {
                candidate.remove();
            }
        }
    }

    /**
     * @param employees коллекция типа Employee.
     *                  Метод удаляет в коллекции объекты с четным индексом, запуская ListIterator с конца этой коллекции.
     */
    static void deletesEvenEmployeeFromTheEnd(Collection<Employee> employees) {
        ArrayList<Employee> peoples = (ArrayList<Employee>) employees;//работников преобразую в ArrayList чтобы добраться до ListIterator()
        for (ListIterator<Employee> candidate = peoples.listIterator(peoples.size()); candidate.hasPrevious(); ) {
            Employee people = candidate.previous();
            if (candidate.nextIndex() % 2 == 0) {
                candidate.remove();
            }
        }
    }
}
