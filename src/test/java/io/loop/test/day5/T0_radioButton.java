package io.loop.test.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
  /*
        https://loopcamp.vercel.app/radio-buttons.html
        wait implicitly 10 seconds
         */

public class T0_radioButton {
    public static void main(String[] args) {
        // Thread.sleep comes from JAVA
        // implicitWait comes from Selenium

        WebDriver driver = WebDriverUtil.getDriver("chrome");
       // driver.manage().window().maximize();

        driver.get("https://loopcamp.vercel.app/radio-buttons.html");
        //Selenium 3 we do this way
       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Selenium 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement red = driver.findElement(By.xpath("//input[@id='red']"));
        WebElement green = driver.findElement(By.xpath("//input[@id='green']"));

        // isSelected() this method returns us true or false if radio button is selected or not
        System.out.println("red.isSelected() BEFORE CLICKING = " + red.isSelected()); // red.isSelected() BEFORE CLICKING = false
        red.click();

        System.out.println("red.isSelected() AFTER CLICKING = " + red.isSelected()); // red.isSelected() AFTER CLICKING = true

        //isEnabled()  will return true if the button i want to choose is active and can be used
        System.out.println("red.isEnabled() = " + red.isEnabled()); // red.isEnabled() = true
        System.out.println("green.isEnabled() = " + green.isEnabled()); // green.isEnabled() = false
    }
}
