package io.loop.test.day5;

import org.testng.Assert;
import org.testng.annotations.*;

public class T1_testNG_intro {

    // in testNG there is no main method
    // in order to use testNG I need to have the dependencies, so I go to maven search for testNG, click on the first one
    // test will run in alphabetic order then numeric order



    @Test(priority = 2) // when I want a test to run first in the arguments add the priority level
    public void test2() {
        System.out.println("Test 2 is running"); // this is running without main method
        String actual = "Feyruz";
        String expected = "Feyruz";
        Assert.assertEquals(actual,expected,"Message from actual, it will show only if the test fails"); // the message will only reflect in the consol whe  it fails
    }

    @Test(priority = 1)
    public void test1(){
        System.out.println("Test 1 is running"); // Test 2 is running
    }
/*
    @Test --> if I dont add the priority, by default will be 0 so it'll always run first
    public void atest(){
        System.out.println("Test a is running"); // Test 2 is running
    }

    @Test
    public void btest(){
        System.out.println("Test b is running"); // Test 2 is running
    }
 */
    @BeforeMethod // this is a set up method, is setting up something so all the methods can run
    // this will run before each method - each method being @Test
    public void beforeMethod() {
        System.out.println("Before method is running");
    }

    @AfterMethod
    // this will run After each method - each method being @Test
    public void tearDown() {
        System.out.println("After method is running");
    }

    @BeforeClass
    // this will run Before each class
    public void setUp() {
        System.out.println("Before class is running");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("After class is running");
    }
    /*
    fore class is running
    Before method is running
    Test 2 is running
After method is running
Before method is running
Test 1 is running
After method is running
After class is running
     */

    // If I want a .quit() i'll use it after @AfterClass


}
