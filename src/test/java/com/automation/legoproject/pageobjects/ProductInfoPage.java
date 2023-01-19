package com.automation.legoproject.pageobjects;

import com.automation.framework.loging.Log4jLogger;
import com.automation.legoproject.base.BasePage;
import com.automation.framework.utils.CoreSelenium;
import org.openqa.selenium.By;

public class ProductInfoPage extends BasePage {

    private static final String PAGE_NAME = "Product info";
    private By ADD_TO_BAG = By.cssSelector("input#add-to-cart-button");


    public ProductInfoPage(CoreSelenium selenium) {
        super(selenium);
        if (!selenium.isElementFound(ADD_TO_BAG))
            throw new RuntimeException("Failed to load " + PAGE_NAME);
        else
            Log4jLogger.log(PAGE_NAME + " was loaded successfully");
    }

    public void addItemToCart() {
        selenium.click(ADD_TO_BAG, "Adding product to cart");
    }
}
