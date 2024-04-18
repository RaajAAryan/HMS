package genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.healthkart.ObjectRepository.AdminLogoutPage;

public class BaseClass {

	public FileUtility Futil=new FileUtility();
	public ExcelUtility Eutil = new ExcelUtility();
	public JavaUtility Jutil = new JavaUtility();
	public WebDriverUtility WDUtil = new WebDriverUtility();
	public DatabaseUtility DbUtil = new DatabaseUtility();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
//	@BeforeSuite(alwaysRun= true)
//	public void connectToDB() throws Throwable
//	{
//	DbUtil.connectingDB();
//	Reporter.log("Database connection established...", true);
//	}//As we dont require database connection to run HMS application,
	//becasue the test data is present in property file and excel file.
	
	//@Parameters("browser")
	@BeforeClass(alwaysRun= true)
	public void launchBrowser() throws Throwable
	{
		String Browse = Futil.readDataFromPropertyFile("browser");
		
		if(Browse.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			Reporter.log("---Launched browser...", true);
			}
		else if(Browse.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
			Reporter.log("---Launched browser...", true);
			
		}
		else if(Browse.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			Reporter.log("---Launched browser...", true);
			
		}
		else {
			Reporter.log("---invalid browser...", true);
		}
		
		sdriver = driver;
		WDUtil.maximizeWindow(driver);
		WDUtil.waitForPageLoad(driver, 10);
	}
	@AfterClass(alwaysRun= true)
	public void closeBrowser()
	{
		WDUtil.quit(driver);
		Reporter.log("---Close the Browser...", true);
	}

	@BeforeMethod(alwaysRun= true)
	public void AppHomePage() throws Throwable
	{
		String Url = Futil.readDataFromPropertyFile("url");
		WDUtil.get(driver, Url);
		Reporter.log("---Welcome to Homepage...", true);
	}

		@AfterMethod(alwaysRun= true)
		public void LogOutFromApp()
		{
			AdminLogoutPage adminLogoutPage = new AdminLogoutPage(driver);
			adminLogoutPage.aLogout();
			Reporter.log("---Loggged out successfully...", true);
		}
		//@AfterSuite(alwaysRun= true)
//		public void closeDBconnection() throws Throwable 
//		{
//		DbUtil.closeDB();	
//		Reporter.log("--Close Database Connection");
//		}
}