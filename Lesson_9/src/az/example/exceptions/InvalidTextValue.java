package az.example.exceptions;

public class InvalidTextValue extends RuntimeException {


    public InvalidTextValue() {
    }

    public InvalidTextValue(String message) {
        super(message);
    }

    public InvalidTextValue(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidTextValue(Throwable cause) {
        super(cause);
    }
}
