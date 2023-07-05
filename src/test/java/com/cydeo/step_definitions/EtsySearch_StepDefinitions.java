package com.cydeo.step_definitions;

import com.cydeo.pages.EtsySearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EtsySearch_StepDefinitions {

    EtsySearchPage etsy = new EtsySearchPage();

    @Given("user is on the Etsy homepage")
    public void user_is_on_the_etsy_homepage() {
        Driver.getDriver().get("https://www.etsy.com");
    }

    @Then("user should see title as expected")
    public void user_should_see_title_as_expected() {
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle = Driver.getDriver().getTitle();



        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

    @When("user types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {
        etsy.searchBox.sendKeys("Wooden Spoon");
    }
    @When("user clicks the search button")
    public void user_clicks_the_search_button() {
        etsy.searchButton.click();
    }
    @Then("user should see Wooden Spoon in the title")
    public void user_should_see_wooden_spoon_in_the_title() {
        BrowserUtils.verifyTitleContains("Wooden spoon");
    }

    @When("user types {string} in the search box")
    public void userTypesInTheSearchBox(String keyword) {
        etsy.searchBox.sendKeys(keyword);
    }

    @Then("user should see {string} in the Etsy title")
    public void userShouldSeeInTheEtsyTitle(String arg0) {
        BrowserUtils.verifyTitleContains(arg0);
    }




}
