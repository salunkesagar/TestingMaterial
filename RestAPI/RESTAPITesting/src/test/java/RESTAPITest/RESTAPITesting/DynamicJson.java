package RESTAPITest.RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DynamicJson {
	
	@Test(dataProvider = "BookRecord")
	
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String res = given().log().all().header("Content-Type","application/json").body("{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}").
		when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
	
		 JsonPath js1 = reusableMethod.rawToJson(res);
		String s4 = js1.getString("ID");
		System.out.println(s4);
	}
	@DataProvider(name="BookRecord")
	public Object[][] getData()
	{
		return new Object[][] {{"abcncyutyu","1234"},{"asdk","67896"}};
		
	}
}
