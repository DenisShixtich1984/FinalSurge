package com.finalsurge.steps;

import com.finalsurge.pages.LoginPage;
import com.finalsurge.pages.OtherCalculatorsPage;
import com.finalsurge.utils.IPageConstants;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.textCaseSensitive;

public class OtherCalculatorsSteps implements IPageConstants {
    LoginPage loginPage;
    OtherCalculatorsPage otherCalculatorsPage;

    public OtherCalculatorsSteps() {
        loginPage = new LoginPage();
        otherCalculatorsPage = new OtherCalculatorsPage();
    }

    @Step
    public OtherCalculatorsSteps calculateCalories() {
        loginPage
                .login();
        otherCalculatorsPage
                .createCaloricCalculate()
                .messageAfterResult.shouldHave(textCaseSensitive(MESSAGE_CAL_FROM_CALCULATE));
        return this;
    }

    @Step
    public OtherCalculatorsSteps calculateCalorieWithError() {
        loginPage
                .login();
        otherCalculatorsPage
                .createCaloricCalculateWithError()
                .generalErrorMessage.shouldHave(textCaseSensitive(EXPECTED_WEIGHT_ERROR));
        return this;
    }

    @Step
    public OtherCalculatorsSteps createStepsPeaceCalculate() {
        loginPage
                .login();
        otherCalculatorsPage
                .createPeaceCalculate()
                .resultText.shouldHave(textCaseSensitive(MESSAGE_CALC));
        return this;
    }

    @Step
    public OtherCalculatorsSteps createStepsPeaceCalculateWithError() {
        loginPage
                .login();
        otherCalculatorsPage
                .createPeaceCalculateWithError()
                .errorMessage.shouldHave(textCaseSensitive(MESSAGE_ERROR_DIS));
        return this;
    }
}