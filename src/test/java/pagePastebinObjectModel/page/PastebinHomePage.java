package pagePastebinObjectModel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHomePage extends AbstractPage {
    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement searchInputText;

    @FindBy(xpath = "//*[@id='select2-postform-expiration-container']")
    private WebElement searchList;

    @FindBy(xpath = "//*[@id='select2-postform-format-container']")
    private WebElement searchListSyntax;

    @FindBy(xpath = "//*[@id='postform-name']")
    private WebElement searchInputName;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement searchButton;

    private static final String HOMEPAGE_URL = "https://pastebin.com/";
    private String textForAdd;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(HOMEPAGE_URL);
    }

    public void addText(String textForAdd) {
        searchInputText.sendKeys(textForAdd);
    }

    public void addName(String textForAdd) {
        searchInputName.sendKeys(textForAdd);
    }

    public void clickList() {
        searchList.click();
    }

    public void clickListSyntax() {
        searchListSyntax.click();
    }

    public void clickListElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public SearchCalculatorPage clickButton() {
        searchButton.click();
        return new SearchCalculatorPage(driver);
    }

}
