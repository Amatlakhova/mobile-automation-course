import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;
import org.openqa.selenium.By;


public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testVerifyElementHasText()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        MainPageObject.assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search…",
                "Search field doesn't match 'Search…' text"
        );
    }

    @Test
    public void testSearchArticles()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Cyprus",
                "Cannot find 'Cyprus' input",
                5
        );
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Articles are not founded",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Cannot find X to cancel search",
                5
        );
        MainPageObject.waitForElementNotPresent(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Articles are still present on the page",
                5
        );
    }

    @Test
    public void testCheckWordsInSearch()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find 'Java' input",
                5
        );
        MainPageObject.assertElementsContainText(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Java",
                "Not all articles contain 'Java'"
        );

    }

    @Test
    public void testDeleteArticleFromMyList()
    {
        // First Article

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5
        );
        MainPageObject.waitForElementsToRender(
                By.xpath("//android.widget.TextView"),
                "Cannot render menu within given time",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option to add article to reading list",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find 'Got it' tip overlay",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "Learning programming",
                "Cannot put text into articles folder input",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press OK button",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find x link",
                5
        );

        // Second Article

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Set of several computer software products and specifications']"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title",
                15
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageView[@content-desc='More options']"),
                "Cannot find button to open article options",
                5
        );
        MainPageObject.waitForElementsToRender(
                By.xpath("//android.widget.TextView"),
                "Cannot render menu within given time",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Add to reading list']"),
                "Cannot find option to add article to reading list",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.TextView[@resource-id='org.wikipedia:id/item_title']"),
                "Cannot find 'Learning Programming' reading list",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find x link",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find navigation button to My List",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Learning programming']"),
                "Cannot find created folder",
                5
        );
        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Java (software platform)']"),
                "Cannot delete saved article",
                5
        );
    }

    @Test
    public void testArticleTitlePresent()
    {
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find 'Search Wikipedia' input",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "Cannot find search input",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' input",
                5
        );
        MainPageObject.assertElementPresent(
                By.id("org.wikipedia:id/view_page_title_text"),
                "Cannot find article title"
        );
    }

}
