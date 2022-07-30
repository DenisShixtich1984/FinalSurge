package com.finalsurge.steps;

import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Condition.visible;

import io.qameta.allure.Step;
import com.finalsurge.pages.CalendarPage;
import com.finalsurge.pages.DashboardPage;
import com.finalsurge.pages.LoginPage;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CalendarSteps {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CalendarPage calendarPage;

    public CalendarSteps() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        calendarPage = new CalendarPage();
    }

    @Step()
    public CalendarSteps createNewWorkOut() {
        loginPage
                .login();
        dashboardPage
                .titleDashboard.shouldBe(visible);
        calendarPage
                .buttonCalendarClick()
                .titleCalendar.shouldBe(visible);
        calendarPage
                .addWorkout()
                .checkAddRun.shouldBe(visible);
        return this;
    }

    @Step()
    public CalendarSteps createNewWorkOutWithError() {
        loginPage
                .login();
        dashboardPage
                .titleDashboard.shouldBe(visible);
        calendarPage
                .buttonCalendarClick()
                .titleCalendar.shouldBe(visible);
        calendarPage
                .errorAddWorkout()
                .errorMassage.shouldBe(visible);
        return this;
    }

    @Step()
    public CalendarSteps deleteNote() {
        loginPage
                .login();
        dashboardPage
                .titleDashboard.shouldBe(visible);
        calendarPage
                .buttonCalendarClick()
                .titleCalendar.shouldBe(visible);
        calendarPage
                .deleteNewNote()
                .noteWorkout.shouldNotBe(visible);
        return this;
    }

    @Step()
    public CalendarSteps dragAndDropWithBike() {
        loginPage
                .login();
        calendarPage
                .buttonCalendarClick()
                .dragAndDropBike();
        return this;
    }
    @Step()
    public CalendarSteps copyDay() {
        loginPage
                .login();
        calendarPage
                .buttonCalendarClick()
                .copyWorkoutDay()
                .runHillClone.shouldHave(textCaseSensitive("Run - Hills"));
        return this;
    }
    @Step()
    public CalendarSteps deleteCopyDay() {
        loginPage
                .login();
        calendarPage
                .buttonCalendarClick()
                .deleteCopyWorkoutDay()
                .runHillClone.shouldNotBe(textCaseSensitive("Run - Hills"));
        return this;
    }
}
