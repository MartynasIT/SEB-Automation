package com.automation.legoproject.base;

import com.automation.framework.loging.Log4jLogger;
import com.automation.framework.utils.CoreSelenium;
import com.automation.legoproject.pagecomponents.HeaderMenu;
import com.automation.legoproject.pageobjects.CartPage;
import com.automation.legoproject.pageobjects.LoginPage;
import com.automation.legoproject.pageobjects.ProductSearchResultPage;

public class PageNavigator extends BasePage{
    HeaderMenu header;

    public PageNavigator(CoreSelenium selenium){
        super(selenium);
        header = new HeaderMenu(selenium);
    }
    public CartPage navigateToCart() {
        Log4jLogger.log("Navigating to Cart");
        header.clickCart();
        return new CartPage(selenium);
    }

    public LoginPage navigateToLogin() {
        Log4jLogger.log("Navigating to Login");
        header.clickLogin();
        return new LoginPage(selenium);
    }
}

