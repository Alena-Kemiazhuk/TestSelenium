package pageGoogleObjectModel.page;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.ArrayList;
@Getter

public class GoogleMailPage extends AbstractPage{

    @FindBy(xpath = "//*[@id='copy_address']")
    private WebElement emailAddress;

    @FindBy(xpath = "//*[@class='message_top']")
    private WebElement mailMessage;

    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    private WebElement totalEstimatedCostMail;

    public GoogleMailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    String getHomePageUrl() {
        return null;
    }

    ArrayList<String> tabs;

    public void goToMailPage(){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public void goOut(){
        driver.switchTo().window(tabs.get(0));
    }

    public void backToMailPage(){
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
    }

    public void timeOut(int timeInSeconds, String xpath){
        new WebDriverWait(driver, timeInSeconds).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }
}
