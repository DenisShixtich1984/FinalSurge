package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

/**
 * in this class there are two tests with a positive and negative scenario for editing user information
 */

public class SettingTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-10")
    public void testEditData() {
        settingsSteps.editDataInfo();
    }

    @Test(retryAnalyzer = Retry.class)
    @TmsLink("FS-11")
    public void testEditDataWithError() {
        settingsSteps.editDataInfoWithError();
    }

    @Test
    public void test () {
        loginPage.login();
        settingsPage.editPhoto();
    }
}
