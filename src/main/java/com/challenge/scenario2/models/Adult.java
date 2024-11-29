package com.challenge.scenario2.models;

import java.util.List;

public class Adult extends  Person{
    List<Child> children;

    public Adult(String name, int age) {
        super(name, age);
    }



}
