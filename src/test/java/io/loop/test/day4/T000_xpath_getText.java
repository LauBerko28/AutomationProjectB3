package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static io.loop.test.utilities.DocuportConstants.EMAIL_FOR_RESET_PASSWORD;
import static io.loop.test.utilities.DocuportConstants.RESET_PASSWORD;

public class T000_xpath_getText {
/*
1. open chrome
2. go to docuport
3. click on forgot password
4. validate url contains: reset password
5. validate - Enter the email address associated with your account
6. Enter forgotpasswordg1@gmail.com to email box
7. validate send button is displayed
8. validate cancel button is displayed
9. click send button
10. validate - "We've sent you an email with a link to reset your password. Please check your email"
 */

    public static void main(String[] args) throws InterruptedException {
        /*

        WebDriver driver = WebDriverUtil.getDriver("chrome");

        // go to docuport
        driver.get("https://beta.docuport.app");

        // click on forgotPasswrod
       // WebElement forgotPassword = driver.findElement(By.cssSelector("div[class='text-right']")); --> THIS IS THE LOCATOR WITH CSS

        // TO LOCATE WITH XPATH
        // #1 Absolute XPath --> go from parent to child one by one --> not a good way of doing it
        //XPath=//tagName[@Attribute='value']
        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();
        //OPTION #2 //*[contains(text(),'Forgot password')]
        //OPTION #3 //*[starts-with(text(),'Forgot password')]
        //OPTION #4 //div[@class='text-right']
        forgotPassword.click();

        // Validate that URL contains "reset password"
        // in order tp validate

        String actualURL = driver.getCurrentUrl();
        // if we have exact expected with exact actual then i use .equalsIgnoreCase ~~ if not we can just use contains
        if(actualURL.contains(RESET_PASSWORD)){
            System.out.println("Actual URL: " + actualURL + " matches expected URL: " + RESET_PASSWORD);
        } else {
            System.err.println("Actual URL: " + actualURL + " does not match expected URL: " + RESET_PASSWORD);
        }

        WebElement validateMessage = driver.findElement(By.xpath("//*contains(text(),'Enter the email address')"));
        // "//div[@class='v-messages__message']"
        String actualValidateMessage = validateMessage.getText();

        if(actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)){
            System.out.println("Test passed");
        }else {
            System.err.println("Test failed");
        }

        // contains
        // contains text --> i want to find any element that contains
        // I can find the elements with exact text

        // to get from parent to child in xpath //div[@class='page-header']/h2

        // in XPath to go from child to parent //div[@class='page-header']/h2/..

        //in XPath to get to the sibling
        //-->  //input[@id='gbqfbb']/preceding-sibling::input


        // 6. Enter forgotpasswordg1@gmail.com to email box


    }
   */
//  1. open chrome
        //  2. go to docuport

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        // 3. click on forgot password

        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();

        // 4. validate url contains: reset password
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(DocuportConstants.RESET_PASSWORD)){
            System.out.println("Actual url matches expected one");
        } else {
            System.err.println("Actual url DOES NOT match expected one");
        }

        //5. validate - Enter the email address associated with yor account
        WebElement validateMessage = driver.findElement(By.xpath("//*[contains(text(),'Enter the email')]"));
        String actualValidateMessage = validateMessage.getText();

        if (actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)){
            System.out.println("Test pass");
        } else {
            System.out.println("Test fail");
        }

        // 6. enter forgotpasswordg1@gmail.com to email box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);


        // 7. validate send button is displayed
        // 8. validate cancel button is displayed
        WebElement cancelButton = driver.findElement(By.xpath("//*[contains(text(),'Cancel')]"));
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));

        if(cancelButton.isDisplayed()){
            System.out.println("Test pass - cancel is displayed");
        } else {
            System.out.println("Test fail - cancel is not displayed");
        }

        if(sendButton.isDisplayed()){
            System.out.println("Test pass - send is displayed");
        } else {
            System.out.println("Test fail - send is not displayed");
        }

        //9.
        sendButton.click();
        Thread.sleep(3000); // i add this one bc i want it to wait a little bit as the following message will pop up after a little bit

        //10.
        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));

        Thread.sleep(5000);
       // staleElemetn = im trying to do something with an element that was there but now is gone --> how to handle it? we can do Try and Catch

       // String actualMessage = successMessage.getText();

       // System.out.println("actualMessage = " + actualMessage);

        try{
            System.out.println(successMessage.getText()); // provide same name or above
        } catch (StaleElementReferenceException e){
            System.out.println("Element is not there anymore"); // the execution doesnt stop because it caught it
        }

        driver.quit();


    }
}
