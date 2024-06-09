package io.loop.test.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
navigate to amazon
maximize
navigate back
navigate forward
refresh
 */
public class NavigateToAmazon {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //navigate to amazon
        driver.navigate().to("https://www.amazon.com");

        //maximize
        driver.manage().window().maximize();

        //navigate back
        driver.navigate().back();

        //navigate forward
        driver.navigate().forward();

        //refresh
        driver.navigate().refresh();

        driver.quit();

    }




}
