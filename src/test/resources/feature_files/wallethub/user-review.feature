@WalletHub @All
Feature: Review rating

  Background:
    When User navigates to WalletHub url: "https://wallethub.com/join/login"
    And User signs in WalletHub with user email: "user_email" and password: "user_password"
    Then Profile name is displayed

  Scenario: User is able to review rating on WalletHub - [TC02]
    When User navigates to WalletHub url: "http://wallethub.com/profile/test_insurance_company/"
    Then Profile name is displayed
    When User hovers over the stars
    Then The first four stars inside get lit up when you hover over them
    When User clicks on the forth star
    Then The forth star is selected with the Policy dropdown
    When User clicks on the Policy dropdown
    And User changes the value to “Health Insurance”
    And User clicks on the link “Write a review” to write some random text at minimum of "200" characters
    And Press submit button
    Then User should see a confirmation screen saying you have reviewed the institution
    When User navigates to WalletHub url: "https://wallethub.com/profile/<user_profile_name>"
    Then Profile name is displayed
