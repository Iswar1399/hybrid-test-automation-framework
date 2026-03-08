package com.automation.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automation.driver.DriverFactory;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        WebDriver driver = DriverFactory.getDriver();
        TakesScreenshot ts = (TakesScreenshot) driver;

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String folderPath = System.getProperty("user.dir") + "/screenshots";

        try {
            Files.createDirectories(Paths.get(folderPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String screenshotPath = folderPath + "/" + testName + "_" + timestamp + ".png";

        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(screenshotPath);

        try {
            source.renameTo(destination);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}