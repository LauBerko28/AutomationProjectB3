package io.loop.test.day1_selenium_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

       // WebDriverManager.chromedriver().setup; this dependency is needed if we are using selenium 4.2 and under we will then need to have a boni garcia code from selenium

        // create an instance of webDriver
        WebDriver driver = new ChromeDriver(); // on the consol a link will come up, once you click it it'll open a new window on chrome

        // maximize the window --> once it opens it'll make the browser bigger
        driver.manage().window().maximize();
        // another way to maximize --> NOT SO USED
        // driver.manage().window().fullscreen();

        // Navitage the webpage --> will bring me to the website i have given the URL to
        driver.get("https://www.loopcamp.io");
        Thread.sleep(5000); // will give it a few seconds before navigating the next browser
        driver.navigate().to("https://www.etsy.com");

        // navigate back
        driver.navigate().back(); // will take me to the first URL, wait a few seconds move to the second URL and then will go back to the first URL

        // navigate forward
        driver.navigate().forward(); // will take me to the last URL

        // refresh
        driver.navigate().refresh(); // will re-load a website again

        // quit and close
        // FIRST -> Closing the first session
        // SECOND -> Close the
        driver.close(); // will go ahead and close the browser
        driver.quit();







    }
}
