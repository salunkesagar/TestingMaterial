package SeleniumPractise.RelativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class AboveLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sagar Salunke\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameLocator = driver.findElement(By.xpath("//input[@name='name'] "));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameLocator)).getText());
		
		
		WebElement cb = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(cb)).click();
		
		
		
		WebElement rb = driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		rb.click();
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rb)).getText());
		
		
		WebElement dob = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		//driver.close();

	}

}
