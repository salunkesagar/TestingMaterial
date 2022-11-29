package RESTAPITest.RESTAPITesting;
import static org.hamcrest.Matchers.*;

import java.io.File;

import java.io.IOException;
import java.io.PrintStream;

import org.testng.Assert;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import files.payLoad;


public class SpecBuilder {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 /*File file = new File("D:\\RestAPI\\RESTAPITesting\\log\\log.txt");
	   
	      PrintStream stream = new PrintStream(file);
	      System.out.println("Output will be printed om "+file.getAbsolutePath()+" not on console");
	      System.setOut(stream);*/
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).addQueryParam("key","qaclick123").build();
		
		
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification req1 = given().spec(req).body(payLoad.Addplace());
		Response res1 = req1.when().post("/maps/api/place/add/json")
		.then().spec(res).extract().response();
		
		String s = res1.asString();
		System.out.println(s);
		JsonPath js = new JsonPath(s);
		String s1 = js.getString("place_id");
		System.out.println(s1);
		
		///Update place
		String add1 = "70 Summer walk, USA";
		
		given().spec(req).body("{\r\n"
				+ "\"place_id\":\""+s1+"\",\r\n"
				+ "\"address\":\""+add1+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().spec(res).body("msg", equalTo("Address successfully updated"));
		
		/* //Get Place
		
	String s2 = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", s1).when().get("/maps/api/place/get/json")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	
	JsonPath js1 = new JsonPath(s2);
	String s3 = js1.getString("address");
	System.out.println(s3);
	
	Assert.assertEquals(s3, add1);
	
	
	//Delete Place
	String s4 = given().log().all().queryParam("key", "qaclick123").body("{\r\n"
			+ "    \"place_id\":\""+s1+"\"\r\n"
			+ "}").when().delete("/maps/api/place/delete/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
	System.out.println(s4);
	
	*/
	}

}
