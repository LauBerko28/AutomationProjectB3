package io.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    /**
     * @param driver
     * @param expectedTitle
     * returns void, assertion is implemented
     * @author nadir
     */
    public static void validateTitle (WebDriver driver, String expectedTitle){
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     * Click any link from loop practice
     * @param nameOfPage
     * @author nadir
     */
    public static void loopLinkClick(String nameOfPage){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='"+nameOfPage+"']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Moves the mouse to given element
     * @param element on which to hover
     * @author nadir
     */
    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Scrolls down to an element using JavaScript
     * @param element
     * @author nadir
     */
    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Clicks on an element using JavaScript
     * @param element
     * @author nadir
     */
    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Performs double click action on an element
     * @param element
     * @author nadir
     */
    public static void doubleClick(WebElement element){
        new Actions(Driver.getDriver()).doubleClick(element).perform();
    }

    /**
     * Waits for the provided element to be visible on the page
     * @param element
     * @param timeToWaitInSec
     * @return
     * @author nadir
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @author nadir
     */
    public static void waitForInVisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * performs a pause
     * @param seconds
     * @author nadir
     */
    public static void justWait (int seconds){
        try{
            Thread.sleep(seconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * Waits for provided element to be clickable
     * @param element
     * @param timeout
     * @return
     * @author nadir
     */
    public static WebElement waitForClickable (WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }








}
