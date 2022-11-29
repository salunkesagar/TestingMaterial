package RestAPIPractice.RestDemo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;
import files.ReusableMethod;

public class basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		
		//Put Place
		
		String res = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(Payload.AddPlace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		
		System.out.println(res);
		
		JsonPath js = new JsonPath(res);
		
		String placeid = js.getString("place_id");
		System.out.println(placeid);
		
		//Put Place
		
		String newAddress = "70 winter walk, Africa";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
				+ "\"place_id\":\""+placeid+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
	
	
		//Get Place
		
		String res1 = given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeid )
		.when().get(" /maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().asString();
		
		JsonPath js1 = ReusableMethod.rawtojson(res1);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);
		
	}

}
