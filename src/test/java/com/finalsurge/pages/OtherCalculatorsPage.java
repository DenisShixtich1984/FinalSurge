package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.IPageConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class OtherCalculatorsPage extends BasePage implements IPageConstants {

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
    public SelenideElement messageAfterResult = $(byText("Training Calories"));
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
    public SelenideElement resultText = $(byText("Time"));
    public SelenideElement errorMessage = $(By.className("alert"));

    public OtherCalculatorsPage createCaloricCalculate() {
        log.info("createCaloricCalculate: workout calorie expenditure calculator with faker data");
        buttonOtherCalculators.click();
        Selenide.switchTo().frame(CalculatorFrame);
        textInFrame.shouldHave(exactText(TEXT_MESSAGE_CALCULATE));
        fieldWeight.sendKeys(String.valueOf(faker.number().numberBetween(70, 100)));
        radioButtonKg.click();
        fieldHeight.sendKeys(String.valueOf(faker.number().numberBetween(170, 200)));
        radioButtonCm.click();
        fieldAge.sendKeys(String.valueOf(faker.number().numberBetween(30, 40)));
        radioButtonGender.click();
        fieldRunDist.sendKeys(String.valueOf(faker.number().numberBetween(15, 25)));
        radioButtonKm.click();
        buttonCalculateCalories.click();
        return this;
    }

    public OtherCalculatorsPage createCaloricCalculateWithError() {
        log.info("createCaloricCalculateWithError: weight error in the calorie calculator during exercise");
        buttonOtherCalculators.click();
        Selenide.switchTo().frame(CalculatorFrame);
        fieldHeight.sendKeys(String.valueOf(faker.number().numberBetween(170, 200)));
        radioButtonCm.click();
        fieldAge.sendKeys(String.valueOf(faker.number().numberBetween(30, 40)));
        radioButtonGender.click();
        fieldRunDist.sendKeys(String.valueOf(faker.number().numberBetween(15, 25)));
        radioButtonKm.click();
        buttonCalculateCalories.click();
        return this;
    }

    public OtherCalculatorsPage createPeaceCalculate() {
        log.info("createPeaceCalculate: calculator of running pace during training with faker data");
        buttonOtherCalculators.click();
        Selenide.switchTo().frame(CalculatorFrame);
        buttonPaceCalculator.click();
        textPaceCalculator.shouldBe(visible);
        fieldDistance.sendKeys(String.valueOf(faker.number().numberBetween(15, 25)));
        selectMeasureElement.click();
        selectKm.click();
        hours.sendKeys(String.valueOf(faker.number().numberBetween(1, 2)));
        minutes.sendKeys(String.valueOf(faker.number().numberBetween(10, 55)));
        seconds.sendKeys(String.valueOf(faker.number().numberBetween(1, 59)));
        saveButtonSettings.click();
        return this;
    }

    public OtherCalculatorsPage createPeaceCalculateWithError() {
        log.info("createPeaceCalculateWithError: creating a workout with an invalid distance");
        buttonOtherCalculators.click();
        Selenide.switchTo().frame(CalculatorFrame);
        buttonPaceCalculator.click();
        textPaceCalculator.shouldBe(visible);
        fieldDistance.sendKeys(String.valueOf(faker.animal().name()));
        selectMeasureElement.click();
        selectKm.click();
        minutes.sendKeys(String.valueOf(faker.number().numberBetween(1, 59)));
        saveButtonSettings.click();
        return this;
    }
}
