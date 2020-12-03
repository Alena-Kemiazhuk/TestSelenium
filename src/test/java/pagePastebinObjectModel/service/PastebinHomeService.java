package pagePastebinObjectModel.service;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pagePastebinObjectModel.page.PastebinHomePage;

@Getter
public class PastebinHomeService {
    WebDriver driver;
    PastebinHomePage page;

    public PastebinHomeService(WebDriver driver) {
        this.driver = driver;
        page = new PastebinHomePage(driver);
    }

    public void createPaste(String inputText, String selectValue,String language, String name) {
        page.getSearchInputText().sendKeys(inputText);
        page.getSearchList().click();
        page.chooseExpirationSelect(selectValue);
        page.chooseSyntax(language);
        page.getSearchInputName().sendKeys(name);
        page.getSearchButton().click();
    }

    public void createPaste(String inputText, String selectValue, String name) {
        page.getSearchInputText().sendKeys(inputText);
        page.getSearchList().click();
        page.chooseExpirationSelect(selectValue);
        page.getSearchInputName().sendKeys(name);
        page.getSearchButton().click();
    }

}
