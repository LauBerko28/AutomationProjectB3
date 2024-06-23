package io.loop.test.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

//1. Open Chrome browser
//        2. Go to http://the-internet.herokuapp.com/add_remove_elements/
//        3. Click to “Add Element” button
//        4. Verify “Delete” button is displayed after clicking.
//        5. Click to “Delete” button.
//        6. Verify “Delete” button is NOT displayed after clicking.
//        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
public class T000_staleElementException {
    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // here im saying to the website to wait 10 seconds

        //click the add button
        WebElement addButton = driver.findElement(By.xpath("//button[.='Add Element']"));
        addButton.click();

        //if I were to use the .isDisplayed() method will only show if at this time the delete button is visible or not, but not really if it was ever visible, that is why it is not a good practice to use this one here
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        if(deleteButton.isDisplayed()) {
            System.out.println("Delete button is displayed --> TEST PASSED");
        }else{
            System.err.println("Delete button is not displayed --> TEST FAILED");
        }
        deleteButton.click(); // go ahead and click delete button

        // if the element was never there it'll throw NoSuchElementException
        // if the element existed but no longer there, then it'll throw a StaleElementException
        try{
            deleteButton.isDisplayed(); // after we click deleteButton (line 36) that specific button will no longer be reflected on the website
        }catch (StaleElementReferenceException e){ // stale element exception means that button was there, but now is not there anymore
            System.out.println("Exception handled");
            System.out.println("Element is not displayed anymore");
        }

    }
}
