package com.challenge.models;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private Person spouse;
    private final List<Person> children = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Person parent) {
        this.name = name;
        parent.addChild(this);
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public void spouse(Person spouse) {
        this.spouse = spouse;
    }

    public void printFamilyTree(int spacing) {
        System.out.print("  ".repeat(spacing));
        System.out.print(name);

        if (spouse == null) {
            System.out.print(" -- Single");
        } else {
            System.out.print(" -- Married to: " + spouse.name);
        }

        if (!children.isEmpty()) {
            System.out.print(" -- Children:\n");
            children.forEach(child -> child.printFamilyTree(spacing + 1));
        } else {
            System.out.println();
        }
    }
}