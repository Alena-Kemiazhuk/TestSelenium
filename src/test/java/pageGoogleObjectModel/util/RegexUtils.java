package pageGoogleObjectModel.util;

import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    public RegexUtils(WebDriver driver){

    }
    public String getCostForCompare(String totalCost, String regex){
        String costFromEstimateForCompare = null;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(totalCost);
        while (matcher.find()) {
            costFromEstimateForCompare = totalCost.substring(matcher.start(), matcher.end());
        }
//        System.out.println("sdfgdf " + costFromEstimateForCompare);
        return costFromEstimateForCompare.trim();
    }
}
