package com.automation.legoproject.pageobjects;

import com.automation.framework.loging.Log4jLogger;
import com.automation.legoproject.base.BasePage;
import com.automation.framework.utils.CoreSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CartPage extends BasePage {

    private static final String PAGE_NAME = "Cart Page";
    private final By DELETE = By.cssSelector(".sc-action-delete .a-color-link");
    private final By TOTAL = By.cssSelector("span#sc-subtotal-amount-activecart > .a-color-base.a-size-medium.sc-price.sc-white-space-nowrap");

    private final By CHECKOUT = By.cssSelector("input[name='proceedToRetailCheckout']");


    public CartPage(CoreSelenium selenium) {
        super(selenium);
        if (!selenium.isElementFound(By.xpath("//div[@id='sc-active-cart']//h1[1]")))
            throw new RuntimeException("Failed to load " + PAGE_NAME);
        else
            Log4jLogger.log(PAGE_NAME + " was loaded successfully");
        ;
    }

    public void deleteItems(int[] index) {
        List<WebElement> elements = selenium.findElements(DELETE);
        Collections.reverse(elements);
        for (int i = elements.size() - 1; i >= 0; i--) {
            if (Arrays.binarySearch(index, i) >= 0) {
                elements.get(i).click();
                selenium.getDriver().navigate().refresh();
                elements = selenium.findElements(DELETE);
                Collections.reverse(elements);
                Log4jLogger.log("Removed Product");
            }
        }
        selenium.getDriver().navigate().refresh();
    }

    public void deleteItems() {
        List<WebElement> elements = selenium.findElements(DELETE);
        for (int i = elements.size() - 1; i >= 0; i--) {
            elements.get(i).click();
            selenium.getDriver().navigate().refresh();
            elements = selenium.findElements(DELETE);
            Collections.reverse(elements);
        }
    }

    public int countItemsInCart() {
        return selenium.findElements(DELETE).size();
    }

    public String getTotal() {
        return selenium.getText(TOTAL);
    }

    public CheckoutPage clickCheckout() {
        selenium.click(CHECKOUT);
        return new CheckoutPage(selenium);
    }
}
