package io.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocuportWebTableUtils {

    /**
     * Return any field from table by given email
     * @param driver
     * @param emailAddress
     * @param field
     * @return
     * @author Laura
     */
    public static String returnAnyField(WebDriver driver, String emailAddress, String field) throws InterruptedException {
        //Once the method is called and the email address is provided which field do I want it to provide
        // the driver will always need to be passed on the arguments

        WebElement element = null;
        String xpath = "";

        switch (field.toLowerCase()){ // field is basically what the user is telling me they want to know from the user
            case "full name":
                xpath = "//td[2][text()='" + emailAddress + "']/preceding-sibling::td//span[2]"; // creating an xpath for the email and making the emailaddress dynamic
                element = driver.findElement(By.xpath(xpath));
                break;

            case "username":
                xpath = "//td[2][. = '"+emailAddress + "']/following-sibling::td"; //now im trying to find the username --> td gives me
                element = driver.findElement(By.xpath(xpath));
                break;
            case "inviter":
                xpath = "//td[2][. = '"+emailAddress + "']/following-sibling::td[2]"; //now im trying to find the inviter field --> td gives me
                element = driver.findElement(By.xpath(xpath));
                break;
            case "phone number":
                xpath = "//td[2][. = '"+emailAddress+"']/following-sibling::td[3]/span"; //now im trying to find the phone Number field --> td gives me
                element = driver.findElement(By.xpath(xpath));
                break;
            case "role":
                xpath = "//td[2][. = '"+emailAddress+"']/following-sibling::td[4]/span/span"; //now im trying to find the phone Number field --> td gives me
                element = driver.findElement(By.xpath(xpath));
                break;
            case "advisor":
                xpath = "//td[2][. = '"+emailAddress+"']/following-sibling::td[5]"; //now im trying to find the phone Number field --> td gives me
                element = driver.findElement(By.xpath(xpath));
                break;
            default:throw new InterruptedException("there is not such a field"+ field);

        }

        return element.getText().trim();

    }



}
