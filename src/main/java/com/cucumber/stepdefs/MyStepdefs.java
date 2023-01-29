package com.cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {

    @Given("the user is on the browser")
    public void the_user_is_on_the_browser() {
        System.out.println("Hello");
    }
    @When("user searches for a text on web")
    public void user_searches_for_a_text_on_web() {
        System.out.println("Hello");
    }
    @Then("user should be able to see the result")
    public void user_should_be_able_to_see_the_result() {
        System.out.println("Hello");
    }

}
