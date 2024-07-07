package io.loop.test.day7;

    /*
    1. Open a chrome browser
    2. Go to : http://the-internet.herokuapp.com/windows
    3. Assert: Title is “The Internet”
    4. Click to: “Click Here” link
    5. Switch to new Window.
    6. Assert: Title is “New Window”
     */

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import static org.testng.Assert.assertEquals; // i added the static here to be able to call the method without the class name
import org.testng.annotations.Test;

import java.util.Set;


public class T1_window extends TestBase {
/*
the windowHandles is that element that will allow me to jump from one window to the next one, and I'm just storing it on Set because that is the type that this method accepts.
 */
    @Test
    public void test_window_handle(){
        driver.get("http://the-internet.herokuapp.com/windows");
        assertEquals(driver.getTitle(), "The Internet", "Results are NOT matching!");

        System.out.println(driver.getWindowHandle() + ": this is windows unique ID"); // 2E484373EA5828DFF8BDC7143C59A7F4: this is windows unique ID
        WebElement clickHere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        clickHere.click();

        System.out.println("driver.getTitle() = " + driver.getTitle());

        String originalWindow = driver.getWindowHandle();// here im getting the original window handle and assign it to string

        // here im getting all the window handles
        Set<String>windowHandles = driver.getWindowHandles();

        // here I loop through amd stay at the last window
        for (String each : windowHandles) {
            System.out.println("each window handle" + each);
            driver.switchTo().window(each); // driver please switch to each of the windows I have and print me their titles

        }

        System.out.println("driver.getTitle() = " + driver.getTitle());

        // here i switch to the original one
        driver.switchTo().window(originalWindow);

        System.out.println("driver.getTitle() = " + driver.getTitle());

        /*
        each window handleFBAC1C9BFC73F1F6341959467EE43E94
        driver.getTitle() = The Internet
        each window handle522B30179C0ECA485E4840BD5340C8A1
        driver.getTitle() = New Window
         */

    }

    @Test
    public void selenium_window(){ // selenium 4 new methods - newWindow for new tab or window --> this just creates a new tab or a new window
        driver.get("http://the-internet.herokuapp.com/windows");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
    }



}
