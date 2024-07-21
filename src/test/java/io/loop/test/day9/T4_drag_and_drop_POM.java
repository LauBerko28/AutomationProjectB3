package io.loop.test.day9;

import io.loop.pages.LoopPracticeDragDropPage;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/*
Loop Practice Drag and Drop Test
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. validate expected default text appears on big circle
Expected = "Drag the small circle here."

Loop Practice Drag and Drop Test
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. validate "Drop here." text appears on big circle

1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. Move it on top of the big circle
5. validate “Now drop…” text appears on big circ

1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. Dropped anywhere outside of big circle
5. validate “Try again!” text appears on big circle
*/
public class T4_drag_and_drop_POM {

    // First I need to create the object of my class
    LoopPracticeDragDropPage loopPracticeDragDropPage;
    Actions actions;

    @BeforeMethod
    public void setUpMethod() { // as all the test will go to the same website that is why im adding it to the before method
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        loopPracticeDragDropPage = new LoopPracticeDragDropPage();
        actions = new Actions(Driver.getDriver());
    }

    @Test
    public void drag_small_here_test(){
        String expected = "Drag the small circle here.";
        String actual = loopPracticeDragDropPage.bigCircle.getText();
        assertEquals(actual,expected,"Actual does not match the expected");
    }

    @Test
    public void drop_here_test(){
       actions.moveToElement(loopPracticeDragDropPage.smallCircle)
               .clickAndHold()
               .moveByOffset(100,100)
               .pause(3000)
               .perform();
       assertEquals(loopPracticeDragDropPage.bigCircle.getText().trim(),"Drop here.", "expected does not match the actual");
    }

    @Test
    public void drop_now_test(){
        actions.moveToElement(loopPracticeDragDropPage.smallCircle)
                .clickAndHold()
                .moveByOffset(0,-200)
                .pause(3000)
                .perform();
        assertEquals(loopPracticeDragDropPage.bigCircle.getText().trim(),"Now drop...", "expected does not match the actual");
    }

    @Test
    public void move_anywhere_test(){
        actions.moveToElement(loopPracticeDragDropPage.smallCircle)
                .clickAndHold()
                .moveByOffset(10,200)
                .pause(3000)
                .release()
                .perform();
        assertEquals(loopPracticeDragDropPage.bigCircle.getText().trim(),"Try again!", "expected does not match the actual");
    }

    @Test
    public void drop_right_location (){
        actions.moveToElement(loopPracticeDragDropPage.smallCircle)
                .clickAndHold()
                .moveToElement(loopPracticeDragDropPage.bigCircle)
                .release()
                .perform();
        assertEquals(loopPracticeDragDropPage.bigCircle.getText().trim(),"You did great!", "expected does not match actual");
    }

    @Test
    public void drop_right_location_Drag_and_drop (){
        actions.dragAndDrop(loopPracticeDragDropPage.smallCircle,loopPracticeDragDropPage.bigCircle)
                        .perform();
        assertEquals(loopPracticeDragDropPage.bigCircle.getText().trim(),"You did great!", "expected does not match actual");
    }



    @AfterMethod
    public void tearDown_method(){
        Driver.closeDriver();
    }

}
