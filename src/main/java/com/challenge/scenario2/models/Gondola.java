package com.challenge.scenario2.models;

public class Gondola {
    private final int number;
    private Person seat1;
    private Person seat2;
    private final Person[] seats = new Person[2];

    public Gondola(int number) {
        this.number = number;
    }

    public Gondola(int number, Person seat1) {
        this.number = number;
        this.seats[0] = seat1;
    }

    public Gondola(int number, Person seat1, Person seat2) {
        this.number = number;
        this.seats[0] = seat1;
        this.seats[1] = seat2;
    }

    public int getNumber() {
        return number;
    }

    public Person[] getSeats() {
        return seats;
    }

    public boolean isValidGondola(int num) {
        return number == num && seats[0] == null && seats[1] == null;
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

    @Override
    public String toString() {
        if (seats[0] == null && seats[1] == null) {
            return number + " (empty)";
        } else if (seats[1] == null) {
            return number + " Only " + seats[0].getName();
        } else {
            return number + " " + seats[0].getName() + " and " + seats[1].getName();
        }
    }

}
