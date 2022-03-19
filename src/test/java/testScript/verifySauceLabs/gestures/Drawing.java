package testScript.verifySauceLabs.gestures;

import helper.TestListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.SauceLabs.GenericPage;
import uiElement.SauceLabs.LoginPage;
import utils.AppDriver;
import utils.BaseTest;
import utils.UIGesture;

@Listeners(TestListeners.class)
public class Drawing extends BaseTest {

    GenericPage genericPage = new GenericPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        AppDriver.activateApp();
        loginPage.loginTheUser();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        AppDriver.terminateApp();
    }

    @Test(groups = {"Gestures","Smoke"}, description = "Make a drawing")
    public void verifyDrawingInApp(){
        genericPage.menuToggle.click();
        genericPage.sleepFor(1);
        UIGesture.performTapOnScreenAt(50,40);
        UIGesture.performSwipe("UP");
        UIGesture.performSwipe("RIGHT");
        UIGesture.performSwipe("DOWN");
        UIGesture.performSwipe("LEFT");
    }

}
