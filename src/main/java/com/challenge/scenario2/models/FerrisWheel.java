package com.challenge.scenario2.models;

import com.challenge.scenario2.models.exceptions.InvalidBoardingAttemptException;
import com.challenge.scenario2.models.exceptions.InvalidGondolaNumberException;
import com.challenge.scenario2.models.exceptions.InvalidPassengerCountException;
import com.challenge.scenario2.models.exceptions.NoAvailableGondolaException;

import java.util.ArrayList;
import java.util.List;

public class FerrisWheel {
    private static final int NUM_GONDOLAS = 18;
    private final List<Gondola> gondolas;

    public FerrisWheel() {
        this.gondolas = new ArrayList<>();
        for (int i = 1; i <= NUM_GONDOLAS; i++) {
            gondolas.add(new Gondola(i));
        }
    }

    private Gondola findNextAvailableGondola(int startingNumber) {
        for (int i = startingNumber; i < gondolas.size(); i++) {
            Gondola gondola = gondolas.get(i);
            if (gondola.getSeats()[0] == null && gondola.getSeats()[1] == null) {
                return gondola;
            }
        }

        for (int i = 0; i < startingNumber; i++) {
            Gondola gondola = gondolas.get(i);
            if (gondola.getSeats()[0] == null && gondola.getSeats()[1] == null) {
                return gondola;
            }
        }
        return null;
    }

    public void board(int number, Person... seats) {
        try {
            if (number < 1 || number > NUM_GONDOLAS) {
                throw new InvalidGondolaNumberException("Error: Invalid gondola number " + number);
            }

            if (seats.length < 1 || seats.length > 2) {
                throw new InvalidPassengerCountException("Error: Invalid number of passengers for gondola " + number);
            }
            Gondola gondola = gondolas.get(number - 1);

            if (gondola.getSeats()[0] != null || gondola.getSeats()[1] != null) {
                gondola = findNextAvailableGondola(number);
                if (gondola == null) {
                    throw new NoAvailableGondolaException("Error: No available gondolas.");
                }
                number = gondola.getNumber();
            }

            if (seats.length == 1) {
                if (gondola.isValidIndividualBoard(number, seats[0])) {
                    gondolas.set(number - 1, new Gondola(number, seats[0]));

                } else {
                    throw new InvalidBoardingAttemptException("Invalid boarding attempt for gondola " + number + " with 1 passenger.");
                }
            } else {
                if (gondola.isValidDoubleBoard(number, seats[0], seats[1])) {
                    gondolas.set(number - 1, new Gondola(number, seats[0], seats[1]));

                } else {
                    throw new InvalidBoardingAttemptException("Invalid boarding attempt for gondola " + number + " with 1 passenger.");
                }
            }
        } catch (InvalidGondolaNumberException | InvalidPassengerCountException | NoAvailableGondolaException |
                 InvalidBoardingAttemptException e) {
            System.out.println(e.getMessage());
        }
    }

    public void status() {
        System.out.println("Gondola Status");
        System.out.println("----------------------------------");
        gondolas.forEach(System.out::println);
    }
}
