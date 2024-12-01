package com.challenge.scenario2.model.entities;

import com.challenge.scenario2.model.exceptions.InvalidGondolaNumberException;
import com.challenge.scenario2.model.exceptions.NoAvailableGondolaException;
import com.challenge.scenario2.model.services.GondolaService;
import com.challenge.scenario2.model.services.ChildBoardService;

import java.util.ArrayList;
import java.util.List;

public class FerrisWheel {
    private static final int NUM_GONDOLAS = 18;
    private final List<Gondola> gondolas;
    private final GondolaService gondolaService;

    public FerrisWheel() {
        this.gondolas = new ArrayList<>();
        for (int i = 1; i <= NUM_GONDOLAS; i++) {
            gondolas.add(new Gondola(i));
        }

        ChildBoardService childBoardService = new ChildBoardService();
        this.gondolaService = new GondolaService(childBoardService);
    }

    public void board(int number, Person... passengers) {
        try {
            validateGondolaNumber(number);

            Gondola gondola = gondolas.get(number - 1);
            if (!gondola.isAvailable()) {
                gondola = findNextAvailableGondola(number);
                if (gondola == null) {
                    throw new NoAvailableGondolaException("Error: No available gondolas.");
                }
            }

            if (gondolaService.isValidBoarding(passengers)) {
                gondola.board(passengers);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateGondolaNumber(int number) {
       try {
           if (number < 1 || number > NUM_GONDOLAS) {
               throw new InvalidGondolaNumberException("Error: Invalid gondola number " + number);
           }
       } catch (Exception e){
           System.out.println(e.getMessage());
       }
    }

    private Gondola findNextAvailableGondola(int startingNumber) {
        for (int i = startingNumber; i < gondolas.size(); i++) {
            if (gondolas.get(i).isAvailable()) {
                return gondolas.get(i);
            }
        }
        for (int i = 0; i < startingNumber; i++) {
            if (gondolas.get(i).isAvailable()) {
                return gondolas.get(i);
            }
        }
        return null;
    }

    public void status() {
        System.out.println("Gondola Status");
        System.out.println("----------------------------------");
        gondolas.forEach(System.out::println);
    }
}

