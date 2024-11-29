package com.challenge.scenario2;

import com.challenge.scenario2.models.Adult;
import com.challenge.scenario2.models.Child;
import com.challenge.scenario2.models.FerrisWheel;
import com.challenge.scenario2.models.Gondola;

public class Main {
    public static void main(String[] args) {
        FerrisWheel ferrisWheel = new FerrisWheel() {
        }; // Creating a new Ferris wheel
        Adult paulo = new Adult("Paulo", 42); // Adult named Paulo
        // Paulo's children
        Child joao = new Child("Joao", 5, paulo); // New child with Paulo as the father
        Child maria = new Child("Maria", 12, paulo); // This is Paulo's daughter
        // Child without defined father
        Child pedro = new Child("Pedro", 13);
        Child henrique = new Child("Henrique", 10);
        /*
         * Now comes the fun part. A rule has been created in the park:
         * - Children under 12 years old can only ride accompanied by their father!
         */
        ferrisWheel.board(2, joao, maria); // ERROR: Joao is under 12 and the father is not present
        ferrisWheel.board(2, joao, paulo); // OK: Now the father is present
        ferrisWheel.board(3, maria); // OK: Maria is 12 years old and can ride alone
        ferrisWheel.board(13, pedro); // OK: Pedro rides alone
        ferrisWheel.board(16, henrique); // ERROR: Henrique is under 12 and we don't know who the father is (should be Silvio, but he didn't assume responsibility!)
        ferrisWheel.status();
    }
}
