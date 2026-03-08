package com.automation.uiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.driver.DriverFactory;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import org.testng.annotations.DataProvider;
import com.automation.utils.ExcelUtil;

public class LoginTest extends BaseTest {
	@DataProvider(name = "loginData")
	public Object[][] getData() throws Exception {

	    return ExcelUtil.getLoginData();

	}

	@Test(dataProvider = "loginData")
	public void loginTest(String username, String password) {

	    LoginPage loginPage = new LoginPage();
	    loginPage.login(username, password);

	    String currentUrl = DriverFactory.getDriver().getCurrentUrl();
	    Assert.assertTrue(currentUrl.contains("inventory"));
	}

    @Test(retryAnalyzer = com.automation.utils.RetryAnalyzer.class)
    public void addProductToCartTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.login("problem_user", "secret_sauce");

        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        Assert.assertTrue(currentUrl.contains("inventory"));

        ProductsPage productsPage = new ProductsPage();
        productsPage.addProductToCart();

        String count = productsPage.getCartCount();
        System.out.println("Cart Count: " + count);

        Assert.assertEquals(count, "1");
    }
}