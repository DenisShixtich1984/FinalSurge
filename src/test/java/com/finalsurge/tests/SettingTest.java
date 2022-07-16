package com.finalsurge.tests;

import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class SettingTest extends BaseTest{
    /**
     * in this class there are two tests with a positive and negative scenario for editing user information
     */
    @Test
    @TmsLink("FS-10")
    public void testEditData () {
        settingsSteps.editDataInfo();
    }
    @Test
    @TmsLink("FS-11")
    public void testEditDataWithError () {
        settingsSteps.editDataInfoWithError();
    }
}
