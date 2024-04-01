package com.lambdatest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseConfig {
    public static String hubURL = "@hub.lambdatest.com/wd/hub";
    private final String LT_ACCESS_KEY = System.getProperty("LT_ACCESS_KEY");
    private final String LT_USERNAME = System.getProperty("LT_USERNAME");
    protected static ChromeOptions browserOptions = new ChromeOptions();
    protected static Map ltOptions = new HashMap<String, Object>();
    private WebDriver driver;

    @BeforeTest
    public static void setup() {

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("121.0");

        ltOptions.put("selenium_version", "4.18.0");
        ltOptions.put("driver_version", "121.0");
        ltOptions.put("build", "LambdaTest Scale Demo");
        ltOptions.put("name", "LambdaTest tests at scale");
        ltOptions.put("acceptInsecureCerts", true);
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-testNG");
        browserOptions.setCapability("LT:Options", ltOptions);
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


    public String getUrl() {

        String username = LT_USERNAME;
        String password = LT_ACCESS_KEY;

        StringBuilder hubUrlBuilder = new StringBuilder("https://")
                .append(username)
                .append(":")
                .append(password)
                .append(hubURL);

        return hubUrlBuilder.toString();
    }

    public WebDriver getDriver() {

        try {
            driver =
                    new RemoteWebDriver(new URL(getUrl()),
                            browserOptions);
        } catch (final MalformedURLException e) {
            throw new Error("Error setting up cloud browser in LambdaTest", e);
        }
        return driver;
    }
}
