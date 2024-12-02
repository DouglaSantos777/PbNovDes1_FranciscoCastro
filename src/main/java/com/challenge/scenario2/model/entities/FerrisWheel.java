package com.challenge.scenario2.model.entities;

import com.challenge.scenario2.model.exceptions.ChildNotAccompaniedByParentException;
import com.challenge.scenario2.model.exceptions.InvalidGondolaNumberException;
import com.challenge.scenario2.model.exceptions.NoAvailableGondolaException;

import java.util.LinkedList;
import java.util.List;

public class FerrisWheel {
    private static final int NUM_GONDOLAS = 18;
    private final List<Gondola> gondolas;

    public FerrisWheel() {
        this.gondolas = new LinkedList<>();
        for (int i = 1; i <= NUM_GONDOLAS; i++) {
            gondolas.add(new Gondola(i));
        }
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
        throw new NoAvailableGondolaException("Error: No available gondolas.");
    }

    public void board(int number, Person... passengers) {
        try {
            validateGondolaNumber(number);
            Gondola gondola = gondolas.get(number - 1);

            if (!gondola.isAvailable()) {
                gondola = findNextAvailableGondola(number);
            }

            for (Person passenger : passengers) {
                if (passenger instanceof Child child) {
                    if (child.getAge() < 12) {
                        boolean isAccompanied = false;
                        for (Person person : passengers) {
                            if (person instanceof Adult adult && adult == child.getParent()) {
                                isAccompanied = true;
                                break;
                            }
                        }
                        if (!isAccompanied) {
                            throw new ChildNotAccompaniedByParentException("Child must be accompanied by an adult.");
                        }
                    }
                }
            }

            gondola.placePassengers(passengers);

        } catch (InvalidGondolaNumberException | NoAvailableGondolaException e) {
            System.out.println(e.getMessage());
        } catch (ChildNotAccompaniedByParentException e) {
            System.out.println("Child Boarding Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void status() {
        System.out.println();
        System.out.println("Gondola Status");
        System.out.println("----------------------------------");
        gondolas.forEach(System.out::println);
    }
}
