package org.mn.msaccount.error;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(Class<?> clazz, Object id) {
        super(clazz.getSimpleName() + " with " + id + " not found!");
    }
}
