package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class AddWorkoutTest extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-18")
    public void createSwimWorkout() {
        addWorkoutSteps.createWorkoutIssue();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-19")
    public void createSwimWorkoutWithError() {
        addWorkoutSteps.createWorkoutIssueWithError();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-20")
    public void createWalkWorkout() {
        addWorkoutSteps.createWorkoutWalk();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-21")
    public void createRestDay() {
        addWorkoutSteps.createMyRestDay();
    }
}
