package utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

import static aquality.selenium.browser.AqualityServices.getBrowser;

@UtilityClass
public class BrowserUtils {

    public void switchToFrame(WebElement frame) {
        getBrowser().getDriver().switchTo().frame(frame);
    }

    public static void switchToDefault() {
        getBrowser().getDriver().switchTo().defaultContent();
    }

    public static void goBack() {
        getBrowser().goBack();
    }
}
