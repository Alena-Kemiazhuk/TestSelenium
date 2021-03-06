package pageGoogleObjectModel.service;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import pageGoogleObjectModel.Model.CalculatorData;
import pageGoogleObjectModel.page.GoogleCalculatorPage;


@Getter
public class GoogleCalculatorService {
    GoogleCalculatorPage calculatorPage;
    String costFromEstimateForCompare;
    private final String xpathNumberOfInstances = "//input[@name='quantity']";

    public GoogleCalculatorService(WebDriver driver) {
        calculatorPage = new GoogleCalculatorPage(driver);
    }

    @SneakyThrows

    public GoogleCalculatorService googleCalculatorFilling(CalculatorData data){
        calculatorPage.setValueInField(calculatorPage.getNumberOfInstances(), data.getNumberOfInstances());
        calculatorPage.selectByName(calculatorPage.getListSeries(), data.getSeries());
        calculatorPage.selectByName(calculatorPage.getListMachineType(), data.getInstanceType());
        calculatorPage.clickButton(calculatorPage.getButtonAddGpus());
        calculatorPage.selectByName(calculatorPage.getListNumbersOfGroups(), data.getNumbersOfGroups());
        calculatorPage.selectByName(calculatorPage.getListTypesOfGpu(), data.getTypesOfGpu());
        calculatorPage.selectByName(calculatorPage.getListLocalsSsd(), data.getLocalSsd());
        calculatorPage.selectByName(calculatorPage.getListDatacentersLocations(), data.getRegion());
        calculatorPage.selectByName(calculatorPage.getListCommittedUsage(), data.getCommittedUsage());
        return this;
    }

    public void calculateEstimate() {
        calculatorPage.clickButton(calculatorPage.getButtonAddedToEstimate());
    }

//    public void checkEnteredActualData(String enteredVmClass, String enteredInstanceType, String enteredRegion, String enteredSsd, String enteredCommitmentTerm) {
//        Assert.assertTrue(calculatorPage.actualDataFromEstimate(enteredVmClass));
//        Assert.assertTrue(calculatorPage.actualDataFromEstimate(enteredInstanceType));
//        Assert.assertTrue(calculatorPage.actualDataFromEstimate(enteredRegion));
//        Assert.assertTrue(calculatorPage.actualDataFromEstimate(enteredSsd));
//        Assert.assertTrue(calculatorPage.actualDataFromEstimate(enteredCommitmentTerm));
//    }
//
//    public void comparisonCalculatedAndRealCosts(String realCost) {
//        assertEquals(realCost, calculatorPage.calculatedTotalEstimatedCost());
//    }

    public void emailEstimate() {
        calculatorPage.clickButton(calculatorPage.getButtonEmailEstimate());
    }


    public void sendEstimateOnEmail() {
        calculatorPage.pasteEmailAddress(calculatorPage.getFieldForMailAddress());
        calculatorPage.clickButton(calculatorPage.getButtonSendEmail());
    }

    public String getTotalCostFromEstimate() {
        String costEstimate = calculatorPage.calculatedTotalEstimatedCost() + " ";
        return costEstimate;
    }


}


