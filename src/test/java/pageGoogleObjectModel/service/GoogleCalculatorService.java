package pageGoogleObjectModel.service;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageGoogleObjectModel.page.GoogleCalculatorPage;

@Getter
public class GoogleCalculatorService {
    WebDriver driver;
    GoogleCalculatorPage calculatorPage;

    public GoogleCalculatorService(WebDriver driver){
        this.driver = driver;
        calculatorPage = new GoogleCalculatorPage(driver);
    }

    private By first = By.cssSelector("[src*='/products/calculator/']");
    @SneakyThrows
    public void googleCalculatorFilling(){
        calculatorPage.setValueInFieldNumberOfInstances("4");
        calculatorPage.chooseValueInField(calculatorPage.getListSeries(), calculatorPage.getSeries());
        Thread.sleep(2000);
        calculatorPage.chooseValueInField(calculatorPage.getListMachineType(), calculatorPage.getMachineType());
        Thread.sleep(2000);
        calculatorPage.clickButton(calculatorPage.getButtonForAddGPUs());
        Thread.sleep(2000);
        calculatorPage.chooseValueInField(calculatorPage.getListNumbersOfGroups(), calculatorPage.getNumberOfGroups());
        Thread.sleep(2000);
        calculatorPage.chooseValueInField(calculatorPage.getListTypesOfGpu(), calculatorPage.getGpuType());
        Thread.sleep(2000);
        calculatorPage.chooseValueInField(calculatorPage.getListLocalsSsd(), calculatorPage.getListLocalsSsd());

    }
}


