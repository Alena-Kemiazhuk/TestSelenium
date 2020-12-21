package pageGoogleObjectModel.service;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageGoogleObjectModel.page.GoogleMailPage;


public class GoogleMailService {
    WebDriver driver;
    GoogleMailPage mailPage;
    private final String xpathMailMassage = "//*[@class='message_top']";
    private final Logger logger = LogManager.getRootLogger();

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
        mailPage.timeOut(3, xpathMailMassage);
        mailPage.clickElement(mailPage.getMailMessage());
        String totalCostFromMail = mailPage.getTotalEstimatedCostMail().getText();
        mailPage.goOut();
        logger.info("Total cost from email = " + totalCostFromMail);
        return totalCostFromMail;
    }
}
