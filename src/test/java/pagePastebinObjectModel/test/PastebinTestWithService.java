package pagePastebinObjectModel.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pagePastebinObjectModel.service.PastebinHomeService;
import pagePastebinObjectModel.service.SearchCalculatorService;


public class PastebinTestWithService {
    PastebinHomeService homePageService;
    SearchCalculatorService searchCalculatorService;

    @Before
    public void beforeAllTests() {
        homePageService = new PastebinHomeService(new ChromeDriver());
//        searchCalculatorService = new SearchCalculatorService(new ChromeDriver());
        homePageService.getPage().openPage();
    }

    @Test
    public void test1() {
        homePageService.createPaste("Hello", "10M", "John");
    }

    @Test
    public void test2() {
        var inputText = "git config --global user.name  \"New Sheriff in Town\"\n" + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force";
        var name = "helloweb";
        var language = "Bash";
        homePageService.createPaste(inputText, "10M", language, name);
        searchCalculatorService.checkCreatedPaste(name, language, inputText);
    }
}

