package tests;
import org.testng.annotations.Test;
public class LoginTest extends BaseTest{

    @Test
    public void loginStart () {
        loginPage.login();
    }
}
