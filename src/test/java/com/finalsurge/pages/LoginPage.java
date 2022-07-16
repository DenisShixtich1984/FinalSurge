package com.finalsurge.pages;

import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.PropertyReader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    PropertyReader reader = new PropertyReader();
    public SelenideElement inputEmail = $(By.id("login_name"));
    public SelenideElement inputPassword = $(By.id("login_password"));
    public SelenideElement buttonLogin = $(By.className("btn"));
    public SelenideElement errorMassage = $x("//strong[text()='Invalid login credentials. Please try again.']");


    public void login() {
        inputEmail.sendKeys(reader.getProperty("MyMail"));
        inputPassword.sendKeys(reader.getProperty("MyPassword"));
        buttonLogin.click();
    }

    public void falseLogin() {
        inputEmail.sendKeys(reader.getProperty("MyMail"));
        inputPassword.sendKeys(reader.getProperty("invalidPassword"));
        buttonLogin.click();
    }
}
