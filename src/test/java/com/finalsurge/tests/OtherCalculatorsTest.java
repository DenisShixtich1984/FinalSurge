package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class OtherCalculatorsTest extends BaseTest {

    /**
     * in this class there are two tests with a positive and negative scenario
     * for counting calories spent over a certain time
     */
    @Test
    @TmsLink("FS-8")
    public void calculateCalories() {
        otherCalculatorsSteps.calculateCalories();
    }
    @Test
    @TmsLink("FS-9")
    public void calculateCaloriesWithError() {
        otherCalculatorsSteps.calculateCalorieWithError();
    }
}