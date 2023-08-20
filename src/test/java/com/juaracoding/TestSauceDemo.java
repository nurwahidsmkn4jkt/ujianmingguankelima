package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSauceDemo {

    WebDriver driver;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    LogoutPage logoutPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        logoutPage = new LogoutPage();
    }

    @Test (priority = 1)
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

    @Test (priority = 4)
    public void addToCart(){
        cartPage.addToCart();
        Assert.assertEquals(cartPage.txtValidationCart(), "Remove");
    }

    @Test (priority = 5)
    public void failedCheckoutOne(){
        checkoutPage.failedCheckout();
        Assert.assertEquals(checkoutPage.getErrData(), "Error: First Name is required");
    }

    @Test (priority = 6)
    public void failedCheckoutTwo(){
        checkoutPage.failedCheckoutTwo();
        Assert.assertEquals(checkoutPage.getErrData(), "Error: Last Name is required");
    }

    @Test (priority = 7)
    public void completeCheckout(){
        checkoutPage.checkout();
        Assert.assertEquals(checkoutPage.getTxtComplete(), "Thank you for your order!");
    }

    @Test (priority = 8)
    public void logout(){
        logoutPage.logout();
        Assert.assertEquals(logoutPage.getTxtLogout(), "Accepted usernames are:");
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }
}
