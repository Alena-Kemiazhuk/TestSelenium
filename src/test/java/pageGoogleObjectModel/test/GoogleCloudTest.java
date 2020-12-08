package pageGoogleObjectModel.test;

import lombok.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageGoogleObjectModel.page.GoogleMailPage;
import pageGoogleObjectModel.service.GoogleCalculatorService;
import pageGoogleObjectModel.service.GoogleCloudHomeService;

@Getter

public class GoogleCloudTest {
    GoogleCloudHomeService googleCloudHomePageService;
    GoogleCalculatorService googleCalculatorPageService;
    GoogleMailPage googleMailPage;
    WebDriver driver;

    @Before
    public void beforeAllTests() {
        googleCloudHomePageService = new GoogleCloudHomeService(new ChromeDriver());
        googleCloudHomePageService.getGoogleCloudHomePage().openPage();
        googleCalculatorPageService = new GoogleCalculatorService(googleCloudHomePageService.getDriver());
        googleMailPage = new GoogleMailPage(googleCloudHomePageService.getDriver());
    }

    @SneakyThrows
    @Test
    public void sendEmailTest(){
        testGoogleCloud();
        googleCalculatorPageService.emailEstimate();
        googleMailPage.copyMailAddress(googleCalculatorPageService);
        googleCalculatorPageService.sendEstimateOnEmail(googleCalculatorPageService);





    }

    @SneakyThrows
    @Test
    public void testGoogleCloud() {
        var inputTextForSearch = "Google Cloud Platform Pricing Calculator";
        String enteredVmClass = "regular";
        String enteredInstanceType = "n1-standard-8";
        String enteredRegion = "Frankfurt";
        String enteredSsd = "2x375 GB";
        String enteredCommitmentTerm = "1 Year";
        String realCost = "Total Estimated Cost: USD 1,082.77 per 1 month";
        googleCloudHomePageService.goToCalculatorPage(inputTextForSearch);
        googleCalculatorPageService.getCalculatorPage().timeOut(10, "//input[@name='quantity']");
        googleCalculatorPageService.googleCalculatorFilling(enteredInstanceType, enteredRegion, enteredSsd, enteredCommitmentTerm).calculateEstimate();
        googleCalculatorPageService.checkEnteredActualData(enteredVmClass, enteredInstanceType, enteredRegion, enteredSsd, enteredCommitmentTerm);
        googleCalculatorPageService.comparisonCalculatedAndRealCosts(realCost);
    }


//    @After
//    public void afterAllTests(){
//        driver.quit();
//    }

}