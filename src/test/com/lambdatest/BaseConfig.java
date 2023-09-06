package com.lambdatest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;

public class BaseConfig {
    public static String hubURL = "https://hub.lambdatest.com/wd/hub";
    protected static DesiredCapabilities capabilities = new DesiredCapabilities();
    protected WebDriver driver;

    @BeforeTest
    public static void setup() {

        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "113");
        HashMap<String, Object> ltOptions = new HashMap<>();
        String username = "neha05nawlani";
        ltOptions.put("user", username);
        String accessKey = "Q0ux5ZJ8LTFp6vpBVj7diMU89o7ElgANbWJnHR2kOza1mxV8P3";
        ltOptions.put("accessKey", accessKey);
        ltOptions.put("build", "Selenium 4");
//        ltOptions.put("name", TestAlerts.class);
        ltOptions.put("platformName", "Windows");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        capabilities.setCapability("LT:Options", ltOptions);
    }

    @AfterTest
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception e) {
            markStatus("failed", "Got exception!", driver);
            e.printStackTrace();
            driver.quit();
        }
    }


    private void markStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jsExecute = (JavascriptExecutor) driver;
        jsExecute.executeScript("lambda-status=" + status);
        System.out.println(reason);
    }

}
