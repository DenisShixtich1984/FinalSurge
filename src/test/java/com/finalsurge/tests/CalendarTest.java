package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

/**
 * there are six tests in this class. test ("FS-3") and ("FS-5") tests with positive scenarios
 * for adding and removing workout . ("FS-4") is a negative test for not filling the required field.
 * ("FS-14")- a scenario with dragging a workout and back it.
 * ("FS-15") and ("FS-16") - copying a workout day and deleting it
 */

public class CalendarTest extends BaseTest {

    @Test(priority = 1, retryAnalyzer = Retry.class)
    @TmsLink("FS-3")
    public void createWorkOut() {
        calendarSteps.createNewWorkOut();
    }

    @Test(priority = 2, retryAnalyzer = Retry.class)
    @TmsLink("FS-5")
    public void deleteNewWorkout() {
        calendarSteps.deleteNote();
    }

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

    @Test(retryAnalyzer = Retry.class, priority = 3)
    @TmsLink("FS-15")
    public void copyDayOfWorkout() {
        calendarSteps.copyDay();
    }

    @Test(retryAnalyzer = Retry.class, priority = 4)
    @TmsLink("FS-16")
    public void deleteDayOfWorkout() {
        calendarSteps.deleteCopyDay();
    }
}
