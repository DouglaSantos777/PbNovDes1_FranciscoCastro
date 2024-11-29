package com.challenge.scenario2.models;

import java.util.ArrayList;
import java.util.List;

public class Gondola {
    private int number;
    private Person seat1;
    private Person seat2;
    private final List<Person> seats = new ArrayList<>(2);

    public Gondola(){

    }

    public Gondola(int number, Person seat1, Person seat2) {
        this.number = number;
        this.seat1 = seat1;
        this.seat2 = seat2;
    }

    public int getNumber() {
        return number;
    }

    public List<Person> getSeats() {
        return seats;
    }

}
