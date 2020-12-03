package pagePastebinObjectModel.test;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagePastebinObjectModel.page.PastebinHomePage;
import pagePastebinObjectModel.page.SearchCalculatorPage;

import static org.junit.Assert.assertEquals;


public class PastebinTest {

    PastebinHomePage homePage;
    SearchCalculatorPage searchCalculatorPage;
    WebDriver driver;

    @Before
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
        assertEquals(actualName, name);
        assertEquals(actualLanguage, language);
        assertEquals(actualTextArea, inputText);

    }

//    @After
//    public void afterAllTests() {
//        driver.quit();
//    }
}

