package com.finalsurge.steps;

import com.finalsurge.pages.GearAndRoutsPage;
import com.finalsurge.pages.LoginPage;
import com.finalsurge.utils.IPageConstants;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.textCaseSensitive;

public class GearAndRoutsSteps implements IPageConstants {
    LoginPage loginPage;
    GearAndRoutsPage gearAndRoutsPage;

    public GearAndRoutsSteps (){
        loginPage = new LoginPage();
        gearAndRoutsPage = new GearAndRoutsPage();
    }
    @Step
    public GearAndRoutsSteps addBike (){
        loginPage
                .login();
        gearAndRoutsPage
                .createBike();
        return this;
    }
    @Step
    public GearAndRoutsSteps addBikeWithMistake (){
        loginPage
                .login();
        gearAndRoutsPage
                .createBikeWithMistake()
                .errorMessageEmptyFieldName.shouldHave(textCaseSensitive(ERROR_MESSAGE_EMPTY_NAME));
        return this;
    }
    @Step
    public GearAndRoutsSteps addShoes () {
        loginPage
                .login();
        gearAndRoutsPage
                .createShoes();

        return this;
    }
    @Step
    public GearAndRoutsSteps addShoesWithMistake () {
        loginPage
                .login();
        gearAndRoutsPage
                .createShoesWithMistake()
                .errorMessageFakeDate.shouldHave((textCaseSensitive(ERROR_MESSAGE_FAKE_DATE)));
        return this;
    }
}
