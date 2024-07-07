package io.loop.test.day7;

 /*
    go to https://loopcamp.vercel.app/nested-frames.html
    validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

     */
import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T0_iframe_practice extends TestBase {

    @Test
    public void left(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top"); // this one is going to parent frame --> I must switch from the parent to the child first, if not i'll get a noSuchElementException
        driver.switchTo().frame("frame-left"); //child

        WebElement left = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        String actualLeft = left.getText();

        Assert.assertEquals(actualLeft.trim(), "LEFT"); // using the .trim() method to take care of the spaces at the beginning and end -otherwise it can fail the test-

    }
}
