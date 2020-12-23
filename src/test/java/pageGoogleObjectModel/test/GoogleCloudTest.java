package pageGoogleObjectModel.test;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageGoogleObjectModel.driver.DriverSingleton;
import pageGoogleObjectModel.service.CalculatorDataCreator;
import pageGoogleObjectModel.service.GoogleCalculatorService;
import pageGoogleObjectModel.service.GoogleCloudHomeService;
import pageGoogleObjectModel.service.GoogleMailService;
import pageGoogleObjectModel.util.RegexUtils;
import pageGoogleObjectModel.util.TestListener;

import static org.testng.AssertJUnit.assertEquals;

@Listeners({TestListener.class})
@Getter
public class GoogleCloudTest {
    GoogleCloudHomeService googleCloudHomePageService;
    GoogleCalculatorService googleCalculatorPageService;
    GoogleMailService googleMailService;
    WebDriver driver;
    RegexUtils regexUtils;
    String inputTextForSearch = "Google Cloud Platform Pricing Calculator";
    //    String realCost = "Total Estimated Cost: USD 1,082.77 per 1 month";
    String regex = "\\s\\d.+?\\d$|\\s\\d.+?\\d\\s";

    @BeforeClass
    public void beforeAllCalculatorTests() {
        driver = DriverSingleton.getDriver();
    }

    @SneakyThrows
    @Test
    public void sendEmailTest() {
        googleCloudHomePageService = new GoogleCloudHomeService(driver);
        googleCloudHomePageService.getGoogleCloudHomePage().openPage();
        googleCalculatorPageService = new GoogleCalculatorService(driver);
        googleMailService = new GoogleMailService(driver);
        regexUtils = new RegexUtils(driver);
        googleCloudHomePageService.goToCalculatorPage(inputTextForSearch);
        googleCalculatorPageService.getCalculatorPage().
                timeOut(30, googleCalculatorPageService.getXpathNumberOfInstances());
        googleCalculatorPageService.googleCalculatorFilling(CalculatorDataCreator.creatorCalculatorData())
                .calculateEstimate();
        googleCalculatorPageService.emailEstimate();
        googleMailService.copyMailAddress();
        googleCalculatorPageService.sendEstimateOnEmail();
        String totalCostFromEmail = regexUtils
                .getCostForCompare(googleMailService.getTotalCostFromSentEmail(), regex);
        String totalCostFromEstimate = regexUtils
                .getCostForCompare(googleCalculatorPageService.getTotalCostFromEstimate(), regex);
        assertEquals(totalCostFromEstimate, totalCostFromEmail);
    }


    @AfterClass
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }


//    @SneakyThrows
//    @Test
//    public void testGoogleCloudCalculator() {
//    googleCloudHomePageService = new GoogleCloudHomeService(driver);
//        googleCloudHomePageService.getGoogleCloudHomePage().openPage();
//    googleCalculatorPageService = new GoogleCalculatorService(driver);
//    googleMailService = new GoogleMailService(driver);
//    regexUtils = new RegexUtils(driver);
//        googleCloudHomePageService.goToCalculatorPage(inputTextForSearch);
//        googleCalculatorPageService.getCalculatorPage().timeOut(10, googleCalculatorPageService.getXpathNumberOfInstances());
//        googleCalculatorPageService.googleCalculatorFilling(CalculatorDataCreator.creatorCalculatorData()).calculateEstimate();
//        googleCalculatorPageService.checkEnteredActualData(calculatorData.getEnteredVmClass(), calculatorData.getEnteredInstanceType(), calculatorData.getEnteredRegion(), calculatorData.getEnteredSsd(), calculatorData.getEnteredCommitmentTerm());
//        googleCalculatorPageService.comparisonCalculatedAndRealCosts(realCost);
//    }


}
