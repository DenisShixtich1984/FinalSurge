package com.finalsurge.pages;

import com.codeborne.selenide.SelenideElement;
import com.finalsurge.utils.PropertyReader;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
@Log4j2
public class LoginPage extends BasePage {

    public SelenideElement inputEmail = $(By.id("login_name"));
    public SelenideElement inputPassword = $(By.id("login_password"));
    public SelenideElement buttonLogin = $(By.className("btn"));
    public SelenideElement errorMassage = $(byText("Invalid login credentials. Please try again."));

    public void login() {
        log.info("LoginPage,login");
        inputEmail.sendKeys(PropertyReader.getProperty("MY_MAIL"));
        inputPassword.sendKeys(PropertyReader.getProperty("MY_PASSWORD"));
        buttonLogin.click();
    }

    public void falseLogin() {
        log.info("LoginPage,falseLogin");
        inputEmail.sendKeys(PropertyReader.getProperty("MY_MAIL"));
        inputPassword.sendKeys(faker.name().firstName());
        buttonLogin.click();
    }
}
