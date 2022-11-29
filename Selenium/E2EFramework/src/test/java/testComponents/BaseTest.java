package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver ;
	public LandingPage lp;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
		
	}
	
	public List<HashMap<String,String>> getJsonData(String filePath) throws IOException
	{
		String jsoncontent = FileUtils.readFileToString(new File(filePath),
				StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> hm = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){
				
			
				
		});
		return hm;
	}
	
	
	public   String getScreenShot(String testcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot  ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") +"//reports"+testcaseName+".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir") +"//reports//"+testcaseName+".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApp() throws IOException
	{
		driver= initializeDriver();
		lp = new LandingPage(driver);

		lp.goTo();
		return lp;

		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}

}
