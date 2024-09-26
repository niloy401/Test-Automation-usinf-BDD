package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CityWeatherPage extends Form {
    private final ILabel cityNameHeader = getElementFactory().getLabel(By.xpath("//h1[@class ='header-loc']"), "City Name Header");

    public CityWeatherPage() {
        super(By.xpath("//div[@class='daily-list content-module']"), "Current City Temperature Page");
    }

    public String getCityName() {
        //getConditionalWait().waitFor(() -> cityNameHeader.state().isDisplayed());
        cityNameHeader.state().waitForDisplayed();
        //getConditionalWait().waitFor(ExpectedConditions.visibilityOfElementLocated(cityNameHeader.getLocator()));
        return cityNameHeader.getText();
        //return getElementFactory().getLabel(CITY_NAME_HEADER_LOCATOR, "City name").getText();
    }
}
