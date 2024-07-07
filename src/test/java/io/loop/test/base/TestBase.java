package io.loop.test.base;

import io.loop.test.utilities.WebDriverUtil;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBase {

public WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
    driver = WebDriverUtil.getDriver("chrome");
    driver.manage().window().maximize();
    }


//   // @AfterMethod
//    public void tearDownMethod() {
//    driver.close(); // if i have here .close() it'll only close that window it opended(the current tab), but when i have a new tab will still open, that is why i use .quit() as this one will kill the driver entirely
    //}


}
