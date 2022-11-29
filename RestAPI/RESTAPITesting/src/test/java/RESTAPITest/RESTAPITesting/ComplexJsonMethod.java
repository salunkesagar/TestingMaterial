package RESTAPITest.RESTAPITesting;

import static org.junit.Assert.assertEquals;

import org.testng.Assert;

import files.payLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(payLoad.dummyResponse());
		
		//Print No of courses returned by API
		
		int a = js.getInt("courses.size()");
		System.out.println(a);
		
		
		//Print Purchase Amount
		
		int b = js.getInt("dashboard.purchaseAmount");
		System.out.println(b);
		
		
		//Print Title of the first course
		
		String c = js.get("courses[0].title");
		System.out.println(c);
		
		//Print All course titles and their respective Prices
		for(int i=0;i<a; i++) {
			String title1 = js.getString("courses["+i+"].title");
			System.out.println(title1);
			int a2 = js.getInt("courses["+i+"].price");
			System.out.println(a2);
			
			
			
			
		}
		
		//5. Print no of copies sold by RPA Course
		for(int i=0;i<a;i++)
		{
			
			String title1 = js.getString("courses["+i+"].title");
			if(title1.equalsIgnoreCase("RPA"))
			{
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println(copies);
			}
			
		}
		
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		
		int sum = 0;
		for(int i=0;i<a;i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			
			sum = sum+amount;
			
		}
		System.out.println(sum);
		int total = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(total, sum);
		
			
	}

}
