package com.cydeo.step_definitions;

import com.cydeo.pages.WikipediaHomePage;
import com.cydeo.pages.WikipediaResultPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikipediaHomePage homPage = new WikipediaHomePage();
    WikipediaResultPage resultsPage = new WikipediaResultPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }
    @When("User types {string} in the wiki search box")
    public void user_types_steve_jobs_in_the_wiki_search_box(String arg0) {
        homPage.searchBox.sendKeys(arg0);
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        homPage.searchButton.click();
    }
    @Then("User should see {string} is in the wiki title")
    public void user_should_see_steve_jobs_is_in_the_wiki_title(String arg0) {
        String expectedInTitle = arg0;
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    @Then("User should see {string} in the main header")
    public void userShouldSeeInTheMainHeader(String expectedHeaderText) {

        String actualHeaderText = resultsPage.mainHeader.getText();

        Assert.assertTrue(actualHeaderText.contains(expectedHeaderText));
    }

    @Then("User should see {string} in the image header")
    public void userShouldSeeInTheImageHeader(String arg0) {
        Assert.assertTrue(resultsPage.imageHeader.getText().contains(arg0));
    }
}
