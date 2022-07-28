package com.finalsurge.steps;

import com.finalsurge.pages.GearAndRoutsPage;
import com.finalsurge.pages.LoginPage;
import io.qameta.allure.Step;

public class GearAndRoutsSteps {
    LoginPage loginPage;
    GearAndRoutsPage gearAndRoutsPage;

    public GearAndRoutsSteps (){
        loginPage = new LoginPage();
        gearAndRoutsPage = new GearAndRoutsPage();
    }
    @Step
    public GearAndRoutsSteps addShoes (){
        loginPage
                .login();
        gearAndRoutsPage
                .createShoes();
        return this;
    }


}
