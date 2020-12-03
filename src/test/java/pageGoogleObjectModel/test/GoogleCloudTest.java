package pageGoogleObjectModel.test;

import lombok.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageGoogleObjectModel.service.GoogleCalculatorService;
import pageGoogleObjectModel.service.GoogleCloudHomeService;

public class GoogleCloudTest {
    GoogleCloudHomeService googleCloudHomePageService;
    GoogleCalculatorService googleCalculatorPageService;

    @Before
    public void beforeAllTests() {
        googleCloudHomePageService = new GoogleCloudHomeService(new ChromeDriver());
        googleCloudHomePageService.getGoogleCloudHomePage().openPage();
        googleCalculatorPageService = new GoogleCalculatorService(googleCloudHomePageService.getDriver());
    }


    @SneakyThrows
    @Test
    public void testGoogleCloud() {
        var inputTextForSearch = "Google Cloud Platform Pricing Calculator";
        googleCloudHomePageService.goToCalculatorPage(inputTextForSearch);
        Thread.sleep(7000);
        googleCalculatorPageService.googleCalculatorFilling();


    }

}
