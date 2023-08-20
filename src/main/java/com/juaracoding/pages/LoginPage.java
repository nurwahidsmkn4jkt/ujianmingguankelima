package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='login_wrapper']")
    WebElement website;
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement formUsername;

    @FindBy(xpath = "//input[@id='password']")
    WebElement formPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement txtDashboard;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errTxtLogin;

    public void invalidLogin(){
        formUsername.sendKeys("Standard_User");
        formPassword.sendKeys("Secret_sauce");
        btnLogin.click();
        formUsername.clear();
        formPassword.clear();
    }
    public void invalidLoginForm(String username, String password){
        formUsername.sendKeys(username);
        formPassword.sendKeys(password);
        btnLogin.click();
        formUsername.clear();
        formPassword.clear();
    }
    public void login(){
        formUsername.sendKeys("standard_user");
        formPassword.clear();
        formPassword.sendKeys("secret_sauce");
        btnLogin.click();
    }
    public String getTxtDashboard(){
        return txtDashboard.getText();
    }
    public String getErrTxtLogin(){
        return errTxtLogin.getText();
    }
}
