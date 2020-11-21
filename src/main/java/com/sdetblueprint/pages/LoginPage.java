package com.sdetblueprint.pages;

import com.sdetblueprint.base.BasePage;
import com.sdetblueprint.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver );
        this.driver = driver;
    }
    // Page Locators

    By username = By.id("login-username" );
    By password = By.id("login-password" );
    By signButton = By.id("js-login-btn" );

    // Page Actions

    public void openVwo(){
        driver.get("https://app.vwo.com");
    }

    public void LoginWithValidCreds(){
        driver.findElement(username).sendKeys(PropertyReader.readItem("username"));
        driver.findElement(password).sendKeys(PropertyReader.readItem("password"));
        driver.findElement(signButton).click();
    }

    public DashboardPage afterLogin(){
        return new DashboardPage(driver);
    }

}
