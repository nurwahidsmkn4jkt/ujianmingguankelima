package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginPage {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void invalidLoginTest(){
        loginPage.invalidLogin();
        Assert.assertEquals(loginPage.getErrTxtLogin(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test (priority = 2)
    public void invalidLoginFormTest(){
        loginPage.invalidLoginForm("Standar_user", "Secret_Sauce");
        Assert.assertEquals(loginPage.getErrTxtLogin(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test (priority = 3)
    public void validLoginTest(){
        loginPage.login();
        Assert.assertEquals(loginPage.getTxtDashboard(), "Swag Labs");
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }
}
