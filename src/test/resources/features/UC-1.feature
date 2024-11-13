Feature: SauceDemo login functionality

  Scenario: User tries to log in with invalid credentials
    Given User open the SauceDemo login Page
    When User enter "standard_user" and "secret_sauce"
    And User clear all fields
    And I click the login button
    Then I should see the error message "Epic sadface: Username is required"
