package Admin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.DatabaseUtility;
import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class HMS_login_test extends BaseClass{

		@Test
		public void LoginToApp() throws IOException {	
			
		}	
}



















//		FileUtility Futil=new FileUtility();
//		ExcelUtility Eutil = new ExcelUtility();
//		JavaUtility Jutil = new JavaUtility();
//		WebDriverUtility WDUtil = new WebDriverUtility();
//		DatabaseUtility DbUtil = new DatabaseUtility();
//		
//		String Browse = Futil.readDataFromPropertyFile("browser");
//		String Url = Futil.readDataFromPropertyFile("url");
//		
//		if(Browse.equalsIgnoreCase("chrome"))
//		{
//			driver=new ChromeDriver();
//			WDUtil.maximizeWindow(driver);
//			WDUtil.waitForPageLoad(driver, 10);
//			}
//		else if(Browse.equalsIgnoreCase("Firefox"))
//		{
//			driver=new FirefoxDriver();
//			
//		}
//		else {
//			System.out.println("--Invalid_Browser--");
//		}
//		WDUtil.get(driver, Url);
//	}	
//}