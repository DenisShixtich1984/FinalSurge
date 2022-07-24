package com.finalsurge.pages;

import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.IPageConstants;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage implements IPageConstants {
    public SelenideElement inputEmail = $(By.id("login_name"));
    public SelenideElement inputPassword = $(By.id("login_password"));
    public SelenideElement buttonLogin = $(By.className("btn"));
    public SelenideElement errorMassage = $(byText("Invalid login credentials. Please try again."));


    public void login() {
        inputEmail.sendKeys(MY_MAIL);
        inputPassword.sendKeys(MY_PASSWORD);
        buttonLogin.click();
    }

    public void falseLogin() {
        inputEmail.sendKeys(MY_MAIL);
        inputPassword.sendKeys(INVALID_PASSWORD);
        buttonLogin.click();
    }
}
