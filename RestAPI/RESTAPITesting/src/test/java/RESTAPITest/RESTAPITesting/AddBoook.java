package RESTAPITest.RESTAPITesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
 
import static io.restassured.RestAssured.given;
 
public class AddBoook {
 
    @Test
 
    public void AddBook() {
 
// TODO Auto-generated method stub
 
//BaseURL or Host
 
        RestAssured.baseURI = "http://216.10.245.166/";
 
                String res = given().
 
                header("Content-Type", "application/json").
 
                body("{" +
 
                        "\"name\":\"Learn Davids book\"," +
 
                        "\"isbn\":\"bcdea\"," +
 
                        "\"aisle\":\"223t\"," +
 
                        "\"author\":\"David Her\"" +
 
                        "}").
 
                when().
 
                get("/Library/Addbook.php").
 
                then().log().body().
 
                assertThat().statusCode(200).
 
                extract().response().asString();
 
        JsonPath jsp = reusableMethod.rawToJson(res);
 
        jsp.get("ID");
 
        System.out.println(jsp.get("ID").toString());
 
 
    }
}