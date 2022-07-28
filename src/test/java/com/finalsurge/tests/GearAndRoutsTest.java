package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class GearAndRoutsTest extends BaseTest{

    @Test//(retryAnalyzer = Retry.class)
    @TmsLink("")
    public void testTest () {
        gearAndRoutsSteps.addShoes();
    }
}
