package Doctor;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.healthkart.ObjectRepository.CreatePatientPage;

import genericUtility.DatabaseUtility;
import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class HMS_CreatePatient_test {
	public static WebDriver driver;
	
	@Test
		
		public void createPatient() throws IOException, InterruptedException {
		FileUtility Futil=new FileUtility();
		ExcelUtility Eutil = new ExcelUtility();
		JavaUtility Jutil = new JavaUtility();
		WebDriverUtility WDUtil = new WebDriverUtility();
		DatabaseUtility DbUtil = new DatabaseUtility();
		
		String Browse = Futil.readDataFromPropertyFile("browser");
		String Url = Futil.readDataFromPropertyFile("url");
		String Un = Futil.readDataFromPropertyFile("username");
		String Pwd = Futil.readDataFromPropertyFile("password");
			
			if(Browse.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
				WDUtil.maximizeWindow(driver);
				WDUtil.ImplicitWait(driver, 10);
			}
			else if(Browse.equalsIgnoreCase("Firefox"))
			{
				driver=new FirefoxDriver();
				WDUtil.maximizeWindow(driver);
				WDUtil.ImplicitWait(driver, 10);
			}
			else {
				System.out.println("--Invalid_Browser--");
			}
			WDUtil.get(driver, Url);
		
		String value1 = Eutil.readDataFromExcel("CreatePatient", 3, 0);
		String value2 = Eutil.readDataFromExcel("CreatePatient", 3, 1);
		String value3 = Eutil.readDataFromExcel("CreatePatient", 3, 2);
		Thread.sleep(1000);
		String value4 = Eutil.readDataFromExcel("CreatePatient", 3, 3);
		Thread.sleep(1000);
		String value5 = Eutil.readDataFromExcel("CreatePatient", 3, 4);
		String value6 = Eutil.readDataFromExcel("CreatePatient", 3, 5);
		//driver.findElement(By.xpath("//label[@for='agree']")).click();
		Thread.sleep(1000);
		CreatePatientPage createPatientPage = new CreatePatientPage(driver);
		createPatientPage.createPat(value1, value2, value3, value4, value5, value6);
		WDUtil.acceptAlert(driver);
	}

}
