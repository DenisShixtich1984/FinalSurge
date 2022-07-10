package tests;
import browser.SelenideConfiguration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LoginPage;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod (alwaysRun = true)
    public void setUp() {

        SelenideConfiguration.configureBrowser("");
        open("");

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }
    @AfterMethod
    public void closeBrowser () {
        Selenide.closeWebDriver();
    }
}