package com.challenge.scenario2.models;

import java.util.ArrayList;
import java.util.List;

public class Gondola implements FerrisWheel {
    private int number;
    private Person seat1;
    private Person seat2;
    private final List<Person> seats = new ArrayList<>(18);

    public Gondola(){

    }

    public Gondola(int number, Person seat1, Person seat2) {
        this.number = number;
        this.seat1 = seat1;
        this.seat2 = seat2;
    }

    @Override
    public boolean board(int number, Person seat1, Person seat2) {
    return false;
    }

    @Override
    public boolean board(int number, Person seat1) {
    return true;
    }

    @Override
    public void status() {
        System.out.println("Teste de print do status");
    }

}
