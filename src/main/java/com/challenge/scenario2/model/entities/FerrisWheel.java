package com.challenge.scenario2.model.entities;

import com.challenge.scenario2.model.exceptions.ChildNotAccompaniedByParentException;
import com.challenge.scenario2.model.exceptions.InvalidBoardingAttemptException;
import com.challenge.scenario2.model.exceptions.InvalidGondolaNumberException;
import com.challenge.scenario2.model.exceptions.NoAvailableGondolaException;
import com.challenge.scenario2.model.services.GondolaBoardService;
import com.challenge.scenario2.model.services.ChildBoardService;

import java.util.ArrayList;
import java.util.List;

public class FerrisWheel {
    private static final int NUM_GONDOLAS = 18;
    private final List<Gondola> gondolas;
    private final GondolaBoardService gondolaBoardService;

    public FerrisWheel() {
        this.gondolas = new ArrayList<>();
        for (int i = 1; i <= NUM_GONDOLAS; i++) {
            gondolas.add(new Gondola(i));
        }

        ChildBoardService childBoardService = new ChildBoardService();
        this.gondolaBoardService = new GondolaBoardService(childBoardService);
    }

    private void validateGondolaNumber(int number) throws InvalidGondolaNumberException {
        if (number < 1 || number > NUM_GONDOLAS) {
            throw new InvalidGondolaNumberException("Error: Invalid gondola number " + number);
        }
    }

    private Gondola findNextAvailableGondola(int startingNumber) throws NoAvailableGondolaException {
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
        throw new NoAvailableGondolaException("Error: No available gondolas.");
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

            if (gondolaBoardService.isValidBoarding(passengers)) {
                gondola.board(passengers);
            }

        } catch (InvalidGondolaNumberException | NoAvailableGondolaException e) {
            System.out.println(e.getMessage());
        } catch (InvalidBoardingAttemptException e) {
            System.out.println("Boarding Error: " + e.getMessage());
        } catch (ChildNotAccompaniedByParentException e) {
            System.out.println("Child Boarding Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    public void status() {
        System.out.println("Gondola Status");
        System.out.println("----------------------------------");
        gondolas.forEach(System.out::println);
    }
}
