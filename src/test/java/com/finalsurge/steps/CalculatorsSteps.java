package com.finalsurge.steps;

import com.finalsurge.pages.CalculatorsPage;
import com.finalsurge.pages.DashboardPage;
import com.finalsurge.pages.LoginPage;
import com.finalsurge.utils.IPageConstants;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class CalculatorsSteps implements IPageConstants {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CalculatorsPage calculatorsPage;

    public CalculatorsSteps() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        calculatorsPage = new CalculatorsPage();
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
                .messageNumberAfterEnterDate.shouldHave(exactText(EXPECTED_MESSAGE));
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
                .errorMassageFrame.shouldHave(textCaseSensitive(ERROR_MESSAGE_SECOND));
        return this;
    }
}
