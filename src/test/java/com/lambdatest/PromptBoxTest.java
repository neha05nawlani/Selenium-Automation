package com.lambdatest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PromptBoxTest extends BaseConfig {

    @Test
    public void testPromptBox() {

        WebDriver driver = getDriver();

        //Navigating to the website
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");

        try {

            // Locate the button and click
            List<WebElement> elements = driver.findElements(By.xpath("//button[contains(text(),'Click Me')][1]"));
            elements.get(2).click();

            // to let the alert be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.alertIsPresent());

            //Switch to the alert window
            Alert promptBoxAlert = driver.switchTo().alert();
            String promptBoxAlertText = promptBoxAlert.getText();
            System.out.println("Alert text is " + promptBoxAlertText);
            Assert.assertEquals(promptBoxAlertText, "Please enter your name");
            promptBoxAlert.accept();
        } catch (Exception ex) {
            System.out.println("Some Error Occurred " + ex.getMessage());
        }

    }
}
