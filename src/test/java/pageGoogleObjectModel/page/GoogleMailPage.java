package pageGoogleObjectModel.page;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageGoogleObjectModel.service.GoogleCalculatorService;

import java.util.ArrayList;
@Getter

public class GoogleMailPage extends AbstractPage{

    @FindBy(xpath = "//*[@id='copy_address']")
    private WebElement emailAddress;

    ArrayList<String> tabs;

    public GoogleMailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    String getHomePageUrl() {
        return null;
    }

    @SneakyThrows
    public void copyMailAddress (GoogleCalculatorService googleCalculatorService){
        ((JavascriptExecutor)googleCalculatorService.getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(googleCalculatorService.getDriver().getWindowHandles());
        googleCalculatorService.getDriver().switchTo().window(tabs.get(1));
        googleCalculatorService.getDriver().get("https://10minutemail.com");
        emailAddress.click();
        googleCalculatorService.getDriver().switchTo().window(tabs.get(0));
    }

}
