package com.epam.finaltask.swuglubsv3.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement titleElement;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean checkTitle(String title){
        if (titleElement.getText().equals(title))
        {
            return true;
        }
        return false;
    }
}
