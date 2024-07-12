package io.loop.test.day8;

public class T00_singleton_pattern_example {
    //singleton pattern --> to use only one instance of pattern
    // in order to achieve it i need a private constructor. as it will not allow external instantiation
    private T00_singleton_pattern_example() {} // this is my constructor

    private static String word; // i want to assign all the re-assignments to this one directly instead of creating new spaces in the heap/pool

    //to access it i need public getter
    public static String getWord(){
        if(word == null){
            System.out.println("First time calling, object is null and assign now");
            word = "driver";
        } else {
            System.out.println("Word is already assigned and has value");
        }

        return word;
    }

}
