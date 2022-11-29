package TestNGDemo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public  class AddPlace {
	
	
	
	@Test
	public static String postData() {
		
		//RestAssured.baseURI ="https://rahulshettyacademy.com";
		String res = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(payLoad.Addplace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = new JsonPath(res);
		String s = js.getString("place_id");
		System.out.println(s);
		return s;
		
	}
}
