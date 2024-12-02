package com.challenge.scenario2.model.services;

import com.challenge.scenario2.model.entities.Child;

public class ChildBoardService{

    public boolean isChildOldEnough(Child child) {
        return child.getAge() >= 12;
    }


    public boolean canChildBoard(Child child) {
        return isChildOldEnough(child) || child.getParent() != null;
    }
}