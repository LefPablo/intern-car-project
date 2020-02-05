package org.rent.cr.exception;

public class NotUpdatedException extends Exception {
    public NotUpdatedException(String entity) {
        super(entity + " not updated!");
    }
}
