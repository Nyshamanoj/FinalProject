package generaltest;




	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;

import test.BaseTest;
import utility.ExtendReportUtility;
	



	public class Listener extends BaseTest implements ITestListener //Listener extends BaseTest and implements a Listener class called ITestListener and it is already known  interface
	//Listener is a  classes that implement specific interfaces in order to track events that occur during the execution of Selenium tests
	
	{
	ExtentTest test;

	ExtentReports extent=ExtendReportUtility.createExtentReports();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();



	public void onTestStart(ITestResult result) {
	
	ITestListener.super.onTestStart(result);
	test =extent.createTest(result.getMethod().getMethodName());
	extentTest.set(test);

	}

	public void onTestSuccess(ITestResult result) {
	
	ITestListener.super.onTestSuccess(result);
	extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
	
	ITestListener.super.onTestFailure(result);
	extentTest.get().log(Status.FAIL, "Test Failed");
	extentTest.get().fail(result.getThrowable());//it shows what the error is.
	

	}

	public void onTestSkipped(ITestResult result) {
	ITestListener.super.onTestSkipped(result);
	extentTest.get().log(Status.SKIP, "Test Skipped");

	}



	public void onFinish(ITestContext context) {

	ITestListener.super.onFinish(context);
	extent.flush(); //used to erase any previous data on report & create new report
	}


	}


