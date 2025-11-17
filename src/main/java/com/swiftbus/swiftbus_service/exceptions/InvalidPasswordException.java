package com.swiftbus.swiftbus_service.exceptions;


public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}
