package SeleniumPractise.RelativeLocator;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sagar Salunke\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW	);
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		driver.get("https://rahulshettyacademy.com/");
		String course =	driver.findElements(By.cssSelector("a[href*= 'https://courses.rahulshettyacademy.com/p']")).get(1).getText();	
		driver.switchTo().window(parent);
		WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
		name.sendKeys(course);
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		
		//To get Height and Width of Web Element
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		driver.quit();
		
		
		
	}

}
