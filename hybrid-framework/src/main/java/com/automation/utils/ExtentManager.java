package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Automation Test Results");
            spark.config().setDocumentTitle("Hybrid Framework Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}