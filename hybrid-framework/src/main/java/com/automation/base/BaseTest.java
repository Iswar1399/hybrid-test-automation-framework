package com.automation.base;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.automation.driver.DriverFactory;
import com.automation.utils.ConfigReader;
import com.automation.utils.ScreenshotUtil;
import com.automation.utils.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {

    protected static ExtentReports extent = ExtentManager.getInstance();
    protected ExtentTest test;

    @BeforeMethod
    public void setup(Method method) {

        test = extent.createTest(method.getName());

        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
            ScreenshotUtil.captureScreenshot(result.getName());
        } 
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        }

        DriverFactory.quitDriver();
        extent.flush();
    }
}