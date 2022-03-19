package uiElement.UICatalog;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SearchPage extends MainPage{

    //DefaultSearch
    @iOSXCUITFindBy(accessibility = "Default")
    public MobileElement defaultSearch;

    //DefaultSearch
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSearchField")
    public MobileElement defaultSearchField;

}
