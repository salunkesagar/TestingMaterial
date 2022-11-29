package TestNGDemo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import files.payLoad;

public class UpdatePlace {
	
	@BeforeTest
	public void prerequisite()
	{
	RestAssured.baseURI ="https://rahulshettyacademy.com";
	}
	
	@Parameters({"Value"})
	@Test
	public void placeUpdate(String keyname)
	{
		 
		
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		String putadd = given().log().all().queryParam("key", keyname).header("Content-Type","application/json")
				
		.body(payLoad.updatePlace())
		
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(putadd);
		String addr = js.getString("address");
		System.out.println(addr);
		
		
	}

}
