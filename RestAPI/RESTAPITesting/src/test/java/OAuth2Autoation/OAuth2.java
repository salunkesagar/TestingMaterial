package OAuth2Autoation;

import static io.restassured.RestAssured.*;

import Pojo.ResponseCourse;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class OAuth2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AdQt8qhZO5sJ8GHs0xCsFDljRwjLI5boK0STvqUtr4yyNCFXPLqMEUlVIVmXmGSyIynOtA&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=1&prompt=none";
		String partial = url.split("code=")[1];
		String code = partial.split("&scope")[0];
		
		
		
		String accesstoken = given().urlEncodingEnabled(false)
				.queryParams("code",code)
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		JsonPath js = new JsonPath(accesstoken);
		String str = js.getString("access_token");
		
		
		
		
		ResponseCourse rc = given().queryParam("access_token", str).expect().defaultParser(Parser.JSON)
		.when().get("https://rahulshettyacademy.com/getCourse.php").as(ResponseCourse.class);
		//System.out.println(Access_Token);
		System.out.println(rc.getInstructor());
		System.out.println(rc.getLinkedIn());
		System.out.println(rc.getCourses().getApi().get(1).getCourseTitle());
		int size = rc.getCourses().getApi().size();
		for(int i=0;i<size;i++)
		{
			if(rc.getCourses().getApi().get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
					{
						System.out.println(rc.getCourses().getApi().get(i).getPrice());
					}
		}

	}

}
