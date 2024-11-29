package com.challenge.scenario2.models;

import java.util.ArrayList;
import java.util.List;

public class FerrisWheel {
    private static final int NUM_GONDOLAS = 18;
    private final List<Gondola> gondolas;

    public FerrisWheel() {
        gondolas =  new ArrayList<>(NUM_GONDOLAS);
        for (int i = 0; i < NUM_GONDOLAS; i++) {
            gondolas.add(new Gondola(i + 1));
        }
    }

    public boolean gondolaIsEmpty(Gondola gondola) {
        return gondola.getSeats()[0] == null && gondola.getSeats()[1] == null;
    }

    public boolean isValidGondola(int number) {
        for (Gondola gondola : gondolas) {
            if (gondola.getNumber() == number && gondolaIsEmpty(gondola)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidDoubleBoard(int number, Child seat1 , Person seat2){
        return isValidGondola(number) && seat1.getParent() == seat2;
    }

    public boolean isValidIndividualBoard(int number, Child seat1){
        return isValidGondola(number) && seat1.haveMinimumAge();
    }

    public void board(int number, Child seat1 , Person seat2) {
        if(isValidDoubleBoard(number, seat1, seat2)){
            gondolas.add((number - 1),  new Gondola(number, seat1, seat2));
        }
    }

    public void board(int number, Child seat1) {
       if(isValidIndividualBoard(number, seat1) && seat1.haveMinimumAge()){
           this.gondolas.add((number - 1) , new Gondola(number, seat1));
       }
    }

    public void status() {
        System.out.println("Gondola Status");
        System.out.println("----------------------------------");
        gondolas.forEach(System.out::println);
    }
}
