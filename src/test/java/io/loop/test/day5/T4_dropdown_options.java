package io.loop.test.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
1. Open Chrome browser
2. Go to https://demoqa.com/select-menu
3. go old style select menu
4. Select Yellow and validate
5. Select Red and validate
6. Select White and validate
Use all Select options. (visible text, value, index)
 */
public class T4_dropdown_options {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverUtil.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

   // @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    // creating my test method

    @Test
    public void colorTest(){
        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
        // 1st by index
        dropDown.selectByIndex(3);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"Yellow"); // if this passes means that my test is correct

        // 2nd select by value
        dropDown.selectByValue("red");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"Red");

        //3rd select by
        dropDown.selectByVisibleText("White");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),"White");

    }


}
