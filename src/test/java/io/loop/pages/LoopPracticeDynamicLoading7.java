package io.loop.pages;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoopPracticeDynamicLoading7 {
    public LoopPracticeDynamicLoading7(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy( id = "alert")
    public WebElement doneMessage;

    @FindBy(xpath = "//img[@src='/img/a-few-moments.jpg']")
    public WebElement image;

    @FindBy(xpath = "//a[.='Dynamic Loading']")
    public WebElement dynamicLoad;


    @FindBy(xpath = "//a[.='Example 7: Loading page title after 5 seconds']")
    public WebElement dynamicLoading7;




}
