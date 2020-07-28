package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject
{
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name,'{TITLE}')]";
        MY_SAVED_LIST = "xpath://XCUIElementTypeStaticText[contains(@name,'{TITLE}')]";
        CLOSE_SYNC_SAVED_ARTICLE = "xpath://XCUIElementTypeButton[@name='Close']";
    }

    public IOSMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
