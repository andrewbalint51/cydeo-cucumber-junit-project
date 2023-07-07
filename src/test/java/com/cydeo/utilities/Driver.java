package com.cydeo.utilities;

import io.cucumber.java.sl.In;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //Private constructor to remove access to this object

    private Driver(){}

    //private to close access outside of the class
    //Static so we can use in a static method
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /*
    Create reusable utility method that will return the same driver instance when we call it.
    If an instance doesn't exist, create it.
     */
    public static WebDriver getDriver(){
        if(driverPool.get()==null){
            //We will read browser type from configuration.properties
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on browser type in configuration.properties, switch statement
            will open the matching browser.
             */
            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


            }
        }

        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get()!=null){
            //terminate current existing driver completely
            driverPool.get().quit();
            //Assign value back to null
            driverPool.remove();
        }

    }

}
