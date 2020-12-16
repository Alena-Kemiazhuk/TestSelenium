package pagePastebinObjectModel.service;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
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
        Assertions.assertEquals(actualLanguage, language);
        Assertions.assertEquals(actualTextArea, inputText);
    }

    public void checkName(String expectedName) {
        Assertions.assertEquals(expectedName, page.getHeaderName().getText());
    }

}
