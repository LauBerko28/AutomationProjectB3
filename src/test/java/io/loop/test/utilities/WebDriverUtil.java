package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverUtil {

    // we are going to create a method with static that will accept parameters which type of driver we want

    /**
     *
     * @param browsertype
     * @return the driver of that browser
     * @author Laura B
     */
    public static WebDriver getDriver(String browsertype) {
        if (browsertype.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        } else if (browsertype.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        } else if (browsertype.equalsIgnoreCase("safari")) {
            return  new SafariDriver();
        }else {
            System.err.println("No driver found");
            System.err.println("Driver is null");
            return null;
        }

    }

}
