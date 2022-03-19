package testScript.verifySauceLabs.gestures;

import helper.TestListeners;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.SauceLabs.GenericPage;
import uiElement.SauceLabs.LoginPage;
import uiElement.SauceLabs.WebviewSelectionPage;
import utils.AppDriver;
import utils.BaseTest;
import utils.UIGesture;

@Listeners(TestListeners.class)
public class webView extends BaseTest {

    GenericPage genericPage = new GenericPage();
    WebviewSelectionPage wsPage = new WebviewSelectionPage();
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

    @Test(groups = {"Gestures", "Smoke"}, description = "Inbuilt Web View Testing")
    public void inbuiltWebViewVerification(){
        genericPage.menuToggle.click();
        genericPage.sleepFor(1);
        UIGesture.performTapOnScreenAt(50,20);
        genericPage.clickAndSendValue(wsPage.address,"https://www.google.com");
        wsPage.gotoSite.click();
        genericPage.clickAndSendValue(wsPage.search,"Thought of the Day");
        Assert.assertTrue(genericPage.isElementDisplayed(wsPage.allTab));
    }

}
