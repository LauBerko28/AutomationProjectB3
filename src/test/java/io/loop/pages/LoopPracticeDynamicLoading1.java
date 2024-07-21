package io.loop.pages;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDynamicLoading1 {
    //create a constructor
    public LoopPracticeDynamicLoading1(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // here im locating and storing my elements
    @FindBy(xpath = "//button[.='Start']")
    public WebElement startButton;

    @FindBy(id = "loading")
    public WebElement loading;

    @FindBy(id="username")
    public WebElement username;

    @FindBy (id = "pwd")
    public WebElement password;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy (id = "flash-messages")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@href='dynamic_loading/1.html']")
    public WebElement dynamicLoading1;


}
