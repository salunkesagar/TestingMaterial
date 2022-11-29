package SeleniumPractise.E2EFramework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.CartPage;
import pageobjects.FinalPage;
import pageobjects.LandingPage;
import pageobjects.OrderHistory;
import pageobjects.PlaceOrder;
import pageobjects.ProductCatalouge;
import testComponents.BaseTest;

public class E2ETest2 extends BaseTest {
//WebDriver driver;	
	

	@Test(dataProvider = "getData",groups={"purchase"})
	public void Submit(HashMap<String, String> input) throws IOException {

		
		ProductCatalouge pc = lp.loginPage(input.get("email"), input.get("pwd"));
		List<WebElement> items = pc.getProducts();
		pc.addToCart(input.get("product"));
		CartPage cp = pc.goToCart();
		Boolean match = cp.cartItem(input.get("product"));
		Assert.assertTrue(match);
		PlaceOrder po = cp.checkOut();
		FinalPage fp = po.placeOrder();
		String confirm = fp.getText();
		Assert.assertTrue(confirm.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(confirm);

	}
	
	@Test(dependsOnMethods= {"Submit"})
	public void OrderHistoryTest()
	{
		
		ProductCatalouge pc = lp.loginPage("salunkesagarg@gmail.com", "Sagar@1234");
		OrderHistory oh = pc.getOrders();
		//Assert.assertTrue(oh.getOrderList(ProductName));
	
	}
	
	
	
	
	
	@DataProvider()
	public Object[][] getData() throws IOException
	{
		

		List<HashMap<String, String>> hm = getJsonData(System.getProperty("user.dir")+ "\\src\\test\\java\\dataResource\\data.json");
		
		return  new Object[][] {{hm.get(0)},{hm.get(1)}};
		 
	}
	/*@DataProvider()
	public Object[][] getData()
	{
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "salunkesagarg@gmail.com");
		map.put("pwd", "Sagar@1234");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "salunkesagarg@gmail.com");
		map1.put("pwd", "Sagar@1234");
		map1.put("product", "ADIDAS ORIGINAL");
		
		return  new Object[][] {{map},{map1}};
		 
	}*/
	
	

}
