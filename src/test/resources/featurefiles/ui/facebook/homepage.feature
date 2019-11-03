@facebook
Feature: Login to home page
  Background:
    Given User navigates to url: "https://www.facebook.com/"
    And Login page is loaded

  Scenario: [UI] User is able  to login and post a status on Facebook - [TC01]
    When Login to Facebook with user email: "name" and password: "password"
    Then Facebook home page is displayed
