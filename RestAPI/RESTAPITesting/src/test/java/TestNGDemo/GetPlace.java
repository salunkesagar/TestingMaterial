package TestNGDemo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class GetPlace extends AddPlace {
	
	//@Test(groups={"Check1"})
	@Test
	public void getPlace()
	{
		String placeid = AddPlace.postData();
		
		 //RestAssured.baseURI = "https://rahulshettyacademy.com";
		 String str2 =given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeid)
		 .when().get("/maps/api/place/get/json")
		 .then().log().all().assertThat().statusCode(200).extract().response().asString();
		 JsonPath js = new JsonPath(str2);
		 String address1 = js.getString("address");
		 System.out.println(address1);
		
	}

}
