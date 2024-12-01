package com.challenge.scenario2.models.exceptions;

public class NoAvailableGondolaException extends Exception {
    private static final long serialVersionUID = 1L;

    public NoAvailableGondolaException(String message) {
        super(message);
    }
}