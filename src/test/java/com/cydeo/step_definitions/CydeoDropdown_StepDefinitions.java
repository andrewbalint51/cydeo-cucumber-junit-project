package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoDropdowns;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CydeoDropdown_StepDefinitions {

    CydeoDropdowns dropdowns = new CydeoDropdowns();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String>months) {

        List<String> monthsAsString = BrowserUtils.dropdownOptionsAsString(dropdowns.monthDropdown);

        Assert.assertTrue(monthsAsString.equals(months));

    }

}
