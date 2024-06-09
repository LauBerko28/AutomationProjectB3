package io.loop.test.day3;
/*
 * Navigate to Google search
 * maximize the page
 * get title of the page
 * get url of the page
 * validate the title, expected title is "Google"
 * validate the url of the page, expected url is "https://www.google.com/"
 * close the brower
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {
       // in selenium 3 we had to set up the driver, for that we need webdriver manager libraries
       // WebDriverManager.chromedriver().setup();

        // create a driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google
        driver.get("https://www.google.com/");

        //maximize
        driver.manage().window().maximize();

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle(); // searches for the title and returns it in a string format
         // System.out.println(driver.getTitle()); // this will print Google in the consol, return type is string

        if(actualTitle.contains(expectedTitle)){ // here we can also do .equals || .equalsIgnoreCase
            System.out.println("Actual title is: " + actualTitle + ", matches expected title: " + expectedTitle + ".  => TEST PASS");
        } else {
            System.err.println("Actual title is: " + actualTitle + ", DOES NOT match expected title: " + expectedTitle + ".  => TEST FAIL");
        }
        // System.err.println() --> when there is an error, the consol will print it in red showign an error

        String expectedURL = "https://www.google.com/";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(expectedURL)){
            System.out.println("Actual URL: " + actualURL + ", matches expected URL: " + expectedURL + ".  => TEST PASS");
        }else {
            System.err.println("Actual URL: " + actualURL + ", DOES NOT match expected URL: " + expectedURL + ".  => TEST FAIL");
        }

        //System.out.println(driver.getCurrentUrl()); //  this method has a return type of String - gets the URL and returns it on a String format
        driver.quit();


    }
}
