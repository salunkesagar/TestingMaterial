package abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.CartPage;
import pageobjects.OrderHistory;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="button[routerlink*='cart'")
	WebElement aadtocart;
	
	
	@FindBy(css="button[routerlink*='/dashboard/myorders']")
	WebElement orderheader;

	public void waitForElement(By findBy)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
	public void waitforCountry(By findby)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitforPlaceOrderButton(By findBy)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
		
		
	}
	
	public void waitForWebElementToDisplay(WebElement findBy)
	{
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until((ExpectedConditions.visibilityOf(findBy)));
	}
	
	
	public void waitforTextToAppear(By findBy)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public CartPage goToCart()
	{
		aadtocart.click();
		CartPage cp = new CartPage(driver);
		return cp;
		
	}
	
	public OrderHistory getOrders()
	{
		orderheader.click();
		OrderHistory oh = new OrderHistory(driver);
		return oh;
		
	}
	
	

}
