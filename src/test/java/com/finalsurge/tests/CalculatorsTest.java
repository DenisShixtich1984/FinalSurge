package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

/**
 * in this class there are two tests with a positive and negative scenario for counting your workout peace
 */
public class CalculatorsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-6")
    public void calculateWorkoutAccuratePace() {
        calculatorsSteps.calculateAccuratePace();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-7")
    public void calculateWorkoutIntensityWithError() {
        calculatorsSteps.calculateDistanceWithError();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("___________")
    public void calculateWorkoutIntensity() {
        calculatorsSteps.calculateDistance();
    }
}