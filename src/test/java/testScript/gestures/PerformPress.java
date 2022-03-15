package testScript.gestures;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.ProductsPage;
import utils.BaseTest;
import utils.UIGesture;
import helper.TestListeners;

@Listeners(TestListeners.class)
public class PerformPress extends BaseTest {

    ProductsPage productsPage = new ProductsPage();

    @Test(groups = "Gestures", description = "This method will perform Press on element")
    public void performPress(){
        UIGesture.performPressOnElement(productsPage.filterIcon,5);
    }

}
