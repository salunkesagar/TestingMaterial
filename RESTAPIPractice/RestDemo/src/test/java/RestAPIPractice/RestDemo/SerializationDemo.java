package RestAPIPractice.RestDemo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.GoogleMap;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		GoogleMap a = new GoogleMap();
		
		a.setAccuracy(50);
		a.setAddress("29, side layout, cohen 09");
		a.setLanguage("French-IN");
		a.setName("Frontline house");
		a.setPhone_number(DEFAULT_BODY_ROOT_PATH);
		a.setWebsite("http://google.com");
		List<String> mylist = new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		a.setTypes(mylist);
		
		Location l = new Location();
		l.setLat(-38.38349);
		l.setLng(33.427362);
		
		a.setLocation(l);
		
		
		
		
		
		
		
		/*RestAssured.baseURI ="https://rahulshettyacademy.com";
		Response res = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(a)
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response();
		String res1 = res.asString();
		System.out.println(res1);*/
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").addHeader("Content-Type","application/json").build();
		RequestSpecification res2 = given().spec(req).body(a);
		
		ResponseSpecification r = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		
		Response res3 = res2.when().post("/maps/api/place/add/json").then().spec(r).extract().response(); 
		String r4 = res3.asString();
		System.out.println(r4);
	}

}
