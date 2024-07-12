package io.loop.test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PizzaOrderWebTablesUtil {

    // creating a method that will return me some information (thats why i do it with String)
    //im doing it as a method so everytime that someone provides me their name i can give the order details
    // im providing the driver bc is the one that navigates
    // i provide the String as this one will help me localize the order
    // I pass the String as the user can have the expected field they want
    public static String returnAnyFieldValue(WebDriver driver, String name, String field){

        String index = "";

        if(field.equalsIgnoreCase("Pizza Type")){ // if field name is Pizza, then provide this will be located at the index of 1, and so on ...
            index = "[1]";
        }else if (field.equalsIgnoreCase("Amount")) {
            index = "[2]";
        } else if (field.equalsIgnoreCase("Date")) {
            index = "[3]";
        } else if (field.equalsIgnoreCase("Street")) {
            index = "[4]";
        } else if (field.equalsIgnoreCase("City")){
            index = "[5]";
        } else if (field.equalsIgnoreCase("State")) {
            index = "[6]";
        } else if (field.equalsIgnoreCase("Zip")) {
            index = "[7]";
        } else if (field.equalsIgnoreCase("Card")) {
            index = "[8]";
        } else if (field.equalsIgnoreCase("Card Number")) {
            index = "[9]";
        } else if (field.equalsIgnoreCase("Exp")) {
            index = "[10]";
        } else {
            System.out.println("There is not such a field: " + field);
        }

        WebElement element = driver.findElement(By.xpath("//td[.='"+name+"']/following-sibling::td" + index)); // here im locating the
        return element.getText().trim();
    }
}
