package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T0_forget_password {
    /*
    verify forget password
    identify reset password heading using css and go from parent to child
     */
    public static void main(String[] args) {

        // creating the web driver
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        // driver.manage().window().maximize();

        // go to the url
        driver.get("https://beta.docuport.app");

        //forget password link
        // i have to search for the forget password element and then
        WebElement forgetPasswordLink = driver.findElement(By.cssSelector("div[class='text-right']>a")); // this one will take me to the parent class div[class='text-right']
        // this >a will take me to the child class
        // search me by attribute --> "a[href='/reset-password']"

        forgetPasswordLink.click();
        // whenever i see div is a parent class, and h is a child class
        //div[class='text-right']>a
        // 1. went to the browser and inspected it
        // 2. search for the forgotpassword location
        // 3. in order to verify

        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class='login-layout__form']>h1"));
        System.out.println("forgetPasswordHeading = " + forgetPasswordHeading);


    }
}
