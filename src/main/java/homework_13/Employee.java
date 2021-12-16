package homework_13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class Employee {
    private String fullName;
    private int uniqNumber;
    private int workExperience;
    private static Collection<Integer> sequenceOfUniqNumber = new ArrayList<>();//уникальные табельные номера работников

    public Employee(String fullName, int workExperience) {
        this.fullName = fullName;
        this.workExperience = workExperience;
        uniqNumberSetter();
    }

    /**
     * Метод присваивает уникальные номера для объектов класса Employee.
     */
    private void uniqNumberSetter() {
        int k = new Random().nextInt(0, 1001);
        if (sequenceOfUniqNumber.contains(k)) {
            uniqNumberSetter();
        } else {
            uniqNumber = k;
            sequenceOfUniqNumber.add(k);
        }
    }

    @Override
    public String toString() {
        return fullName + " - Таб.№" + getUniqNumber();
    }

    public int getUniqNumber() {
        return uniqNumber;
    }

    public int getWorkExperience() {
        return workExperience;
    }

}
