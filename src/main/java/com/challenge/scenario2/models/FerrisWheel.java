package com.challenge.scenario2.models;

import java.util.ArrayList;
import java.util.List;

public class FerrisWheel {
    private static final int NUM_GONDOLAS = 18;
    private final List<Gondola> gondolas;
    private Gondola gondola;

    public FerrisWheel() {
        gondolas = new ArrayList<>(NUM_GONDOLAS);
        for (int i = 0; i < NUM_GONDOLAS; i++) {
            gondolas.add(new Gondola(i + 1));
        }
    }

    public void board(int number, Person... seats) {
        if (number < 1 || number > NUM_GONDOLAS) {
            System.out.println("Error: Invalid gondola number " + number);
            return;
        }

        if (seats.length < 1 || seats.length > 2) {
            System.out.println("Error: Invalid number of passengers for gondola " + number);
            return;
        }

        Gondola gondola = gondolas.get(number - 1);

        if (seats.length == 1) {
            if (gondola.isValidIndividualBoard(number, seats[0])) {
                gondolas.set(number - 1, new Gondola(number, seats[0]));
                System.out.println("Successfully boarded 1 passenger to gondola " + number);
            } else {
                System.out.println("Invalid boarding attempt for gondola " + number + " with 1 passenger.");
            }
        }

        else {
            if (gondola.isValidDoubleBoard(number, seats[0], seats[1])) {
                gondolas.set(number - 1, new Gondola(number, seats[0], seats[1]));
                System.out.println("Successfully boarded 2 passengers to gondola " + number);
            } else {
                System.out.println("Invalid boarding attempt for gondola " + number + " with 2 passengers.");
            }
        }
    }

    public void status() {
        System.out.println("Gondola Status");
        System.out.println("----------------------------------");
        gondolas.forEach(System.out::println);
    }
}
