package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * go to docuport
 * enter username
 * do NOT enter password
 * click on login button
 * verify error message - please enter password
 */
public class T1_locators_getText {
    public static void main(String[] args) {

    // go to the URL - i created a method under utilities package so i'll call it here not to have to create manually the webdriver everytime
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");


        // if the number doesnt change after refreshing the website means that it is a unique number
        WebElement userName = driver.findElement(By.id("input-14"));
        userName.sendKeys(DocuportConstants.USERNAME_CLIENT); // I created a method final so the information is always the same, if i need to change anything i can go directly to the method i created and will change it directly there


        WebElement loginButton = driver.findElement(By.className("v-btn__content"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.className("v-messages__message"));
        //System.out.println(errorMessage.getText()); // gets the text in between

        String actualErrorMessage = errorMessage.getText();
        // String expectedErrorMessage = "Please enter password"; // this comes from AC

        if (actualErrorMessage.equalsIgnoreCase(DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)) {
            System.out.println("Expected Error Message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", matches actual error message: " + actualErrorMessage + " test PASS");
        } else {
            System.err.println("Expected Error Message: " + DocuportConstants.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", DOES NOT match actual error message: " + actualErrorMessage + " test FAILED");
        }
        driver.quit();


    }
}
