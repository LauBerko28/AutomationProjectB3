package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeOptionsExample {
    public static void main(String[] args) {



        // created an object of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver();
        // adding arguments to options
        driver.get("https://www.google.com");



    }



}
