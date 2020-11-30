package pagePastebinObjectModel.page;

import lombok.Getter;
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

    @FindBy(id = "postform-expiration")
    private Select expirationSelect;

    @FindBy(id = "postform-format")
    private Select postformSelect;

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
}
