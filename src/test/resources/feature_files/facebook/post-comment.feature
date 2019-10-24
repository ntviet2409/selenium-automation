@Facebook @All
Feature: Posting a status on Facebook

  Background:
    Given Generic logout
    And User navigates to url: "https://www.facebook.com/"

  Scenario: User is able to login and post a status on Facebook - [TC01]
    Given Login page is loaded
    When Login to Facebook with user email: "<fb_username>" and password: "<fb_password>"
    Then Facebook home page is displayed
    When User input status message: "Hello World"
    Then Status message: "Hello World" is created
