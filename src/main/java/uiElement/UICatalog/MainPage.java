package uiElement.UICatalog;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import uiElement.BasePage;

public class MainPage extends BasePage {

    //Search Button
    @iOSXCUITFindBy(accessibility = "Search")
    public MobileElement search;

}
