package com.finalsurge.tests;

import org.testng.annotations.Test;

public class AddWorkoutTest extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    public void createSwimWorkout() {
        addWorkoutSteps.createWorkoutIssue();
    }

    @Test(retryAnalyzer = Retry.class)
    public void createSwimWorkoutWithError() {
        addWorkoutSteps.createWorkoutIssueWithError();
    }

    @Test(retryAnalyzer = Retry.class)
    public void createWalkWorkout() {
        addWorkoutSteps.createWorkoutWalk();
    }

    @Test(retryAnalyzer = Retry.class)
    public void createRestDay() {
        addWorkoutSteps.createMyRestDay();
    }

}
