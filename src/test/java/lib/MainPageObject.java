package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class MainPageObject {
    protected ChromeDriver driver;

    public MainPageObject(ChromeDriver driver){
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String errorMassege, long timeoutInSecond) throws Exception {
        By by = this.getLocatorByString(locator);
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSecond);
        webDriverWait.withMessage(errorMassege + "\n");
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementClick(String locator, String errorMassege, long timeoutInSecond) throws Exception {
        WebElement webElement = waitForElementPresent(locator, errorMassege, timeoutInSecond);
        webElement.click();
        return webElement;
    }

    public WebElement waitForElementSendKeys(String locator, String value, String errorMassege, long timeoutInSecond) throws Exception {
        WebElement webElement = waitForElementPresent(locator, errorMassege, timeoutInSecond);
        webElement.sendKeys(value);
        return webElement;
    }

    private By getLocatorByString(String locatorWithType) throws Exception {
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];
        if (byType.equals("xpath")){
            return By.xpath(locator);
        }else if (byType.equals("id")){
            return By.id(locator);
        }else if (byType.equals("css")) {
            return By.cssSelector(locator);
        }else {
            throw new Exception("cannot get type of locator. Locator: " + locatorWithType);
        }
    }
}
