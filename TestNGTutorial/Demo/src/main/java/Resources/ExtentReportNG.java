package Resources;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	public static ExtentReports extent;
	
	public  static ExtentReports configExtent() 
	{
		String path = System.getProperty("user.dir") + "\\reports.index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("API Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "Sagar Salunke");
		return extent;
		
		
	 
 }
}
