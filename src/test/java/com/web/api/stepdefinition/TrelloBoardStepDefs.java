package com.web.api.stepdefinition;

import static com.web.api.constants.ApiCommonConstants.PRODUCTION;
import static com.web.api.constants.ApiCommonConstants.TRELLO;
import static org.apache.http.HttpStatus.SC_OK;

import com.web.api.utilities.BoardsUtils;
import com.web.api.utilities.CommonUtils;
import com.web.configuration.YmlReaders;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

public class TrelloBoardStepDefs {
    private Response response;
    private static final String PROD_BASE_URL = CommonUtils.getAppUrlFromYmlConfig(TRELLO, PRODUCTION);
    private static final String TOKEN = YmlReaders.getToken(PRODUCTION);
    private static final String KEY = YmlReaders.getKey(PRODUCTION);
    private static final String SHORT_URL = "shortUrl";

    @When("^Get board information by id \"(.*)\"$")
    public void betBoardInformationById(String id) {
        response = BoardsUtils.getBoardInfoById(PROD_BASE_URL, id, KEY, TOKEN);
    }

    @Then("Verify getting board information by id \"(.*)\" is successful")
    public void verifyGettingBoardInformationByIdIsSuccessful(String id) {
        response.then().assertThat()
                .statusCode(SC_OK)
                .body(SHORT_URL, Matchers.containsString(id));
    }
}
