package com.challenge.scenario2.models;

public class Child extends Person {
    private Adult parent;

    public Child(String name, int age) {
        super(name, age);
    }

    public Child(String name, int age, Adult parent) {
        super(name, age);
        this.parent = parent;
    }

    public boolean haveParent() {
        return parent != null;
    }

    public Adult getParent() {
        return parent;
    }

    public boolean haveMinimumAge (){
      /*  if(getAge() < 12){
            return false;
        } */
        return true;
    }

}
