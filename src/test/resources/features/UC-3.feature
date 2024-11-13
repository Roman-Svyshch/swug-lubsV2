Feature: UC-3
  Scenario: Test Login form with credentials by passing Username & Password
    Given User open the SauceDemo login Page
    When User enter "standard_user" and "secret_sauce"
    And I click the login button
    Then User should see title "Swag Labs"
