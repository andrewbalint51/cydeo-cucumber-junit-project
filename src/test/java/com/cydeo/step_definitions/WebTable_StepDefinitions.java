package com.cydeo.step_definitions;

import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WT_OrderPage;
import com.cydeo.pages.WebTable_LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebTable_StepDefinitions {

    WebTable_LoginPage loginPage = new WebTable_LoginPage();
    WT_OrderPage orderPage = new WT_OrderPage();
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();

    @Given("user is on the WebTable App login page")
    public void user_is_on_the_web_table_app_login_page() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }
    @When("user enters correct username")
    public void user_enters_correct_username() {
        loginPage.usernameBox.sendKeys("Test");

    }

    @And("user enters correct password")
    public void userEntersCorrectPassword() {
        loginPage.passwordBox.sendKeys("Tester");
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }


    @Then("user should see orders word in the URL")
    public void userShouldSeeOrdersWordInTheURL() {
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualURL.contains("orders"));
    }

    @When("user enters {string} as a username and {string} as a password")
    public void userEntersAsAUsernameAndAsAPassword(String username, String password) {
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
    }

    @When("user enters the below credentials")
    public void userEntersTheBelowCredentials(Map<String, String> credentials) {
        loginPage.usernameBox.sendKeys(credentials.get("username"));
        loginPage.passwordBox.sendKeys(credentials.get("password"));
    }


    @Given("user is already logged in to the WebTable app")
    public void user_is_already_logged_in_to_the_web_table_app() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        loginPage.login();
    }
    @When("user is on the order page")
    public void user_is_on_the_order_page() {

        orderPage.orderLink.click();
        BrowserUtils.sleep(2);

    }
    @Then("user should see below options under product dropdown")
    public void user_should_see_below_options_under_product_dropdown(List<String> productOptions) {
        List<String> actualOptions = BrowserUtils.dropdownOptionsAsString(orderPage.productDropdown);

        Assert.assertTrue(actualOptions.equals(productOptions));

    }

    @Then("user should see below radio buttons enabled")
    public void userShouldSeeBelowRadioButtonsEnabled(List<String> paymentOptions) {

        List<String> actualOptions = BrowserUtils.webElementsAsString(orderPage.paymentOptions);

        Assert.assertTrue(actualOptions.equals(paymentOptions));

        for (WebElement paymentOption : orderPage.paymentOptions) {

            Assert.assertTrue(paymentOption.isEnabled());
        }
    }

    @Then("user sees Visa enabled as a payment option")
    public void userSeesVisaEnabledAsAPaymentOption() {
        orderPage.visaRadioButton.isEnabled();
    }

    @Then("user sees MasterCard enabled as a payment option")
    public void userSeesMasterCardEnabledAsAPaymentOption() {
        orderPage.masterCardRadioButton.isEnabled();
    }

    @Then("user sees American Express enabled as a payment option")
    public void userSeesAmericanExpressEnabledAsAPaymentOption() {
        orderPage.americanExpressRadioButton.isEnabled();
    }

    @And("user selects {string} from the products dropdown")
    public void userSelectsFromTheProductsDropdown(String selected) {

        Select select = new Select(orderPage.productDropdown);

        select.selectByVisibleText(selected);
    }

    @And("user enters {string} as a quantity")
    public void userEntersAsAQuantity(String quantity) {

        orderPage.quantityBox.clear();
        orderPage.quantityBox.sendKeys(quantity);
    }

    @Then("user clicks the calculate button")
    public void userClicksTheCalculateButton() {
        orderPage.calculateButton.click();
    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String name) {

        orderPage.customerName.sendKeys(name);

    }

    @And("user enters street address {string}")
    public void userEntersStreetAddress(String address) {
        orderPage.inputStreet.sendKeys(address);
    }

    @And("user enters city {string}")
    public void userEntersCity(String city) {
        orderPage.inputCity.sendKeys(city);
    }

    @And("user enters state {string}")
    public void userEntersState(String state) {
        orderPage.inputState.sendKeys(state);
    }

    @And("user enters zip {string}")
    public void userEntersZip(String zip) {
        orderPage.inputZip.sendKeys(zip);
    }

    @And("user selects payment option {string}")
    public void userSelectsPaymentOption(String cardType) {

        BrowserUtils.clickRadioButton(orderPage.paymentOptions, cardType);

    }

    @And("user enters card number {string}")
    public void userEntersCardNumber(String cardNo) {

        orderPage.inputCardNo.sendKeys(cardNo);
    }

    @And("user enters expiration date {string}")
    public void userEntersExpirationDate(String expDate) {
        orderPage.inputExpDate.sendKeys(expDate);
    }

    @And("user clicks process order button")
    public void userClicksProcessOrderButton() {
        orderPage.processOrderButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("user should see {string} in the first row of the web table")
    public void userShouldSeeInTheFirstRowOfTheWebTable(String name) {
        Assert.assertTrue(viewAllOrdersPage.firstListedCell.getText().equals(name));
    }
}
