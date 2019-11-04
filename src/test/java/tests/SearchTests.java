package tests;

import lib.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTests {
    private ChromeDriver driver = new ChromeDriver();

    @Test
    public void runSearch() throws Exception {
        driver.navigate().to("https://www.amazon.com/");
        SearchPageObject searchPageObject = new SearchPageObject(driver);
        searchPageObject.initSearchInput("Nikon");
        searchPageObject.clickSearchButton();
        searchPageObject.clickSortByButton();
        searchPageObject.clickSortByPriceDescItem();
        searchPageObject.clickSecondItem();
        Assert.assertTrue(searchPageObject.getTextTitleItem().contains("Nikon D3X"));
        driver.close();
    }
}
