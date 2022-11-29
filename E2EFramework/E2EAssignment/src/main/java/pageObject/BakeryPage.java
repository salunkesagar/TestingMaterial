package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BakeryPage {
	
	WebDriver driver;
	public BakeryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(css=".menu-fi-item[href='/products/bakerypastry']")
	WebElement bakery;
	
	
	@FindBy(xpath="//a[@class='cat cat-bakerypastry'][normalize-space()='Sweeteners']")
	
	WebElement sweetner;
	
	
	public WebElement Bakery()
	{
		return bakery;
	}
	
	public WebElement Sweetner()
	{
		return sweetner;
	} 
}
