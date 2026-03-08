package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.driver.DriverFactory;

public class ProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
   
    private By cartBadge = By.className("shopping_cart_badge");

    public ProductsPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void addProductToCart() {

        // wait until Add to Cart button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        driver.findElement(addToCartButton).click();

    }

    public String getCartCount() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));

        return driver.findElement(cartBadge).getText();
    }
}