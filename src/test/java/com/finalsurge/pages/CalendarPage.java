package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CalendarPage extends BasePage {
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
    public SelenideElement fieldForDrop = $x("//*[@id=\"CalendarContent\"]/div/div[2]/div[2]/table/tbody/tr[3]/td[5]");


    public CalendarPage dragAndDropBike() {

        actions().dragAndDrop(workoutBike,fieldForDrop).build().perform();

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
        dateOfWorkOut.sendKeys(reader.getProperty("DateForAdd"));
        workoutTime.click();
        timeOfWorkOut.click();
        activityType.sendKeys(reader.getProperty("ActivityType"));
        workoutName.sendKeys(reader.getProperty("WorkoutName"));
        workoutDescription.sendKeys(reader.getProperty("WorkoutDescription"));
        distance.sendKeys(reader.getProperty("Distance"));
        distType.click();
        km.click();
        duration.sendKeys(reader.getProperty("Duration"));
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
