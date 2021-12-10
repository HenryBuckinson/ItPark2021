package homework_12.Exceptions;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException() {
    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
