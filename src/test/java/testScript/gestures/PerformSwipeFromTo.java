package testScript.gestures;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.ProductsPage;
import utils.BaseTest;
import utils.UIGesture;
import helper.TestListeners;

@Listeners(TestListeners.class)
public class PerformSwipeFromTo extends BaseTest {

    ProductsPage productsPage = new ProductsPage();

    @Test(groups = "Gestures", description = "This will perform swipe from a element")
    public void performSwipeFromTo(){
        UIGesture.performSwipeFromTo(productsPage.thirdProduct,productsPage.firstProduct);
    }

}
