package com.finalsurge.steps;

import com.finalsurge.pages.CalculatorsPage;
import com.finalsurge.pages.DashboardPage;
import com.finalsurge.pages.LoginPage;
import com.finalsurge.utils.PropertyReader;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class CalculatorsSteps {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CalculatorsPage calculatorsPage;
    PropertyReader reader;

    public CalculatorsSteps() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        calculatorsPage = new CalculatorsPage();
        reader = new PropertyReader();
    }

    @Step()
    public CalculatorsSteps calculateDistance() {
        loginPage
                .login();
        dashboardPage
                .titleDashboard.shouldBe(visible);
        calculatorsPage
                .createWorkoutCalculator()
                .messageAfterEnterDate.shouldBe(visible);
        calculatorsPage
                .messageNumberAfterEnterDate.shouldHave(exactText(reader.getProperty("expectedMessage")));
        return this;
    }

    @Step()
    public CalculatorsSteps calculateDistanceWithError() {
        loginPage
                .login();
        dashboardPage
                .titleDashboard.shouldBe(visible);
        calculatorsPage
                .createCalculatorWithMistake()
                .errorMassageFrame.shouldHave(textCaseSensitive(reader.getProperty("ErrorMessageAboutSecond")));
        return this;
    }
}
