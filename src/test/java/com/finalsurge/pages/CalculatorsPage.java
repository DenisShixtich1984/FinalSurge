package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.IPageConstants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalculatorsPage implements IPageConstants {
    public SelenideElement buttonCalculatorsWorkout = $(By.className("icsw16-stop-watch"));
    public SelenideElement iFrame = $(By.id("IntensityCalciFrame"));
    public SelenideElement buttonIntensity = $(byText("Intensity"));
    public SelenideElement radioButton10km = $(By.id("TENK"));
    public SelenideElement radioButtonHalfMar = $(By.id("HALFMAR"));
    public SelenideElement fieldHour = $(By.id("TimeHH"));
    public SelenideElement fieldMinute = $(By.id("TimeMM"));
    public SelenideElement fieldSecond = $(By.id("TimeSS"));
    public SelenideElement saveButtonSettings = $(By.id("saveButtonSettings"));
    public SelenideElement messageAfterEnterDate = $(byText("Your Workout Paces"));
    public SelenideElement messageNumberAfterEnterDate = $(byText("8:13 /km"));
    public SelenideElement errorMassageFrame = $(By.className("alert"));


    public CalculatorsPage createWorkoutCalculator() {
        buttonCalculatorsWorkout.click();
        Selenide.switchTo().frame(iFrame);
        buttonIntensity.shouldBe(visible);
        radioButton10km.click();
        fieldHour.sendKeys(HOUR_CALC);
        fieldMinute.sendKeys(MINUTE_CALC);
        fieldSecond.sendKeys(SECOND_CALC);
        saveButtonSettings.click();
        return new CalculatorsPage();
    }

    public CalculatorsPage createCalculatorWithMistake() {
        buttonCalculatorsWorkout.click();
        Selenide.switchTo().frame(iFrame);
        buttonIntensity.shouldBe(visible);
        radioButtonHalfMar.click();
        fieldHour.sendKeys(HOUR_FOR_ERROR);
        fieldMinute.sendKeys(MINUTE_FOR_ERROR);
        saveButtonSettings.click();
        return new CalculatorsPage();
    }

}
