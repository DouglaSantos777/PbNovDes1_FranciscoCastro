package com.challenge.scenario2.models;

import java.util.ArrayList;
import java.util.List;

public class Gondola {
    private int number;
    private Person seat1;
    private Person seat2;
    private final List<Person> seats = new ArrayList<>(2);

    public Gondola(int number) {
        this.number = number;
    }

    public Gondola(int number, Person seat1, Person seat2) {
        this.number = number;
        this.seat1 = seat1;
        this.seat2 = seat2;
    }

    public Gondola(int number, Person seat1) {
        this.number = number;
        this.seat1 = seat1;
    }

    public int getNumber() {
        return number;
    }

    public List<Person> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        if (seats.isEmpty()) {
            return number + " (empty)";
        } else if (seats.size() == 1) {
            return number + " Only " + seats.get(0).getName();
        } else {
            return number + " " + seats.get(0).getName() + " and " + seats.get(1).getName();
        }
    }
}
