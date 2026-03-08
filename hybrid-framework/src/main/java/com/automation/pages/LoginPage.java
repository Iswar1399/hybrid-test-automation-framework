package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.driver.DriverFactory;

public class LoginPage {

    private WebDriver driver;

    // Constructor
    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    // Locators
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    // Actions
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    // Business Method
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}