package testScript.verifySauceLabs.gestures;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.SauceLabs.LoginPage;
import uiElement.SauceLabs.ProductsPage;
import utils.AppDriver;
import utils.BaseTest;
import utils.UIGesture;
import helper.TestListeners;

@Listeners(TestListeners.class)
public class PerformPress extends BaseTest {

    ProductsPage productsPage = new ProductsPage();

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

    @Test(groups = "Gestures", description = "This method will perform Press on element")
    public void performPress(){
        UIGesture.performPressOnElement(productsPage.filterIcon,5);
    }

}
