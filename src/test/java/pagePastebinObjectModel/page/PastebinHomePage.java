package pagePastebinObjectModel.page;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Getter
public class PastebinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement searchInputText;

    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']")
    private WebElement searchList;

    @FindBy(xpath = "//*[@id='select2-postform-format-container']")
    private WebElement searchListSyntax;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationSelect;

    @FindBy(css = "[id = 'postform-format']+span")
    private WebElement postformSelect;


    @FindBy(xpath = "//*[@id='postform-name']")
    private WebElement searchInputName;

    @FindBy(xpath = "//label[@for='paste-raw-on']")
    private WebElement syntaxHighlightingLabel;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement searchButton;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    String getHomePageUrl() {
        return HOMEPAGE_URL;
    }

    @SneakyThrows
    public void chooseExpirationSelect(String nameElement){
        expirationSelect.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(String.format("//li[text()='%s']",nameElement))).click();
    }

    @SneakyThrows
    public void chooseSyntax(String nameElement){
        postformSelect.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(String.format("//li[text()='%s']",nameElement))).click();
    }

}
