package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement inputEmail = $(By.id("login_name"));
    public SelenideElement inputPassword = $(By.id("login_password"));
    public SelenideElement buttonLogin = $(By.className("btn"));

    public void login () {
        inputEmail.sendKeys("dehok@mail.ru");
        inputPassword.sendKeys("bLC*XDnyyRaCG$3");
        buttonLogin.click();

    }

}
