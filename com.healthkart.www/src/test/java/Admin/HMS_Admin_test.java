package Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.healthkart.ObjectRepository.AdminPage;

import genericUtility.BaseClass;
import genericUtility.DatabaseUtility;
import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class HMS_Admin_test extends BaseClass{
	
	
		@Test
		public void adminLogin() throws IOException, InterruptedException {
			
			String Un = Futil.readDataFromPropertyFile("username");
			String Pwd = Futil.readDataFromPropertyFile("password");
			AdminPage adminPage = new AdminPage(driver);	
			Thread.sleep(2000);
			adminPage.loginToHMSApp(Un, Pwd);
	}
}




////////////////////////////

//FileUtility Futil=new FileUtility();
//ExcelUtility Eutil = new ExcelUtility();
//JavaUtility Jutil = new JavaUtility();
//WebDriverUtility WDUtil = new WebDriverUtility();
//DatabaseUtility DbUtil = new DatabaseUtility();
//
//String Browse = Futil.readDataFromPropertyFile("browser");
//String Url = Futil.readDataFromPropertyFile("url");
//	
//	if(Browse.equalsIgnoreCase("chrome"))
//	{
//		driver=new ChromeDriver();
//		WDUtil.maximizeWindow(driver);
//		WDUtil.ImplicitWait(driver, 10);
//	}
//	else if(Browse.equalsIgnoreCase("Firefox"))
//	{
//		driver=new FirefoxDriver();
//		WDUtil.maximizeWindow(driver);
//		WDUtil.ImplicitWait(driver, 10);
//	}
//	else {
//		System.out.println("--Invalid_Browser--");
//	}
//	WDUtil.get(driver, Url);