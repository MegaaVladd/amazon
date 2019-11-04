package lib;

import org.openqa.selenium.chrome.ChromeDriver;

public class SearchPageObject extends MainPageObject {
    protected static String SEARCH_FIELD = "xpath://input[@id='twotabsearchtextbox']";
    protected static String SEARCH_BUTTON = "xpath://input[@class='nav-input']";
    protected static String SORT_BY_BUTTON = "xpath://span[@aria-label='Sort by:']";
    protected static String CHOOSE_PRICE_DESC = "xpath://a[@data-value='{\"stringVal\":\"price-desc-rank\"}']";
    protected static String SECOND_ITEM = "xpath://div[@class='s-result-list s-search-results sg-row']/div[2]//div[@class='sg-row']//div[@class='sg-col-inner']";
    protected static String TITLE_ITEM = "css:#productTitle";

    public SearchPageObject(ChromeDriver driver) {
        super(driver);
    }

    public void initSearchInput(String value) throws Exception {
        this.waitForElementSendKeys(SEARCH_FIELD, value, "Cannot find search field", 5);
    }

    public void clickSearchButton() throws Exception {
        this.waitForElementClick(SEARCH_BUTTON, "Cannot find and click search button.", 5);
    }

    public void clickSortByButton() throws Exception {
        this.waitForElementClick(SORT_BY_BUTTON, "Cannot find and click 'Sort by:' button.", 5);
    }

    public void clickSortByPriceDescItem() throws Exception {
        this.waitForElementClick(CHOOSE_PRICE_DESC, "Cannot find and click 'price_desc' item", 5);
    }

    public void clickSecondItem() throws Exception {
        this.waitForElementClick(SECOND_ITEM, "Cannot find and click second item item", 5);
    }

    public String getTextTitleItem() throws Exception {
        return this.waitForElementPresent(TITLE_ITEM, "Cannot find title", 5).getText();
    }
}
