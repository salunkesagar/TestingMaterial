package E2E.Demo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.io.IOException;



;

public class AddPlace extends base{
	
	
	private static Logger log = LogManager.getLogger(AddPlace.class.getName());
	
	
	@BeforeTest
	public void initializeURI() throws IOException 
	{
		String uri = getURI();
		//System.out.println(uri);
		RestAssured.baseURI = uri;
		log.info("Hit the Base URI");
	}
	
	
	@Parameters({"value1"})
	
	@Test
	public void addPlace(String valuename) throws IOException
	{
		
		String res = given().log().all().queryParam("key",valuename).header("Content-Type","application/json")
		.body(PayLoad.AddPlace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = reusableMethod.rawToJson(res);
		String str1 = js.getString("place_id");
		log.info("Executed Successfully");
		log.info(str1);
		
		
		
		
		
	}
	

}
