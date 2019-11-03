@trello @api
Feature: Trello user can get board information by api

  Scenario: User can create new board - [TC-01]
    When Create Trello board
    Then Verify the new board is created successfully

  Scenario: User can not create board with invalid token - [TC-02]
    When Create Trello board with invalid token
    Then Verify the action is not succeeded because of error code "401"

  Scenario: User updates board with the same name as creation - [TC-03]
    When Update Trello board with the incorrect board id "!!#@$"
    Then Verify the action is not succeeded because of error code "400"
