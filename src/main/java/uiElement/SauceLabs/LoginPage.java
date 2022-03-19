package uiElement.SauceLabs;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends GenericPage{

    //Std User
    @iOSXCUITFindBy(accessibility = "test-standard_user")
    public MobileElement standardUser;

    //Login Btn
    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    public MobileElement loginBtn;

    public void loginTheUser(){
        standardUser.click();
        loginBtn.click();
    }

}
