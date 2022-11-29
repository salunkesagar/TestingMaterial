package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class ProductCatalouge extends AbstractComponent{
	
	WebDriver driver;
	public ProductCatalouge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement invisible;
	
	By product = By.cssSelector(".col-lg-4");
	By addtoCart =By.cssSelector(".card-body button:last-of-type");
	By toast = By.cssSelector("#toast-container");
	
	public List<WebElement> getProducts()
	{
		waitForElement(product);
		return products;
	}
	
	public WebElement getProductByName(String ProductName)
	{
		WebElement itm = getProducts().stream()
				.filter(item -> item.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(ProductName))
				.findFirst().orElse(null);
		return itm;
	}
	
	public void addToCart(String ProductName)
	{
		WebElement prod = getProductByName(ProductName);
		prod.findElement(addtoCart).click();
		waitForElement(toast);
		waitForElementToDisappear(invisible);
	}
}
