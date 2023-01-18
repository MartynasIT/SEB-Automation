package com.automation.framework.driver;

import com.automation.framework.utils.SystemUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeDriverManager extends DriverManager {

    @Override
    protected void createWedDriver() {
        try {
            driver.set(new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), new EdgeOptions()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        this.driver.get().manage().window().maximize();

    }
}
