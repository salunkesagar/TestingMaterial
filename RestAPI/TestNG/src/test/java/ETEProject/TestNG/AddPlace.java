package ETEProject.TestNG;

import java.io.IOException;
import io.restassured.RestAssured;

import org.testng.annotations.Test;

public class AddPlace extends base {
	@Test
	public void addPlace() throws IOException
	{
		String BaseURI = URI();
		RestAssured.baseURI = BaseURI
		//System.out.println(baseURI);
		
	}
	
	@Test
	

}
