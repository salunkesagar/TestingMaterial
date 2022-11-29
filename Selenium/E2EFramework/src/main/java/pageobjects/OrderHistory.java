package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class OrderHistory extends AbstractComponent {
	
	
	WebDriver driver ;
	public OrderHistory(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
		
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderlist;
	
	
	public Boolean getOrderList(String ProductName)
	{
		Boolean match = orderlist.stream().anyMatch(ord->ord.getText().equalsIgnoreCase(ProductName));
		return match;
		
	}
	

}
