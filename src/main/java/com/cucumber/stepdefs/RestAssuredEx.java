package com.cucumber.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.MatcherAssert.assertThat;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredEx {

    private final String BASE_URL = "https://dummy.restapiexample.com";
    private Response response;

    @Given("the end point")
    public void theEndPoint() {
        System.out.println("Inside endpoint setup : ");
        RestAssured.baseURI = BASE_URL;

    }

    @When("user performs get operation")
    public void userPerformsGetOperation() {
        System.out.println("Inside perform action :");
        response =
                given().contentType(ContentType.JSON)
                        .when().get("/api/v1/employees") // watch out for GET method
                        .then().extract().response();
       // System.out.println("The response : " + response.asString());
       // System.out.println("The response : " + response.prettyPrint());
    }

    @Then("user should be able to get employee information")
    public void userShouldBeAbleToGetEmployeeInformation() {
        System.out.println(response.getBody().prettyPrint());
        System.out.println(response.statusCode());
    }

    @And("user should be able to verify the data in the output")
    public void userShouldBeAbleToVerifyTheDataInTheOutput() {

        System.out.println("------------Data Extraction----------");
        System.out.println(response.jsonPath().get("status").toString());
        System.out.println(response.jsonPath().getInt("data[0].id")); // get ID value from the block
        System.out.println(response.jsonPath().get("data[0].employee_name").toString()); // get employee_name value from the block
        System.out.println(response.jsonPath().get("data[0]").toString()); // a block of data

        System.out.println("------------Assertions----------------");
        assertThat(response.jsonPath().get("status").toString(), equalTo("success"));
        assertThat(response.jsonPath().get("data[0].employee_name").toString(), equalTo("Tiger Nixon"));
    }


    @When("user performs post operation")
    public void userPerformsPostOperation() {
        System.out.println("Inside POST action :");

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Donald Jeff"); //insert key value pair to jsonObject
        jsonObject.put("salary", 200000);
        jsonObject.put("age", 50);

        response =
                given().contentType(ContentType.JSON)
                        .when().post("/api/v1/create") // watch out for POST method
                        .then().extract().response();

        System.out.println(response.prettyPrint());
    }

    @Then("user should be able to post employee information")
    public void userShouldBeAbleToPostEmployeeInformation() {
        System.out.println("Inside validate POST action status code :" + response.statusCode());

    }

    @Then("user should be able to validate the output against the schema")
    public void userShouldBeAbleToValidateTheOutputAgainstTheSchema() {
        //obtain response
        response.then()
                .assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("/Users/praveenbaliga/Documents/cucumberSelenium/src/test/resources/schemas/schema.json")));

    }

    @When("user performs put operation")
    public void userPerformsPutOperation() {
        System.out.println("Inside PUT action :");

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "Donald Jeff"); //insert key value pair to jsonObject
        jsonObject.put("salary", 600000);
        jsonObject.put("age", 50);

        response =
                given().contentType(ContentType.JSON)
                        .when().put("api/v1/update/9158") // watch out for PUT method
                        .then().extract().response();

        System.out.println(response.prettyPrint());

    }

    @Then("user should be able to update employee information")
    public void userShouldBeAbleToUpdateEmployeeInformation() {
        System.out.println("Inside validate PUT action status code :" + response.statusCode());
    }
}
