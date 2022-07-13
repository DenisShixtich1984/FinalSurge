package com.finalsurge.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class CalendarPage {
    public SelenideElement buttonCalendar = $(By.className("icsw16-day-calendar"));
    public SelenideElement titleCalendar = $x("//a[text()='Training Calendar']");
    public SelenideElement buttonQuickAdd = $(By.id("QuickAddToggle"));
    public SelenideElement calendarButton = $(By.className("icon-calendar"));
    public SelenideElement dateOfWorkOut = $(By.id("WorkoutDate"));
    public SelenideElement workoutTime = $(By.id("WorkoutTime"));
    public SelenideElement timeOfWorkOut = $x("//li[text()='05:45 AM']");
    public SelenideElement activityType = $(By.id("ActivityType"));
    public SelenideElement workoutName = $(By.id("Name"));
    public SelenideElement workoutDescription = $(By.id("Desc"));
    public SelenideElement distance = $(By.id("Distance"));
    public SelenideElement distType = $(By.id("DistType"));
    public SelenideElement km = $x("//*[@id='DistType']/option[2]");
    public SelenideElement duration = $(By.id("Duration"));
    public SelenideElement saveButton = $(By.id("saveButton"));
    public SelenideElement checkAddRun = $x(" //div[text()='Run: long run']");
    public SelenideElement errorMassage = $x("//*[@id='workout-add']/div[1]");
    public SelenideElement noteWorkout = $x("//div[text()='Run: long run']");
    public SelenideElement buttonDelete = $x("/html/body/div[1]/div[3]/form/div/div[4]/div/div[2]/div[2]/table/tbody/tr[2]/td[6]/div/div[2]/div/div/ul/li[8]/a");
    public SelenideElement buttonOK = $x("//a[text()='OK']");


    public CalendarPage buttonCalendarClick() {
        buttonCalendar.click();
        return new CalendarPage();
    }

    public CalendarPage addWorkout() {
        buttonQuickAdd.click();
        calendarButton.click();
        dateOfWorkOut.clear();
        dateOfWorkOut.sendKeys("07/08/2022");
        workoutTime.click();
        timeOfWorkOut.click();
        activityType.sendKeys("Run");
        workoutName.sendKeys("long run");
        workoutDescription.sendKeys("preparation for marathon running at a distance of more than 10 km");
        distance.sendKeys("10");
        distType.click();
        km.click();
        duration.sendKeys("00:01:10");
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
