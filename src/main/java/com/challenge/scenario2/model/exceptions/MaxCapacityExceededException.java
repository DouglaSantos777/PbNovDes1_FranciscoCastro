package com.challenge.scenario2.model.exceptions;

public class MaxCapacityExceededException extends Exception{
    private static final long serialVersionUID = 1L;

    public MaxCapacityExceededException(String msg) {
        super(msg);
    }
}
