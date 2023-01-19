package com.automation.legoproject.pageobjects;

import com.automation.framework.loging.Log4jLogger;
import com.automation.framework.utils.CoreSelenium;
import com.automation.legoproject.base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private static String PAGE_NAME = "Login Page";
    private final By EMAIL = By.cssSelector("#ap_email");
    private final By PASSWORD = By.cssSelector("#ap_password");
    private final By LOGIN = By.cssSelector("input#signInSubmit");

    private final By CONTINUE = By.cssSelector("input#continue");


    public LoginPage(CoreSelenium selenium) {
        super(selenium);
        if (!selenium.isElementFound(By.cssSelector("#createAccountSubmit"), 5, 1))
            throw new RuntimeException("Failed to load " + PAGE_NAME);
        else
            Log4jLogger.log(PAGE_NAME + " was loaded successfully");
    }

    public void enterEmail(String email) {
        selenium.sendKeys(EMAIL, email, true, "Entering Email: " + email, 5, 1);
    }

    public void enterPassword(String password) {
        selenium.sendKeys(PASSWORD, password, true, "Entering Password: " + password, 5, 1);
    }

    public MainPage clickLogin() {
        selenium.click(LOGIN, "Clicking login");
        // Sometimes it requires captcha
        if (selenium.isElementFound(By.cssSelector(".a-alert-heading"), 1, 0))
            selenium.click(By.cssSelector(".a-link-nav-icon > i[role='img']"), "Navigating to Main page due to captcha");
        return new MainPage(selenium);
    }

    public void clickContinue() {
        selenium.click(CONTINUE, "Clicking continue");
    }
}
