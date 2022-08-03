package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class AddWorkoutTest extends BaseTest {

    /**
     * In this class there are four tests for creating workouts.("FS-18")&("FS-19")with a positive and negative
     * scenario for creating swimming workouts using a builder, ("FS-20")- a positive scenario for creating walking
     * workout using a builder,("FS-21")a positive scenario for creating rest day.
     */

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
