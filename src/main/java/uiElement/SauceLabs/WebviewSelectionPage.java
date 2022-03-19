package uiElement.SauceLabs;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WebviewSelectionPage extends GenericPage{

    //Address Bar
    @iOSXCUITFindBy(accessibility = "test-enter a https url here...")
    public MobileElement address;

    //Goto Site
    @iOSXCUITFindBy(accessibility = "test-GO TO SITE")
    public MobileElement gotoSite;

    //Search Button
    @iOSXCUITFindBy(accessibility = "Search")
    public MobileElement search;

    //All Tab
    @iOSXCUITFindBy(accessibility = "All")
    public MobileElement allTab;

}
