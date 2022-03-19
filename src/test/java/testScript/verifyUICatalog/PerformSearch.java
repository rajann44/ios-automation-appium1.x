package testScript.verifyUICatalog;

import helper.TestListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uiElement.UICatalog.MainPage;
import uiElement.UICatalog.SearchPage;
import utils.BaseTest;

@Listeners(TestListeners.class)
public class PerformSearch extends BaseTest {

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Test(groups = {"RealSmoke"}, description = "This will perform Search")
    public void performSearch(){
        mainPage.search.click();
        searchPage.defaultSearch.click();
        searchPage.sendKeys(searchPage.defaultSearchField,"Hello Text");
        searchPage.sleepFor(5);
    }

}
