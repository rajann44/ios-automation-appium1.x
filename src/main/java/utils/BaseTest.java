package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static AppiumDriver<MobileElement> driver = null;

    public BaseTest() {
        driver = AppDriver.getDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {

    }

    @AfterSuite
    public void totalCleanup(){
        driver.closeApp();
    }

}
