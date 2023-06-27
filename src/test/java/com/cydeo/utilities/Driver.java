package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    //Private constructor to remove access to this object

    private Driver(){}

    //private to close access outside of the class
    //Static so we can use in a static method
    private static WebDriver driver;

    /*
    Create reusable utility method that will return the same driver instance when we call it.
    If an instance doesn't exist, create it.
     */
    public static WebDriver getDriver(){
        if(driver==null){
            //We will read browser type from configuration.properties
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on browser type in configuration.properties, switch statement
            will open the matching browser.
             */
            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            }
        }

        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            //terminate current existing driver completely
            driver.quit();
            //Assign value back to null
            driver = null;
        }

    }

}
