package pageGoogleObjectModel.page;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter

public class GoogleCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='quantity']")
    private WebElement NumberOfInstances;

    @FindBy(xpath = "//*[@class= 'md-text ng-binding']")
    private WebElement listSeries;

    @FindBy(xpath = "//*[@class= 'ng-scope md-ink-ripple' and @value='n1']")
    private WebElement series;

    @FindBy(xpath = "//*[@placeholder= 'Instance type']")
    private WebElement listMachineType;

    @FindBy(xpath = "//*[@class='ng-scope md-ink-ripple' and @value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement machineType;

    @FindBy(xpath = "//md-checkbox[@ng-model = 'listingCtrl.computeServer.addGPUs']")
    private WebElement buttonForAddGPUs;

    @FindBy(xpath = "//*[@placeholder= 'Number of GPUs']")
    private WebElement listNumbersOfGroups;

    @FindBy(xpath = "//*//*[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='1']")
    private WebElement numberOfGroups;

    @FindBy(xpath = "//*[@placeholder= 'GPU type']")
    private WebElement listTypesOfGpu;

    @FindBy(xpath = "//*[@class= 'ng-scope md-ink-ripple' and @value='NVIDIA_TESLA_V100']")
    private WebElement gpuType;

    @FindBy(xpath = "//*[@placeholder= 'Local SSD']")
    private WebElement listLocalsSsd;

    @FindBy(xpath = "//*[@class= 'ng-scope md-ink-ripple' and @value='2' and @ng-repeat='item in listingCtrl.supportedSsd']")
    private WebElement localSsd;

    private By firstIframe = By.cssSelector("[src*='/products/calculator/']");

    public GoogleCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    String getHomePageUrl() {
        return null;
    }

    public void openIframe(){
        driver.switchTo().frame(driver.findElement(firstIframe));
        driver.switchTo().frame("myFrame");
    }

    public void setValueInFieldNumberOfInstances(String numberOfInstance){
        openIframe();
        NumberOfInstances.sendKeys(numberOfInstance);
        driver.switchTo().defaultContent();
    }

    @SneakyThrows
    public void chooseValueInField(WebElement listOfElements, WebElement element){
        openIframe();
        listOfElements.click();
        Thread.sleep(2000);
        element.click();
        driver.switchTo().defaultContent();
    }

    public void clickButton(WebElement element){
        openIframe();
        element.click();
        driver.switchTo().defaultContent();
    }



}
