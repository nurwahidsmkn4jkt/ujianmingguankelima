package com.juaracoding.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{
    @Override
    public WebDriver setStrategy() {
        String path = "D:\\SQA RPA Batch 10 - Juaracoding\\MyTools\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",path);
        WebDriver driver = new FirefoxDriver();
        return null;
    }
}
