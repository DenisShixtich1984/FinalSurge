package com.finalsurge.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.PropertyReader;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SettingsPage {
    PropertyReader reader = new PropertyReader();
    public SelenideElement buttonSettings = $x("//a[text()='Settings']");
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
    public SelenideElement selectBelarus = $x("//option[text()='Belarus']");
    public SelenideElement inputCity = $(By.id("City"));
    public SelenideElement checkCounty = $x("/html/body/div[1]/div[3]/div/div[1]/div[1]/div[2]/div/div[2]/p[6]");
    public SelenideElement editProfile = $(By.className("span10"));

    public SelenideElement errorMessageWrongSymbol = $x("//*[@class='alert alert-error']");


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






//        Selenide.switchTo().frame(iFrameUpload);
//        buttonChangeAvatar.click();

               // sendKeys(System.getProperty("user.dir")+"/src/test/resources/avatar.jpg");
  //      buttonNextStep.click();
//        buttonNextStep.click();
//        saveButtonProfile.click();



//        genderRadioButton.click();
//        fieldBDay.sendKeys(reader.getProperty("BDay"));





}
