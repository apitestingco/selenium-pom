package com.sdetblueprint.base;

import com.sdetblueprint.utils.DriverManager;
import com.sdetblueprint.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import com.sdetblueprint.utils.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class TestBase extends DriverManager {

    public WebDriver driver;
    PropertyReader pr = new PropertyReader( );

    public TestBase() {

        this.driver = super.getDriver( );
        Log.info("Getting WebDriver Settings");

    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        try {

            if (PropertyReader.readItem("browser").equals("firefox")) {
                Log.info("Found firefox as Browser");
                driver = new FirefoxDriver( );
                driver.manage( ).window( ).maximize( );

            } else {
                try {
                    throw new Exception("Browser or Browser Driver is not supported yet.");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.getMessage( );
                    e.printStackTrace( );
                    Log.error("Browser Launch Failure: ", e);
                }
            }
        } catch (Exception e) {
            Log.error("Chrome Launch Failure: ", e);

        }
    }


    @AfterMethod(alwaysRun = true)
    public void teardown() {
        Log.info("Closing Webdriver Windows");
        driver.quit( );


    }


}
