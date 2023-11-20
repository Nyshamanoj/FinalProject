package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	//static ExtentReports extent;
	public static ExtentReports createExtentReports()
	{
		String path =System.getProperty("user.dir")+"\\extent-reports\\extent-report.html";
		//path of the report
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);//create object
		reporter.config().setReportName("Web Automation Results");//title when we open extent-report.html
		reporter.config().setDocumentTitle("Test Results");//title of the tab when we open extent-report.html

		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);// to attach the path of the report

		return extent;
	}
}