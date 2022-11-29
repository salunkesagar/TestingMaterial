package RESTAPITest.RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


import java.util.ArrayList;
import java.util.List;

import Pojo.getLocation;
import Pojo.getPlace;


public class serializationTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getPlace gp = new getPlace();
		gp.setAccuracy(50);
		gp.setAddress("29, side layout, cohen 09");
		gp.setPhone_number("(+91) 983 893 3937");
		gp.setName("Frontline house");
		gp.setWebsite("http://google.com");
		gp.setLanguage("French-IN");
		List<String> l1 = new ArrayList<String>();
		l1.add("shoe park");
		l1.add("shop");
		gp.setTypes(l1);
		
		getLocation gl= new getLocation();
		gl.setLat(-38.383494);
		gl.setLng(33.427362);
		gp.setLocation(gl);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response res = given().log().all().queryParam("key","qaclick123").body(gp).when().post("/maps/api/place/add/json")
		.then().log().all().statusCode(200).extract().response();
		String responseString=res.asString();
		System.out.println(responseString);
		
		
		

				
	}

}
