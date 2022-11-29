package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='query-input']")
		WebElement searchbox;
	
	@FindBy(xpath="//input[@unbxdattr='sq_bt']")
		WebElement search;
	
	@FindBy(xpath="//h2[normalize-space()='BETTER EGGS']")
		WebElement title;
	
	public WebElement searchBox()
	{
		return searchbox;
		
	}
	
	public WebElement Search()
	{
		return search;
	}

	public WebElement Title()
	{
		return title;
	}
}
