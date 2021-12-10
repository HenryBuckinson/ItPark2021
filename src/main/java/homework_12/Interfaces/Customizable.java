package homework_12.Interfaces;

import homework_12.Classes.StringMatrix;
import homework_12.Exceptions.MyArrayDataException;
import homework_12.Exceptions.MyArraySizeException;

public interface Customizable {

    default int countIntegerElements(StringMatrix strMatrix) throws MyArraySizeException, MyArrayDataException {
        return 1;
    }
}
