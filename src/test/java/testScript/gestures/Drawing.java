package testScript.gestures;

import helper.TestListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.GenericPage;
import utils.BaseTest;
import utils.UIGesture;

@Listeners(TestListeners.class)
public class Drawing extends BaseTest {

    GenericPage genericPage = new GenericPage();

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
