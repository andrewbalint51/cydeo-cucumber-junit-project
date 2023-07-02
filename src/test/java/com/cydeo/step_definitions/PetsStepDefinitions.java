package com.cydeo.step_definitions;

import io.cucumber.java.en.Then;

import java.util.List;

public class PetsStepDefinitions {


    @Then("I will share my favorite")
    public void i_will_share_my_favorite(List<String> pets) {
        System.out.println("pets = " + pets);
    }
}
