package E2E.Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test1 {
	
	@Test
	public void getData()
	{
		RestAssured.baseURI = "https:\\Google.com";
	}

}
