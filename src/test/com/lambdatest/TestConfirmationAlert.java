package com.lambdatest;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TestConfirmationAlert extends BaseConfig {

    @Test
    public void testConfirmationAlert() throws InterruptedException, MalformedURLException {

        driver = new RemoteWebDriver(new URL(hubURL), capabilities);

        //Navigating to the website
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        try {

            // Locate the button and click
            Thread.sleep(3000);
            List<WebElement> elements = driver.findElements(By.xpath("//button[contains(text(),'Click Me')][1]"));
            elements.get(1).click();

            // to let the alert be visible
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.alertIsPresent());

            //Switch to the alert window
            Alert confirmationAlert = driver.switchTo().alert();
            String confirmationAlertText = confirmationAlert.getText();
            System.out.println("Alert text is " + confirmationAlertText);
            Assert.assertEquals(confirmationAlertText, "Press a button!");
            confirmationAlert.accept();
        } catch (Exception ex) {
            System.out.println("Some Error Occurred " + ex.getMessage());

        }
    }
}