package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T00_css_isDisplayed {
    /*
    http://the-internet.herokuapp.com/forgot_password
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
       // driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/forgot_password");

        WebElement forgotPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));
        System.out.println("forgotPasswordHeading.getText() = " + forgotPasswordHeading.getText()); // forgotPasswordHeading.getText() = Forgot Password

        // this will return if the ... on html is visible or not
        System.out.println("forgotPasswordHeading.isDisplayed() = " + forgotPasswordHeading.isDisplayed()); // this returns boolean -if it can see it or not-

        if(forgotPasswordHeading.isDisplayed()){
            System.out.println("test PASSED");
        } else{
            System.err.println("test FAILED");
        }

    }
}
