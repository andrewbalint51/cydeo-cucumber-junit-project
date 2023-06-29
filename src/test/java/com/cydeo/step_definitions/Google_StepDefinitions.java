package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleHomePage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_StepDefinitions {

    GoogleHomePage googleHomePage = new GoogleHomePage();

    @When("user is on the google search page")
    public void user_is_on_the_google_search_page() {

        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see the title is Google")
    public void user_should_see_the_title_is_google() {

        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(expectedTitle.equals(actualTitle));
    }

    @And("user searches for a keyword")
    public void userSearchesForAKeyword() {

        googleHomePage.searchBox.sendKeys(ConfigurationReader.getProperty("keyword")+ Keys.ENTER);

    }

    @Then("keyword should be included in the title")
    public void keywordShouldBeIncludedInTheTitle() {

        String expectedTitle = ConfigurationReader.getProperty("keyword")+" - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
