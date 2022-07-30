package com.finalsurge.browser;
import com.codeborne.selenide.Configuration;
import com.finalsurge.utils.PropertyReader;

import static com.codeborne.selenide.Browsers.*;

public class SelenideConfiguration {
    public static void configureBrowser(String browser) {
        setUpBasicConfigure();

        switch (browser) {
            case "safari":
                Configuration.browser = SAFARI;
                break;
            case "firefox":
                Configuration.browser = FIREFOX;
                break;
            default:
                Configuration.browser = CHROME;
                break;
        }
    }

    public static void setUpBasicConfigure() {
        PropertyReader reader = new PropertyReader();
        Configuration.baseUrl = PropertyReader.getProperty("urlFinalSurge");
        Configuration.headless = Boolean.parseBoolean(PropertyReader.getProperty("headless"));
        Configuration.browserSize = PropertyReader.getProperty("size");
        Configuration.timeout = Integer.parseInt(PropertyReader.getProperty("timeout"));
        Configuration.screenshots = Boolean.parseBoolean(PropertyReader.getProperty("screenshots"));
    }
}

