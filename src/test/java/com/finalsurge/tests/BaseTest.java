package com.finalsurge.tests;

import com.finalsurge.browser.SelenideConfiguration;
import com.codeborne.selenide.Selenide;
import com.finalsurge.pages.*;
import com.finalsurge.steps.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.open;

@Listeners(MyListener.class)
public class BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CalendarPage calendarPage;
    CalendarSteps calendarSteps;
    CalculatorsPage calculatorsPage;
    CalculatorsSteps calculatorsSteps;
    OtherCalculatorsPage otherCalculatorsPage;
    OtherCalculatorsSteps otherCalculatorsSteps;
    SettingsPage settingsPage;
    SettingsSteps settingsSteps;
    AddWorkoutPage addWorkoutPage;
    AddWorkoutSteps addWorkoutSteps;
    GearAndRoutsPage gearAndRoutsPage;
    GearAndRoutsSteps gearAndRoutsSteps;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        SelenideConfiguration.configureBrowser("");
        open("");

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        calendarPage = new CalendarPage();
        calendarSteps = new CalendarSteps();
        calculatorsPage = new CalculatorsPage();
        calculatorsSteps = new CalculatorsSteps();
        otherCalculatorsPage = new OtherCalculatorsPage();
        otherCalculatorsSteps = new OtherCalculatorsSteps();
        settingsPage = new SettingsPage();
        settingsSteps = new SettingsSteps();
        addWorkoutPage = new AddWorkoutPage();
        addWorkoutSteps = new AddWorkoutSteps();
        gearAndRoutsPage = new GearAndRoutsPage();
        gearAndRoutsSteps = new GearAndRoutsSteps();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }
}