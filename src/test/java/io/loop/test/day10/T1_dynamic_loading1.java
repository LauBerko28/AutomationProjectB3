package io.loop.test.day10;

import io.loop.pages.LoopPracticeDynamicLoading1;
import io.loop.test.utilities.BrowserUtilities;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/*
1. go to https://loopcamp.vercel.app/dynamic_loading/1.html
2. click start
3. wait loading bar disappears
4. validate username is displayed
5. enter username tomsmith
6. enter password incorrectpassword
7. click submit button
8. validate "Your password is invalid!" is displayed
 */
public class T1_dynamic_loading1 {

    LoopPracticeDynamicLoading1 loopPracticeDynamicLoading1;

    @BeforeMethod
    public void setUpMethod(){
        loopPracticeDynamicLoading1 = new LoopPracticeDynamicLoading1();
        Driver.getDriver().get(ConfigurationReader.getProperties("loop.practice"));
    }

    @Test
    public void dynamicLoading1() {
        BrowserUtilities.loopLinkClick("Dynamic Loading"); // here im clicking on the dynamic loading element form the main opage of the website
        BrowserUtilities.waitForClickable(loopPracticeDynamicLoading1.dynamicLoading1,10).click(); // here im going to click on another link that appears after i clicked on dynamic loading
        BrowserUtilities.waitForClickable(loopPracticeDynamicLoading1.startButton,10).click(); // here im waiting for an element to be displayed (clickable) and then to click it
        BrowserUtilities.waitForInVisibility(loopPracticeDynamicLoading1.loading,10); // here im waiting for the loading bar to disappear
        assertTrue(loopPracticeDynamicLoading1.username.isDisplayed()); // once the loading bar disappear check that the element is in fact displayed
        loopPracticeDynamicLoading1.username.sendKeys(ConfigurationReader.getProperties("dynamicLoading.username"));
        loopPracticeDynamicLoading1.password.sendKeys(ConfigurationReader.getProperties("dynamicLoading.incorrectPassword"));
        loopPracticeDynamicLoading1.submitButton.click();
        BrowserUtilities.waitForVisibility(loopPracticeDynamicLoading1.errorMessage,10).isDisplayed();
    }


}
