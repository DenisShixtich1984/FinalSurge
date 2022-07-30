package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

/**
 * there are three tests in this class. test ("FS-3") and ("FS-5") dependent tests with positive scenarios
 * for adding and removing workout . ("FS-5") is a negative test for not filling in the required field
 */

public class CalendarTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-3")
    public void createWorkOut() {
        calendarSteps.createNewWorkOut();
    }

    @Test (dependsOnMethods = "createWorkOut", retryAnalyzer = Retry.class)
    @TmsLink("FS-5")
    public void deleteNewWorkout() {
        calendarSteps.deleteNote();}

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-4")
    public void createWorkOutWithError() {
        calendarSteps.createNewWorkOutWithError();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-14")
    public void dragAndDropWithBike() {
        calendarSteps.dragAndDropWithBike();
    }

    @Test(retryAnalyzer = Retry.class, priority = 1)
    @TmsLink("///")
    public void copyDayOfWorkout() {
        calendarSteps.copyDay();
    }

    @Test (retryAnalyzer = Retry.class, priority = 2)
    @TmsLink("///")
    public void deleteDayOfWorkout() {
        calendarSteps.deleteCopyDay();
    }
}
