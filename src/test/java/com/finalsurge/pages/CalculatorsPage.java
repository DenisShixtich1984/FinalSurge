package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalculatorsPage extends BasePage {
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
        fieldHour.sendKeys(reader.getProperty("Hour"));
        fieldMinute.sendKeys(reader.getProperty("Minute"));
        fieldSecond.sendKeys(reader.getProperty("Second"));
        saveButtonSettings.click();
        return new CalculatorsPage();
    }

    public CalculatorsPage createCalculatorWithMistake() {
        buttonCalculatorsWorkout.click();
        Selenide.switchTo().frame(iFrame);
        buttonIntensity.shouldBe(visible);
        radioButtonHalfMar.click();
        fieldHour.sendKeys(reader.getProperty("HourForError"));
        fieldMinute.sendKeys(reader.getProperty("MinuteForError"));
        saveButtonSettings.click();
        return new CalculatorsPage();
    }

}
