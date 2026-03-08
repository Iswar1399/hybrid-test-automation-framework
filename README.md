# Hybrid Test Automation Framework

## Overview

This project is a hybrid automation framework built using **Selenium WebDriver and RestAssured** for UI and API testing.

The framework follows **Page Object Model (POM)** design and supports **data-driven testing, parallel execution, retry logic, and detailed reporting**.

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* RestAssured
* Maven
* Apache POI
* Extent Reports
* Log4j

---

## Framework Features

* Page Object Model (POM)
* Hybrid UI + API Automation
* Parallel Test Execution
* Retry Analyzer for flaky tests
* Screenshot Capture on Failure
* Excel Data-Driven Testing
* Environment Configuration
* Extent Reporting

---

## Project Structure

```
src
 ├── main
 │   └── java
 │       └── com.automation
 │            ├── base
 │            ├── driver
 │            ├── pages
 │            ├── api
 │            └── utils
 │
 ├── test
 │   └── java
 │       └── com.automation
 │            ├── uiTests
 │            └── apiTests
 │
 └── resources
      config.properties
      LoginData.xlsx
```

---

## How to Run Tests

Clone the repository:

```
git clone https://github.com/yourusername/hybrid-test-automation-framework.git
```

Run tests using Maven:

```
mvn clean test
```

Or run the TestNG suite:

```
testng.xml
```

---

## Reports

After execution, the **Extent Report** will be generated inside:

```
/reports/ExtentReport.html
```

---

## Author

Automation Engineer Project
