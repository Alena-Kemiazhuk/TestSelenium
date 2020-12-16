package pageGoogleObjectModel.service;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import pageGoogleObjectModel.page.GoogleMailPage;


public class GoogleMailService {
    WebDriver driver;
    GoogleMailPage mailPage;
    private final String xpathMailMassage = "//*[@class='message_top']";

    public GoogleMailService(WebDriver driver) {
        this.driver = driver;
        mailPage = new GoogleMailPage(driver);
    }

    public void copyMailAddress(){
        mailPage.goToMailPage();
        mailPage.clickElement(mailPage.getEmailAddress());
        mailPage.goOut();
    }

    @SneakyThrows
    public String getTotalCostFromSentEmail(){
        mailPage.backToMailPage();
        mailPage.timeOut(300, xpathMailMassage);
        mailPage.clickElement(mailPage.getMailMessage());
        String totalCostFromMail = mailPage.getTotalEstimatedCostMail().getText();
        mailPage.goOut();
        System.out.println(totalCostFromMail);
        return totalCostFromMail;
    }
}
