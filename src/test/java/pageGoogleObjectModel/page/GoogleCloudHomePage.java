package pageGoogleObjectModel.page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagePastebinObjectModel.page.SearchCalculatorPage;

import java.util.List;

@Getter
public class GoogleCloudHomePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='devsite-search-field devsite-search-query']")
    private WebElement buttonForSearch;

    @FindBy(css = "[id*='suggestion-product']")
    private List<WebElement> searchResultsOfSearch;

    private final static String HOMEPAGE_URL = "https://cloud.google.com/";

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
    }

    @Override
    String getHomePageUrl() {
        return HOMEPAGE_URL;
    }

    public void chooseOneOption(int number) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("[id*='suggestion-product']"))).get(number - 1);
        searchResultsOfSearch.get(number - 1).click();
    }

}
