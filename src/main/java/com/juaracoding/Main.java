package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.LogoutPage;
import org.openqa.selenium.WebDriver;


public class Main{
    static WebDriver driver;


    public static void main(String[] args) {
        // Open Browers
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        LogoutPage logoutPage = new LogoutPage();


        // Negatif Case Login One
        loginPage.invalidLogin();
        System.out.print("Status Test login: ");
        DriverSingleton.contains(loginPage.getErrTxtLogin(), "Swag Labs");
        // Negatif Case Login Two
        loginPage.invalidLoginForm("Standar_user", "Secret_Sauce");
        System.out.print("Status Test login: ");
        DriverSingleton.contains(loginPage.getErrTxtLogin(), "Swag Labs");
        // Valid login
        loginPage.login();
        System.out.print("Status Test login: ");
        DriverSingleton.contains(loginPage.getTxtDashboard(), "Swag Labs");


        // Add Product to Cart
        cartPage.addToCart();
        System.out.print("Status Test Add To Cart: ");
        DriverSingleton.contains(cartPage.txtValidationCart(), "Remove");


        // Negatif Case Checkout One
        checkoutPage.failedCheckout();
        System.out.print("Status Test Checkout: ");
        DriverSingleton.contains(checkoutPage.getErrData(), "Thank you for your order!");
        // Negatif Case Checkout Two
        checkoutPage.failedCheckoutTwo();
        System.out.print("Status Test Checkout: ");
        DriverSingleton.contains(checkoutPage.getErrData(), "Thank you for your order!");
        // Checkout Complete
        checkoutPage.checkout();
        System.out.print("Status Test Checkout: ");
        DriverSingleton.contains(checkoutPage.getTxtComplete(), "Thank you for your order!");


        // Logout
        logoutPage.logout();
        System.out.print("Status Test Logout: ");
        DriverSingleton.contains(logoutPage.getTxtLogout(), "Accepted usernames are:");


        // Close Browers
        DriverSingleton.delay(5);
        DriverSingleton.closeObjectInstance();
    }
}
