package com.web.api.stepdefinition;

import com.web.api.models.Decorators;
import com.web.api.utilities.DecorateUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import static org.apache.http.HttpStatus.SC_OK;

public class DecorateStepDefs {
    private Response response;
    private static final String NULL = "null";

    @Then("Verify validation request should be successful")
    public void verifyValidationRequestShouldBeSuccessful() {
        response.then().assertThat().statusCode(SC_OK);
    }

    private Decorators setUpDecorators(String name, String description, String type, String specifics) {
        if (name.equals(NULL)) {
            name = null;
        }
        if (description.equals(NULL)) {
            description = null;
        }
        if (type.equals(NULL)) {
            type = null;
        }
        if (specifics.equals(NULL)) {
            specifics = null;
        }
        Decorators deco = new Decorators();
        deco.setName(name);
        deco.setDescription(description);
        deco.setType(type);
        deco.setSpecifics(specifics);
        return deco;
    }

    @When("Get a decorator by name (.*), description (.*), type (.*), specifics (.*)")
    public void getDecoratorByRequest(String name, String desc, String type, String specifics) {
        Decorators deco = setUpDecorators(name + RandomStringUtils.randomAlphabetic(5), desc, type, specifics);
        response = DecorateUtils.createDecorator(deco);
        System.out.println(response.prettyPeek());
    }
}
