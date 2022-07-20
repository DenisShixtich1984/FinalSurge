package com.finalsurge.steps;

import com.finalsurge.pages.LoginPage;
import com.finalsurge.pages.OtherCalculatorsPage;
import com.finalsurge.utils.PropertyReader;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.textCaseSensitive;

public class OtherCalculatorsSteps {
    LoginPage loginPage;
    OtherCalculatorsPage otherCalculatorsPage;
    PropertyReader reader;

    public OtherCalculatorsSteps() {
        loginPage = new LoginPage();
        otherCalculatorsPage = new OtherCalculatorsPage();
        reader = new PropertyReader();
    }

    @Step
    public OtherCalculatorsSteps calculateCalories() {
        loginPage
                .login();
        otherCalculatorsPage
                .createCaloricCalculate()
                .tableAfterResult.shouldHave(textCaseSensitive(reader.getProperty("numberCalFromCalculate")));
        return this;
    }

    @Step
    public OtherCalculatorsSteps calculateCalorieWithError() {
        loginPage
                .login();
        otherCalculatorsPage
                .createCaloricCalculateWithError()
                .generalErrorMessage.shouldHave(textCaseSensitive(reader.getProperty("expectedWeightError")));
        return this;
    }

    @Step
    public OtherCalculatorsSteps createStepsPeaceCalculate() {
        loginPage
                .login();
        otherCalculatorsPage
                .createPeaceCalculate()
                .result.shouldHave(textCaseSensitive(reader.getProperty("speed")));
        return this;
    }

    @Step
    public OtherCalculatorsSteps createStepsPeaceCalculateWithError() {
        loginPage
                .login();
        otherCalculatorsPage
                .createPeaceCalculateWithError()
                .errorMessage.shouldHave(textCaseSensitive(reader.getProperty("messageErrorDistance")));
        return this;
    }
}