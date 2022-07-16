package com.finalsurge.steps;

import com.codeborne.selenide.Condition;
import com.finalsurge.pages.LoginPage;
import com.finalsurge.pages.OtherCalculatorsPage;
import com.finalsurge.utils.PropertyReader;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;

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
    public OtherCalculatorsSteps calculateCalories () {
        loginPage
                .login();
        otherCalculatorsPage
                .createCaloricCalculate()
                .numberOfCalories.shouldHave(exactText(reader.getProperty("numberCalFromCalculate")));
        return this;
    }
    @Step
    public OtherCalculatorsSteps calculateCalorieWithError () {
        loginPage
                .login();
        otherCalculatorsPage
                .createCaloricCalculateWithError()
                .generalErrorMessage.shouldHave(Condition.textCaseSensitive(reader.getProperty("expectedWeightError")));
        return this;
    }
}