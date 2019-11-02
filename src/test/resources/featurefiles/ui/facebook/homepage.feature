@smoke
Feature: Login to home page
  Background:
    Given User navigates to url: "https://www.facebook.com/"
    And Login page is loaded

  Scenario: User is able  to login and post a status on Facebook - [TC01]
    When Login to Facebook with user email: "ntviet2409@gmail.com" and password: "Ntv-1990facebook"
    Then Facebook home page is displayed
