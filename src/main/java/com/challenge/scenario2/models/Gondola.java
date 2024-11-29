package com.challenge.scenario2.models;

public class Gondola implements FerrisWheel {
    private int number;
    private Person seat1;
    private Person seat2;

    public Gondola(){

    }

    public Gondola(int number, Person seat1, Person seat2) {
        this.number = number;
        this.seat1 = seat1;
        this.seat2 = seat2;
    }


    @Override
    public void board(int number, Person seat1, Person seat2) {

    }

    @Override
    public void board(int number, Person seat1) {

    }

    @Override
    public void status() {
        System.out.println("Teste de print do status");
    }

}
