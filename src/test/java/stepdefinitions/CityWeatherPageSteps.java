package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CityWeatherPage;

import static io.qameta.allure.Allure.step;

public class CityWeatherPageSteps {

    private final CityWeatherPage cityWeatherPage = new CityWeatherPage();

    @Then("I should see page header contains {string} city from the search result")
    public void checkCityName(String string) {
        step("Getting the City Name from the Weather Page");
        String cityName = cityWeatherPage.getCityName();
        step("Checking if the webpage header contains the City Name from search or not.");
        Assert.assertTrue(cityName.contains(string), "The Weather Page does not contain City Name");
    }
}
