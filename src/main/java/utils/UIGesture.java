package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;

import java.security.InvalidParameterException;
import java.time.Duration;

public class UIGesture {

    protected static AppiumDriver driver = AppDriver.getDriver();

    /**
     * Tap on the passed co-ordinates
     * @param xCoordinate
     * @param yCoordinate
     */
    public static void performTapOnCoordinate(int xCoordinate, int yCoordinate){
        TouchAction t = new TouchAction(driver);
        t.tap(PointOption.point(xCoordinate,yCoordinate)).perform();
    }

    /**
     * Tap at the center of passed element
     * OLD NAME: performTapAtCenterOfElement
     * @param element
     */
    public static void performTapOn(MobileElement element){
        Rectangle elRect = element.getRect();
        int xCord = elRect.x + (int) (elRect.getWidth() * 0.5);
        int yCord = elRect.y + (int) (elRect.getHeight() * 0.5);
        performTapOnCoordinate(xCord,yCord);
    }

    /**
     * Perform tap on element based on passed co-ordinates
     * @param element
     * @param xCoordinate
     * @param yCoordinate
     */
    public static void performTapOnElementAt(MobileElement element, double xCoordinate, double yCoordinate) {
        Rectangle elementRect = element.getRect();
        int xCord = elementRect.x + (int) (elementRect.getWidth() * xCoordinate);
        int yCord = elementRect.y + (int) (elementRect.getHeight() * yCoordinate);
        performTapOnCoordinate(xCord,yCord);
    }

    /**
     * This method will press on element for 'X' seconds
     * @param mobileElement
     * @param timeInSecond
     */
    public static void performPressOnElement(MobileElement mobileElement, int timeInSecond){
        Rectangle elementRect = mobileElement.getRect();
        int xCord = elementRect.x + (int) (elementRect.getWidth() * 0.5);
        int yCord = elementRect.y + (int) (elementRect.getHeight() * 0.5);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(xCord,yCord))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeInSecond*1000))).release().perform();
    }

    /**
     * This method will wait until Context menu is visible
     * @param mobileElement
     * @param timeInSecond
     */
    public static void performLongPressOnElement(MobileElement mobileElement, int timeInSecond){
        Rectangle elementRect = mobileElement.getRect();
        int xCord = elementRect.x + (int) (elementRect.getWidth() * 0.5);
        int yCord = elementRect.y + (int) (elementRect.getHeight() * 0.5);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(xCord,yCord))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeInSecond*1000))).release().perform();
    }

    /**
     * This method will perform swipe from 70% button to 50%
     */
    public static void performSwipe(String direction){
        int startX, startY, endX, endY;
        Dimension dimension = driver.manage().window().getSize();
        switch(direction){
            case "UP":
                startX = (int) (dimension.width * 0.5);
                endX = startX;
                startY = (int) (dimension.height * 0.7);
                endY = (int) (dimension.height * 0.5);
                break;
            case "DOWN":
                startX = (int) (dimension.width * 0.5);
                endX = startX;
                startY = (int) (dimension.height * 0.35);
                endY = (int) (dimension.height * 0.8);
                break;
            case "LEFT":
                startX = (int) (dimension.width * 0.8);
                endX =  (int) (dimension.width * 0.2);
                startY = (int) (dimension.height * 0.5);
                endY = startY;
                break;
            case "RIGHT":
                startX = (int) (dimension.width * 0.2);
                endX = (int) (dimension.width * 0.8);
                startY = (int) (dimension.height * 0.5);
                endY = startY;
                break;
            default:
                throw new InvalidParameterException("Invalid Direction passed - Kindly check");
        }
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(endX,endY)).release().perform();
    }

    /**
     * This method will perform swipe from ElementOne -> ElementTwo
     * @param elementOne
     * @param elementTwo
     */
    public static void performSwipeFromTo(MobileElement elementOne, MobileElement elementTwo){
        Rectangle elementRect = elementOne.getRect();
        int xCordOne = elementRect.x + (int) (elementRect.getWidth() * 0.5);
        int yCordOne = elementRect.y + (int) (elementRect.getHeight() * 0.5);
        elementRect = elementTwo.getRect();
        int xCordTwo = elementRect.x + (int) (elementRect.getWidth() * 0.5);
        int yCordTwo = elementRect.y + (int) (elementRect.getHeight() * 0.5);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(xCordOne,yCordOne))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(xCordTwo,yCordTwo)).release().perform();
    }

    /**
     * This method will perform swipe Until element found
     * @param direction
     * @param element
     */
    public static void performSwipeUntilElementFound(String direction, MobileElement element, int maxSwipeRetries){
        int currentValue = 0;
        while (!(element.isDisplayed()) && currentValue++<maxSwipeRetries){
            performSwipe(direction);
        }
    }

    public static void performTapOnScreenAt(int percentOfHorizontalX, int percentOfVerticalY){
        Dimension screenDimension = driver.manage().window().getSize();
        int xCord = (int) (screenDimension.getWidth() * (double)percentOfHorizontalX/100);
        int yCord = (int) (screenDimension.getHeight() * (double)percentOfVerticalY/100);
        performTapOnCoordinate(xCord,yCord);
    }

}
