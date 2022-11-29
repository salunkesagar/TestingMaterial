package ETEProject.TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class base {
	
	public String URI() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\RestAPI\\TestNG\\src\\main\\java\\data.properties");
		prop.load(fis);
		String str = prop.getProperty("baseURI");
		return str;
		
		
	}

}
