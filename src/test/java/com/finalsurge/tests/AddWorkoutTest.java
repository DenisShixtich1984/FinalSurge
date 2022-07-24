package com.finalsurge.tests;

import org.testng.annotations.Test;

public class AddWorkoutTest extends BaseTest{
    @Test
    public void createSwimWorkout () {
        addWorkoutSteps.createWorkoutIssue();
    }

    @Test
    public void createSwimWorkoutWithError () {
        addWorkoutSteps.createWorkoutIssueWithError();
    }
    @Test
    public void createWalkWorkout () {
        addWorkoutSteps.createWorkoutWalk();
    }
}
