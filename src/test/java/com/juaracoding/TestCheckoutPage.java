package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCheckoutPage {
    WebDriver driver;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        loginPage.login();
        cartPage = new CartPage();
        cartPage.addToCart();
        checkoutPage = new CheckoutPage();
    }

    @Test(priority = 1)
    public void failedCheckoutOne(){
        checkoutPage.failedCheckout();
        Assert.assertEquals(checkoutPage.getErrData(), "Error: First Name is required");
    }

    @Test (priority = 2)
    public void failedCheckoutTwo(){
        checkoutPage.failedCheckoutTwo();
        Assert.assertEquals(checkoutPage.getErrData(), "Error: Last Name is required");
    }

    @Test (priority = 3)
    public void completeCheckout(){
        checkoutPage.checkout();
        Assert.assertEquals(checkoutPage.getTxtComplete(), "Thank you for your order!");
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }
}
