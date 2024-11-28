package com.challenge.models;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private Person spouse;

    private final List<Person> children = new ArrayList<>();;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Person parent) {
        this.name = name;
        parent.addChild( this );
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public void spouse(Person spouse) {
        this.spouse = spouse;
    }

    public void printFamilyTree(int n) {

        System.out.print(name);

        if (spouse == null) {
            System.out.print(" -- Single \n");
        } else if (children.isEmpty()) {
            System.out.print(" -- Married to: -- " + spouse.name
                    + " -- Children:\n");
        } else {
            System.out.println(" -- Married to: -- " + spouse.name
                    + " -- Children:");

            children.forEach(child -> child.printFamilyTree(1));
        }
    }
}
