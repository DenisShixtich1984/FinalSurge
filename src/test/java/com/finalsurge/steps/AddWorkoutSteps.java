package com.finalsurge.steps;

import com.codeborne.selenide.Condition;
import com.finalsurge.pages.AddWorkoutPage;
import com.finalsurge.pages.LoginPage;
import com.finalsurge.utils.CreateWorkout;
import com.finalsurge.utils.IPageConstants;
import com.finalsurge.utils.IVariables;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class AddWorkoutSteps implements IPageConstants, IVariables {
    LoginPage loginPage;
    AddWorkoutPage addWorkoutPage;
    Faker faker;

    public AddWorkoutSteps() {
        loginPage = new LoginPage();
        addWorkoutPage = new AddWorkoutPage();
        faker = new Faker();
    }

    @Step()
    public AddWorkoutSteps createWorkoutIssue() {
        loginPage
                .login();
        addWorkoutPage
                .createSwimWorkout();
        CreateWorkout workoutSwim = CreateWorkout.builder()
                .workoutDateOfActivity(DATE_SWIM)
                .workoutNameOfActivity(WORK0UT_NAME_SWIM)
                .workoutDescriptionOfActivity(WORK0UT_DESCRIPTION_SWIM)
                .workoutDistance(PLAN_DIST_SWIM)
                .workoutTimeOfActivity(PLAN_TIME_SWIM)
                .workoutFactTimeOfActivity(FACT_TIME_SWIM)
                .workoutFactDistanceOfActivity(FACT_DIST_SWIM)
                .workoutOverallPlace(OVERALL_PLACE)
                .workoutAgeGroupPlace(AGE_GROUP_PLACE)
                .workoutKCal(K_CAL)
                .build();
        addWorkoutPage.workoutMyList(workoutSwim)
                .activityTypeName.shouldHave(Condition.textCaseSensitive(CHECK_NAME));
        return this;
    }

    @Step()
    public AddWorkoutSteps createWorkoutIssueWithError() {
        loginPage
                .login();
        addWorkoutPage
                .createSwimWorkout();
        CreateWorkout workoutSwim = CreateWorkout.builder()
                .workoutDateOfActivity(DATE_SWIM)
                .workoutNameOfActivity(WORK0UT_NAME_SWIM)
                .workoutDescriptionOfActivity(WORK0UT_DESCRIPTION_SWIM)
                .workoutDistance(PLAN_DIST_SWIM_ERROR)
                .workoutTimeOfActivity(PLAN_TIME_SWIM)
                .workoutFactTimeOfActivity(FACT_TIME_SWIM)
                .workoutFactDistanceOfActivity(FACT_DIST_SWIM)
                .workoutOverallPlace(OVERALL_PLACE)
                .workoutAgeGroupPlace(AGE_GROUP_PLACE)
                .workoutKCal(K_CAL)
                .build();
        addWorkoutPage.workoutMyList(workoutSwim)
                .errorMessage.shouldHave(Condition.textCaseSensitive(CHECK_ERROR_MESSAGE));
        return this;
    }

    @Step()
    public AddWorkoutSteps createWorkoutWalk() {
        loginPage
                .login();
        addWorkoutPage
                .createWalkWorkout();
        CreateWorkout workoutWalk = CreateWorkout.builder()
                .workoutDateOfActivity(DATE_WALK)
                .workoutNameOfActivity(faker.name().name())
                .workoutDescriptionOfActivity(faker.backToTheFuture().quote())
                .workoutDistance(String.valueOf(faker.number().numberBetween(100, 500)))
                .workoutTimeOfActivity(String.valueOf(faker.number().numberBetween(1550, 2500)))
                .workoutFactTimeOfActivity(FACT_TIME_SWIM)
                .workoutFactDistanceOfActivity(String.valueOf(faker.number().numberBetween(50, 300)))
                .workoutOverallPlace(String.valueOf(faker.number().numberBetween(1, 15)))
                .workoutAgeGroupPlace(String.valueOf(faker.number().numberBetween(3, 20)))
                .workoutKCal(String.valueOf(faker.number().numberBetween(1300, 2350)))
                .build();
        addWorkoutPage.workoutMyList(workoutWalk)
                .checkNameActivity.shouldHave(Condition.textCaseSensitive(CHECK_NAME_MESSAGE));

        return this;
    }
}
