package com.finalsurge.steps;

import com.codeborne.selenide.Condition;
import com.finalsurge.pages.LoginPage;
import com.finalsurge.pages.SettingsPage;
import com.finalsurge.utils.IPageConstants;
import com.finalsurge.utils.IVariables;
import io.qameta.allure.Step;

public class SettingsSteps implements IPageConstants, IVariables {
    LoginPage loginPage;
    SettingsPage settingsPage;

    public SettingsSteps() {
        loginPage = new LoginPage();
        settingsPage = new SettingsPage();
    }

    @Step
    public SettingsSteps editDataInfo() {
        loginPage
                .login();
        settingsPage
                .editData()
                .editProfile.shouldHave(Condition.textCaseSensitive(COUNTY));
        return this;
    }

    @Step
    public SettingsSteps editDataInfoWithError() {
        loginPage
                .login();
        settingsPage
                .editDataWithError()
                .errorMessageWrongSymbol.shouldHave(Condition.textCaseSensitive(ERROR_WRONG_SET));
        return this;
    }
}
