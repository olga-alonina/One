package io.fleet.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.fleet.pages.VehiclesPage;
import io.fleet.utilities.ConfigurationReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TC07 {

    public static final Logger LOG = LogManager.getLogger();
    VehiclesPage vehiclesPage = new VehiclesPage();

    @Given("User on the home page")
    public void user_on_the_home_page() {
        LOG.info("Environment  url = " + ConfigurationReader.getProperty("urlFleet"));
        vehiclesPage.login();
    }

    @When("I hover over to {string} module")
    public void i_hover_over_to_module(String moduleName) throws Exception {
        vehiclesPage.hoverOverToModule(moduleName);
    }

    @When("I click {string} option")
    public void i_click_option(String subName) throws Exception {
        vehiclesPage.clickSubModule(subName);

    }

    @Then("I should see {string} page title")
    public void i_should_see_page_title(String pageTitle) {
        vehiclesPage.assertPageTitle(pageTitle);
    }

    @Then("{string} button on the right side of {string}")
    public void button_on_the_right_side_of(String button1, String button2) {
        vehiclesPage.assertOneButtonIsLeftToAnother(button1, button2);
    }

}
