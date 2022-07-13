package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class CalendarTest extends BaseTest {

    @Test
    @TmsLink("FS-3")
    public void createWorkOut() {
        calendarSteps.createNewWorkOut();
    }

    @Test
    @TmsLink("FS-4")
    public void createWorkOutWithError() {
        calendarSteps.createNewWorkOutWithError();
    }

    @Test(dependsOnMethods = "createWorkOut")
    @TmsLink("FS-5")
    public void deleteNewWorkout() {
        calendarSteps.deleteNote();
    }

}
