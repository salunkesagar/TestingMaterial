package Baldorfood.Assignment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sagar Salunke\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.baldorfood.com/");
		
		WebElement bakery = driver.findElement(By.cssSelector(".menu-fi-item[href='/products/bakerypastry']"));
		WebElement sweetner = driver.findElement(By.xpath("//a[@class='cat cat-bakerypastry'][normalize-space()='Sweeteners']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Actions a = new Actions(driver);
		a.moveToElement(bakery).build().perform();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='cat cat-bakerypastry'][normalize-space()='Sweeteners']")));
		a.moveToElement(sweetner).click().build().perform();
		
		
	}

}
