package tests;

import browser.SelenideConfiguration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    LoginPage loginPage;

    @BeforeMethod (alwaysRun = true)
    public void setUp() {

        SelenideConfiguration.configureBrowser("");
        open();

        loginPage = new LoginPage();
    }
    @AfterMethod
    public void closeBrowser () {
        Selenide.closeWebDriver();
    }
}