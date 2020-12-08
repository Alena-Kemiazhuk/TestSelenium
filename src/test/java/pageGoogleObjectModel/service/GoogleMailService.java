//package pageGoogleObjectModel.service;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import pageGoogleObjectModel.page.GoogleCalculatorPage;
//import pageGoogleObjectModel.page.GoogleMailPage;
//
//import java.util.ArrayList;
//
//public class GoogleMailService {
//    WebDriver driver;
//    GoogleMailPage mailPage;
//
//    public GoogleMailService(WebDriver driver) {
//        this.driver = driver;
//        mailPage = new GoogleMailPage(driver);
//    }
//
//    public void openMailPage(GoogleCalculatorService googleCalculatorService){
//        String mainWindowHandle = googleCalculatorService.getDriver().getWindowHandles().iterator().next();
//        ((JavascriptExecutor)googleCalculatorService.getDriver()).executeScript("window.open()");
//        ArrayList<String> tabs = new ArrayList<String>(googleCalculatorService.getDriver().getWindowHandles());
//        googleCalculatorService.getDriver().switchTo().window(tabs.get(1));
//        googleCalculatorService.getDriver().get("https://10minutemail.com");
//    }
//
//    public void cop(){
//        mailPage.copyEmailAddress();
//    }
//
//}
