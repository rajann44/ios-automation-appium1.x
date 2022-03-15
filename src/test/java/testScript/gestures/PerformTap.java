package testScript.gestures;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.ProductsPage;
import utils.BaseTest;
import utils.UIGesture;
import helper.TestListeners;

@Listeners(TestListeners.class)
public class PerformTap extends BaseTest {

    ProductsPage productsPage = new ProductsPage();

    @Test(groups = "Gestures", description = "This method will perform Tap")
    public void performTap(){
        UIGesture.performTapOn(productsPage.filterIcon);
    }

}
