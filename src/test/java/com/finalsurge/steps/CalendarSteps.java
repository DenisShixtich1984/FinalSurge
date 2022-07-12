package com.finalsurge.steps;

import static com.codeborne.selenide.Condition.visible;

import io.qameta.allure.Step;
import com.finalsurge.pages.CalendarPage;
import com.finalsurge.pages.DashboardPage;
import com.finalsurge.pages.LoginPage;

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
                .buttonCalendarClickAndCheck()
                .addWorkout();
        return this;
    }
    @Step()
    public CalendarSteps createNewWorkOutWithError() {
        loginPage
                .login();
        dashboardPage
                .titleDashboard.shouldBe(visible);
        calendarPage
                .buttonCalendarClickAndCheck()
                .errorAddWorkout();
        return this;
    }
    @Step()
    public CalendarSteps deleteNote() {
        loginPage
                .login();
        dashboardPage
                .titleDashboard.shouldBe(visible);
        calendarPage
                .buttonCalendarClickAndCheck()
                .deleteNewNote();
        return this;
    }

}
