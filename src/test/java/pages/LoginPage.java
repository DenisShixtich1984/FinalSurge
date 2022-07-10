package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public SelenideElement inputEmail = $(By.id("login_name"));
    public SelenideElement inputPassword = $(By.id("login_password"));
    public SelenideElement buttonLogin = $(By.className("btn"));
    public SelenideElement errorMassage = $x("//strong[text()='Invalid login credentials. Please try again.']");


    public void login () {
        inputEmail.sendKeys("dehok@mail.ru");
        inputPassword.sendKeys("bLC*XDnyyRaCG$3");
        buttonLogin.click();

    }

    public void falseLogin () {
        inputEmail.sendKeys("dehok@mail.ru");
        inputPassword.sendKeys("bLC*XDnyyRaCG$4");
        buttonLogin.click();

    }

}
