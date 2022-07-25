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
        Configuration.baseUrl = reader.getProperty("urlFinalSurge");
        Configuration.headless = Boolean.parseBoolean(reader.getProperty("headless"));
        Configuration.browserSize = reader.getProperty("size");
        Configuration.timeout = Integer.parseInt(reader.getProperty("timeout"));
        Configuration.screenshots = Boolean.parseBoolean(reader.getProperty("screenshots"));
    }
}

