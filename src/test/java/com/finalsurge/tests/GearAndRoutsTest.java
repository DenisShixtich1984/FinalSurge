package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class GearAndRoutsTest extends BaseTest {

    /**
     * In this class there are four tests for entering information about a training bike and sports shoes.
     * ("FS-22")&("FS-23") a positive and negative scenario for creating info about a training bike.
     * ("FS-24")&("FS-25") a positive and negative scenario for creating info about a sports shoes.
     */

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-22")
    public void testAddBike() {
        gearAndRoutsSteps.addBike();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-23")
    public void testAddBikeWithError() {
        gearAndRoutsSteps.addBikeWithMistake();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-24")
    public void testAddShoes() {
        gearAndRoutsSteps.addShoes();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-25")
    public void testAddShoesWithError() {
        gearAndRoutsSteps.addShoesWithMistake();
    }
}
