package com.challenge.scenario2.model.exceptions;

public class NoAvailableGondolaException extends Exception {
    private static final long serialVersionUID = 1L;

    public NoAvailableGondolaException(String msg) {
        super(msg);
    }
}