package SeleniumPractise.E2EFramework;

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
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LandingPage;

public class E2ETest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ProductName = "ZARA COAT 3";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		// driver.manage().timeouts().implicitlyWait(D)
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys("salunkesagarg@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Sagar@1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
		List<WebElement> items = driver.findElements(By.cssSelector(".col-lg-4"));
		WebElement itm = items.stream()
				.filter(item -> item.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(ProductName))
				.findFirst().orElse(null);

		itm.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		w.until((ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating")))));
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

		List<WebElement> itemcart = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = itemcart.stream().anyMatch(it -> it.getText().equalsIgnoreCase(ProductName));
		// Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow  button")).click();
		driver.findElement(By.cssSelector("input[placeholder$='Select Country']")).sendKeys("india");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		// List<WebElement> countries = driver.findElements(By.cssSelector(".ta-item
		// "));
		// WebElement right = driver.findElement(By.cssSelector(".fa-search"));
		// Stream<WebElement> c = countries.stream().filter(country->
		// country.findElement(with(By.tagName("i")).toRightOf(right)).getText().equalsIgnoreCase("India"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,100)");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item:nth-child(3)")));
		driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
		js.executeScript("window.scrollBy(0,400)");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));
		WebElement e = driver.findElement(By.cssSelector(".action__submit"));
		

		js.executeScript("arguments[0].click(0);", e);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		String confrim = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confrim.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(confrim);
		driver.close();

	}

}
