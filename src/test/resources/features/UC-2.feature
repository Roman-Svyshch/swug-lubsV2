Feature: UC-2
  Scenario: Test Login form with passing Username credentials

    Given User open the SauceDemo login Page
    When User enter "anyUsername" and "anyPassword"
    And User clear password field
    And I click the login button
    Then I should see the error message "Epic sadface: Password is required"
