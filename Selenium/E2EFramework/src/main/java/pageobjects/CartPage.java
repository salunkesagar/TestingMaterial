package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> itemcart;
	
	@FindBy(css=".totalRow  button")
	WebElement Checkout;
	
	public Boolean cartItem(String ProductName)
	{
		
		Boolean match = itemcart.stream().anyMatch(it -> it.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
	public PlaceOrder checkOut()
	{
		Checkout.click();
		PlaceOrder po = new PlaceOrder(driver);
		return po;
	}

}
