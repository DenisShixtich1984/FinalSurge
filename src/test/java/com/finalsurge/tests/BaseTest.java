package com.finalsurge.tests;
import com.finalsurge.browser.SelenideConfiguration;
import com.codeborne.selenide.Selenide;
import com.finalsurge.steps.CalendarSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.finalsurge.pages.CalendarPage;
import com.finalsurge.pages.DashboardPage;
import com.finalsurge.pages.LoginPage;
import com.finalsurge.pages.MyListener;

import static com.codeborne.selenide.Selenide.open;
@Listeners (MyListener.class)
public class BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CalendarPage calendarPage;
    CalendarSteps calendarSteps;

    @BeforeMethod (alwaysRun = true)
    public void setUp() {

        SelenideConfiguration.configureBrowser("");
        open("");

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        calendarPage = new CalendarPage();
        calendarSteps = new CalendarSteps();
    }
    @AfterMethod (alwaysRun = true)
    public void closeBrowser () {
        Selenide.closeWebDriver();
    }
}