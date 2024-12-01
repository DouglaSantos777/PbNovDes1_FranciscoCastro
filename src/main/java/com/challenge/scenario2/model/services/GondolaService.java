package com.challenge.scenario2.model.services;

import com.challenge.scenario2.model.entities.Person;
import com.challenge.scenario2.model.entities.Child;
import com.challenge.scenario2.model.entities.Adult;
import com.challenge.scenario2.model.exceptions.InvalidBoardingAttemptException;

public class GondolaService {
    private final BoardValidationService boardValidationService;

    public GondolaService(BoardValidationService boardValidationService) {
        this.boardValidationService = boardValidationService;
    }

    public boolean isValidBoarding(Person... seats) throws InvalidBoardingAttemptException {
        if (seats.length == 1) {
            return isValidIndividualBoard(seats[0]);
        } else if (seats.length == 2) {
            return isValidDoubleBoard(seats[0], seats[1]);
        }
        throw new InvalidBoardingAttemptException("Invalid number of passengers.");
    }

    private boolean isValidDoubleBoard(Person seat1, Person seat2) throws InvalidBoardingAttemptException {
        if (seat1 instanceof Child) {
            return validateChildWithAdult((Child) seat1, seat2);
        } else if (seat2 instanceof Child) {
            return validateChildWithAdult((Child) seat2, seat1);
        }
        return true;
    }

    private boolean isValidIndividualBoard(Person seat) throws InvalidBoardingAttemptException {
        if (seat instanceof Child && !boardValidationService.canChildBoard((Child) seat)) {
            throw new InvalidBoardingAttemptException("Child must be accompanied by an adult or meet the minimum age.");
        }
        return true;
    }

    private boolean validateChildWithAdult(Child child, Person adult) throws InvalidBoardingAttemptException {
        if (adult instanceof Adult && child.getParent() == adult) {
            return true;
        }
        throw new InvalidBoardingAttemptException("Child must be accompanied by an adult or meet the minimum age.");
    }
}
