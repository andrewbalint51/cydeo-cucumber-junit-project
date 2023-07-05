package com.cydeo.step_definitions;

import com.cydeo.pages.R_VytrackDashboardPage;
import com.cydeo.pages.R_VytrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class R_Vytrack_StepDefinitions {

    R_VytrackLoginPage loginPage = new R_VytrackLoginPage();
    R_VytrackDashboardPage dashboardPage = new R_VytrackDashboardPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
    }
    @When("user enters the driver information")
    public void user_enters_the_driver_information() {

        loginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));
    }
    @Then("user should be able to login")
    public void user_should_be_able_to_login() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Dashboard"));
        BrowserUtils.verifyTitle("Dashboard");

    }

    @When("user enters the sales manager information")
    public void user_enters_the_sales_manager_information() {

        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty("sales_manager_password"));
    }

    @When("user enters the store manager information")
    public void user_enters_the_store_manager_information() {

        loginPage.login(ConfigurationReader.getProperty("store_manager_username"), ConfigurationReader.getProperty("store_manager_password"));
    }


    @When("user enters the {string} information")
    public void dynamicLogin(String employeeType) {

        employeeType=employeeType.replace(" ", "_");

        loginPage.login(ConfigurationReader.getProperty(employeeType+"_username"), ConfigurationReader.getProperty(employeeType+"_password"));
    }

    @Then("user should be able to see following modules")
    public void userShouldBeAbleToSeeFollowingModules(List<String> modules) {

        List<String> modulesAsString = new ArrayList<>();


        Assert.assertTrue(BrowserUtils.webElementsAsString(dashboardPage.allTopModules).equals(modules));
    }
}
