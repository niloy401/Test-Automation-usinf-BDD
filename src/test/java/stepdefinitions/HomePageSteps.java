package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

import static io.qameta.allure.Allure.step;

public class HomePageSteps {

    private final HomePage homePage = new HomePage();

    @When("I accept the cookie policy")
    public void acceptCookie() {
        step("Accepting the Cookie Policy");
        homePage.acceptCookie();
    }

    @And("I enter {string} in the search bar")
    public void enterCityName(String string) {
        step("Typing the Desired city name in the Search Bar");
        homePage.enterLocation(string);
    }

    @Then("I should see the search results")
    public void shouldSeeSearchResults() {
        step("Checking if the Search Result is displayed or not");
        Assert.assertTrue(homePage.isSearchBarListDisplayed(), "The Search Result is not displayed");
    }

    @When("I click on the first search Result")
    public void firstSearchResult() {
        step("Clicking on the First Location that appears in the Search Result");
        homePage.clickTheFirstSearchResult();
    }

    @Then("I will validate the main page is opened or not")
    public void validateMainPage() {
        step("Validating the Main Page is opened or not");
        Assert.assertTrue(homePage.state().waitForDisplayed(), "The Main Page is not displayed");
    }

    @When("I Choose the first City in Recent Location")
    public void clickOnRecentLocation() {
        step("Choose the city name from Recent Location");
        homePage.clickRecentLocation();
        step("Removing the Pop Up Advertisement");
        homePage.removeAd();
    }

    @When("I click the search field")
    public void clickSearchField() {
        step("Clicking on the Search Field");
        homePage.clickSearchField();
    }

    @Then("I should see the current location label is displayed")
    public void checkCurrentLocationLabel() {
        step("Checking if the Search Field is displayed or not");
        Assert.assertTrue(homePage.isCurrentLocationBarDisplayed(), "The Search Field is not displayed");
    }
}
