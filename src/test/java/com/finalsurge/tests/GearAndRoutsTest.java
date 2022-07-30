package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class GearAndRoutsTest extends BaseTest{

    @Test//(retryAnalyzer = Retry.class)
    @TmsLink("")
    public void testAddBike () {
        gearAndRoutsSteps.addBike();
    }

    @Test//(retryAnalyzer = Retry.class)
    @TmsLink("")
    public void testAddBikeWithError () {
        gearAndRoutsSteps.addBikeWithMistake();
    }

    @Test//(retryAnalyzer = Retry.class)
    @TmsLink("")
    public void testAddShoes () {
        gearAndRoutsSteps.addShoes();
    }

    @Test//(retryAnalyzer = Retry.class)
    @TmsLink("")
    public void testAddShoesWithError () {
        gearAndRoutsSteps.addShoesWithMistake();
    }
}
