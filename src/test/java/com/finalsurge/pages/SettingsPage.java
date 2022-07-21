package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SettingsPage extends BasePage {
    public SelenideElement buttonSettings = $(byText("Settings"));
    public SelenideElement buttonEditProfile = $(By.className("dropdown-toggle"));
    public SelenideElement genderRadioButton = $(By.id("male"));
    public SelenideElement fieldBDay = $(By.id("BDay"));
    public SelenideElement buttonChangeImage = $(By.id("EditProfilePicOther"));
    public SelenideElement buttonChangeAvatar = $(By.name("profilepic"));
    public SelenideElement buttonNextStep = $(By.id("NextStep"));
    public SelenideElement saveButtonProfile = $(By.id("saveButtonProfile"));
    public SelenideElement iFrameUpload = $(By.className("main-wrapper"));
    public SelenideElement cancel = $(By.id("Cancel"));
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
        weight.clear();
        weight.sendKeys(reader.getProperty("weight"));
        inputCity.clear();
        inputCity.sendKeys(reader.getProperty("city"));
        selectCountry.click();
        selectBelarus.click();
        radioButtonKg.click();
        fieldBDay.clear();
        fieldBDay.sendKeys(reader.getProperty("BDay"));
        saveButtonProfile.click();
        return this;
    }

    public SettingsPage editDataWithError() {
        buttonSettings.click();
        buttonEditProfile.click();
        fieldBDay.clear();
        fieldBDay.sendKeys(reader.getProperty("WrongSymbol"));
        saveButtonProfile.click();
        return this;
    }

    public SettingsPage editPhoto() {
        buttonSettings.click();
        buttonEditProfile.click();
        buttonChangeImage.click();
        Selenide.switchTo().frame(iFrameUpload);
        buttonChangeAvatar.click();

//
//        buttonChangeAvatar.click();

        // sendKeys(System.getProperty("user.dir")+"/src/test/resources/avatar.jpg");
        //      buttonNextStep.click();
//        buttonNextStep.click();
//        saveButtonProfile.click();


//        genderRadioButton.click();
//        fieldBDay.sendKeys(reader.getProperty("BDay"));
        return this;
    }
}