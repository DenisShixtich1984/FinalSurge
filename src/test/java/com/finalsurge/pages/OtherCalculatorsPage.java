package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.PropertyReader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OtherCalculatorsPage {
    PropertyReader reader = new PropertyReader();
    public SelenideElement buttonOtherCalculators = $(By.className("icsw16-calculator"));
    public SelenideElement CalculatorFrame = $(By.id("OtherCalciFrame"));
    public SelenideElement textInFrame = $x("//h4[text()='Daily Caloric Needs Calculator']");
    public SelenideElement fieldWeight = $(By.id("Weight"));
    public SelenideElement radioButtonKg = $(By.id("optionsRadios4"));
    public SelenideElement fieldHeight = $(By.id("HeightInchCent"));
    public SelenideElement radioButtonCm = $x("//input[@value='m']");
    public SelenideElement fieldAge = $(By.id("Age"));
    public SelenideElement radioButtonGender = $(By.id("optionsRadios5"));
    public SelenideElement fieldRunDist = $(By.id("RunDist"));
    public SelenideElement radioButtonKm = $(By.id("optionsRadios8"));
    public SelenideElement buttonCalculateCalories = $(By.id("saveButtonSettings"));
    public SelenideElement numberOfCalories = $x("//*[@id='calorie-calc']/div/div[2]/div[2]/table/tbody/tr/td[2]");
    public SelenideElement generalErrorMessage = $x("//*[@class='alert alert-error']");

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

}
