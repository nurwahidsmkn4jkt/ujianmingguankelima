package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogoutPage {
    WebDriver driver;
    LoginPage loginPage;
    LogoutPage logoutPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        loginPage.login();
        logoutPage = new LogoutPage();
    }

    @Test
    public void logout(){
        logoutPage.fiturLogout();
        Assert.assertEquals(logoutPage.getTxtLogout(), "Accepted usernames are:");
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }
}
