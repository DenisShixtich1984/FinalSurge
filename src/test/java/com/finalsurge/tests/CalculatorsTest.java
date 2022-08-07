package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

/**
 * in this class there are two tests ("FS-6") and ("FS-7") with a positive and negative scenario for counting workout peace using a faker,
 * and а test using accurate data to verify the result obtained ("FS-17")
 */
public class CalculatorsTest extends BaseTest {

    @Test(groups = "smoke",retryAnalyzer = Retry.class)
    @TmsLink("FS-6")
    public void calculateWorkoutAccuratePace() {
        calculatorsSteps.calculateAccuratePace();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-7")
    public void calculateWorkoutIntensityWithError() {
        calculatorsSteps.calculateDistanceWithError();
    }

    @Test(groups = "smoke", retryAnalyzer = Retry.class)
    @TmsLink("FS-17")
    public void calculateWorkoutIntensity() {
        calculatorsSteps.calculateDistance();
    }
}