package pagePastebinObjectModel.test;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagePastebinObjectModel.page.PastebinHomePage;
import pagePastebinObjectModel.page.SearchCalculatorPage;



public class PastebinTest {

    PastebinHomePage homePage;
    SearchCalculatorPage searchCalculatorPage;
    WebDriver driver;

    @BeforeAll
    public void beforeAllTests() {
        driver = new ChromeDriver();
        homePage = new PastebinHomePage(driver);
        searchCalculatorPage = new SearchCalculatorPage(driver);
        homePage.openPage();
    }

    @Test
    public void test1() {
        homePage.getSearchInputText().sendKeys("Hello from WebDriver");
        homePage.getSearchList().click();
        homePage.chooseExpirationSelect("10 Minutes");
        homePage.getSearchInputName().sendKeys("helloweb");
        homePage.getSearchButton().click();
    }

    @SneakyThrows
    @Test
    public void test2() {
        var inputText = "git config --global user.name  \"New Sheriff in Town\"\n" + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force";
        var name = "helloweb";
        var language = "Bash";
        homePage.getSearchInputText().sendKeys(inputText);
        homePage.getSyntaxHighlightingLabel().click();
        homePage.chooseSyntax(language);
        homePage.chooseExpirationSelect("10 Minutes");
        homePage.getSearchInputName().sendKeys(name);
        homePage.getSearchButton().click();
        Thread.sleep(3000);

        var actualName = searchCalculatorPage.getHeaderName().getText();
        var actualLanguage = searchCalculatorPage.getSelectedLanguage().getText();
        var actualTextArea = searchCalculatorPage.getTextArea().getText();
        Assertions.assertEquals(actualName, name);
        Assertions.assertEquals(actualLanguage, language);
        Assertions.assertEquals(actualTextArea, inputText);

    }

//    @After
//    public void afterAllTests() {
//        driver.quit();
//    }
}

