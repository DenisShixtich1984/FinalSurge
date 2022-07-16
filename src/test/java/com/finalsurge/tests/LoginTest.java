package com.finalsurge.tests;

import org.testng.annotations.Test;
import io.qameta.allure.*;

import static com.codeborne.selenide.Condition.visible;

public class LoginTest extends BaseTest {
    /**
     * This class consists of two tests. A positive test ("FS-1") for the successful authorization
     * of the user with a check on the Dashboard. The second test ("FS-2") is for the introduction
     * of a non-valid password with the verification of an error message.
     */
    @Test
    @TmsLink("FS-1")
    public void loginStart() {
        loginPage.login();
        dashboardPage.titleDashboard.shouldBe(visible);
    }

    @Test
    @TmsLink("FS-2")
    public void loginStartWithFalsePassport() {
        loginPage.falseLogin();
        loginPage.errorMassage.shouldBe(visible);

    }
}
