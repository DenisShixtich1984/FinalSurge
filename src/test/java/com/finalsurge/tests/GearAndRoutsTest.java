package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class GearAndRoutsTest extends BaseTest{

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-22")
    public void testAddBike () {
        gearAndRoutsSteps.addBike();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-23")
    public void testAddBikeWithError () {
        gearAndRoutsSteps.addBikeWithMistake();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-24")
    public void testAddShoes () {
        gearAndRoutsSteps.addShoes();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-25")
    public void testAddShoesWithError () {
        gearAndRoutsSteps.addShoesWithMistake();
    }
}
