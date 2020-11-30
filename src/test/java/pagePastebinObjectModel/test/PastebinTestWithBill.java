package pagePastebinObjectModel.test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pagePastebinObjectModel.bills.PasteCreatorBill;


public class PastebinTestWithBill {
    PasteCreatorBill pasteCreatorBill;

    @Before
    public void beforeAllTests() {
        pasteCreatorBill = new PasteCreatorBill(new ChromeDriver());
        pasteCreatorBill.getPastebinHomeService().getPage().openPage();
    }

    @Test
    public void test2() {
        var inputText = "git config --global user.name  \"New Sheriff in Town\"\n" + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force";
        var name = "helloweb";
        var language = "Bash";
        pasteCreatorBill.checkCreatingPaste(inputText, name, language);
    }
}

