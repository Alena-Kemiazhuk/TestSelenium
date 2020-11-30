package pagePastebinObjectModel.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import pagePastebinObjectModel.page.PastebinHomePage;

import static org.junit.Assert.assertEquals;


public class PastebinTest {

    PastebinHomePage homePage;
    WebDriver driver;

    @Before
    public void beforeAllTests() {
        driver = new ChromeDriver();
        homePage = new PastebinHomePage(driver);
        homePage.openPage();
    }

    @Test
    public void test1() {
        homePage.getSearchInputText().sendKeys("snkjchskd");
        homePage.addText("Hello from WebDriver");
        homePage.clickList();
        homePage.clickListElement("//*[@class='select2-container select2-container--default select2-container--open']//ul/li[text()='10 Minutes']");
        homePage.addName("helloweb");
        homePage.clickButton();
    }

    @Test
    public void test2() {
        homePage.addText("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
        homePage.clickListElement("//label[@for='paste-raw-on']");
        homePage.clickListSyntax();
        homePage.clickListElement("//*[@class='select2-container select2-container--default select2-container--open']//ul/li[text()='Bash']");
        homePage.clickList();
        homePage.clickListElement("//*[@class='select2-container select2-container--default select2-container--open']//ul/li[text()='10 Minutes']");
        homePage.addName("how to gain dominance among developers");
        homePage.clickButton();
//        String actualTitle = driver.getTitle();
//        System.out.println(actualTitle);
//        String expectedTitle = "how to gain dominance among developers";
//        assertEquals(expectedTitle,actualTitle);



    }

//    @After
//    public void afterAllTests() {
//        driver.quit();
//    }
}

