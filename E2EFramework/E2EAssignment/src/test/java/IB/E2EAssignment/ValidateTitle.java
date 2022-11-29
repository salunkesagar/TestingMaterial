package IB.E2EAssignment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.HomePage;

public class ValidateTitle extends base {
	
	public WebDriver driver;
	
	@BeforeTest
	public void stepUp() throws IOException {
		driver = initializeDriver();
		// driver.get("https://www.baldorfood.com/");
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	
	public void getTitle() throws IOException
	{
		
		HomePage hp = new HomePage(driver);
		//String text = hp.Title().getText();
		//System.out.println(text);
		Assert.assertEquals(hp.Title().getText(), "BETTER EGGS12");
		
	
	}
	
	@AfterTest

	public void tearDown() {
		driver.close();
	}

}
