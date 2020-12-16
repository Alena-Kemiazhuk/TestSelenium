package pageGoogleObjectModel.test;
import lombok.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageGoogleObjectModel.Model.CalculatorData;
import pageGoogleObjectModel.driver.DriverSingleton;
import pageGoogleObjectModel.service.CalculatorDataCreator;
import pageGoogleObjectModel.service.GoogleCalculatorService;
import pageGoogleObjectModel.service.GoogleCloudHomeService;
import pageGoogleObjectModel.service.GoogleMailService;
import util.RegexUtils;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter

public class GoogleCloudTest {
    GoogleCloudHomeService googleCloudHomePageService;
    GoogleCalculatorService googleCalculatorPageService;
    GoogleMailService googleMailService;
    RegexUtils regexUtils;
    WebDriver driver;
//    CalculatorData calculatorData;
    String inputTextForSearch = "Google Cloud Platform Pricing Calculator";
    String realCost = "Total Estimated Cost: USD 1,082.77 per 1 month";
    String regex = "\\s\\d.+?\\d$|\\s\\d.+?\\d\\s";

    @BeforeEach
    public void beforeAllCalculatorTests() {
//        driver = new ChromeDriver();
        driver = DriverSingleton.getDriver();
        googleCloudHomePageService = new GoogleCloudHomeService(driver);
        googleCloudHomePageService.getGoogleCloudHomePage().openPage();
        googleCalculatorPageService = new GoogleCalculatorService(driver);
        googleMailService = new GoogleMailService(driver);
        regexUtils = new RegexUtils(driver);
//        calculatorData = new CalculatorData("Google Cloud Platform Pricing Calculator", "regular", "n1-standard-8", "Frankfurt", "2x375", "1 Year");
    }

    @BeforeEach
    public void beforeTest() {
        googleCloudHomePageService.
                goToCalculatorPage(inputTextForSearch);
        googleCalculatorPageService.
                getCalculatorPage().
                timeOut(10, googleCalculatorPageService.getXpathNumberOfInstances());
        googleCalculatorPageService.googleCalculatorFilling(CalculatorDataCreator.creatorCalculatorData()).
                calculateEstimate();
    }

    @SneakyThrows
    @Test
    public void sendEmailTest() {
        googleCalculatorPageService.emailEstimate();
        googleMailService.copyMailAddress();
        googleCalculatorPageService.sendEstimateOnEmail();
        String totalCostFromEmail = regexUtils.getCostForCompare(googleMailService.getTotalCostFromSentEmail(), regex);
        String totalCostFromEstimate = regexUtils.getCostForCompare(googleCalculatorPageService.getTotalCostFromEstimate(), regex);
        assertEquals(totalCostFromEstimate, totalCostFromEmail);
    }

//    @SneakyThrows
//    @Test
//    public void testGoogleCloudCalculator() {
//        googleCalculatorPageService.checkEnteredActualData(calculatorData.getEnteredVmClass(), calculatorData.getEnteredInstanceType(), calculatorData.getEnteredRegion(), calculatorData.getEnteredSsd(), calculatorData.getEnteredCommitmentTerm());
//        googleCalculatorPageService.comparisonCalculatedAndRealCosts(realCost);
//    }



//    @After
//    public void afterAllTests(){
//        driver.quit();
//    }

}