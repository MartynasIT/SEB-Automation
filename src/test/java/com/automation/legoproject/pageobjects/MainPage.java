package com.automation.legoproject.pageobjects;

import com.automation.framework.loging.Log4jLogger;
import com.automation.legoproject.base.BasePage;
import com.automation.framework.utils.CoreSelenium;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private static String PAGE_NAME = "Main Page";

    public MainPage(CoreSelenium selenium) {
        super(selenium);
        if (!selenium.isElementFound(By.cssSelector(".a-carousel-row-inner"), 5, 1))
            throw new RuntimeException("Failed to load " + PAGE_NAME);
        else
            Log4jLogger.log(PAGE_NAME + " was loaded successfully");
    }
}
