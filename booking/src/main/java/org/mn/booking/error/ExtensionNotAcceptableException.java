package org.mn.booking.error;

public class ExtensionNotAcceptableException extends RuntimeException {

    public ExtensionNotAcceptableException(String extension) {
        super("." + extension + " ");
    }

}
