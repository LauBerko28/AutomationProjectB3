package io.loop.test.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    //this class will help us to read what is inside configuration properties
    private static Properties properties; // this is a variable declaration private so not everyone will have access
    static{
        try{
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path); // hey java go and find this file from my framework
            properties = new Properties();
            properties.load(input); // here im adding the values to the properties
            input.close(); // here im closing the file
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperties(String keyName){ //keyName will provide me the key name that i have in my conf properties
        return properties.getProperty(keyName);
    }
}
