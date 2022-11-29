package stepDefinitions;


//import cucumber.api.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

//import cucumber.api.java.en.And;
//import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition {

    @Given("^User is on neebanking page$")
    public void user_is_on_neebanking_page() throws Throwable {
    	System.out.println("Hello");
        
    }

    @When("^User enters the credentials$")
    public void user_enters_the_credentials() throws Throwable {
    	System.out.println("successful");
        
    }

    @Then("^Home Page should get displayed$")
    public void home_page_should_get_displayed() throws Throwable {
    	System.out.println("Home Page validated");
       
    }
    
    @When("^User enters the credentials with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_the_credentials_with_username_something_and_password_something(String strArg1, String strArg2) throws Throwable {
    	System.out.println(strArg1);
    	System.out.println(strArg2);
    }
    
    @And("^All cards get displayed is \"([^\"]*)\"$")
    public void all_cards_get_displayed_is_something(String strArg1) throws Throwable {
       System.out.println(strArg1);
    }


    @And("^All cards get displayed$")
    public void all_cards_get_displayed() throws Throwable {
    	System.out.println("Cards validated");
       
    }

}