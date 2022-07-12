package tests;
import browser.SelenideConfiguration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CalendarPage;
import pages.DashboardPage;
import pages.LoginPage;
import steps.CalendarSteps;

import static com.codeborne.selenide.Selenide.open;

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
    @AfterMethod
    public void closeBrowser () {
        Selenide.closeWebDriver();
    }
}