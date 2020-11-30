package pagePastebinObjectModel.page;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class SearchCalculatorPage extends AbstractPage {

    public SearchCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".info-top")
    private WebElement headerName;

    @FindBy(css = ".highlighted-code .left a")
    private WebElement selectedLanguage;

    @FindBy(css = ".textarea")
    private WebElement textArea;



    String getHomePageUrl() {
        return null;
    }
}
