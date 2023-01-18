package com.automation.framework.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void createWedDriver() {
        try {
            driver.set(new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), new ChromeOptions()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.get().manage().window().maximize();
    }
}
