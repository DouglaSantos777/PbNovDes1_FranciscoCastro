package com.challenge.scenario2.models;

public class Child extends Person{
    private Adult parent;

    public Child(String name, int age) {
        super(name, age);
    }

    public Child(String name, int age, Adult parent) {
        super(name, age);
        this.parent = parent;
    }

}
