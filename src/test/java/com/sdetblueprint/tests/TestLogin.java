package com.sdetblueprint.tests;

import com.sdetblueprint.base.BasePage;
import com.sdetblueprint.base.TestBase;
import com.sdetblueprint.pages.DashboardPage;
import com.sdetblueprint.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {


    @Step
    @Description("Login to the VWO App")
    @Test
    public void loginVWO() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openVwo( );
        loginPage.LoginWithValidCreds( );
    }

    @Step
    @Description("Login to the VWO App and Verify Dashboard")
    @Test
    public void loginAndVerifyDashboard() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openVwo( );
        loginPage.LoginWithValidCreds( );
        DashboardPage dashboardPage = loginPage.afterLogin( );
        Assert.assertEquals(dashboardPage.loggedInUserName( ), "Wingify");

    }
}
