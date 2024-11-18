package com.epam.finaltask.swuglubsv3.stepDefinitions;

import com.epam.finaltask.swuglubsv3.pageObjects.HomePage;
import com.epam.finaltask.swuglubsv3.pageObjects.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@Execution(ExecutionMode.CONCURRENT)

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;


    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();

        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        System.out.println("Driver Initialized for browser: " + browser);
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
