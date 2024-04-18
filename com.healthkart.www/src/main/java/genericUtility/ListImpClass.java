package genericUtility;

import java.util.Random;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListImpClass implements ITestListener {
	ExtentReports reports;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
	
		String MethodName = result.getMethod().getMethodName();
		test=reports.createTest(MethodName);
		Reporter.log("execution starts from here", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName);
		Reporter.log(MethodName+"---executed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	String MethodName = result.getMethod().getMethodName();
	try {
		String screenshot = WebDriverUtility.getScreenShot(BaseClass.sdriver, MethodName);
		test.log(Status.FAIL, MethodName+"----failed");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(screenshot);
		Reporter.log(MethodName+"--Failed");
		
	}catch(Throwable e)
	{
		e.printStackTrace();
	}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"---Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+"---Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/Report"+new JavaUtility().getSystemDateinFormat()+".html");
		htmlReport.config().setDocumentTitle("Hospital Management System");
		htmlReport.config().setReportName("HMS_Reports");
		htmlReport.config().setTheme(Theme.DARK);
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base-Platform", "windows");
		reports.setSystemInfo("Base-Browser", "chrome");
		reports.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Hospital_Management_System/");
		reports.setSystemInfo("ReporterName", "Raj-AAryan");
	}
	
	@Override
	public void onFinish(ITestContext context) {
	reports.flush();
	}

}
