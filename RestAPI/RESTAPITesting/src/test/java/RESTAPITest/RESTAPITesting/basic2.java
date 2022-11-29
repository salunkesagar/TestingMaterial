package RESTAPITest.RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import files.payLoad;

public class basic2 {
	private static Logger log =LogManager.getLogger(basic.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.info("Base URL is opened");
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String abc = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(payLoad.Addplace()).when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)").extract().asString();
		//System.out.println(abc);
		log.info(abc);
		JsonPath js = new JsonPath(abc);
			String ab = js.getString("place_id");
			//System.out.println(ab);
			log.info(ab);
			log.info("Place id extracted from response");
		/*String[] a = abc.split("reference");
		String[] a1 = a[1].split(":");
		//System.out.println(a1[1]);
		String[] a2= a1[1].split(",");
		System.out.println(a2[0]);
		
		/*String strContent = a2[0];
        
        String strPattern = "\"[^\"]*\"";
        
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(strContent);
        
        while( matcher.find() ) {
            System.out.println( matcher.group() );
        }*/
			
			/*String add1 = "70 Summer walk, USA";
			
			given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
					+ "\"place_id\":\""+ab+"\",\r\n"
					+ "\"address\":\""+add1+"\",\r\n"
					+ "\"key\":\"qaclick123\"\r\n"
					+ "}")
			.when().put("/maps/api/place/update/json")
			.then().log().all().assertThat().body("msg", equalTo("Address successfully updated"));
			
			String s2 = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", ab).when().get("/maps/api/place/get/json")
					.then().log().all().assertThat().statusCode(200).extract().response().asString();
					
					JsonPath js1 = new JsonPath(s2);
					String s3 = js1.getString("address");
					//System.out.println(s3);
					log.info(s3);
					
					Assert.assertEquals(s3, add1);*/
		
		

				
	}

}
