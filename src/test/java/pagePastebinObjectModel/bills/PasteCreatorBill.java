package pagePastebinObjectModel.bills;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pagePastebinObjectModel.service.PastebinHomeService;
import pagePastebinObjectModel.service.SearchCalculatorService;

@Getter
public class PasteCreatorBill {
    PastebinHomeService pastebinHomeService;
    SearchCalculatorService searchCalculatorService;

    public PasteCreatorBill(WebDriver driver){
        pastebinHomeService = new PastebinHomeService(driver);
        searchCalculatorService = new SearchCalculatorService(driver);
    }

    public void checkCreatingPaste(String text,String name, String language){
        pastebinHomeService.createPaste(text, "10M", language, name);
        searchCalculatorService.checkCreatedPaste(name, language, text);
    }
}
