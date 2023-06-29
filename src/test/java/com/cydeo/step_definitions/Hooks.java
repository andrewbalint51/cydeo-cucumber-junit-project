package com.cydeo.step_definitions;

/*
In this class we are able to create pre and post conditions and scenarios for ALL scenarios and even steps.
 */

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //@Before
    public void setupMethod(){
        System.out.println("RUNNING BEFORE EACH METHOD");
    }

    @After
    public void teardownMethod(Scenario scenario){

        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        //System.out.println("RUNNING AFTER EACH SCENARIO");
        Driver.closeDriver();
    }

    //@BeforeStep
    public void beforeStep(){
        System.out.println("Before each step");
    }

    //@AfterStep
    public void teardownStep(){
        System.out.println("After each step");
    }
}
