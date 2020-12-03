package pageGoogleObjectModel.service;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageGoogleObjectModel.page.GoogleCalculatorPage;
import pageGoogleObjectModel.page.GoogleCloudHomePage;
@Getter

public class GoogleCloudHomeService {
    WebDriver driver;
    GoogleCloudHomePage googleCloudHomePage;

    public GoogleCloudHomeService(WebDriver driver){
        this.driver = driver;
        googleCloudHomePage = new GoogleCloudHomePage(driver);
    }

    @SneakyThrows
    public void goToCalculatorPage(String inputTextForSearch){
        googleCloudHomePage.getButtonForSearch().click();
        googleCloudHomePage.getButtonForSearch().sendKeys(inputTextForSearch);
        Thread.sleep(5000);
        googleCloudHomePage.chooseOneOption(1);

    }

}
