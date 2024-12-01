package com.challenge.scenario2.model.exceptions;

public class ChildNotAccompaniedByParentException extends Exception {
    private static final long serialVersionUID = 1L;

    public ChildNotAccompaniedByParentException(String msg) {
        super(msg);
    }
}
