package io.loop.test.day6;
    /*
    1- Open a chrome browser
    2- Go to: https://loopcamp.vercel.app/iframe.html
    3- Clear text from comment body
    4- Type "Loop Academy" in comment body
    5- Verify "Loop Academy" text is written in comment body
    6- Verify header "An iFrame containing the TinyMCE WYSIWYG Editor" is displayed
     */
import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class T2_iframe extends TestBase {

    @Test
    public void iframeTest()  {
        driver.get("https://loopcamp.vercel.app/iframe.html");
       // driver.manage().window().maximize();
/*
        WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame ')]")); // //div[@class='example']/h3
        System.out.println(header.getText());
        WebElement textBox = driver.findElement(By.xpath("//*[@id='iframe']"));
        System.out.println(textBody.getText()); // NoSuchElementException --> bc the element im trying to locate is inside iframe

 */
        // iFrame --> is like HTML inside HTML. if an element is inside iFrame, and I already got inside it, in order to find another element that is out of iFrame, i still have to ask the driver to get out of it to look to that element, so I send .defaultContent();
        // Need to find my iFrame and then locate it
        // ways to locate iFrame --> with xpath , with index, the last one is by ID


        //OPTION #1: by xpath
        //WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));  // here im locating the iframe
        //driver.switchTo().frame(iframe); // here im switching to iFrame which means im now inside it

        //OPTION #2: by Index
        //driver.switchTo().frame(0); // hey switch to index 0 of iframe

        //OPTION #3: By id
        driver.switchTo().frame("mce_0_ifr");

        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox.clear();
        String textToSend = "Loop Academy";
        textBox.sendKeys(textToSend);
        assertEquals(textBox.getText(),textToSend, "Actual is NOT matching expected");

        driver.switchTo().defaultContent(); // .defaultContent() --> take me back to HTML so i can find an element that is out of iFrame

        WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame ')]"));
        System.out.println(header.getText());
        assertTrue(header.isDisplayed()); // please check if this is visible, and if so return true

    }

    @Test
    public void nestedFrame(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        List<WebElement>iframes;
        iframes = driver.findElements(By.xpath("//frame"));
        System.out.println("iframes.size() = " + iframes.size()); // iframes.size() = 2
    }


}
