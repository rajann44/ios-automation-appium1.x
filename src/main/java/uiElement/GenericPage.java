package uiElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class GenericPage extends BasePage{

    //Menu Toggle
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Menu\"]/XCUIElementTypeOther")
    public MobileElement menuToggle;

    //Cart Icon
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Cart\"]")
    public MobileElement cart;

}
