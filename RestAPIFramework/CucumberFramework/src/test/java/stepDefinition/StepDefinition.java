package stepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(Cucumber.class)
public class StepDefinition {

    @Given("^User is on NetBanking page$")
    public void user_is_on_netbanking_page() throws Throwable {
    	System.out.println("Navigating to Login Page");
      
    }

    @When("^User login with Username and Password$")
    public void user_login_with_username_and_password() throws Throwable {
    	System.out.println("Successful Login");
        
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
    	System.out.println("Home Page");
        
    }

    @And("^All cards are displayed$")
    public void all_cards_are_displayed() throws Throwable {
    	System.out.println("Cards Displayed");
        
    }

}