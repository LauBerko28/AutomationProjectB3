package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_getAttribute_css {
    /*
    Go to docuport app
    identify docuport with css
    get value of the attribute
    validate if it is "Docuport"

    HOMEWORK=
    locate: username - password - login with css - login to docuport - locate home icon of docuport after login or any other element after login - validate that you are logged in
     */
    public static void main(String[] args) {
        // new locator: CSS - 1 of 8 locators of selenium, and allow us to custom the locators
        // css I can move from parent to child class


        // SYNTAX # 1  tagName [attribute] = 'attribute value'] --> BY ATTRIBUTE
        // example input[placeholder='first name']

        // SYNTAX # 2 tagName#idValue  --> BY ID
        // normal way -> input[id='gbqfbb']
        // shortcut with ID --> input#gbqfbb

        // SYNTAX # 3 - input[class='gNO89b'] --> BY CLASS NAME

        // div[class='page-header'] --> this will go to the parent
        // if I want to go to the child : div[class='page-header']>h2 ~~ >h2 is the beginning of the tag of the child


        // go to url:
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");

        // identify the logo with class
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']")); // using this one because it is a unique value
        // now i need to get that docuport value
        // located an attribute with the help of CSS selector
        String docuport = logo.getAttribute("alt");

        System.out.println("docuport = " + docuport);

        if(DocuportConstants.LOGO_DOCUPORT.equalsIgnoreCase(docuport)){
            System.out.println("expected logo docuport " + DocuportConstants.LOGO_DOCUPORT + " matches actual logo docuport " + docuport);
            System.out.println("TEST PASSED");
        }else {
            System.out.println("expected logo docuport " + DocuportConstants.LOGO_DOCUPORT + " DOES NOT match actual logo docuport " + docuport);
            System.err.println("TEST FAILED");

        }
    }
}
