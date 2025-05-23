package com.challenge.scenario2.model.entities;

public class Child extends Person {
    private Adult parent;

    public Child(String name, int age) {
        super(name, age);
    }

    public Child(String name, int age, Adult parent) {
        super(name, age);
        this.parent = parent;
    }

    public Adult getParent() {
        return parent;
    }

}
