package SeleniumPractise.E2EFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.CartPage;
import pageobjects.FinalPage;
import pageobjects.LandingPage;
import pageobjects.PlaceOrder;
import pageobjects.ProductCatalouge;
import testComponents.BaseTest;

public class ErrorValidation extends BaseTest{
//WebDriver driver;	

	@Test(groups="ErrorHandling",retryAnalyzer=testComponents.Retry.class)
	public void loginPageErrorValidation() throws IOException
	{

		
		lp.loginPage("salunkesagarg@gmail.com", "Sagar1234");
		lp.getError();
		Assert.assertEquals("Incorrect email or password.", lp.getError());
	}
	
	@Test
	public void productPageValidation()
	{
		String ProductName = "ZARA COAT 3";
		ProductCatalouge pc = lp.loginPage("salunkesagarg@gmail.com", "Sagar@1234");
		List<WebElement> items = pc.getProducts();

		pc.addToCart(ProductName);
		
		CartPage cp = pc.goToCart();
		
		Boolean match = cp.cartItem("ZARA COAT 345");


		 Assert.assertFalse(match);
	}
	
	

}
