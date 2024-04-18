package PatientBackup;

import java.awt.Robot;
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
import org.openqa.selenium.support.ui.Select;

public class HMS_PatientLogin_test {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fiS = new FileInputStream("./src/test/resources/Credentials.properties");
		Properties prop = new Properties();
		prop.load(fiS);
		
		String Browse = prop.getProperty("browser");
		String Url = prop.getProperty("url");
		
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
		//Patient Login
		driver.findElement(By.xpath("//a[@href='hms/user-login.php']")).click();
		FileInputStream fis1 = new FileInputStream("./src/test/resources/AllTC.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet D1 = wb.getSheet("CreatePatient");
		String value1 = D1.getRow(2).getCell(3).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(value1);
		String value2 = D1.getRow(2).getCell(4).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(value2);
		driver.findElement(By.xpath("//button[@class='btn btn-primary pull-right']")).click();
		
		//Book Appointments
		driver.findElement(By.xpath("//h2[contains(text(),'Book My Appointment')]/following::a[@href='book-appointment.php']")).click();
		WebElement drop1 = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
		Select s1 = new Select(drop1);
		s1.selectByValue("General Doctor");
		
		WebElement drop2 = driver.findElement(By.xpath("//select[@onchange='getfee(this.value);']"));
		drop2.click();
		Select s2 = new Select(drop2);
		s2.selectByValue("1477");
		String value3 = D1.getRow(2).getCell(6).getStringCellValue();
		
		driver.findElement(By.xpath("//input[@class='form-control datepicker']")).sendKeys(value3);
		String value4 = D1.getRow(2).getCell(7).getStringCellValue();
		driver.findElement(By.xpath("//input[@id='timepicker1']")).sendKeys(value4);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		Alert popup = driver.switchTo().alert();
		popup.accept();
		
		
		
		
		
		


	}

}
