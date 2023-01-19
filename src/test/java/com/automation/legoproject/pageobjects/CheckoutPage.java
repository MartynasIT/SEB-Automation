package com.automation.legoproject.pageobjects;

import com.automation.framework.loging.Log4jLogger;
import com.automation.framework.utils.CoreSelenium;
import com.automation.legoproject.base.BasePage;
import org.openqa.selenium.By;


public class CheckoutPage extends BasePage {

    private static final String PAGE_NAME = "Checkout Page";
    private final By TOTAL = By.cssSelector("div#subtotals-marketplace-table > .a-normal.small-line-height > tbody > " +
            "tr:nth-of-type(1) > .a-align-bottom.a-text-right.aok-nowrap");


    public CheckoutPage(CoreSelenium selenium) {
        super(selenium);
        if (!selenium.isElementFound(By.xpath("//h1[contains(.,'Checkout')]")))
            throw new RuntimeException("Failed to load " + PAGE_NAME);
        else
            Log4jLogger.log(PAGE_NAME + " was loaded successfully");

    }

    public String getTotal() {
        return selenium.getText(TOTAL);
    }
}
