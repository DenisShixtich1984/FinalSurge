package com.finalsurge.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
@Log4j2
public class GearAndRoutsPage extends BasePage {
    public SelenideElement buttonGear = $(byText("Gear & Routes"));
    public SelenideElement buttonBikes = $(byText("Bikes"));
    public SelenideElement buttonShoes = $(byText("Shoes"));
    public SelenideElement fieldName = $(byId("ShoeName"));
    public SelenideElement fieldShoeDate = $(byId("ShoeDate"));
    public SelenideElement shoeShoeSize = $(byId("ShoeSize"));
    public SelenideElement shoeDistAlert = $(byId("DistAlert"));
    public SelenideElement shoeDistAlertType = $(byId("DistAlertType"));

    public SelenideElement fieldStartDist = $(byId("StartDist"));
    public SelenideElement distType = $(byId("DistType"));
    public SelenideElement datePurchased = $x("(//*[@class=' table-condensed'])/tbody/tr[2]/td[6]");
    public SelenideElement shoeModel = $(byId("ShoeModel"));
    public SelenideElement shoeCost = $(byId("ShoeCost"));
    public SelenideElement shoeNotes = $(byId("ShoeNotes"));
    public SelenideElement saveButton = $(byId("saveButton"));
    public SelenideElement errorMessageFakeDate = $x("//*[@class='alert alert-error']");
    public SelenideElement errorMessageEmptyFieldName = $(byClassName("error"));

    public GearAndRoutsPage createBike () {
        log.info("GearAndRoutsPage,createBike");
        actions().moveToElement(buttonGear).build().perform();
        buttonBikes.click();
        fieldName.sendKeys(faker.name().firstName());
        fieldShoeDate.click();
        datePurchased.click();
        fieldStartDist.clear();
        fieldStartDist.sendKeys(String.valueOf(faker.number().numberBetween(1200, 35000)));
        distType.selectOption(1);
        shoeModel.sendKeys(faker.artist().name());
        shoeCost.sendKeys(String.valueOf(faker.number().numberBetween(120, 3500)));
        shoeNotes.sendKeys(faker.backToTheFuture().quote());
        saveButton.click();
        return this;
    }
    public GearAndRoutsPage createBikeWithMistake () {
        log.info("GearAndRoutsPage,createBikeWithMistake");
        actions().moveToElement(buttonGear).build().perform();
        buttonBikes.click();
        saveButton.click();
        return this;
    }

    public GearAndRoutsPage createShoes () {
        log.info("GearAndRoutsPage,createShoes");
        actions().moveToElement(buttonGear).build().perform();
        buttonShoes.click();
        fieldName.sendKeys(faker.name().firstName());
        fieldShoeDate.click();
        shoeCost.sendKeys(String.valueOf(faker.number().numberBetween(20, 1500)));
        shoeModel.sendKeys(faker.artist().name());
        datePurchased.click();
        shoeShoeSize.selectOption(2);
        fieldStartDist.clear();
        fieldStartDist.sendKeys(String.valueOf(faker.number().numberBetween(100, 3000)));
        distType.selectOption(1);
        shoeDistAlert.sendKeys(String.valueOf(faker.number().numberBetween(10000, 30000)));
        shoeDistAlertType.selectOption(1);
        shoeNotes.sendKeys(faker.backToTheFuture().quote());
        saveButton.click();
        return this;
    }
    public GearAndRoutsPage createShoesWithMistake () {
        log.info("GearAndRoutsPage,createShoesWithMistake");
        actions().moveToElement(buttonGear).build().perform();
        buttonShoes.click();
        fieldName.sendKeys(faker.name().firstName());
        fieldShoeDate.click();
        fieldShoeDate.sendKeys(faker.name().name());
        saveButton.click();
        return this;
    }
}
