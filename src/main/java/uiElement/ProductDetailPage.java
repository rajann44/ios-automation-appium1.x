package uiElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductDetailPage extends GenericPage{

    //Add to cart
    @iOSXCUITFindBy(accessibility = "test-ADD TO CART")
    public MobileElement addToCard;

}
