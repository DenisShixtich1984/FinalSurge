package com.finalsurge.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class DashboardPage extends BasePage{
    public SelenideElement titleDashboard = $(byText("Dashboard"));

}
