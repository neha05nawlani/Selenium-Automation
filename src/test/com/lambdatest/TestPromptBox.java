package com.lambdatest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TestPromptBox extends BaseConfig {

    @Test
    public void testPromptBox() throws InterruptedException, MalformedURLException {

        driver = new RemoteWebDriver(new URL(hubURL), capabilities);

        //Navigating to the website
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        // Locate the button and click
        Thread.sleep(3000);
        List<WebElement> elements = driver.findElements(By.xpath("//button[contains(text(),'Click Me')][1]"));
        elements.get(2).click();

        // to let the alert be visible
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());

        //Switch to the alert window
        Alert promptBoxAlert = driver.switchTo().alert();
        String promptBoxAlertText = promptBoxAlert.getText();
        System.out.println("Alert text is " + promptBoxAlertText);
        Assert.assertEquals(promptBoxAlertText, "Please enter your name");
        promptBoxAlert.accept();
    }
}
