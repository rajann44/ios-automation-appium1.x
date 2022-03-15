package uiElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class YourCartPage extends GenericPage{

    //Checkout Button
    @iOSXCUITFindBy(accessibility = "test-CHECKOUT")
    public MobileElement checkout;

    //First Name
    @iOSXCUITFindBy(accessibility = "test-First Name")
    public MobileElement firstName;

    //Last Name
    @iOSXCUITFindBy(accessibility = "test-Last Name")
    public MobileElement lastName;

    //Zip Code
    @iOSXCUITFindBy(accessibility = "test-Zip/Postal Code")
    public MobileElement zipCode;

    //Continue Button
    @iOSXCUITFindBy(accessibility = "test-CONTINUE")
    public MobileElement continueBtn;

    //Finish Button
    @iOSXCUITFindBy(accessibility = "test-FINISH")
    public MobileElement finishBtn;

    //Order Complete Message
    @iOSXCUITFindBy(accessibility = "THANK YOU FOR YOU ORDER")
    public MobileElement orderComplete;


}
