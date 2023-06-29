package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearchPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Bing_StepDefinitions {

    BingSearchPage bingSearchPage = new BingSearchPage();

    @When("user is on the Bing search page")
    public void user_is_on_the_bing_search_page() {
        Driver.getDriver().get("https://www.bing.com");
    }

    @When("user searches Bing for {word}")
    public void user_searches_bing_for_a_keyword(String keyWord) {
        bingSearchPage.searchBox.sendKeys(keyWord+ Keys.ENTER);
    }

    @Then("{word} should be included in the Bing title")
    public void keyword_should_be_included_in_the_bing_title(String keyWord) {

        String expectedTitle = keyWord+" - Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @And("user enters {string} in the Bing search box")
    public void userEntersInTheBingSearchBox(String arg0) {
        bingSearchPage.searchBox.sendKeys(arg0+Keys.ENTER);
    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String arg0) {

        String expectedTitle = arg0+" - Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
