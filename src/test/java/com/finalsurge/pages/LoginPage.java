package com.finalsurge.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{
    public SelenideElement inputEmail = $(By.id("login_name"));
    public SelenideElement inputPassword = $(By.id("login_password"));
    public SelenideElement buttonLogin = $(By.className("btn"));
    public SelenideElement errorMassage = $(byText("Invalid login credentials. Please try again."));


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
