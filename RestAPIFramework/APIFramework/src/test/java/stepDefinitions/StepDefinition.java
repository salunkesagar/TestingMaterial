package stepDefinitions;

import java.io.IOException;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


@RunWith(Cucumber.class)
public class StepDefinition  extends Utils {
	RequestSpecification req1;
    ResponseSpecification res;
    Response res1;
    static String place_id;
    TestDataBuild  data = new TestDataBuild();	
   
	
	
		

    @Given("Add Place Payload {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {
        // Write code here that turns the phrase above into concrete actions
       
  

	   
	    	
	    	
	    	
	         req1 = given().spec(reqSpecBuild()).body(data.AddPlacePayload(name, language, address));
	        
	       
	        		
	        		
	    }

    @When("User calls {string} with {string} request")
    public void user_calls_with_request(String resource, String method) {
	    	
	    	APIResources resourceAPI = APIResources.valueOf(resource);
	    	System.out.println(resourceAPI.getResource());
	    	
	    	 res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	    	if(method.equalsIgnoreCase("Post"))
	    	 res1 = req1.when().post(resourceAPI.getResource())
	    			.then().spec(res).extract().response();
	    	else if(method.equalsIgnoreCase("Get"))
	    		res1 = req1.when().get(resourceAPI.getResource())
    			.then().spec(res).extract().response();
	    		
	        
	    }

	    @Then("^The API call is successful with status code 200$")
	    public void the_api_call_is_successful_with_status_code_200() throws Throwable {
	    	assertEquals(res1.getStatusCode(),200);
	        
	    }

	    @And("^\"([^\"]*)\" in response is \"([^\"]*)\"$")
	    public void something_in_response_is_something(String key, String value) throws Throwable {
	    	
	    	
	    	assertEquals(getJsonPath(res1,key),value);
	    	
	        
	    }
	    
	    @Then("verfiy place_id created maps to {string} using {string}")
	    public void verfiy_place_id_created_maps_to_using(String expectedname, String resource) throws IOException {
	        // Write code here that turns the phrase above into concrete actions
	    	
	    	 place_id = getJsonPath(res1,"place_id");
	    	req1 = given().spec(reqSpecBuild()).queryParam("place_id", place_id);
	    	 user_calls_with_request(resource,"GET");
	    	 String actualname = getJsonPath(res1,"name");
	    		assertEquals(actualname, expectedname);
	    	
	      
	    }
	    
	    @Given("DeletePlaceAPI Payload")
	    public void delete_place_api_payload() throws IOException {
	        // Write code here that turns the phrase above into concrete actions
	    	req1 = given().spec(reqSpecBuild()).body(data.DeletePlaceAPI(place_id));
	        
	    }


	    

	}

