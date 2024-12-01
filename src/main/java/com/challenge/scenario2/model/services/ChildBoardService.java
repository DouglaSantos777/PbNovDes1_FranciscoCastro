package com.challenge.scenario2.model.services;

import com.challenge.scenario2.model.entities.Child;

public class ChildBoardService implements BoardValidationService {


    @Override
    public boolean isChildOldEnough(Child child) {
        return child.getAge() >= 12;
    }

    @Override
    public boolean canChildBoard(Child child) {
        return isChildOldEnough(child) || child.getParent() != null;
    }
}