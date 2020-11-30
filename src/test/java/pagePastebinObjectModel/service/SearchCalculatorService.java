package pagePastebinObjectModel.service;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pagePastebinObjectModel.page.SearchCalculatorPage;

import static org.junit.Assert.assertEquals;

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
        assertEquals(actualLanguage, language);
        assertEquals(actualTextArea, inputText);
    }

    public void checkName(String expectedName) {
        assertEquals(expectedName, page.getHeaderName().getText());
    }

}
