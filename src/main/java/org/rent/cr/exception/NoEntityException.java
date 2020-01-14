package org.rent.cr.exception;

public class NoEntityException extends Exception {
    public NoEntityException(int id, String entity){
        super("Entity " + entity + " by id " + id + " was not found");
    }
}
