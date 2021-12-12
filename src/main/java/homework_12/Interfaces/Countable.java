package homework_12.Interfaces;

import homework_12.Exceptions.MyArrayDataException;
import homework_12.Exceptions.MyArraySizeException;

public interface Countable {

    int countIntegerElements() throws MyArraySizeException, MyArrayDataException;
}
