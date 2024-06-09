package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        // create the driver object

        WebDriver driver = new ChromeDriver();

        // navigate to Google.com
        driver.get("https://www.google.com");

        // maximize
        driver.manage().window().maximize();

        //locate the element
        //1. create an object
        // 2. on the website i need to click inspect and search for the ID, that is the information that im pasing on the driver.findElement
        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb"));


        WebElement searchBoxWithName = driver.findElement(By.name("q"));
       // searchBoxWithName.sendKeys(textToSearch + Keys.ENTER);

        // go find that element that has a link and has a text which is "About"
        WebElement aboutLink = driver.findElement(By.linkText("About"));
        //aboutLink.click();


        String textToSearch = "Feyruz is smart";
        searchBoxWithID.sendKeys("Nadir is smart");

        Thread.sleep(3000);

        searchBoxWithID.clear();

        Thread.sleep(3000);

        // here im creating a string for the text i want to cheak


        searchBoxWithID.sendKeys(textToSearch); // just brings me to the search part and added the string "Feyruz is smart"
        searchBoxWithID.sendKeys(textToSearch + Keys.ENTER); // Keys.ENTER hits search so it actually looks for it






    }
}
