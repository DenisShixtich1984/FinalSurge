package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CalendarPage {
    public SelenideElement buttonCalendar = $(By.className("icsw16-day-calendar"));
    public SelenideElement titleCalendar = $x("//a[text()='Training Calendar']");
    public SelenideElement buttonQuickAdd = $(By.id("QuickAddToggle"));
    public SelenideElement calendarButton = $(By.className("icon-calendar"));
    public SelenideElement dateOfWorkOut = $(By.id("WorkoutDate"));
    public SelenideElement workoutTime = $(By.id("WorkoutTime"));
    public SelenideElement timeOfWorkOut = $x("//li[text()='05:45 AM']");
    public SelenideElement activityType = $(By.id("ActivityType"));
    public SelenideElement workoutName = $(By.id("Name"));
    public SelenideElement workoutDescription = $(By.id("Desc"));
    public SelenideElement distance = $(By.id("Distance"));
    public SelenideElement saveButton = $(By.id("saveButton"));
    public SelenideElement checkAddRun = $x(" //div[text()='Run: long run']");


    public CalendarPage buttonCalendarClickAndCheck() {
        buttonCalendar.click();
        titleCalendar.shouldBe(visible);
        return new CalendarPage();
    }

    public CalendarPage addWorkout() {
        buttonQuickAdd.click();
        calendarButton.click();
        dateOfWorkOut.clear();
        dateOfWorkOut.sendKeys("07/07/2022");
        workoutTime.click();
        timeOfWorkOut.click();
        activityType.sendKeys("Run");
        workoutName.sendKeys("long run");
        workoutDescription.sendKeys("preparation for marathon running at a distance of more than 10 km");
        distance.sendKeys("10");
        saveButton.scrollIntoView(false);
        saveButton.click();
        checkAddRun.shouldBe(visible);
        return new CalendarPage();
    }

}
