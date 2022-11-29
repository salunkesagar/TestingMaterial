package IB.E2EAssignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.BakeryPage;

public class BakerySweetnerPage extends base {
	public WebDriver driver;

	@BeforeTest
	public void stepUp() throws IOException {
		driver = initializeDriver();
		// driver.get("https://www.baldorfood.com/");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void hoverData() throws IOException {

		BakeryPage bp = new BakeryPage(driver);

		WebElement bakery = bp.Bakery();
		WebElement sweetner = bp.Sweetner();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Actions a = new Actions(driver);
		a.moveToElement(bakery).build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='cat cat-bakerypastry'][normalize-space()='Sweeteners']")));
		a.moveToElement(sweetner).click().build().perform();

	}

	@AfterTest

	public void tearDown() {
		driver.close();
	}

}
