package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    in order to achieve singleton patter i need a private constructor
    creating a private constructor so this class's object is not reachable from outside
     */
    private Driver(){}

    /*now i need to create the object of the Driver. I want to make it private, so others cannot access this
    static - so it can tun before everything else, and it can be used in static method
     */
    private static WebDriver driver;

    /*
    in order to access this driver i need a public getter method
    reusable method that will return the same driver instance everytime is called
     */
    // Im creating the below method so everytime I create a new driver what it does instead of creating a new space in the heap, it re-assignes the value to the original driver
    // IQ: What is singleton --> in order to use only one instance of driver, in order to achieve i need private constructor and private instance of the class, also need the getter method to acces it, the same needs to be first null to check if its empty and if so it will assign a new value of this. I make the static method to ensure the value is empty as thios static method is the very first one that will run before the class

    /**
     * Singgle pattern
     * @return a driver
     */
    public static WebDriver getDriver() {
        if (driver==null){
            String browserType = ConfigurationReader.getProperties("browser");
            switch (browserType.toLowerCase()){
                case "chrome":
                    driver = new ChromeDriver();
//                    ChromeOptions options = new ChromeOptions();
//                    options.addArguments("--incognito");
//                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    /**
     * closing the driver
     * @author Laura
     */

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }

}
