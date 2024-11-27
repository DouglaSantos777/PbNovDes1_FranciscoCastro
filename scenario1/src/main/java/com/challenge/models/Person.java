package com.challenge.models;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Person spouse;
    private List<Person> children;

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public Person(String name, Person person) {
        this.name = name;
        this.spouse = person;
        this.children = new ArrayList<>();
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

    public void printFamilyTree() {
        System.out.println("Teste");
    }
}
