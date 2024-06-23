package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
        1- Open a chrome browser
        2- Go to: https://www.nba.com
        3- Locate all the links in the page.
         */
public class T1_findElements {
    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.get("https://www.nba.com");

        // this will find a list of all the elements that have "a" tag
        List<WebElement> nbaLinks = driver.findElements(By.tagName("a"));
        System.out.println(nbaLinks.size()); // here im finding how many a elements that a tag has  --> 409

        List<WebElement> nbaLinksXpath = driver.findElements(By.xpath("//a")); // driver inspect the website and return how many tags you find
        System.out.println(nbaLinksXpath.size());  // here im finding how many a elements that a tag has --> 409

        //span[@class='body-1']
        for (WebElement nbaLink : nbaLinks) { // after the driver gets all the links i need to check each one of them
            if(!nbaLink.getText().equalsIgnoreCase("")){ //if there is text take it
                System.out.println(nbaLink.getText()); // whenever there is text please print it
                System.out.println(nbaLink.getAttribute("href")); // href is the attribute, here im telling it please go ahead and return me the actual link
            }
        }

        for (int i = 0; i < nbaLinks.size(); i++) { // go to the browser and inspect it until you dont find any more links
            if(!nbaLinks.get(i).getText().equals("")){ // check if the links have text
                System.out.println(nbaLinks.get(i).getText()); // please print the text that you see there
                System.out.println(nbaLinks.get(i).getAttribute("href")); // please print the link that you see there


            }
        }


    }

}
