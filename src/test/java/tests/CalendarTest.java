package tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class CalendarTest extends BaseTest{

    @Test
    @TmsLink("FS-3")
    public void createWorkOut () {
    calendarSteps.createNewWorkOut();
    }
}
