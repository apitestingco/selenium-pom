package com.sdetblueprint.pages;

import com.sdetblueprint.base.BasePage;
import com.sdetblueprint.utils.DataUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage{

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        super(driver );
        this.driver = driver;
    }

    By userName  = By.cssSelector("[data-qa='lufexuloga']");

    // Page Action
    public String loggedInUserName(){
        waitForElementToAppear(userName);
        return driver.findElement(userName).getText();
    }
}
