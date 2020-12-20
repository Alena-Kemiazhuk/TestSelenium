package pagePastebinObjectModel.service;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pagePastebinObjectModel.page.SearchCalculatorPage;

@Getter
public class SearchCalculatorService {
    WebDriver driver;
    SearchCalculatorPage page;

    public SearchCalculatorService(WebDriver driver) {
        this.driver = driver;
        page = new SearchCalculatorPage(driver);
    }

    public void checkCreatedPaste(String name, String language, String inputText) {
        var actualLanguage = page.getSelectedLanguage().getText();
        var actualTextArea = page.getTextArea().getText();
        checkName(name);
        Assert.assertEquals(actualLanguage, language);
        Assert.assertEquals(actualTextArea, inputText);
    }

    public void checkName(String expectedName) {
        Assert.assertEquals(expectedName, page.getHeaderName().getText());
    }

}
