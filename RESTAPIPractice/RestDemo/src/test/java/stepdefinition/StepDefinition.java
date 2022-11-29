package stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddLocation;
import pojo.Location1;
import testData.APIResources;
import testData.TestDataBuild;
import testData.Utils;

public class StepDefinition extends Utils {
	
	static RequestSpecification req1;
	static ResponseSpecification res;
	static Response res1;
	static String place_id;
	TestDataBuild data = new TestDataBuild();
	
	@Given("AddPlace Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException{
		
		
		
		
		
		
		
		res = new ResponseSpecBuilder()
				.expectStatusCode(200).expectContentType(ContentType.JSON).build();
		req1= given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));
		
				


	}
	@When("user calls {string} API with {string} request")
	public void user_calls_api_with_request(String resource , String method) {
		
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		
		if(method.equalsIgnoreCase("POST"))
			
			res1 = req1.when().post(resourceAPI.getResource()).then().spec(res).extract()
			.response();
		
		else if(method.equalsIgnoreCase("GET"))
			
			res1 = req1.when().get(resourceAPI.getResource()).then().spec(res).extract()
			.response();
		

		
			



	}
	@Then("API call get success with status code {int}")
	public void api_call_get_success_with_status_code(Integer int1) {
	    assertEquals(res1.getStatusCode(),200);

	}


	
	@Then("The {string} in body is {string}")
	public void the_in_body_is(String keyvalue, String expectedValue) {

		
		assertEquals(getJsonPath(res1,keyvalue),expectedValue);
	}
	
	
	@Then("verify placeID created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {

		 place_id = getJsonPath(res1, "place_id");
		req1= given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_api_with_request( resource , "GET"); 
		String actualName = getJsonPath(res1, "name");
		assertEquals(actualName, expectedName);
		
	    
	    
	}
	
	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		req1= given().spec(requestSpecification()).body(data.deletePlace(place_id));
		
		


	}
	
		
	}

	



