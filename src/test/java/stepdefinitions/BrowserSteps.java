package stepdefinitions;

import io.cucumber.java.en.And;
import utils.BrowserUtils;

import static io.qameta.allure.Allure.step;

public class BrowserSteps {

    @And("I Go back to Main Page")
    public void goBack() {
        step("Navigating back to the Main Page");
        BrowserUtils.goBack();
    }
}
