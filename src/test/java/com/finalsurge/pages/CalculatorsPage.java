package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.IPageConstants;
import com.finalsurge.utils.IVariables;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalculatorsPage implements IPageConstants, IVariables {
    Faker faker = new Faker();
    public SelenideElement buttonCalculatorsWorkout = $(By.className("icsw16-stop-watch"));
    public SelenideElement iFrame = $(By.id("IntensityCalciFrame"));
    public SelenideElement buttonIntensity = $(byText("Intensity"));
    public SelenideElement radioButton10km = $(By.id("TENK"));
    public SelenideElement radioButton5km = $(By.id("FIVEK"));
    public SelenideElement radioButtonHalfMar = $(By.id("HALFMAR"));
    public SelenideElement fieldHour = $(By.id("TimeHH"));
    public SelenideElement fieldMinute = $(By.id("TimeMM"));
    public SelenideElement fieldSecond = $(By.id("TimeSS"));
    public SelenideElement saveButtonSettings = $(By.id("saveButtonSettings"));
    public SelenideElement messageAfterEnterDate = $(byText("Your Workout Paces"));
    public SelenideElement errorMassageFrame = $(By.className("alert"));
    public SelenideElement checkMessageCalculate = $(byText("Your Workout Paces"));
    public SelenideElement messageText = $(byText("10:21 /km"));


    public CalculatorsPage createWorkoutCalculator() {
        buttonCalculatorsWorkout.click();
        Selenide.switchTo().frame(iFrame);
        buttonIntensity.shouldBe(visible);
        radioButton10km.click();
        fieldHour.sendKeys(String.valueOf(faker.number().numberBetween(1, 2)));
        fieldMinute.sendKeys(String.valueOf(faker.number().numberBetween(20, 45)));
        fieldSecond.sendKeys(String.valueOf(faker.number().numberBetween(10, 55)));
        saveButtonSettings.click();
        return new CalculatorsPage();
    }

    public CalculatorsPage createCalculatorWithMistake() {
        buttonCalculatorsWorkout.click();
        Selenide.switchTo().frame(iFrame);
        buttonIntensity.shouldBe(visible);
        radioButtonHalfMar.click();
        fieldHour.sendKeys(String.valueOf(faker.number().numberBetween(0, 2)));
        fieldMinute.sendKeys(String.valueOf(faker.number().numberBetween(12, 35)));
        saveButtonSettings.click();
        return new CalculatorsPage();
    }

    public CalculatorsPage createWorkoutCalculatorWithAccurateData() {
        buttonCalculatorsWorkout.click();
        Selenide.switchTo().frame(iFrame);
        buttonIntensity.shouldBe(visible);
        radioButton5km.click();
        fieldHour.sendKeys(HOURS_PACE);
        fieldMinute.sendKeys(MINUTES_PACE);
        fieldSecond.sendKeys(SECONDS_PACE);
        saveButtonSettings.click();
        return new CalculatorsPage();
    }
}
