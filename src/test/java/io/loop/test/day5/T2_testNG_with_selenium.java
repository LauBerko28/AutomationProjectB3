package io.loop.test.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_testNG_with_selenium {
    // creating some variables that I will need to ue

    WebDriver driver;
    String expected;
    String actual;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverUtil.getDriver("chrome");
       // driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

    @Test
    public void googleTittle(){
        driver.get("https://www.google.com");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Google";
        actual = driver.getTitle();
        Assert.assertEquals(actual,expected,"Actual: " + actual + "Does not match expected: " + expected); // the message will only popup if the test is failing
        // give me 2 values and check if they are equals or not
    }

    @Test
    public void docuportTitle(){
        driver.get("https://beta.docuport.app");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Docuport";
        actual = driver.getTitle();
        Assert.assertTrue(actual.contains(expected), "Actual does not match expected"); // assertTrue --> make sure that the condition I give is true, if the actual contains expected, if it returns true the test will pass, else will fail
        // ((RemoteWebDriver) driver).getSessionId() = 85a1ac4341d2726448f1b75a574ae0cf --> it gets the Id for the current session

        //The below means that for each
        //((RemoteWebDriver) driver).getSessionId() = 58cf80c1af21e5b5b671c16e6c2b4af1
        //((RemoteWebDriver) driver).getSessionId() = ed1ca4077e584044df435503bba28cbf


    }

}
