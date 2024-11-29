package com.challenge.scenario2.models;

import java.util.ArrayList;
import java.util.List;

public class Gondola {
    private int number;
    private Person seat1;
    private Person seat2;
    private final Person[] seats = new Person[2];

    public Gondola(int number) {
        this.number = number;
    }

    public Gondola(int number, Person seat1, Person seat2) {
        this.number = number;
        this.seat1 = seat1;
        this.seat2 = seat2;
        seats[0] = seat1;
        seats[1] = seat2;
    }

    public Gondola(int number, Person seat1) {
        this.seat1 = seat1;
        this.number = number;
        seats[0] = seat1;
    }

    public int getNumber() {
        return number;
    }

    public Person[] getSeats() {
        return seats;
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
