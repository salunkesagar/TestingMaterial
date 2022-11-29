package RestAPIPractice.RestDemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	static String id;
	
	@Test(dataProvider ="bookdata")
	public static void addBook(String isbn,String aisle)
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String res = given().log().all().header("Content-Type","application/json").body(Payload.Addbook(isbn,aisle))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = ReusableMethod.rawtojson(res);
		
		id = js.getString("ID");
		System.out.println(id);
	}
	
	
	@Test
	public void deleteBook() {
		given().log().all().header("Content-Type","application/json").body(id)
		.when().delete("/Library/DeleteBook.php")
		.then().log().all().assertThat().statusCode(200);
	}
	
	@DataProvider(name="bookdata")
	
	public Object[][] getData()
	{
		return new Object[][] {{"police1","169"},{"police2","169"},{"police3","169"}};
	}

}
