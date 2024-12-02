package com.challenge.scenario2.model.services;

import com.challenge.scenario2.model.entities.Person;
import com.challenge.scenario2.model.entities.Child;
import com.challenge.scenario2.model.entities.Adult;
import com.challenge.scenario2.model.exceptions.InvalidBoardingAttemptException;
import com.challenge.scenario2.model.exceptions.ChildNotAccompaniedByParentException;

public class GondolaBoardService {
    private final ChildBoardService boardValidationService;

    public GondolaBoardService(ChildBoardService childValidationService) {
        this.boardValidationService = childValidationService;
    }

    public boolean isValidBoarding(Person... seats) throws InvalidBoardingAttemptException, ChildNotAccompaniedByParentException {
        if (seats.length == 1) {
            return isValidIndividualBoard(seats[0]);
        } else if (seats.length == 2) {
            return isValidDoubleBoard(seats[0], seats[1]);
        }
        throw new InvalidBoardingAttemptException("Invalid number of passengers.");
    }

    private boolean isValidDoubleBoard(Person seat1, Person seat2) throws ChildNotAccompaniedByParentException {
        if (seat1 instanceof Child) {
            return validateChildWithAdult((Child) seat1, seat2);
        } else if (seat2 instanceof Child) {
            return validateChildWithAdult((Child) seat2, seat1);
        }
        return true;
    }

    private boolean isValidIndividualBoard(Person seat) throws InvalidBoardingAttemptException {
        if (seat instanceof Child && !boardValidationService.canChildBoard((Child) seat)) {
            throw new InvalidBoardingAttemptException("Child is not old enough to board.");
        }
        return true;
    }

    private boolean validateChildWithAdult(Child child, Person adult) throws ChildNotAccompaniedByParentException {
        if (adult instanceof Adult && child.getParent() == adult) {
            return true;
        }
        throw new ChildNotAccompaniedByParentException("Child must be accompanied by an adult.");
    }
}
