package com.digdes.java2023.exception;

public class BusinessLogicException extends Exception{
    public BusinessLogicException(String message) {
        super(message);
    }

    public BusinessLogicException(String message, Throwable cause) {
        super(message, cause);
    }
}
