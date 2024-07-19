package io.loop.test.day9;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

/*
1. Go to https://www.etsy.com
2. Scroll down
3. Generate random email and enter into subscribe box
4. Click on Subscribe
5. Verify "Great! We've sent you an email to confirm your subscription." is displayed
*/
public class T3_JSExecutor_scroll {

    @Test
    public void etsy_scroll_test(){
        Driver.getDriver().get("https://loopcamp.vercel.app/");
        WebElement link = Driver.getDriver().findElement(By.xpath("//a[@target='_blank']"));

        Actions actions = new Actions(Driver.getDriver());

        //SCROLLING
        // #1 WAY - Use actions move to element
            //actions.moveToElement(link).perform();
            // actions.scrollToElement(link).perform();

        //#2 WAY - Use Key Press
            //actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform(); --> I do it 3 times so it brings me all the way to the end

        //#3 WAY - move horizontally or vertically
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver(); // here im using JavaScriptExecutor
        //js.executeScript("window.scroll(0,5000)");

        //#4 WAY - Scroll to view
        js.executeScript("arguments[0].scrollIntoView(true)",link);
        js.executeScript("arguments[0].click()",link);
        js.executeScript("window.scroll(0,500)");




    }

}
