package tests;
import org.testng.annotations.Test;
import io.qameta.allure.*;
import static com.codeborne.selenide.Condition.visible;

public class LoginTest extends BaseTest{

    @Test
    @TmsLink("FS-1")
    public void loginStart () {
        loginPage.login();
        dashboardPage.titleDashboard.shouldBe(visible);
    }
    @Test
    @TmsLink("FS-2")
    public void loginStartWithFalsePassport () {
        loginPage.falseLogin();
        loginPage.errorMassage.shouldBe(visible);
    }

}
