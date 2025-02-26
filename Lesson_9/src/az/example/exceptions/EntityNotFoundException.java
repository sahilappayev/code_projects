package az.example.exceptions;

public class EntityNotFoundException extends RuntimeException {


    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Class entityClass, Object id) {
        super("Entity " + entityClass.getName() + " with id " + id + " not found!");
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
