package uiElement;

import config.ConfigKey;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AppDriver;

import java.util.Set;

public class BasePage {

    protected AppiumDriver driver = AppDriver.getDriver();

    public BasePage () {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Change driver context
     */
    public void changeDriverContext() {
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP or WEBVIEW_1
        }
        //driver.context(contextNames.toArray()[0].toString()); // set context to WEBVIEW_1/WEBVIEW_1..
    }


    /**
     * Wait for 'x' seconds
     */
    public void sleepFor(int numberOfSeconds) {
        int time = numberOfSeconds * 1000;
        try{
            Thread.sleep(time);
        }catch (Exception exception){
            System.out.println("Not able to sleep");
            driver.manage().getCookies();

        }
    }

    /**
     * Press Android back button
     */
    public void backButton() {
        driver.navigate().back();
    }

    /**
     * Checks if element is displayed
     */
    public boolean isElementDisplayed(MobileElement e) {
        try{
            return e.isDisplayed();
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

    /**
     * Click the element and sendKeys
     */
    public void clickAndSendValue(MobileElement e, String value) {
        waitForVisibility(e);
        e.click();
        e.sendKeys(value, Keys.ENTER);//This also hides the keyboard
        //((IOSDriver) driver).hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
    }

    /**
     * Wait Until element is visible
     */
    public void waitForInvisibility(MobileElement e) {
        ExpectedConditions.invisibilityOf(e);
    }

    /**
     * Hides the keyboard if showing
     */
    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    /**
     * Get Screen Size / Resolution of device
     */
    public Dimension getScreenSize(){
        return driver.manage().window().getSize();
    }

    /**
     * Wait Until element is visible
     */
    public void waitForVisibility(MobileElement e) {
        new WebDriverWait(driver, Long.parseLong(ConfigKey.EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(By e) {
        new WebDriverWait(driver, Long.parseLong(ConfigKey.EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    /**
     * Clears the inputbox
     */
    public void clear(MobileElement e) {
        waitForVisibility(e);
        e.clear();
    }

    /**
     * Click the element
     */
    public void click(MobileElement e) {
        waitForVisibility(e);
        e.click();
    }

    public void click(By e) {
        waitForVisibility(e);
        driver.findElement(e).click();
    }

    /**
     * Enters value in the input box / element
     */
    public void sendKeys(MobileElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }

    /**
     * Gets the attribute value of a element
     */
    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }

    public String getAttribute(By e, String attribute) {
        waitForVisibility(e);
        return driver.findElement(e).getAttribute(attribute);
    }

    /**
     * Gets the inner text value of element
     */
    public String getText(MobileElement mobileElement) {
        waitForVisibility(mobileElement);
        return getAttribute(mobileElement, "label");
    }

    public String getText(By e) {
        return getAttribute(e, "label");
    }

}
