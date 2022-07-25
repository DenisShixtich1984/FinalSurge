package com.finalsurge.pages;

import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.IPageConstants;
import com.finalsurge.utils.IVariables;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SettingsPage implements IPageConstants, IVariables {
    Faker faker = new Faker();
    public SelenideElement buttonSettings = $(byText("Settings"));
    public SelenideElement buttonEditProfile = $(By.className("dropdown-toggle"));
    public SelenideElement genderRadioButton = $(By.id("male"));
    public SelenideElement fieldBDay = $(By.id("BDay"));
    public SelenideElement enterDate = $x("//table//tr[3]//td[7]");
    public SelenideElement saveButtonProfile = $(By.id("saveButtonProfile"));
    public SelenideElement weight = $(By.id("Weight"));
    public SelenideElement radioButtonKg = $(By.id("optionsRadios4"));
    public SelenideElement selectCountry = $(By.id("Country"));
    public SelenideElement selectBelarus = $(byText("Belarus"));
    public SelenideElement inputCity = $(By.id("City"));
    public SelenideElement editProfile = $(By.className("span10"));
    public SelenideElement errorMessageWrongSymbol = $(By.className("alert"));

    public SettingsPage editData() {
        buttonSettings.click();
        buttonEditProfile.click();
        genderRadioButton.click();
        fieldBDay.click();
        enterDate.click();
        weight.clear();
        weight.sendKeys(String.valueOf(faker.number().numberBetween(70, 100)));
        inputCity.clear();
        inputCity.sendKeys(CITY);
        selectCountry.click();
        selectBelarus.click();
        radioButtonKg.click();
        saveButtonProfile.click();
        return this;
    }

    public SettingsPage editDataWithError() {
        buttonSettings.click();
        buttonEditProfile.click();
        fieldBDay.clear();
        fieldBDay.sendKeys(String.valueOf(faker.animal().name()));
        saveButtonProfile.click();
        return this;
    }
}