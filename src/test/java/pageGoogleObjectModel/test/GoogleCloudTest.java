package pageGoogleObjectModel.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageGoogleObjectModel.page.GoogleCloudHomePage;

public class GoogleCloudTest {

    @Test
    public void test1() {
        WebDriver driver = new ChromeDriver();
        GoogleCloudHomePage homePage = new GoogleCloudHomePage(driver);
        homePage.openPage();
        homePage.clickSearchButtonSearch();
        homePage.addTextInButtonSearch("Google Cloud Platform Pricing Calculator");
        homePage.clickButtonSearch("//a[contains(text(), 'google cloud')]");
    }
}
