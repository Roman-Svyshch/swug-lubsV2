package com.epam.finaltask.swuglubsv3.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private final Logger log = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(xpath = "//input[@name='user-name']")
    WebElement usernameElement;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordElement;

    @FindBy(xpath = "//input[@type='submit' and @class='submit-button btn_action']")
    WebElement buttonElement;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        if (username != null) {
            usernameElement.sendKeys(username);
        }
    }

    public void enterPassword(String password) {
        if (password != null) {
            passwordElement.sendKeys(password);
        }
    }

    public void clickLoginButton() {
        if (buttonElement.isDisplayed()) {
            buttonElement.click();
        }
    }

    public String getErrorUsernameTextMessage() {

            return errorMessage.getText();

    }
    public void clearAllFields(){
        try {
            usernameElement.click();
            usernameElement.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE);
            log.info("Username field was successfully deleted");
            passwordElement.click();
            passwordElement.sendKeys(Keys.chord(Keys.CONTROL,"a"),Keys.DELETE);
            log.info("Password field was successfully deleted");
        }catch (Exception e){
            log.error("Error while clearing username or password field :{}",e.getMessage());
            throw  e;
        }
    }

    public void clearPasswordField(){
        passwordElement.click();
        passwordElement.sendKeys(Keys.chord(Keys.CONTROL,"a"), Keys.DELETE);
    }
}
