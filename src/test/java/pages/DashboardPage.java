package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    public SelenideElement titleDashboard = $x("//a[text()='Dashboard']");

}
