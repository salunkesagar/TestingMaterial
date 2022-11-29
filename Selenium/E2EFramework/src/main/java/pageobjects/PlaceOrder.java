package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class PlaceOrder extends AbstractComponent {
	
	WebDriver driver;
	
	public PlaceOrder(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder$='Select Country']")
	WebElement textbox;
	
	@FindBy(css=".ta-item:nth-child(3)")
	WebElement selectcountry;
	
	@FindBy(css=".action__submit")
	WebElement placeorder;
	
	By country = By.cssSelector(".ta-results");
	
	By placebutton = By.cssSelector(".action__submit");
	
	
	
	
	public FinalPage placeOrder()
	{
		textbox.sendKeys("India");
		waitforCountry(country);
		selectcountry.click();
		waitforPlaceOrderButton(placebutton);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,100)");
		js.executeScript("window.scrollBy(0,400)");
		js.executeScript("arguments[0].click(0);", placeorder);
		
		return new FinalPage(driver);
		 
		
	}
	

}
