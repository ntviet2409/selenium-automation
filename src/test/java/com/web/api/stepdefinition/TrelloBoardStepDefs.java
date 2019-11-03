package com.web.api.stepdefinition;

import static com.web.api.constants.ApiCommonConstants.ID;
import static com.web.api.constants.ApiCommonConstants.NAME;
import static com.web.api.constants.ApiCommonConstants.PRODUCTION;
import static com.web.api.constants.ApiCommonConstants.TRELLO;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

import com.utilities.webdriver.InitDriver;
import com.web.api.utilities.BoardsUtils;
import com.web.api.utilities.CommonUtils;
import com.web.configuration.YmlReaders;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;

public class TrelloBoardStepDefs {
    private Response response;
    private String boardId;
    private static final String PROD_BASE_URL = CommonUtils.getAppUrlFromYmlConfig(TRELLO, PRODUCTION);
    private static final String RANDOM_STRING = RandomStringUtils.randomNumeric(5);
    private static final String TOKEN = YmlReaders.getToken(PRODUCTION);
    private static final String KEY = YmlReaders.getKey(PRODUCTION);
    private static final String BOARD_NAME = RANDOM_STRING;

    @After
    public void tearDown() {
        InitDriver.getInstance().getDriver().quit();
    }

    @When("^Create Trello board$")
    public void createNewTrelloBoard() {
        response = BoardsUtils.createBoard(PROD_BASE_URL, BOARD_NAME, KEY, TOKEN);
    }

    @Then("Verify the new board is created successfully")
    public void verifyNewBoardIsCreatedSuccessfully() {
        boardId = response.then().assertThat()
                .statusCode(SC_OK)
                .body(NAME, Matchers.equalTo(BOARD_NAME))
                .extract().jsonPath().get(ID);
        System.out.println(response.prettyPeek());
    }

    @When("^Create Trello board with invalid token$")
    public void createNewTrelloBoardWithInvalidToken() {
        response = BoardsUtils.createBoard(PROD_BASE_URL, BOARD_NAME, KEY, RANDOM_STRING);
    }

    @Then("^Verify the action is not succeeded because of error code \"(.*)\"$")
    public void verifyNewBoardIsCreatedSuccessfully(String code) {
        int errorCode = Integer.parseInt(code);
        response.then().assertThat().statusCode(errorCode);
    }

    @When("^Update Trello board with the incorrect board id \"(.*)\"$")
    public void updateTrelloBoardWithTheSameNameAsCreation(String id) {
        response = BoardsUtils.updateBoardName(PROD_BASE_URL, id, BOARD_NAME, KEY, TOKEN);
    }

    @Then("Verify the new board is not updated")
    public void verifyNewBoardIsNotUpdated() {
        response.then().assertThat().statusCode(SC_BAD_REQUEST);
    }
}
