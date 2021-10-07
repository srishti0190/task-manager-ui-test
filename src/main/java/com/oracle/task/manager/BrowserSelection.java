package com.oracle.task.manager;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserSelection {
    static WebDriver driver;

    public static WebDriver usingChrome() {
        String driverName;
        if (SystemUtils.IS_OS_MAC) {
            driverName = "chromedriver_mac";
        } else if (SystemUtils.IS_OS_LINUX){
            driverName = "chromedriver_linux";
        } else {
            driverName = "chromedriver_window.exe";
        }
        System.setProperty("webdriver.chrome.driver", driverName);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}