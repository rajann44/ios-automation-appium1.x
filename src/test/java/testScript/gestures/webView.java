package testScript.gestures;

import helper.TestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.GenericPage;
import uiElement.WebviewSelectionPage;
import utils.BaseTest;
import utils.UIGesture;

@Listeners(TestListeners.class)
public class webView extends BaseTest {

    GenericPage genericPage = new GenericPage();
    WebviewSelectionPage wsPage = new WebviewSelectionPage();

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
