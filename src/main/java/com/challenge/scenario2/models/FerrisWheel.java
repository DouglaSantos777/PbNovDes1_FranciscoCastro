package com.challenge.scenario2.models;

public interface FerrisWheel {

    public boolean board(int number, Person seat1, Person seat2);

    public boolean board(int number, Person seat1);

    public void status();
}
