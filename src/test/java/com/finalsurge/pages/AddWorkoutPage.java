package com.finalsurge.pages;

import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.IPageConstants;
import com.finalsurge.utils.CreateWorkout;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
@Log4j2
public class AddWorkoutPage extends BasePage implements IPageConstants {
    public SelenideElement buttonWorkouts = $(byText("Workouts"));
    public SelenideElement buttonAddWorkout = $(byText("Add Workout"));
    public SelenideElement swim = $x("//*[@id='blog_accordion_left']/div[3]");
    public SelenideElement walk = $x("//*[@id='blog_accordion_left']/div[5]");
    public SelenideElement restDay = $x("//*[@id='blog_accordion_left']/div[6]");
    public SelenideElement workoutDate = $(byId("WorkoutDate"));
    public SelenideElement workoutTime = $(byId("WorkoutTime"));
    public SelenideElement timeOfWorkout = $(byText("07:00 AM"));
    public SelenideElement workoutName = $(byId("Name"));
    public SelenideElement workoutDescription = $(byId("Desc"));
    public SelenideElement plannedWorkout = $(byId("PlannedWorkout"));
    public SelenideElement planDist = $(byId("PDistance"));
    public SelenideElement planType = $(byId("PDistType"));
    public SelenideElement pDuration = $(byId("PDuration"));
    public SelenideElement duration = $(byId("Duration"));
    public SelenideElement distance = $(byId("Distance"));
    public SelenideElement metersInFact = $(byId("DistType"));
    public SelenideElement paceType = $(byId("PaceType"));
    public SelenideElement isRace = $(byId("IsRace"));
    public SelenideElement overallPlace = $(byId("OverallPlace"));
    public SelenideElement ageGroupPlace = $(byId("AgeGroupPlace"));
    public SelenideElement hf_normal = $(byId("hf_normal"));
    public SelenideElement perEffort = $(byId("PerEffort"));
    public SelenideElement kCal = $(byId("kCal"));
    public SelenideElement saveButton = $(byId("saveButton"));
    public SelenideElement activityTypeName = $(byClassName("activityTypeName"));
    public SelenideElement errorMessage = $(byClassName("alert"));
    public SelenideElement checkNameActivity = $(byClassName("activityTypeName"));
    public SelenideElement addDate = $(byClassName("add-on"));
    public SelenideElement addDay = $x("//table//tr[6]//td[4]");

    public AddWorkoutPage createRestDay() {
        log.info("AddWorkoutPage,createRestDay");
        actions().moveToElement(buttonWorkouts).build().perform();
        buttonAddWorkout.click();
        restDay.click();
        addDate.click();
        addDay.click();
        workoutName.sendKeys(faker.name().title());
        workoutDescription.sendKeys(faker.hitchhikersGuideToTheGalaxy().quote());
        saveButton.click();
        return this;
    }

    public AddWorkoutPage createSwimWorkout() {
        log.info("AddWorkoutPage,createSwimWorkout");
        actions().moveToElement(buttonWorkouts).build().perform();
        buttonAddWorkout.click();
        swim.click();

        return this;
    }

    public AddWorkoutPage createWalkWorkout() {
        log.info("AddWorkoutPage,createWalkWorkout");
        actions().moveToElement(buttonWorkouts).build().perform();
        buttonAddWorkout.click();
        walk.click();
        return this;
    }

    public AddWorkoutPage workoutMyList(CreateWorkout createWorkout) {
        log.info("AddWorkoutPage,workoutMyList");
        workoutDate.clear();
        workoutDate.sendKeys(createWorkout.getWorkoutDateOfActivity());
        workoutTime.click();
        timeOfWorkout.click();
        workoutName.sendKeys(createWorkout.getWorkoutNameOfActivity());
        workoutDescription.sendKeys(createWorkout.getWorkoutDescriptionOfActivity());
        plannedWorkout.click();
        planDist.sendKeys(createWorkout.getWorkoutDistance());
        planType.selectOption(2);
        pDuration.sendKeys(createWorkout.getWorkoutTimeOfActivity());
        duration.sendKeys(createWorkout.getWorkoutFactTimeOfActivity());
        distance.sendKeys(createWorkout.getWorkoutFactDistanceOfActivity());
        metersInFact.selectOption(2);
        paceType.selectOption(4);
        isRace.click();
        overallPlace.sendKeys(createWorkout.getWorkoutOverallPlace());
        ageGroupPlace.sendKeys(createWorkout.getWorkoutAgeGroupPlace());
        hf_normal.click();
        perEffort.selectOption(2);
        kCal.sendKeys(createWorkout.getWorkoutKCal());
        saveButton.click();
        return this;
    }
}
