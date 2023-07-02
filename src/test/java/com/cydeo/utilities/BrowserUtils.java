package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    /*
  This method will accept an integer in seconds and run Thread.sleep for the input duration
  Args: int seconds
   */
    public static void sleep(int seconds)
    {
        seconds*=1000;
        try{
            Thread.sleep(seconds);
        }
        catch (InterruptedException e){

        }
    }

    /*
    This method switches to the window with the specified URL and verifies the window's title
    WebDriver driver, String expectedInURL, String expectedInTitle
     */

    public static void switchWindowAndVerify(String expectedInURL, String expectedInTitle){

        Set<String> handles = Driver.getDriver().getWindowHandles();

        for (String each : handles) {

            Driver.getDriver().switchTo().window(each);
            if(Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }

        }

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    /*
    This method verifies if the current title is as expected
    Args: WebDriver driver, String expectedTitle
     */

    public static void verifyTitle(String expectedTitle){

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public static void verifyTitleContains(String expectedInTitle){

        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void waitForInvisibilityOf(WebElement target){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitForTitleContains(String title){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleContains(title));
    }

    /**
     * This method returns a List of WebElements as a List of Strings
     * @param dropdownElement
     * @return
     */

    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){

        Select dropdown = new Select(dropdownElement);

        List<WebElement> month_as_WEBELEMENT = dropdown.getOptions();

        List<String> monthAs_STRING = new ArrayList<>();

        for (WebElement each : month_as_WEBELEMENT) {
            monthAs_STRING.add(each.getText());
        }

        return monthAs_STRING;

    }
}
