package RestAPIPractice.RestDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;


public class SumValidation {
	
	
	@SuppressWarnings("deprecation")
	@Test
	public static void sum()
	{
		JsonPath js = new JsonPath(Payload.Mockresponse());
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		int price = js.getInt("dashboard.purchaseAmount");
		System.out.println(price);
		
		int sum = 0;
		
		for(int i=0;i<count;i++)
			
		{
			int price1 = js.get("courses.price["+i+"]");
			int copies = js.get("courses["+i+"].copies");
			
			int amount = price1 * copies;
			//System.out.println(amount);
			sum = sum + amount;
			
		}
		System.out.println(sum);
		
		Assert.assertEquals(price, sum);
		
		
	}

}
