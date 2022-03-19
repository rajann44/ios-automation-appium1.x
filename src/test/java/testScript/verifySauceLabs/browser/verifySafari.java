package testScript.verifySauceLabs.browser;

import helper.TestListeners;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.SauceLabs.GenericPage;
import utils.BaseTest;

@Listeners(TestListeners.class)
public class verifySafari extends BaseTest {

    GenericPage genericPage = new GenericPage();

    @Test
    public void verifySafariIsLaunched(){
        driver.get("https://google.com");
        driver.findElement(By.xpath("//input[@name='q']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Appium Safari",Keys.ENTER);
        ((IOSDriver) driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "search");
        genericPage.sleepFor(3);
        driver.findElement(By.xpath("//a[@href='https://appium.io/docs/en/drivers/safari/']")).click();
        genericPage.sleepFor(5);
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@id='the-safari-driver']")).isDisplayed());
    }

}
