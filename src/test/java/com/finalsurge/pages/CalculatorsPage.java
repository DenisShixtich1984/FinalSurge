package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.PropertyReader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalculatorsPage {
    PropertyReader reader = new PropertyReader();
    public SelenideElement buttonCalculatorsWorkout = $(By.className("icsw16-stop-watch"));
    public SelenideElement iFrame = $(By.id("IntensityCalciFrame"));
    public SelenideElement buttonIntensity = $x("//button[text()='Intensity']");
    public SelenideElement radioButton10km = $(By.id("TENK"));
    public SelenideElement radioButtonHalfMar = $(By.id("HALFMAR"));
    public SelenideElement fieldHour = $(By.id("TimeHH"));
    public SelenideElement fieldMinute = $(By.id("TimeMM"));
    public SelenideElement fieldSecond = $(By.id("TimeSS"));
    public SelenideElement saveButtonSettings = $(By.id("saveButtonSettings"));
    public SelenideElement messageAfterEnterDate = $x("//*[@id='intensity-calc']/div/div[3]/div[1]/h4");
    public SelenideElement messageNumberAfterEnterDate = $x("//*[@id='intensity-calc']/div/div[3]/div[2]/table/tbody/tr[2]/td[4]");
    public SelenideElement errorMassageFrame = $x("//*[@id='CalcBox']/div[1]/div/div[2]/strong");


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
