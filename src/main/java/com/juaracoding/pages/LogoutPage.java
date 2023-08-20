package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    private WebDriver driver;

    public LogoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='back-to-products']")
    WebElement btnHome;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement menuList;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    WebElement btnLogout;

    @FindBy(xpath = "//h4[normalize-space()='Accepted usernames are:']")
    WebElement txtLogout;

    public void logout(){
        btnHome.click();
        menuList.click();
        btnLogout.click();
    }
    public void fiturLogout(){
        menuList.click();
        btnLogout.click();
    }
    public String getTxtLogout(){
        return txtLogout.getText();
    }
}
