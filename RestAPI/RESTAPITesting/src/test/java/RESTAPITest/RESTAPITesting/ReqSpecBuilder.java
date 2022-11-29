package RESTAPITest.RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddLocation;
import Pojo.GetLoc;

public class ReqSpecBuilder {

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
		
		RequestSpecification res1 = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification  resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		RequestSpecification  res = given().spec(res1).body(a);
		Response res2 =res.when().post("/maps/api/place/add/json")
		.then().spec(resspec).extract().response();
		
		String str = res2.asString();
		System.out.println(str);
	}

}
