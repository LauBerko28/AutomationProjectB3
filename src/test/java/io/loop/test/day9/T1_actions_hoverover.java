package io.loop.test.day9;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*
1. Go to https://www.google.com
2. Hover over on Search button
3. Hover over on Feeling Lucky button
*/
public class T1_actions_hoverover {

    @Test
    public void google_action_hover() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperties("google.url"));
        // first instance of the driver is created
        WebElement googleSearch = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']/preceding-sibling::input")); // here im finding a unique element without using index
        WebElement feelingLucky = Driver.getDriver().findElement(By.xpath("//input[@id='gbqfbb']"));

        Actions actions = new Actions(Driver.getDriver());
        // if i want to see how it hoversover then i need to provide some waiting time
        Thread.sleep(3000);
        // hover over method
        //perform method will actually perform what I want to do
        actions.moveToElement(googleSearch).perform();

        Thread.sleep(3000);
        actions.moveToElement(feelingLucky).perform();

        actions.sendKeys(Keys.F12);

    }
}
