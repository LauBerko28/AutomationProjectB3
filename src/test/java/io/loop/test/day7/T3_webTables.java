package io.loop.test.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.DocuportWebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class T3_webTables extends TestBase {

    @Test
    public void test_webTables() throws InterruptedException {
        //call the method that will login when called
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Now I need to create an element for the user
        WebElement user = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        user.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String expectedFullName = "Alex De Souza";
        String actualFullName = DocuportWebTableUtils.returnAnyField(driver,"alex.de.souza@gmail.com", "full name" );
        System.out.println("actualFullName = " + actualFullName); // this will only return the full name, not if the test passed or not -at this level-

        // xpath: //td[2][text()='more@gmail.com']/preceding-sibling::td//span[2]
        // td[2] --> this one will provide the table that belongs to the index of 2
        // [text()='more@gmail.com']

        assertEquals(actualFullName, expectedFullName,"expected does not match actualFullName");



    }





}
