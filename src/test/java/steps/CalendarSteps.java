package steps;

import static com.codeborne.selenide.Condition.visible;

import io.qameta.allure.Step;
import pages.CalendarPage;
import pages.DashboardPage;
import pages.LoginPage;

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
}
