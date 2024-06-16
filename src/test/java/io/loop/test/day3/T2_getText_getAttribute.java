package io.loop.test.day3;
/*
go to url: https://loopcamp.vercel.app/registration_form.html
verify header text expected:  Registration form
verify placeholder attribute value expected name expected - first name
 */

import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static io.loop.test.utilities.LoopCampConstants.EXPECTED_PLACEHOLDER_FIRSTNAME;

public class T2_getText_getAttribute {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.get("http://loopcamp.vercel.app/registration_form.html");

        // i can also locate by tagName <h2>

        WebElement headerForForm = driver.findElement(By.tagName("h2"));
        String actualHeaderForForm = headerForForm.getText();

        if(actualHeaderForForm.equalsIgnoreCase(LoopCampConstants.EXPECTED_HEADER_FOR_FORM)){
            System.out.println("expected header for " + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + ", matches actual header form " + actualHeaderForForm + " ==> TEST PASSED");
        }else {
            System.out.println("expected header for " + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + ", DOES NOT match actual header form " + actualHeaderForForm + " ==> TEST FAIL ");
        }

        // Now we will check how to get information by the atribute
        // 1. create the object
        //2. from inspection in the browser i got the attribute firstname --> comes from placeholder= this is not TEXT (when is text the letters are white)the VALUE OF THE ATTRIBUTE (the letters are inside "")
        WebElement firstNamePlaceHolder = driver.findElement(By.name("firstname"));
        String actualPlaceHolderForFirstName = firstNamePlaceHolder.getAttribute("placeholder"); // getatribute wants me to provide the name of the attirbute, and then will return me its value --> in this case the name of the attribute is placeholder
        System.out.println(actualPlaceHolderForFirstName); // returns the value of the attribuyte --> first name

        // Now im doing the validation
        if(actualPlaceHolderForFirstName.equalsIgnoreCase(EXPECTED_PLACEHOLDER_FIRSTNAME)){
            //Can also do it this way! --> if (actualPlaceHolderForFirstName.equalsIgnoreCase(EXPECTED_PLACEHOLDER_FIRSTNAME));
            System.out.println("Expected placeholder matches the actual place holder");
            System.out.println("TEST PASSED");

        } else {
            System.out.println("Expected placeholder DOES NOT match the actual placeholder");
            System.err.println("TEST FAILED"); // the .err will show it in red

        }




    }
}
