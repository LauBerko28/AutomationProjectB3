package io.loop.test.day8;

import org.testng.annotations.Test;

public class T000_singleton_practice {

    //singleton patter helps us to reduce the memory, it is very helpul in our driver class, because we call the driver many times when we find an element. lets say i have a framework with 1000+ scenarios
    @Test
    public void practice(){
        String str1 = T00_singleton_pattern_example.getWord();
        System.out.println("str1 = " + str1); // here i called my string and it was empty so that its why it assigned the value of null
        /*
        First time calling, object is null and assign now
        str1 = driver
         */

        System.out.println("*************************");
        String str2 =  T00_singleton_pattern_example.getWord();
        System.out.println("str2 = " + str2);
        /*
        In this case
        Word is already assigned and has value
        str2 = driver
         */

    }
}
