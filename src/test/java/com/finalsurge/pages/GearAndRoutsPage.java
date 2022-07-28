package com.finalsurge.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class GearAndRoutsPage {
    Faker faker = new Faker();
    public SelenideElement buttonGear = $(byText("Gear & Routes"));
    public SelenideElement buttonBikes = $(byText("Bikes"));
    public SelenideElement fieldBikesName = $(byId("ShoeName"));
    public SelenideElement fieldShoeDate = $(byId("ShoeDate"));
    public SelenideElement fieldStartDist = $(byId("StartDist"));
    public SelenideElement distType = $(byId("DistType"));
    public SelenideElement datePurchased = $x("(//*[@class=' table-condensed'])/tbody/tr[2]/td[6]");
    public SelenideElement shoeModel = $(byId("ShoeModel"));
    public SelenideElement shoeCost = $(byId("ShoeCost"));
    public SelenideElement shoeNotes = $(byId("ShoeNotes"));
    public SelenideElement saveButton = $(byId("saveButton"));

    public GearAndRoutsPage createShoes () {
        actions().moveToElement(buttonGear).build().perform();
        buttonBikes.click();
        fieldBikesName.sendKeys(faker.name().firstName());
        fieldShoeDate.click();
        datePurchased.click();
        fieldStartDist.clear();
        fieldStartDist.sendKeys(String.valueOf(faker.number().numberBetween(12000, 35000)));
        distType.selectOption(1);
        shoeModel.sendKeys(faker.artist().name());
        shoeCost.sendKeys(String.valueOf(faker.number().numberBetween(120, 3500)));
        shoeNotes.sendKeys(faker.backToTheFuture().quote());
        saveButton.click();
        return this;
    }
}
