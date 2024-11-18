package com.epam.finaltask.swuglubsv3.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginPage {

    private final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private final  WebDriverWait wait;

    @FindBy(xpath = "//input[@name='user-name']")
    WebElement usernameElement;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordElement;

    @FindBy(xpath = "//input[@type='submit' and @class='submit-button btn_action']")
    WebElement buttonElement;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        log.info("Waiting for visibility of the username field");
        wait.until(ExpectedConditions.visibilityOf(usernameElement));
        log.info("Username element is visible");
        if (username != null) {
            log.info("Entering username (hidden for security reasons).");
            usernameElement.sendKeys(username);
            log.info("Username was successfully entered.");
        } else {
            log.warn("Username is null, skipping input.");
        }
    }

    public void enterPassword(String password) {
        try {
            log.info("Waiting for visibility of the password field");
            wait.until(ExpectedConditions.visibilityOf(passwordElement));
            log.info("Password element is visible");
            if (password != null) {
                // Логуємо лише факт введення пароля, але не сам пароль
                log.info("Entering password (hidden for security reasons).");
                passwordElement.sendKeys(password);
                log.info("Password was successfully entered.");
            } else {
                log.warn("Password is null, skipping input.");
            }
        } catch (TimeoutException e) {
            log.error("Timeout: Password field not visible within the expected time.", e);
        } catch (Exception e) {
            log.error("An error occurred while entering the password.", e);
        }
    }

    public void clickLoginButton() {
        try {
            log.info("Waiting for expected condition: button to be clickable");
            wait.until(ExpectedConditions.elementToBeClickable(buttonElement));
            log.info("Button element is clickable");
            buttonElement.click();
            log.info("Login button was successfully clicked.");
        } catch (TimeoutException e) {
            log.error("Timeout: Login button not clickable within the expected time.", e);
        } catch (Exception e) {
            log.error("An error occurred with the login button.", e);
        }
    }

    public String getErrorUsernameTextMessage() {
        try {
            log.info("Waiting for expected condition: visibility of error message");
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            log.info("Error message is visible");
        } catch (TimeoutException e) {
            log.error("Timeout: Error message not visible within the expected time.", e);
        } catch (Exception e) {
            log.error("An error occurred while retrieving the error message.", e);
        }
        return errorMessage.getText();
    }

    public void clearAllFields() {
        try {
            log.info("Waiting for visibility of the username field to clear");
            wait.until(ExpectedConditions.visibilityOf(usernameElement));
            usernameElement.click();
            usernameElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            log.info("Username field was successfully cleared");

            passwordElement.click();
            passwordElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            log.info("Password field was successfully cleared");
        } catch (Exception e) {
            log.error("Error while clearing username or password field: {}", e.getMessage());
            throw e;
        }
    }

    public void clearPasswordField() {
        try {
            log.info("Waiting for visibility of the password field to clear");
            wait.until(ExpectedConditions.visibilityOf(passwordElement));
            log.info("Clicking on the password element");
            passwordElement.click();
            log.info("Clearing the password field");
            passwordElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
            log.info("Password field was successfully cleared");
        } catch (Exception e) {
            log.error("An error occurred while clearing the password field.", e);
        }
    }

}

