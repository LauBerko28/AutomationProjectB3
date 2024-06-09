package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {
    public static void main(String[] args) {

        //Create the driver
        // BEST WAY TO LOCATE SOMETHING IS BY ID

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // navigate to loopcamp practice page
        driver.get("https://loopcamp.vercel.app/registration_form.html");

        //lacating the element
        WebElement firstName = driver.findElement(By.name("firstname"));
        //sending keys
        firstName.sendKeys("Loop"); // will go to the website and where it finds the spot firstname will add "Loopcamp"

        // using the class name - when there is  more than one element it'll loopk for the first match and use it
   // WebElement withClassName = driver.findElement(By.className("form-control"));
    //withClassName.sendKeys("Loop");

   // WebElement lastNameWithClass = driver.findElement(By.className("form-control"));
   // lastNameWithClass.sendKeys("Academy");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Academy");


        WebElement female = driver.findElement(By.name("gender"));
        female.click();
    }
}
