package testScript.verifySauceLabs.makePurchase;

import helper.TestListeners;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.SauceLabs.*;
import utils.AppDriver;
import utils.BaseTest;
import utils.UIGesture;

@Listeners(TestListeners.class)
public class BuyItem extends BaseTest {

    ProductsPage productsPage = new ProductsPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    GenericPage genericPage = new GenericPage();
    YourCartPage yourCartPage = new YourCartPage();
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

    @Test(groups = {"Core", "Smoke"}, description = "Make purchase of an item")
    public void verifyPurchaseOfAnItem(){
        productsPage.firstProduct.click();
        UIGesture.performSwipe("UP");//Swipe until element found
        productDetailPage.addToCard.click();
        genericPage.cart.click();
        yourCartPage.checkout.click();
        yourCartPage.firstName.setValue("First_Name");
        yourCartPage.lastName.setValue("Last_Name");
        yourCartPage.zipCode.setValue("123");
        yourCartPage.continueBtn.click();
        UIGesture.performSwipeUntilElementFound("UP",yourCartPage.finishBtn,5);
        yourCartPage.finishBtn.click();
        Assert.assertTrue(yourCartPage.isElementDisplayed(yourCartPage.orderComplete));
    }

}
