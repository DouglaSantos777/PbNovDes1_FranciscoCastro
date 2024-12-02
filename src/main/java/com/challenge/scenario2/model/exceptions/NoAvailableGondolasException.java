package com.challenge.scenario2.model.exceptions;

public class NoAvailableGondolasException extends Exception {
    private static final long serialVersionUID = 1L;

    public NoAvailableGondolasException(String msg) {
        super(msg);
    }
}