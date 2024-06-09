package io.loop.test.day3;
/*
go to url: https://loopcamp.vercel.app/registration_form.html
verify header text expected:  Registration form
verify placeholder attribute value expected - username
 */

import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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



    }
}
