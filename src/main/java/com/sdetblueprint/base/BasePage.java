package com.sdetblueprint.base;

import com.sdetblueprint.utils.WaitForHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BasePage{

    protected WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
    }
    //open url method
    public void gotoURL(String url) {
        driver.get(url);
    }

    //wait method
    public void waitForElementToAppear(By elementLocation) {
        //Conditional wait for one of the elements on the search results page to be present
        new WaitForHelper(driver).presenceOfTheElement(elementLocation);
    }

    public void waitForTime() {
        //Conditional wait for one of the elements on the search results page to be present
        new WaitForHelper(driver).implicitwait( );
    }

    //Click Method
    public void click(By elementLocation) {
        driver.findElement(elementLocation).click( );
    }

    //Write Text
    public void writeText(By elementLocation, String text) {
        driver.findElement(elementLocation).clear( );
        driver.findElement(elementLocation).sendKeys(text);
    }


    //Read Text
    public String readText(By elementLocation) {
        return driver.findElement(elementLocation).getText( );
    }

    // Move to Element
    public void moveToElement(By elementLocation) {

        new Actions(driver).moveToElement(driver.findElement(elementLocation)).build( ).perform( );

    }
}
