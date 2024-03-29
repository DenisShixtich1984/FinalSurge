package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.IPageConstants;
import com.finalsurge.utils.IVariables;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CalculatorsPage extends BasePage implements IPageConstants, IVariables {
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
        log.info("createWorkoutCalculator: calculator of training intensity with any variations distance and time");
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
        log.info("createCalculatorWithMistake: creating a calculator with an error: empty seconds field");
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
        log.info("createWorkoutCalculatorWithAccurateData: workout intensity calculator with" +
                " hour interval = '0', minute interval = '45' and seconds interval = '15'");
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
