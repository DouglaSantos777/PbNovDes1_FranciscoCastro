package com.challenge.scenario2.models;

import java.util.ArrayList;
import java.util.List;

public class FerrisWheel {
    private static final int NUM_GONDOLAS = 18;
    private final List<Gondola> gondolas;

    public FerrisWheel() {
        gondolas = new ArrayList<>(NUM_GONDOLAS);
        for (int i = 0; i < NUM_GONDOLAS; i++) {
            gondolas.add(new Gondola(i + 1));
        }
    }

    public boolean gondolaIsEmpty(Gondola gondola) {
        return gondola.getSeats()[0] == null && gondola.getSeats()[1] == null;
    }

    public boolean isValidGondola(int number) {
        for (Gondola gondola : gondolas) {
            if (gondola.getNumber() == number && gondolaIsEmpty(gondola)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidDoubleBoard(int number, Person seat1, Person seat2) {
        if (seat1 instanceof Child && seat2 instanceof Adult) {
            if (((Child) seat1).canRideAlone()) {
                return isValidGondola(number);
            }
            return isValidGondola(number) && ((Child) seat1).getParent() == seat2;
        } else if (seat2 instanceof Child && seat1 instanceof Adult) {
            if (((Child) seat2).canRideAlone()) {
                return isValidGondola(number);
            }
            return isValidGondola(number) && ((Child) seat2).getParent() == seat1;
        }
        return false;
    }

    public boolean isValidIndividualBoard(int number, Person seat1) {
        if (seat1 instanceof Adult) {
            return isValidGondola(number);
        } else if (seat1 instanceof Child && ((Child) seat1).canRideAlone()) {
            return isValidGondola(number);
        }
        return false;
    }

    public void board(int number, Person seat1, Person seat2) {
        if (isValidDoubleBoard(number, seat1, seat2)) {
            Gondola newGondola = seat1 instanceof Child ? new Gondola(number, seat1, seat2) : new Gondola(number, seat2, seat1);
            gondolas.add((number - 1), newGondola);
        } else {
            System.out.println("Invalid boarding attempt for gondola " + number);
        }
    }

    public void board(int number, Person seat1) {
        if (seat1 instanceof Child) {
            if (isValidIndividualBoard(number, seat1)) {
                this.gondolas.add((number - 1), new Gondola(number, seat1));
            }
        }
    }

    public void status() {
        System.out.println("Gondola Status");
        System.out.println("----------------------------------");
        gondolas.forEach(System.out::println);
    }
}
