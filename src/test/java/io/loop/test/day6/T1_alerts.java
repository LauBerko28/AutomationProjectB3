package io.loop.test.day6;
    /*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed
     */
import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class T1_alerts extends TestBase { // extends TestBase --> allows me to have access to have access to the TestBase class on which I have already created a before and after method

    @Test
    public void informationAlert(){ // #1 informative alert - only ok
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForJSAlert.click();

        Alert alert = driver.switchTo().alert(); // creating an element for the informative alert- an informative alert is the one that pops up but I cannot locate iot by html
        alert.accept(); // .accept() clicks the "ok" from the alert message

        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected ="You successfully clicked an alert";
        String actual = successMessageForInformationAlert.getText();

        assertEquals(actual,expected,"Alert message was not clicked");

    }

    @Test
    public void confirmationAlert(){ // #2 - confirmation alert it has ok and cancel
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickForJSConfirm.click();

        driver.switchTo().alert().accept(); // will click ok and accept the alert
        WebElement successMessageForConfirmationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You clicked: Ok";
        String actual = successMessageForConfirmationAlert.getText();
        assertEquals(actual, expected, "Actual does not match the expected");

        clickForJSConfirm.click();
        driver.switchTo().alert().dismiss(); // will click cancel = will dismiss the alert
        expected = "You clicked: Cancel";
        actual = successMessageForConfirmationAlert.getText();
        assertEquals(actual, expected, "Actual does not match the expected");

    }

    @Test
    public void promptAlert(){ //  #3 - Prompt alert - it requires you to send some information before you can click ok or cancel
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickJSPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickJSPrompt.click();

        String text = "Loopcamp"; // this is just the text that i'll be sending
       // driver.switchTo().alert().sendKeys(text); // OPTION 1 TO SEND IT
       // driver.switchTo().alert().accept();

        // OPTION #2

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();


        WebElement successMessagePromptAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessagePromptAlert.getText();
        String expected = "You entered: " + text;
        assertEquals(actual, expected, "Actual does not match the expected");

        clickJSPrompt.click();
        alert.sendKeys(text);
        alert.dismiss();
        actual = successMessagePromptAlert.getText();
        expected = "You entered: " + null;
        Assert.assertEquals(actual, expected, "Does not match");
    }




}
