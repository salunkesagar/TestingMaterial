package Demo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class TestNG1 {
	
	@Test
	public void postData()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log();
	}

}
