package com.lambdatest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TestPopups extends BaseConfig {

    @Test
    public void testSuccessfulPopup() {
        WebDriver driver = getDriver();

        //Navigating to the website
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");


        try {
            // Clicking Follow Us on LinkedIn button
            driver.findElement(By.xpath("//a[contains(text(),'Follow us On Linkedin')]")).click();

            String MainWindow = driver.getWindowHandle();

            // To handle all new opened window
            Set<String> s1 = driver.getWindowHandles();

            for (String ChildWindow : s1) {
                if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                    // Switching to Child window

                    driver.switchTo().window(ChildWindow);

                    // to verify that driver focus is shifted to popup window

                    WebElement linkedInFollowButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
                    String PopupText = linkedInFollowButton.getText();
                    System.out.println("Popup box text is " + PopupText);
                    Assert.assertTrue(linkedInFollowButton.isDisplayed(), "Verify LinkedIn Sign In is displayed");

                    // Closing the Child Window.
                    driver.close();
                }
            }

            // Switching to Parent window ~ Main Window
            driver.switchTo().window(MainWindow);
        } catch (Exception ex) {

            System.out.println("Some Error Occurred " + ex.getMessage());
        }
    }
}