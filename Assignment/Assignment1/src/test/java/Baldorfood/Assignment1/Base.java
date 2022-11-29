package Baldorfood.Assignment1;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ExcelData as = new ExcelData();
		ArrayList<String> data = as.getData("SearchKeyword");
		//System.out.println(data.get(0));
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sagar Salunke\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.baldorfood.com/");
	//	driver.findElement(By.id("suggestions-form")).sendKeys(data.get(1));
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='query-input']")));
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='query-input']"));
		
		for(int i=1;i<=3;i++)
		{
			searchBox.sendKeys(data.get(i));
			searchBox.clear();
		}
		
		driver.close();

	}

}
