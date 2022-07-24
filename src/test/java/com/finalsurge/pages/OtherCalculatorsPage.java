package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.IPageConstants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OtherCalculatorsPage implements IPageConstants {
    public SelenideElement buttonOtherCalculators = $(By.className("icsw16-calculator"));
    public SelenideElement CalculatorFrame = $(By.id("OtherCalciFrame"));
    public SelenideElement textInFrame = $(byText("Daily Caloric Needs Calculator"));
    public SelenideElement fieldWeight = $(By.id("Weight"));
    public SelenideElement radioButtonKg = $(By.id("optionsRadios4"));
    public SelenideElement fieldHeight = $(By.id("HeightInchCent"));
    public SelenideElement radioButtonCm = $x("//input[@value='m']");
    public SelenideElement fieldAge = $(By.id("Age"));
    public SelenideElement radioButtonGender = $(By.id("optionsRadios5"));
    public SelenideElement fieldRunDist = $(By.id("RunDist"));
    public SelenideElement radioButtonKm = $(By.id("optionsRadios8"));
    public SelenideElement buttonCalculateCalories = $(By.id("saveButtonSettings"));
    public SelenideElement tableAfterResult = $(By.className("table"));
    public SelenideElement generalErrorMessage = $(By.className("alert"));
    public SelenideElement buttonPaceCalculator = $(byText("Pace Calculator"));
    public SelenideElement textPaceCalculator = $(byText("Pace Calculator"));
    public SelenideElement fieldDistance = $(By.id("RunDist"));
    public SelenideElement selectMeasureElement = $(By.id("DistType"));
    public SelenideElement selectKm = $x("//*[@id='DistType']/option[2]");
    public SelenideElement hours = $(By.id("TimeHH"));
    public SelenideElement minutes = $(By.id("TimeMM"));
    public SelenideElement seconds = $(By.id("TimeSS"));
    public SelenideElement saveButtonSettings = $(By.id("saveButtonSettings"));
    public SelenideElement result = $(By.className("table"));
    public SelenideElement errorMessage = $(By.className("alert"));

    public OtherCalculatorsPage createCaloricCalculate() {
        buttonOtherCalculators.click();
        Selenide.switchTo().frame(CalculatorFrame);
        textInFrame.shouldHave(exactText(TEXT_MESSAGE_CALCULATE));
        fieldWeight.sendKeys(WEIGHT);
        radioButtonKg.click();
        fieldHeight.sendKeys(HEIGHT);
        radioButtonCm.click();
        fieldAge.sendKeys(AGE);
        radioButtonGender.click();
        fieldRunDist.sendKeys(DIST);
        radioButtonKm.click();
        buttonCalculateCalories.click();
        return this;
    }

    public OtherCalculatorsPage createCaloricCalculateWithError() {
        buttonOtherCalculators.click();
        Selenide.switchTo().frame(CalculatorFrame);
        fieldHeight.sendKeys(HEIGHT);
        radioButtonCm.click();
        fieldAge.sendKeys(AGE);
        radioButtonGender.click();
        fieldRunDist.sendKeys(DIST);
        radioButtonKm.click();
        buttonCalculateCalories.click();
        return this;
    }

    public OtherCalculatorsPage createPeaceCalculate() {
        buttonOtherCalculators.click();
        Selenide.switchTo().frame(CalculatorFrame);
        buttonPaceCalculator.click();
        textPaceCalculator.shouldBe(visible);
        fieldDistance.sendKeys(FIELD_DISTANCE);
        selectMeasureElement.click();
        selectKm.click();
        hours.sendKeys(HOUR_DIST);
        minutes.sendKeys(MINUTE_DIST);
        seconds.sendKeys(SECOND_DIST);
        saveButtonSettings.click();
        return this;
    }

    public OtherCalculatorsPage createPeaceCalculateWithError() {
        buttonOtherCalculators.click();
        Selenide.switchTo().frame(CalculatorFrame);
        buttonPaceCalculator.click();
        textPaceCalculator.shouldBe(visible);
        fieldDistance.sendKeys(FIELD_DIS_WITH_ERROR);
        selectMeasureElement.click();
        selectKm.click();
        minutes.sendKeys(MINUTE_DIST);
        saveButtonSettings.click();
        return this;
    }
}