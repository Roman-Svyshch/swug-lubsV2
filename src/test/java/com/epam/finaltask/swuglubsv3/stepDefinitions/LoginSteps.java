package com.epam.finaltask.swuglubsv3.stepDefinitions;

import com.epam.finaltask.swuglubsv3.pageObjects.HomePage;
import com.epam.finaltask.swuglubsv3.pageObjects.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        System.out.println("Driver Initialized!");
    }

    @Given("User open the SauceDemo login Page")
    public void userOpenTheSauceDemoLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enter {string} and {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("User clear all fields")
    public void userClearAllFields() {
        loginPage.clearAllFields();
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String message) {
        Assertions.assertEquals(message, loginPage.getErrorUsernameTextMessage());
    }

    @And("User clear password field")
    public void userClearPasswordField() {
        loginPage.clearPasswordField();
    }

    @Then("User should see title {string}")
    public void userShouldSeeTitle(String title) {
        homePage.checkTitle(title);
    }
}
