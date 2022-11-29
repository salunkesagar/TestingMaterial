package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	public LandingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userid;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement geterror;
	
	
	
	public ProductCatalouge loginPage(String username,String passw )
	{
		userid.sendKeys(username);
		password.sendKeys(passw);
		submit.click();
		ProductCatalouge pc = new ProductCatalouge(driver);
		return pc;
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String getError()
	{
		waitForWebElementToDisplay(geterror);
		return geterror.getText();
		
	}
	

}
