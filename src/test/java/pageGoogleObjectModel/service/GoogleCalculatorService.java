package pageGoogleObjectModel.service;

import lombok.Getter;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageGoogleObjectModel.page.GoogleCalculatorPage;

import static org.junit.Assert.assertEquals;

@Getter
public class GoogleCalculatorService {
//    WebDriver driver;
    GoogleCalculatorPage calculatorPage;

    public GoogleCalculatorService(WebDriver driver) {
//        this.driver = driver;
        calculatorPage = new GoogleCalculatorPage(driver);
    }

    @SneakyThrows
    public GoogleCalculatorService googleCalculatorFilling(String enteredInstanceType, String enteredRegion, String enteredSsd,String enteredCommitmentTerm) {
        calculatorPage.setValueInField(calculatorPage.getNumberOfInstances(), "4");
        calculatorPage.selectByName(calculatorPage.getListSeries(), "N1");
        calculatorPage.selectByName(calculatorPage.getListMachineType(), enteredInstanceType);
        calculatorPage.clickButton(calculatorPage.getButtonAddGpus());
        calculatorPage.selectByName(calculatorPage.getListNumbersOfGroups(), "1");
        calculatorPage.selectByName(calculatorPage.getListTypesOfGpu(), "NVIDIA Tesla V100");
        calculatorPage.selectByName(calculatorPage.getListLocalsSsd(), enteredSsd);
        calculatorPage.selectByName(calculatorPage.getListDatacentersLocations(), enteredRegion);
        calculatorPage.selectByName(calculatorPage.getListCommittedUsage(), enteredCommitmentTerm);
        return this;
    }

    public void calculateEstimate() {
        calculatorPage.clickButton(calculatorPage.getButtonAddedToEstimate());
    }

    public void checkEnteredActualData(String enteredVmClass, String enteredInstanceType, String enteredRegion, String enteredSsd, String enteredCommitmentTerm){
        Assert.assertTrue(calculatorPage.actualDataFromEstimate(enteredVmClass));
        Assert.assertTrue(calculatorPage.actualDataFromEstimate(enteredInstanceType));
        Assert.assertTrue(calculatorPage.actualDataFromEstimate(enteredRegion));
        Assert.assertTrue(calculatorPage.actualDataFromEstimate(enteredSsd));
        Assert.assertTrue(calculatorPage.actualDataFromEstimate(enteredCommitmentTerm));
    }

    public void comparisonCalculatedAndRealCosts(String realCost){
        assertEquals(realCost, calculatorPage.calculatedTotalEstimatedCost());
    }

    public void emailEstimate(){
        calculatorPage.clickButton(calculatorPage.getButtonEmailEstimate());
    }

    public void sendEstimateOnEmail(GoogleCalculatorService h){
        calculatorPage.pasteEmailAddress(calculatorPage.getFieldForMailAddress(),h);
    }

}


