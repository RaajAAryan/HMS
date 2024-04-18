package Admin;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.healthkart.ObjectRepository.AdminPage;
import com.healthkart.ObjectRepository.DoctorDashboardPage;
import com.healthkart.ObjectRepository.ManageDoctorPage;

import genericUtility.BaseClass;
@Listeners(genericUtility.ListImpClass.class)
class AdminRun_1Test extends BaseClass {

		@Test(retryAnalyzer = genericUtility.RetryImpClass.class)
		public void adminLogin() throws IOException, InterruptedException{
			
			String Un = Futil.readDataFromPropertyFile("username");
			String Pwd = Futil.readDataFromPropertyFile("password");
			AdminPage adminPage = new AdminPage(driver);
			Thread.sleep(2000);
			adminPage.loginToHMSApp(Un, Pwd);
			//Assert.fail();
	}
		
		@Test
		//(retryAnalyzer = genericUtility.RetryImpClass.class)
		public void manageDoctor() throws EncryptedDocumentException, IOException, InterruptedException{
		
		AdminPage adminPage = new AdminPage(driver);	
		adminPage.loginToHMSApp(Futil.readDataFromPropertyFile("username"), Futil.readDataFromPropertyFile("password"));
			
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
//			Thread.sleep(3000);
//			AdminLogoutPage adminLogoutPage = new AdminLogoutPage(driver);
//			adminLogoutPage.aLogout();			
		}
}
