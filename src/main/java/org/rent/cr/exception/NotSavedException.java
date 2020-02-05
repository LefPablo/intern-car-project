package org.rent.cr.exception;

public class NotSavedException extends Exception {
    public NotSavedException(String entity) {
        super(entity + " not saved!");
    }
}
