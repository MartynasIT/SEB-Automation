package com.automation.legoproject.pageobjects;

import com.automation.framework.loging.Log4jLogger;
import com.automation.legoproject.base.BasePage;
import com.automation.framework.utils.CoreSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductSearchResultPage extends BasePage {

    private static final String PAGE_NAME = "Product Result Page";
    private final By SORT_BUTTON = By.xpath("(//span[contains(.,'Sort by:')])[2]");
    private final By PRODUCT = By.xpath("//div[@id='search']//img");

    public ProductSearchResultPage(CoreSelenium selenium) {
        super(selenium);
        if (!selenium.isElementFound(SORT_BUTTON))
            throw new RuntimeException("Failed to load " + PAGE_NAME);
        else
            Log4jLogger.log(PAGE_NAME + " was loaded successfully");
    }

    public ProductSearchResultPage selectSort(String type) {
        selenium.click(SORT_BUTTON, "Clicking sort drop-down");
        selenium.click(By.linkText(type), "Sorting by: " + type);
        selenium.waitForElementToBeInVisible(By.cssSelector(".a-spinner-wrapper .a-spinner-medium"), 10, 2);
        return new ProductSearchResultPage(selenium);
    }

    public java.util.List<WebElement> getAllProducts() {
        return selenium.findElements(PRODUCT);
    }

    public WebElement getProduct(int index) {
        return selenium.findElement(By.xpath("(//div[@id='search']//img)" + "[" + index + "]"));
    }
}
