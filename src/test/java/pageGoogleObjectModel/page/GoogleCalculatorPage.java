package pageGoogleObjectModel.page;

import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Getter
public class GoogleCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.class']")
    private WebElement machineClass;

    @FindBy(xpath = "//*[@class= 'md-text ng-binding']")
    private WebElement listSeries;

    @FindBy(xpath = "//*[@placeholder= 'Instance type']")
    private WebElement listMachineType;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement buttonAddGpus;

    @FindBy(xpath = "//*[@placeholder= 'Number of GPUs']")
    private WebElement listNumbersOfGroups;

    @FindBy(xpath = "//*[@placeholder= 'GPU type']")
    private WebElement listTypesOfGpu;

    @FindBy(xpath = "//*[@placeholder= 'Local SSD']")
    private WebElement listLocalsSsd;

    @FindBy(xpath = "//*[@placeholder= 'Datacenter location']")
    private WebElement listDatacentersLocations;

    @FindBy(xpath = "//*[@placeholder= 'Committed usage']")
    private WebElement listCommittedUsage;

    @FindBy(xpath = "//*[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement buttonAddedToEstimate;

    @FindBy(xpath = "//*[@class='md-select-menu-container md-active md-clickable']//md-option")
    private List<WebElement> selectOptions;

    @FindBy(xpath = "//md-list/md-list-item/div")
    private List<WebElement> actualData;

    @FindBy(xpath = "//h2/b[@class='ng-binding']")
    private WebElement actualTotalEstimatedCost;

    @FindBy(xpath = "//*[@layout-align='space-between start']/button[@aria-label = 'Email Estimate']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement fieldForMailAddress;

    @FindBy(xpath = "//*[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and @aria-label ='Send Email']")
    private WebElement buttonSendEmail;

    private final By firstIframe = By.cssSelector("[src*='/products/calculator/']");
    private final String xpathSelectOptions = "//*[@class='md-select-menu-container md-active md-clickable']//md-option";
    private final Logger logger = LogManager.getRootLogger();

    public GoogleCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    String getHomePageUrl() {
        return null;
    }

    public void openIframe() {
        driver.switchTo().frame(driver.findElement(firstIframe));
        driver.switchTo().frame("myFrame");
    }

    public void closeIframe() {
        driver.switchTo().defaultContent();
    }

    public void setValueInField(WebElement element, String numberOfInstance) {
        openIframe();
        element.sendKeys(numberOfInstance);
        closeIframe();
    }


    public void clickButton(WebElement element) {
        openIframe();
        timeOut(10, "//input[@name='quantity");
        element.click();
        closeIframe();
    }

    public void selectByName(WebElement element, String name) {
        openIframe();
        element.click();
        closeIframe();
        timeOut(10, xpathSelectOptions);
        openIframe();
        getSelectOptions().stream().filter(item -> item.getText().contains(name)).findFirst().get().click();
        closeIframe();
    }

//    public boolean actualDataFromEstimate(String data) {
//        openIframe();
//        var result = actualData.stream().anyMatch(item -> item.getText().contains(data));
//            closeIframe();
//            return result;
//    }

    public String calculatedTotalEstimatedCost() {
        openIframe();
        String actualTotalEstimatedCost = getActualTotalEstimatedCost().getText();
        closeIframe();
        logger.info("Actual Total Estimated Cost = " + actualTotalEstimatedCost);
        return actualTotalEstimatedCost;
    }

    public void timeOut(int timeInSeconds, String xpath){
        openIframe();
        new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
        closeIframe();
    }

    @SneakyThrows
    public void pasteEmailAddress(WebElement fieldForAddress){
        openIframe();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", fieldForAddress);
        fieldForAddress.sendKeys(Keys.PAGE_UP);
        Actions builder = new Actions(driver);
        builder.keyDown( Keys.CONTROL).perform();
        builder.sendKeys("v").perform();
        builder.keyUp(Keys.CONTROL).perform();
        closeIframe();
    }

}




