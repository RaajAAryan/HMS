package AdminBackup;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;

public class HMS_manageDoctor_test {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
			FileInputStream fiS1 = new FileInputStream("./src/test/resources/Credentials.properties");
			Properties prop = new Properties();
			prop.load(fiS1);
			
			Random ran = new Random();
			int r=ran.nextInt(100);
			String rd=ran+"value5";
			
			String Browse = prop.getProperty("browser");
			String Url = prop.getProperty("url");
			String Un = prop.getProperty("username");
			String Pwd = prop.getProperty("password");
			
			if(Browse.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
			}
			else if(Browse.equalsIgnoreCase("Firefox"))
			{
				driver=new FirefoxDriver();
			}
			else {
				System.out.println("--Invalid_Browser--");
			}
			driver.get(Url);
			driver.findElement(By.xpath("//h3[.='Admin Login']/..//a")).click();
			driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(Un);
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		
			//Add Doctors
			driver.findElement(By.xpath("//span[.=' Doctors ']/following-sibling::i[@class='icon-arrow']")).click();
			driver.findElement(By.xpath("//a[@href='add-doctor.php']")).click();
			
//			Enter all necessary details of Doctor for f0r registration
			WebElement DropDown = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
			DropDown.click();
			Select s = new Select(DropDown);
			s.selectByValue("General Physician");
			FileInputStream fis2 = new FileInputStream("./src/test/resources/AllTC.xlsx");
			Workbook wb = WorkbookFactory.create(fis2);
			Sheet D1 = wb.getSheet("Doctor");
			String value1 = D1.getRow(1).getCell(0).getStringCellValue();
			driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Name']")).sendKeys(value1);
			String value2 = D1.getRow(1).getCell(1).getStringCellValue();
			driver.findElement(By.xpath("//textarea[@placeholder='Enter Doctor Clinic Address']")).sendKeys(value2);
			String value3 = D1.getRow(1).getCell(2).getStringCellValue();
			driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Consultancy Fees']")).sendKeys(value3);
			String value4 = D1.getRow(1).getCell(3).getStringCellValue();
			driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Contact no']")).sendKeys(value4);
			String value5 = D1.getRow(1).getCell(4).getStringCellValue();
			driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Email id']")).sendKeys(value5);
			String value6 = D1.getRow(1).getCell(5).getStringCellValue();
			driver.findElement(By.xpath("//input[@placeholder='New Password']")).sendKeys(value6);
			String value7 = D1.getRow(1).getCell(6).getStringCellValue();
			driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(value7);
			//Handling Popup
			WebElement alertPop = driver.findElement(By.xpath("//button[@id='submit']"));
			alertPop.click();
			Alert Up = driver.switchTo().alert();
			Up.accept();
			
			//Back to Doctors dash board
			driver.findElement(By.xpath("//a[@href='dashboard.php']")).click();
			//Manage doctors- edit details
			driver.findElement(By.xpath("//a[@href='manage-doctors.php']")).click();
			driver.findElement(By.xpath("//a[@href='edit-doctor.php?id=1515']")).click();
			String value8 = D1.getRow(1).getCell(7).getStringCellValue();
			driver.findElement(By.xpath("//input[@name='docemail']")).sendKeys(value8);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			//Admin Logout
			driver.findElement(By.xpath("//span[@class='username']")).click();
			driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	}
}
