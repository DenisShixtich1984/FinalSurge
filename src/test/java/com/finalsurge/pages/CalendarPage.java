package com.finalsurge.pages;

import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.IPageConstants;
import com.finalsurge.utils.IVariables;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CalendarPage implements IPageConstants, IVariables {
    Faker faker = new Faker();
    public SelenideElement buttonCalendar = $(By.className("icsw16-day-calendar"));
    public SelenideElement titleCalendar = $(byText("Training Calendar"));
    public SelenideElement buttonQuickAdd = $(By.id("QuickAddToggle"));
    public SelenideElement calendarButton = $(By.className("icon-calendar"));
    public SelenideElement dateOfWorkOut = $(By.id("WorkoutDate"));
    public SelenideElement workoutTime = $(By.id("WorkoutTime"));
    public SelenideElement timeOfWorkOut = $(byText("05:45 AM"));
    public SelenideElement activityType = $(By.id("ActivityType"));
    public SelenideElement workoutName = $(By.id("Name"));
    public SelenideElement workoutDescription = $(By.id("Desc"));
    public SelenideElement distance = $(By.id("Distance"));
    public SelenideElement distType = $(By.id("DistType"));
    public SelenideElement km = $x("//*[@id='DistType']/option[2]");
    public SelenideElement duration = $(By.id("Duration"));
    public SelenideElement saveButton = $(By.id("saveButton"));
    public SelenideElement checkAddRun = $(byText("Run: long run"));
    public SelenideElement errorMassage = $x("//*[@id='workout-add']/div[1]");
    public SelenideElement noteWorkout = $(byText("Run: long run"));
    public SelenideElement buttonDelete = $(byXpath("(//a[text()='Delete'])[2]"));
    public SelenideElement buttonOK = $(byText("OK"));
    public SelenideElement workoutBike = $(By.id("wid-33a910da-e03b-47b7-abbd-b2394941b6e2"));
    public SelenideElement fieldForDropDateOf14 = $x("//table//tr[3]//td[5]");
    public SelenideElement fieldForDropDateOf13 = $x("//table//tr[3]//td[4]");
    public SelenideElement copyActivity = $(byXpath("(//a[text()='Copy Day'])[6]"));
    public SelenideElement activityRunHill = $(byText("Run - Hills"));
    public SelenideElement copyActivityRunHill = $(byXpath("(//a[text()='Copy'])[1]"));
    public SelenideElement addOnRunHillClone = $(byXpath("(//*[@class='add-on'])[1]"));
    public SelenideElement dateClickRunHillClone = $(byXpath("(//*[@class=' table-condensed'])[97]/tbody/tr[2]/td[6]"));

    public SelenideElement icon = $x("//table//tr[1]//td[6]");
    public SelenideElement iconPlus = $x("(//*[@class='icon-plus'])[6]");
    public SelenideElement cloneDay = $x("//table//tr[2]//td[6]/div/div/div");
    public SelenideElement buttonDeleteClone = $(byXpath("(//a[text()='Delete'])[2]"));
    public SelenideElement buttonOkDelClone = $(byXpath("(//*[@class='modal-footer'])/a[1]"));

    public CalendarPage runMyHills (){
        activityRunHill.click();
        copyActivityRunHill.click();
        addOnRunHillClone.click();
        dateClickRunHillClone.click();

        return this;
    }

    public CalendarPage dragAndDropBike() {
        actions().dragAndDrop(workoutBike, fieldForDropDateOf14).build().perform();
        fieldForDropDateOf14.shouldHave(textCaseSensitive(BIKE));
        actions().dragAndDrop(workoutBike, fieldForDropDateOf13).build().perform();
        fieldForDropDateOf13.shouldHave(textCaseSensitive(BIKE));
        return this;
    }

    public CalendarPage buttonCalendarClick() {
        buttonCalendar.click();
        return new CalendarPage();
    }

    public CalendarPage addWorkout() {
        buttonQuickAdd.click();
        calendarButton.click();
        dateOfWorkOut.clear();
        dateOfWorkOut.sendKeys(DATE_FOR_ADD);
        workoutTime.click();
        timeOfWorkOut.click();
        activityType.sendKeys(ACTIVITY_TYPE);
        workoutName.sendKeys(WORKOUT_NAME_RUN);
        workoutDescription.sendKeys(WORKOUT_DESCRIPTION);
        distance.sendKeys(String.valueOf(faker.number().numberBetween(7, 11)));
        distType.click();
        km.click();
        duration.sendKeys(String.valueOf(faker.number().numberBetween(110, 125)));
        saveButton.scrollIntoView(false);
        saveButton.click();
        return new CalendarPage();
    }

    public CalendarPage errorAddWorkout() {
        buttonQuickAdd.click();
        saveButton.scrollIntoView(false);
        saveButton.click();
        return new CalendarPage();
    }

    public CalendarPage deleteNewNote() {
        noteWorkout.click();
        buttonDelete.click();
        buttonOK.click();
        return new CalendarPage();
    }
}
