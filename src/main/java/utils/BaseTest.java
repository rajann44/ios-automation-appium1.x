package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import uiElement.LoginPage;

public class BaseTest {

    protected static AppiumDriver<MobileElement> driver = null;
    LoginPage loginPage = new LoginPage();

    public BaseTest() {
        driver = AppDriver.getDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        AppDriver.activateApp();
        loginPage.loginTheUser();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        AppDriver.terminateApp();
        //Terminated the App
    }

    @AfterSuite
    public void cleanup(){
        //AppiumServerBuilder.stopAppiumServer();
    }

}
