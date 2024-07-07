package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.AssertJUnit.assertTrue;

public class BrowserUtilities {
    /**
     * validate if driver switched to expected url and title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author Laura
     * implements assertion
     */

    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){
        // first I need to make sure they are in lowercase because the user can provide it in any format
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        // get all window handles, switch one by one
        Set<String> windowHandles = driver.getWindowHandles(); // this method will get me all the tabs and windows that will be opened
        // each time check if the url matches the expected one
        for (String each : windowHandles){
            driver.switchTo().window(each); // please jump to each one of the windows 
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){ // if the actual url matches the expected one please grab it and finish
                break;
            }
        }
        //after stopping on expected url, validate the title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     *
     * @param driver
     * @param targetTitle
     * @author Laura
     */
    public static void switchToWindow(WebDriver driver, String targetTitle){
        //when the user provides something that is not valid i want it to go back to the original window
        String origin = driver.getWindowHandle();

        // how can i get the windowsHandle without storing it?

        for(String handle:driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(targetTitle)){
                return; // if it finds the title will return the same
            }
        }

        driver.switchTo().window(origin); // when there is not a matching case please return to the original window

    }

}
