package com.challenge.scenario2.models.exceptions;

public class InvalidGondolaNumberException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidGondolaNumberException(String msg) {
        super(msg);
    }
}