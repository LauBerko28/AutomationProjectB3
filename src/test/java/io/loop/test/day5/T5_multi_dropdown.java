package io.loop.test.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/*
 1. Open Chrome browser
 2. Go to https://demoqa.com/select-menu
 3. Select all the options from multiple select dropdown.
 4. Print out all selected values.
 5. Deselect all values.
  */
public class T5_multi_dropdown {
    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = WebDriverUtil.getDriver("chrome");
        driver.get("https://demoqa.com/select-menu");
        //driver.navigate().to("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown(){
      //  driver.close();
    }

    @Test
    public void multiSelect() throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='cars']"))); // webElement does not have access to .isMultiple that is why i have to use Select
        //isMultiple allows us to test if dropdown is a multi select one
        Assert.assertTrue(dropdown.isMultiple(), "Dropdown is not multiple selection");

        /* This way i'll select one by one
        dropdown.selectByIndex(0);
        Thread.sleep(3000);

        dropdown.selectByValue("saab");
        Thread.sleep(3000);

        dropdown.selectByVisibleText("Opel");
        Thread.sleep(3000);

        dropdown.selectByIndex(3);
        */

        //
        List<WebElement> options;    //created WebElement of options
        options = dropdown.getOptions(); // this will store all the options visible

        //OPTION 1 - FOR LOOP
//        for (WebElement option : options) { // iterate through the option - from all the options i have please go through each one of them
//            option.click();                 // once you have them click them
//            System.out.println(option.getText()); //
//        }

        //OPTION 2 - WITH LAMBDA
        options.forEach(option ->{
            option.click();
            System.out.println(option.getText());
        });


    }

}
