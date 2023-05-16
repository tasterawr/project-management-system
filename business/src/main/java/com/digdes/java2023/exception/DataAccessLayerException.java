package com.digdes.java2023.exception;

public class DataAccessLayerException extends Exception{
    public DataAccessLayerException(String message) {
        super(message);
    }

    public DataAccessLayerException(String message, Exception cause) {
        super(message, cause);
    }
}
