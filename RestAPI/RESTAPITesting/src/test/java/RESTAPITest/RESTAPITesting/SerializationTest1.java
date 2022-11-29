package RESTAPITest.RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddLocation;
import Pojo.GetLoc;

public class SerializationTest1 {

	public static void main(String[] args) {
		
		AddLocation a = new AddLocation();
		a.setAccuracy(50);
		a.setAddress("29, side layout, cohen 09");
		a.setLanguage("French-IN");
		a.setName("Frontline house");
		a.setPhone_number("(+91) 983 893 3937");
		a.setWebsite("http://google.com");
		List<String> myList =  new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		a.setTypes(myList);
		GetLoc l = new GetLoc();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		a.setLocation(l);
		
		
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response res = given().log().all().queryParam("key", "qaclick123").body(a)
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response();
		
		String str = res.asString();
		System.out.println(str);
	}

}
