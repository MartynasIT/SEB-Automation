package com.automation.legoproject.pagecomponents;

import com.automation.framework.utils.CoreSelenium;
import com.automation.legoproject.base.BasePage;
import com.automation.legoproject.pageobjects.LoginPage;
import com.automation.legoproject.pageobjects.ProductSearchResultPage;
import org.openqa.selenium.By;

public class HeaderMenu extends BasePage {

    private final String HEADER_MENU_MAIN_NAVIGATION = "//div[@id='navbar']";
    private final By SEARCH_FIELD = By.xpath(HEADER_MENU_MAIN_NAVIGATION + "//input[@id='twotabsearchtextbox']");
    private final By CART = By.xpath(HEADER_MENU_MAIN_NAVIGATION + "//div[@id='nav-cart-text-container']");
    private final By SIGN_IN = By.xpath(HEADER_MENU_MAIN_NAVIGATION + "//span[@id='nav-link-accountList-nav-line-1']");

    private final By SEARCH_BUTTON = By.xpath(HEADER_MENU_MAIN_NAVIGATION + "//input[@id='nav-search-submit-button']");


    public HeaderMenu(CoreSelenium selenium) {
        super(selenium);
    }

    public void clickCart() {
        selenium.jsClick(selenium.findElement(CART), "Clicking Cart");
    }

    public ProductSearchResultPage enterSearch(String text) {
        selenium.sendKeys(SEARCH_FIELD, text, "Entering into search filed: " + text);
        selenium.click(SEARCH_BUTTON, "Clicking search button");
        return new ProductSearchResultPage(selenium);
    }

    public LoginPage clickLogin() {
        selenium.click(SIGN_IN);
        return new LoginPage(selenium);
    }
}
