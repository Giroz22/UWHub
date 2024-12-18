package com.waveghost.uwhub.utils.exceptions;

public class IdNotFoundException extends RuntimeException{
    private final static String ERROR_MESSAGE = "Not found %s with id: %s";

    public IdNotFoundException(String entity, String id){
        super(String.format(ERROR_MESSAGE, entity, id));
    }
}
