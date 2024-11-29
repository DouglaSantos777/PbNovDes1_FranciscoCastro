package com.challenge.scenario1.models;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private Person spouse;
    private final List<Person> children = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Person genitor) {
        this(name);
        genitor.addChild(this);
    }

    //add child to List of children

    public void addChild(Person child) {
        children.add(child);
    }

    // add spouse to Person
    public void addSpouse(Person spouse) {
        this.spouse = spouse;
    }

    /* Method to print the family tree starting from this person,
    with indentation based on the spacing */

    public void printFamilyTree(int spacing) {
        System.out.print("  ".repeat(spacing));
        System.out.print(name);

        if (spouse == null) {
            System.out.print(" -- Single");
        } else {
            System.out.print(" -- Married to: " + spouse.name);
        }

// If the person has children, print them with indentation for the hierarchy with 2 spaces
        if (!children.isEmpty()) {
            System.out.print(" -- Children:\n");
            children.forEach(child -> child.printFamilyTree(spacing + 1));
        } else {
            System.out.println();
        }
    }
}