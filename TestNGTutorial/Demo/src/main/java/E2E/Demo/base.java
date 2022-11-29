package E2E.Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class base {
	
	public String getURI() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\TestNGTutorial\\Demo\\src\\main\\java\\data.properties");
		prop.load(fis);
		String str = prop.getProperty("uri");
		return str;
		
		
	}
}
