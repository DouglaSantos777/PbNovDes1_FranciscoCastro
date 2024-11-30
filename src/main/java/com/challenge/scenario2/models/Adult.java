package com.challenge.scenario2.models;

import java.util.ArrayList;
import java.util.List;

public class Adult extends Person{
    private final List<Child> children;

    public Adult(String name, int age) {
        super(name, age);
        children = new ArrayList<>();
    }

}
