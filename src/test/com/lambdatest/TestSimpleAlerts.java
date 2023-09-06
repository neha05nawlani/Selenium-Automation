package com.lambdatest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestSimpleAlerts extends BaseConfig {
    @Test
    public void testSimpleAlert() throws InterruptedException, MalformedURLException {

        driver = new RemoteWebDriver(new URL(hubURL), capabilities);

        //Navigating to the website
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        try {

            // Locate the button and click
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[contains(text(),'Click Me')][1]")).click();

            // to let the alert be visible
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());

            //Switch to the alert window and accept
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert text is " + alertText);
            Assert.assertEquals(alertText, "I am an alert box!");
            alert.accept();
        } catch (Exception ex) {
            System.out.println("Some Error Occurred " + ex.getMessage());
        }
    }
}