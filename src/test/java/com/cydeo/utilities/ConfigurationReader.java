package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {


    private static Properties properties = new Properties();

    static {

        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);

            //Close the file
            file.close();

        } catch (IOException e) {
            System.err.println("FILE NOT FOUND WITH GIVEN PATH!");
            e.printStackTrace();

        }
    }


    public static String getProperty(String property) {

        return properties.getProperty(property);


    }
}
