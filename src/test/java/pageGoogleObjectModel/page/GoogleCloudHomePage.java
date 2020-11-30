package pageGoogleObjectModel.page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pagePastebinObjectModel.page.SearchCalculatorPage;

import java.util.List;

@Getter
public class GoogleCloudHomePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='devsite-search-field devsite-search-query']")
    private WebElement searchButtonSearch;

    private String textForAdd;
    @FindBy(css = "[id*='suggestion-partial-query']")
    private List<WebElement> searchResults;

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
    }

    public void chooseNthOption(int number) {
        getSearchResults().get(number + 1).click();
    }

    public void clickSearchButtonSearch() {
        searchButtonSearch.click();
    }

    public void addTextInButtonSearch(String textForAdd) {
        searchButtonSearch.sendKeys(textForAdd);
    }

    public SearchCalculatorPage clickButtonSearch(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
        return new SearchCalculatorPage(driver);
    }
}
