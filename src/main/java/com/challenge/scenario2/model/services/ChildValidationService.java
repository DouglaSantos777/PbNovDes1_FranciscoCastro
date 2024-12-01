package com.challenge.scenario2.model.services;

import com.challenge.scenario2.model.entities.Child;

public interface ChildValidationService {
    boolean isChildOldEnough(Child child);

    boolean canChildBoard(Child child);
}