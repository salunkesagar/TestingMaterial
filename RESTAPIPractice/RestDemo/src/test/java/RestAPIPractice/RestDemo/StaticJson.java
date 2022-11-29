package RestAPIPractice.RestDemo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;
public class StaticJson {
	
	@Test
	public static void main() throws IOException
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().header("Content-Type","application/json").body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Sagar Salunke\\Documents\\payload1.json"))))
		.when().post("Library/Addbook.php").then().log().all().assertThat().statusCode(200);
	}

}
