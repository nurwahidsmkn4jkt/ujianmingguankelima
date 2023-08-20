package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement btnCart;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement btnCheckout;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement formFirstName;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement formLastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement formPostCode;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement btnConfirm;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement btnFinish;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement txtComplete;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errData;


    public void failedCheckout(){
        btnCart.click();
        btnCheckout.click();
        formFirstName.sendKeys("");
        formLastName.sendKeys("Wahid");
        formPostCode.sendKeys("19310");
        btnConfirm.click();
    }

    public void failedCheckoutTwo(){
        btnCart.click();
        btnCheckout.click();
        formFirstName.sendKeys("Nur");
        formLastName.clear();
        btnConfirm.click();
    }

    public void checkout(){
        formLastName.sendKeys("Wahid");
        formPostCode.sendKeys("19310");
        btnConfirm.click();
        DriverSingleton.scroll();
        btnFinish.click();
    }
    public String getTxtComplete(){
        return txtComplete.getText();
    }
    public String getErrData(){
        return errData.getText();
    }
}
