package com.challenge.scenario2.models;

import java.util.ArrayList;
import java.util.List;

public class FerrisWheel {
    List<Gondola> gondolas;

    public FerrisWheel() {
        new ArrayList<>(18);
    }

    public boolean isValidGondola(int number) {
        for (Gondola gondola : gondolas) {
            if (gondola.getNumber() == number) {
                return true;
            }
        }
        return false;
    }

    public boolean board(int number, Person seat1, Person seat2) {
       return true;

    }

    public boolean board(int number, Person seat1) {
        return true;
    }

    public void status() {
        System.out.println("Gondola Status");
        System.out.println("----------------------------------");
    }
}
