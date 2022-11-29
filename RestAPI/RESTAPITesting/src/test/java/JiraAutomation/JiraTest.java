package JiraAutomation;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;

public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://localhost:8080";
		
		//Cookie based authentication
		
		SessionFilter filter = new SessionFilter();
		
		String res = given().relaxedHTTPSValidation().log().all().header("Content-Type","application/json").body("{ \"username\": \"salunkesagarg\", \"password\": \"Sagar@Tester\" }")
		.filter(filter).when().post("/rest/auth/1/session")
		.then().log().all().extract().response().asString();
		System.out.println(res);
		
		//Add comment
		String message = "This is new comment";
		String str1 = given().log().all().pathParam("key","10103").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"body\": \""+message+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(filter).when().post("/rest/api/2/issue/{key}/comment")
		.then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = new JsonPath(str1);
		String commentID = js.getString("id");
		
		// Add Attachment using multi part method
		
		given().header("X-Atlassian-Token","no-check").filter(filter).pathParam("key","10103").header("Content-Type","multipart/form-data")
		.multiPart("file", new File("jira.txt")).when().post("/rest/api/2/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200);
		
		//get issue details
		
		String str = given().log().all().filter(filter).pathParam("key", "10103")
		.queryParam("fields","comment")
		.when().get("/rest/api/2/issue/{key}")
		.then().log().all().extract().response().asString();
		System.out.println(str);
		
		JsonPath js1 = new JsonPath(str);
		int count = js1.getInt("fields.comment.comments.size()");
		for (int i=0;i<count;i++)
		{
			String str2 = js1.get("fields.comment.comments["+i+"].id").toString();
			if(str2.equalsIgnoreCase(commentID))
			{
				String str3 = js1.getString("fields.comment.comments["+i+"].body").toString();
				System.out.println(str3);
				Assert.assertEquals(str3, message);
			}
		}
		
		
		
	}

}
