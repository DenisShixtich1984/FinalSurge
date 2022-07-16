package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class CalculatorsTest extends BaseTest {
    /**
     * in this class there are two tests with a positive and negative scenario for counting your workout peace
     */
    @Test
    @TmsLink("FS-6")
    public void calculateWorkoutIntensity() {
        calculatorsSteps.calculateDistance();
    }

    @Test
    @TmsLink("FS-7")
    public void calculateWorkoutIntensityWithError() {
        calculatorsSteps.calculateDistanceWithError();
    }
}