package com.challenge.models;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Person spouse;
    private List<Person> children = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Person person) {
        this.name = name;
        this.spouse = person;
    }

    public String getName() {
        return name;
    }

    public void spouse(Person spouse) {
        this.spouse = spouse;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public void printFamilyTree(int n) {
        if (spouse == null) {
            System.out.println(name + " -- Married to: -- Single");
        } else if (children.isEmpty()) {
            System.out.println(name + " -- Married to: -- " +this.spouse.name
                    + " -- Children: \n");
        } else {
            System.out.println(name + " -- Married to: -- " +this.spouse.name
                    + " -- Children: \n");

            this.children.forEach(child -> child.printFamilyTree(1));
        }
    }
}
