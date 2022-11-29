package TestNGDemo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import files.payLoad;

public class DeletePlace {
	@Parameters({"URI"})
	
	@Test
	public void deletePlace(String uri)
	{
		RestAssured.baseURI = uri ;
		String s3 = given().log().all().queryParam("key", "qaclick123").body(payLoad.delete())
		.when().delete("/maps/api/place/delete/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		System.out.println(s3);
	}

}
