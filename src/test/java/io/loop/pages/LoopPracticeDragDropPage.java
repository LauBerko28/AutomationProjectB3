package io.loop.pages;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDragDropPage {
    //creating a constructor
    public LoopPracticeDragDropPage(){
        // here im initializing PageFactory that comes from Selenium
        // this will allow me not to create many times the element
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // this is how I am going to find the element small Circle
    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement smallCircle;

    @FindBy (id = "droptarget")
    public WebElement bigCircle;




}
