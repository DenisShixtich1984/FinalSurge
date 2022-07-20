package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OtherCalculatorsPage extends BasePage{
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
        textInFrame.shouldHave(exactText(reader.getProperty("textMassageCalculate")));
        fieldWeight.sendKeys(reader.getProperty("Weight"));
        radioButtonKg.click();
        fieldHeight.sendKeys(reader.getProperty("Height"));
        radioButtonCm.click();
        fieldAge.sendKeys(reader.getProperty("Age"));
        radioButtonGender.click();
        fieldRunDist.sendKeys(reader.getProperty("Dist"));
        radioButtonKm.click();
        buttonCalculateCalories.click();
        return this;
    }

    public OtherCalculatorsPage createCaloricCalculateWithError() {
        buttonOtherCalculators.click();
        Selenide.switchTo().frame(CalculatorFrame);
        fieldHeight.sendKeys(reader.getProperty("Height"));
        radioButtonCm.click();
        fieldAge.sendKeys(reader.getProperty("Age"));
        radioButtonGender.click();
        fieldRunDist.sendKeys(reader.getProperty("Dist"));
        radioButtonKm.click();
        buttonCalculateCalories.click();
        return this;
    }

    public OtherCalculatorsPage createPeaceCalculate() {
        buttonOtherCalculators.click();
        Selenide.switchTo().frame(CalculatorFrame);
        buttonPaceCalculator.click();
        textPaceCalculator.shouldBe(visible);
        fieldDistance.sendKeys(reader.getProperty("fieldDistance"));
        selectMeasureElement.click();
        selectKm.click();
        hours.sendKeys(reader.getProperty("hours"));
        minutes.sendKeys(reader.getProperty("minutes"));
        seconds.sendKeys(reader.getProperty("seconds"));
        saveButtonSettings.click();
        return this;
    }

    public OtherCalculatorsPage createPeaceCalculateWithError() {
        buttonOtherCalculators.click();
        Selenide.switchTo().frame(CalculatorFrame);
        buttonPaceCalculator.click();
        textPaceCalculator.shouldBe(visible);
        fieldDistance.sendKeys(reader.getProperty("fieldDistanceWithError"));
        selectMeasureElement.click();
        selectKm.click();
        minutes.sendKeys(reader.getProperty("minutes"));
        saveButtonSettings.click();
        return this;
    }
}