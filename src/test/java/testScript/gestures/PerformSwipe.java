package testScript.gestures;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.GenericPage;
import uiElement.ProductsPage;
import utils.AppDriver;
import utils.BaseTest;
import utils.UIGesture;
import helper.TestListeners;

@Listeners(TestListeners.class)
public class PerformSwipe extends BaseTest {

    GenericPage genericPage = new GenericPage();
    ProductsPage productsPage = new ProductsPage();

    @Test(groups = {"Gestures", "Smoke"}, description = "This will perform swipe")
    public void performSwipe(){
        productsPage.firstProduct.click();
        Assert.assertTrue(genericPage.isElementDisplayed(productsPage.productTitleDesc));
        UIGesture.performSwipe("UP");
        UIGesture.performSwipe("DOWN");
        UIGesture.performSwipe("UP");
        UIGesture.performSwipe("DOWN");
    }

}
