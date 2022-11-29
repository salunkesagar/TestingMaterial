package RestAPIPractice.RestDemo;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class MockResponse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	JsonPath js = new JsonPath(Payload.Mockresponse());
	int count = js.getInt("courses.size()");
	System.out.println(count);
	
	int price = js.getInt("dashboard.purchaseAmount");
	System.out.println(price);
	
	//String title = js.getString("courses.title[0]");
	//System.out.println(title);
	for(int i=0;i<count;i++)
		
	{
		System.out.println(js.getString("courses.title["+i+"]").toString());
		System.out.println(js.get("courses.price["+i+"]").toString());
	}
	
	
	System.out.println("Number of copies sold by RPA course");
	
	for(int i=0;i<count;i++)
		
	{
		String courseTitle = js.getString("courses["+i+"].title");
		if(courseTitle.equalsIgnoreCase("Appium"))
		{
			System.out.println(js.get("courses["+i+"].copies"));
			//break;
		}
	}
	
	}
}
	
	


