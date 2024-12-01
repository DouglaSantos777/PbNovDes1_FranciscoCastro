package com.challenge.scenario2.models.exceptions;

public class InvalidBoardingAttemptException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidBoardingAttemptException(String message) {
        super(message);
    }
}