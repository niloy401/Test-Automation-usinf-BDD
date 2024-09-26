package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static aquality.selenium.browser.AqualityServices.getConditionalWait;
import static utils.BrowserUtils.switchToDefault;
import static utils.BrowserUtils.switchToFrame;

public class HomePage extends Form {
    private final By SEARCHED_LOCATION_LIST = By.xpath("//p[contains(@class,'search-bar-result__name')]");
    private final By RECENT_LOCATION = By.xpath("//a[contains(@class,'recent-location-item featured-location  ')]");
    private final By IFRAME_LOCATOR = By.id("google_ads_iframe_/6581/web/gb/interstitial/news_info/country_home_0");
    private final IButton cookieAcceptButton = getElementFactory().getButton(By.xpath("//div[contains(@class,'banner-button policy-accept')]"), "Cookie Accept Button");
    private final IButton closeAdButton = getElementFactory().getButton(By.xpath("//div[contains(@class,'btn skip')]"), " Close AD Button");
    private final ITextBox searchBar = getElementFactory().getTextBox(By.xpath("//input[contains(@name,'query')]"), "Search bar");
    private final ILabel currentLocationIndicator = getElementFactory().getLabel(By.xpath("//div[contains(@class,'search-bar-result current-location-result')]"), "Current Location");

    public HomePage() {
        super(By.xpath("//p[@class='module-title spaced-content']"), "AccuWeather Home Page");
    }

    public void acceptCookie() {
        cookieAcceptButton.click();
    }

    public void enterLocation(String text) {
        searchBar.type(text);
    }

    public void clickTheFirstSearchResult() {
        getConditionalWait().waitFor(() -> getBrowser().getDriver().findElements(SEARCHED_LOCATION_LIST).size() > 0);
        List<ILabel> elements = getElementFactory().findElements(SEARCHED_LOCATION_LIST, ElementType.LABEL);
        elements.get(0).click();
        getConditionalWait().waitFor(() -> getBrowser().getDriver().findElements(SEARCHED_LOCATION_LIST).size() == 0);
    }

    public boolean isSearchBarListDisplayed() {
        return getConditionalWait().waitFor(() -> getBrowser().getDriver().findElements(SEARCHED_LOCATION_LIST).size() > 0);
    }

    public void clickRecentLocation() {
        List<ILabel> elements = getElementFactory().findElements(RECENT_LOCATION, ElementType.LABEL);
        elements.get(0).click();
    }

    public void removeAd() {
        WebElement iframe = IFRAME_LOCATOR.findElement(getBrowser().getDriver());
        switchToFrame(iframe);
        closeAdButton.click();
        switchToDefault();
    }

    public void clickSearchField() {
        searchBar.click();
    }

    public boolean isCurrentLocationBarDisplayed() {
        return currentLocationIndicator.state().waitForDisplayed();
    }
}
