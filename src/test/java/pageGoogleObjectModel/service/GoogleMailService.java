package pageGoogleObjectModel.service;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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

    @SneakyThrows
    public void copyMailAddress(){
        Thread.sleep(2000);
        mailPage.goToMailPage();
        Thread.sleep(2000);
//        mailPage.clickElement(mailPage.getEmailAddress());
        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("c").build();
        keydown.perform();
        Thread.sleep(2000);
        mailPage.goOut();
        Thread.sleep(2000);
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
