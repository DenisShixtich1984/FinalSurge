package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

/**
 * in this class there are two tests ("FS-8")&("FS-9") with a positive and negative scenario
 * for counting calories spent over a certain time. And there are two tests ("FS-12") &("FS-13") with
 * a positive and negative scenario for counting the pace of running on time.
 */

public class OtherCalculatorsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-8")
    public void calculateCalories() {
        otherCalculatorsSteps.calculateCalories();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-9")
    public void calculateCaloriesWithError() {
        otherCalculatorsSteps.calculateCalorieWithError();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-12")
    public void calculatePeace() {
        otherCalculatorsSteps.createStepsPeaceCalculate();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-13")
    public void calculatePeaceWithError() {
        otherCalculatorsSteps.createStepsPeaceCalculateWithError();
    }
}
