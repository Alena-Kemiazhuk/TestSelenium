package pageGoogleObjectModel.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.get(getHomePageUrl());
    }

    abstract String getHomePageUrl();
}
