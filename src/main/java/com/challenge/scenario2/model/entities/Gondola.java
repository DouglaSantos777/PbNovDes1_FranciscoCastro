package com.challenge.scenario2.model.entities;

public class Gondola {
    private final int number;
    private Person seat1;
    private Person seat2;

    public Gondola(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Person[] getSeats() {
        return new Person[] { seat1, seat2 };
    }

    public boolean isAvailable() {
        return seat1 == null && seat2 == null;
    }

    public void placePassengers(Person... passengers) {
        this.seat1 = passengers[0];
        if (passengers.length > 1) {
            this.seat2 = passengers[1];
        }
    }

    @Override
    public String toString() {
        if (seat1 == null && seat2 == null) {
            return number + " (empty)";
        } else if (seat1 != null && seat2 != null) {
            return number + " " + seat1.getName() + " and " + seat2.getName();
        } else {
            return number + " Only " + (seat1 != null ? seat1.getName() : seat2.getName());
        }
    }
}
