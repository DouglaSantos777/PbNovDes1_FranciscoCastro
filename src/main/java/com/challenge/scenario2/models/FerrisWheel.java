package com.challenge.scenario2.models;

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
        if (number < 1 || number > NUM_GONDOLAS) {
            System.out.println("Error: Invalid gondola number " + number);
            return;
        }

        if (seats.length < 1 || seats.length > 2) {
            System.out.println("Error: Invalid number of passengers for gondola " + number);
            return;
        }

        Gondola gondola = gondolas.get(number - 1);

        // Se a gôndola escolhida estiver ocupada, buscar a próxima livre
        if (gondola.getSeats()[0] != null || gondola.getSeats()[1] != null) {
            gondola = findNextAvailableGondola(number);
            if (gondola == null) {
                System.out.println("Error: No available gondolas.");
                return;
            }
            number = gondola.getNumber(); // Atualizar para o número da próxima gôndola livre
        }

        if (seats.length == 1) {
            if (gondola.isValidIndividualBoard(number, seats[0])) {
                gondolas.set(number - 1, new Gondola(number, seats[0]));
                System.out.println("Successfully boarded 1 passenger to gondola " + number);
            } else {
                System.out.println("Invalid boarding attempt for gondola " + number + " with 1 passenger.");
            }
        } else {
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
