package pageGoogleObjectModel.service;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageGoogleObjectModel.page.GoogleCalculatorPage;
import pageGoogleObjectModel.page.GoogleCloudHomePage;

import java.util.List;

@Getter

public class GoogleCloudHomeService {
    WebDriver driver;
    GoogleCloudHomePage googleCloudHomePage;

    public GoogleCloudHomeService(WebDriver driver) {
        this.driver = driver;
        googleCloudHomePage = new GoogleCloudHomePage(driver);
    }

    @SneakyThrows
    public void goToCalculatorPage(String inputTextForSearch) {
        googleCloudHomePage.getButtonForSearch().click();
        googleCloudHomePage.getButtonForSearch().sendKeys(inputTextForSearch);
//        new WebDriverWait(driver, 10).equals(googleCloudHomePage.getSearchResultsOfSearch()!=null);
        googleCloudHomePage.chooseOneOption(1);

    }

}
