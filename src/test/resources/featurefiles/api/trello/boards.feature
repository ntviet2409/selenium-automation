@trello
Feature: Trello user can get board information by api

  Scenario: [API] Admin can get board information by id - [TC-03]
    When Get board information by id "nzqB6ufX"
    Then Verify getting board information by id "nzqB6ufX" is successful
