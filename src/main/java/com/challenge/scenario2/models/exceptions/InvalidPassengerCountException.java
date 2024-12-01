package com.challenge.scenario2.models.exceptions;

public class InvalidPassengerCountException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidPassengerCountException(String msg) {
        super(msg);
    }
}
