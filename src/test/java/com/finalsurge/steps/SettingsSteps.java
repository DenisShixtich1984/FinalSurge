package com.finalsurge.steps;
import com.codeborne.selenide.Condition;
import com.finalsurge.pages.LoginPage;
import com.finalsurge.pages.SettingsPage;
import com.finalsurge.utils.PropertyReader;
import io.qameta.allure.Step;

public class SettingsSteps {
    LoginPage loginPage;
    SettingsPage settingsPage;
    PropertyReader reader;

    public SettingsSteps() {
        loginPage = new LoginPage();
        settingsPage = new SettingsPage();
        reader = new PropertyReader();
    }

    @Step
    public SettingsSteps editDataInfo() {
        loginPage
                .login();
        settingsPage
                .editData()
                .editProfile.shouldHave(Condition.textCaseSensitive(reader.getProperty("country")));
        return this;
    }

    @Step
    public SettingsSteps editDataInfoWithError() {
        loginPage
                .login();
        settingsPage
                .editDataWithError()
                .errorMessageWrongSymbol.shouldHave(Condition.textCaseSensitive(reader.getProperty("errorWrongSymbols")));
        return this;
    }

}
