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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.healthkart.ObjectRepository.AddPatientDetailsPage;
import com.healthkart.ObjectRepository.AddPatientPage;
import com.healthkart.ObjectRepository.DoctorLoginPage;
import com.healthkart.ObjectRepository.ManagePatientsPage;
import com.healthkart.ObjectRepository.PMedicalHistoryPage;
import com.healthkart.ObjectRepository.ViewPatientsPage;

import genericUtility.DatabaseUtility;
import genericUtility.ExcelUtility;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

public class HMS_DoctorLogin_test {
	public static WebDriver driver;
	
	@Test
		public void doctorLogin() throws IOException, InterruptedException {
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
			String value1 = Eutil.readDataFromExcel("Doctor", 2, 0);
			String value2 = Eutil.readDataFromExcel("Doctor", 2, 1);
			DoctorLoginPage doctorLoginPage = new DoctorLoginPage(driver);
			doctorLoginPage.DocLogin(value1, value2);
		
		
		//Add Patient
			AddPatientPage addPatientPage = new AddPatientPage(driver);
			addPatientPage.addPatientNvgn();
		
		//Enter all the required details to create patient profile.
		Thread.sleep(3000);
		String value4 = Eutil.readDataFromExcel("Patient", 1, 0);
		String value5 = Eutil.readDataFromExcel("Patient", 1, 1);
		String value6 = Eutil.readDataFromExcel("Patient", 1, 2);
		Thread.sleep(3000);
		String value7 = Eutil.readDataFromExcel("Patient", 1, 3);
		String value8 = Eutil.readDataFromExcel("Patient", 1, 4);
		String value9 = Eutil.readDataFromExcel("Patient", 1, 5);
		Thread.sleep(3000);
		AddPatientDetailsPage addPatientDetailsPage = new AddPatientDetailsPage(driver);
		addPatientDetailsPage.EnterDetails(value4, value5, value6, value7, value8, value9);
		
		//Manage Patients
		Thread.sleep(3000);
		String value10 = Eutil.readDataFromExcel("Patient", 1, 6);
		ManagePatientsPage managePatientsPage = new ManagePatientsPage(driver);
		managePatientsPage.mangPatient(value10);
		
		//View Patients
		Thread.sleep(3000);
		ViewPatientsPage viewPatientsPage = new ViewPatientsPage(driver);
		viewPatientsPage.ViewPatient();
		
		//Medical History
		Thread.sleep(3000);
		String value11 = Eutil.readDataFromExcel("Patient", 1, 7);
		String value12 = Eutil.readDataFromExcel("Patient", 2, 7);
		String value13 = Eutil.readDataFromExcel("Patient", 3, 7);
		String value14 = Eutil.readDataFromExcel("Patient", 4, 7);
		String value15 = Eutil.readDataFromExcel("Patient", 5, 7);
		
		PMedicalHistoryPage pMedicalHistoryPage = new PMedicalHistoryPage(driver);
		pMedicalHistoryPage.MedicalHistory(value11, value12, value13, value14, value15);
		WDUtil.acceptAlert(driver);	
	}

}