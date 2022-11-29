package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	
	public RequestSpecification reqSpecBuild() throws IOException
	{
		if(req == null)
		{
			
		
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(getData("base")).setContentType(ContentType.JSON).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return req;
		}
		return req;
		
	}
	
	public static String getData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\RestAPIFramework\\APIFramework\\src\\test\\java\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	public String getJsonPath(Response res1, String key)
	{
		String s = res1.asString();
    	JsonPath js = new JsonPath(s);
    	return js.get(key).toString();
	}

}
