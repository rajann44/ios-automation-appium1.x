package uiElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductsPage extends GenericPage{

    //First Product
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"test-Item title\"])[1]")
    public MobileElement firstProduct;

    //Third Product
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"\uDB81\uDF41\"])[3]/XCUIElementTypeOther/XCUIElementTypeImage")
    public MobileElement thirdProduct;

    //Login Btn
    @iOSXCUITFindBy(accessibility = "Sauce Labs Backpack")
    public MobileElement productTitleDesc;

    //Filter Icon
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"test-Modal Selector Button\"]/XCUIElementTypeOther/XCUIElementTypeOther")
    public MobileElement filterIcon;

}
