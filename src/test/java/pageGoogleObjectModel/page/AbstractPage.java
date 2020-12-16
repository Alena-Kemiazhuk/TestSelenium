package pageGoogleObjectModel.page;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageGoogleObjectModel.driver.DriverSingleton;


public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 3;


    public AbstractPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void openPage(){
        driver.get(getHomePageUrl());
    }

    abstract String getHomePageUrl();
}
