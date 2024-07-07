package io.loop.test.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtilities;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.Set;

/*
    1. Create new test and make set ups
    2. Go to : https://www.amazon.com
    3. Copy paste the lines from below into your class
    4. Create a logic to switch to the tab where Etsy.com is open
    5. Assert: Title contains “Etsy”
    Lines to be pasted:
    ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
    These lines will simply open new tabs using something called JavascriptExecutor
    and get those pages. We will learn JavascriptExecutor later as well.
     */
public class T2_window extends TestBase {

    @Test
    public void windowHandleTest(){
        driver.get("https://www.amazon.com"); // 1st one
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');"); // 2nd one
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');"); // 3rd one
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');"); // 4th one


/*      TO AVOID SO MANY LINES OF CODE, I CREATED A METHOD ON BROWSER UTILITIES THAT WILL HOLD ALL THE BELOW AND EVERYTIME I CALL IT, IT WILL ASK ME FOR THE PARAMETERS AND
        Set<String> windowHandles = driver.getWindowHandles(); //driver.get()windowHandles() returns set that is why i want to store it there
        //creating a logic to switch to the tab etsy
        for (String eachWindow : windowHandles) { // since the driver will open different tabs i want it to go through each one of them and check if my condition applies or not
            driver.switchTo().window(eachWindow); // please switch to each one of the windows you get
            System.out.println("current URL: "+driver.getCurrentUrl());

            if(driver.getCurrentUrl().toLowerCase().contains("google")){ // once the driver finds the tab with a title "Etsy" will stop because the case is true
                break;
            }

        }

 */

        // CALLING MY RE-USABLE METHOD THAT HAS 3 PARAMETERS AND WILL
      //  BrowserUtilities.switchWindowAndValidate(driver,"etsy.com", "ETSY");

        BrowserUtilities.switchToWindow(driver,"Google");
    }





}
