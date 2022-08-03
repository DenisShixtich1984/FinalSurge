package com.finalsurge.pages;

import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.IPageConstants;
import com.finalsurge.utils.IVariables;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class CalendarPage extends BasePage implements IPageConstants, IVariables {
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
    public SelenideElement errorMessage = $x("//*[@id='workout-add']/div[1]");
    public SelenideElement noteWorkout = $(byText("Run: long run"));
    public SelenideElement buttonDelete = $(byXpath("//*[@id='CalendarContent']/descendant::div[85]//li[8]/a"));
    public SelenideElement buttonOK = $(byText("OK"));
    public SelenideElement workoutBike = $(byText("Bike - Recovery Ride"));
    public SelenideElement workoutBikeBack = $x("//*[@id='CalendarContent']/descendant::div[165]");
    public SelenideElement fieldForDropDateOf18 = $x("//table//tr[3]//td[5]");
    public SelenideElement fieldForDropDateOf17 = $x("//table//tr[3]//td[4]");
    public SelenideElement dayForCopy = $x("//*[@id='CalendarContent']/descendant::td[36]");
    public SelenideElement cloneDay = $x("//*[@id='CalendarContent']/descendant::td[36]//li[6]/a");
    public SelenideElement addDateCopy = $(byXpath("//div[@class='datepicker dropdown-menu'" +
            " and contains(@style,'block')]/div[1]/table/tbody/tr[2]/td[7]"));
    public SelenideElement runHillClone = $x("(//div[text()='Run - Hills'])[2]");
    public SelenideElement deleteClone = $x("(//a[text()='Delete'])[4]");
    public SelenideElement buttonClickOk = $x("//*[@class='btn btn-primary']");

    public CalendarPage copyWorkoutDay() {
        log.info("copyWorkoutDay: copying a workout for another day");
        actions().moveToElement(dayForCopy).build();
        dayForCopy.click();
        cloneDay.click();
        addDateCopy.click();
        return this;
    }

    public CalendarPage deleteCopyWorkoutDay() {
        log.info("deleteCopyWorkoutDay: deleting a copy of the training day");
        runHillClone.click();
        deleteClone.click();
        buttonClickOk.click();
        return this;
    }

    public CalendarPage dragAndDropBike() {
        log.info("dragAndDropBike: rescheduling a workout to another day and bringing it back");
        actions().dragAndDrop(workoutBike, fieldForDropDateOf18).build().perform();
        fieldForDropDateOf18.shouldHave(textCaseSensitive(BIKE));
        actions().dragAndDrop(workoutBikeBack, fieldForDropDateOf17).build().perform();
        fieldForDropDateOf17.shouldHave(textCaseSensitive(BIKE));
        return this;
    }

    public CalendarPage buttonCalendarClick() {
        log.info("buttonCalendarClick");
        buttonCalendar.click();
        return new CalendarPage();
    }

    public CalendarPage addWorkout() {
        log.info("addWorkout: creating and adding a workout with filled all fields");
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
        log.info("errorAddWorkout: creating a workout with error: invalid Activity Type");
        buttonQuickAdd.click();
        saveButton.scrollIntoView(false);
        saveButton.click();
        return new CalendarPage();
    }

    public CalendarPage deleteNewNote() {
        log.info("deleteNewNote: deleting a workout");
        noteWorkout.click();
        buttonDelete.click();
        buttonOK.click();
        return new CalendarPage();
    }
}
