package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SponsoredPage {

	WebDriver driver;

	public SponsoredPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[contains(text(),'Sponsored')]")
	WebElement sponsored;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/h3[1]/a[1]")
	WebElement productName;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[3]/span[1]")
	WebElement prductQuantity;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[2]")
	WebElement productCode;

	@FindBy(xpath = "//div[@id='product_ju18g']//div[@class='product-title-and-sku']//div[2]//h3[1]//a[1]")
	WebElement productName1;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/span[3]/span[1]")
	WebElement prductQuantity1;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/span[2]")
	WebElement productCode1;

	@FindBy(xpath = "//div[@id='product_ju11a']//div[@class='product-title-and-sku']//div[2]//h3[1]//a[1]")
	WebElement productName2;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[3]/span[1]")
	WebElement prductQuantity2;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/span[2]")
	WebElement productCode2;

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/span[1]/a[1]")
	WebElement advertiser;

	public WebElement Sponsored() {
		return sponsored;

	}

	public WebElement ProductName() {
		return productName;

	}

	public WebElement ProductQuantity() {
		return prductQuantity;

	}

	public WebElement ProductCode() {
		return productCode;

	}

	public WebElement ProductName1() {
		return productName1;
	}

	public WebElement ProductQuantity1() {
		return prductQuantity;

	}

	public WebElement ProductCode1() {
		return productCode1;

	}

	public WebElement ProductName2() {
		return productName2;
	}

	public WebElement ProductQuantity2() {
		return prductQuantity2;

	}

	public WebElement ProductCode2() {
		return productCode2;

	}

	public WebElement Advertiser() {
		return advertiser;

	}

}
