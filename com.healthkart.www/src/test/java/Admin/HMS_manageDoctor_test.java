package Admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Test;

import com.healthkart.ObjectRepository.AdminLogoutPage;
import com.healthkart.ObjectRepository.AdminPage;
import com.healthkart.ObjectRepository.DoctorDashboardPage;
import com.healthkart.ObjectRepository.ManageDoctorPage;

import genericUtility.BaseClass;

public class HMS_manageDoctor_test extends BaseClass {
		@Test
		public void manageDoctor() throws IOException, InterruptedException {
		
		AdminPage adminPage = new AdminPage(driver);	
		adminPage.loginToHMSApp(Futil.readDataFromPropertyFile("username"), Futil.readDataFromPropertyFile("password"));
		
		Random ran = new Random();
		int r=ran.nextInt(1000);
		String rd=r+"value5";

		//Add Doctors
			String value1 = Eutil.readDataFromExcel("Doctor", 1, 0);
			String value2 = Eutil.readDataFromExcel("Doctor", 1, 1);
			String value3 = Eutil.readDataFromExcel("Doctor", 1, 2);
			String value4 = Eutil.readDataFromExcel("Doctor", 1, 3);
			String value5 = WDUtil.getRandomNumber()+ Eutil.readDataFromExcel("Doctor", 1, 4);
			String value6 = Eutil.readDataFromExcel("Doctor", 1, 5);
			String value7 = Eutil.readDataFromExcel("Doctor", 1, 6);
				
			//Manage doctors- edit details
			Thread.sleep(2000);
			ManageDoctorPage manageDoctorPage = new ManageDoctorPage(driver);
			manageDoctorPage.EditDoctorDetails(WDUtil, "General Physician", value1, value2, value3, value4, value5, value6, value7);
			WDUtil.acceptAlert(driver);
			
			//Back to Doctors dash board
			Thread.sleep(2000);
			String value8 = Eutil.readDataFromExcel("Doctor", 1, 7);
			DoctorDashboardPage doctorDashboardPage = new DoctorDashboardPage(driver);
			doctorDashboardPage.DoctorDashboard(value8);
			
			//Admin Logout
			Thread.sleep(3000);
			AdminLogoutPage adminLogoutPage = new AdminLogoutPage(driver);
			adminLogoutPage.aLogout();			
	}
}
////////////////////////////////////////////////
//FileUtility Futil=new FileUtility();
//ExcelUtility Eutil = new ExcelUtility();
//JavaUtility Jutil = new JavaUtility();
//WebDriverUtility WDUtil = new WebDriverUtility();
//DatabaseUtility DbUtil = new DatabaseUtility();
//
//Random ran = new Random();
//int r=ran.nextInt(100);
//String rd=r+"value5";
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

//String Un = Futil.readDataFromPropertyFile("username");
//String Pwd = Futil.readDataFromPropertyFile("password");
//	AdminPage adminPage = new AdminPage(driver);	
//	adminPage.loginToHMSApp(Un, Pwd);
