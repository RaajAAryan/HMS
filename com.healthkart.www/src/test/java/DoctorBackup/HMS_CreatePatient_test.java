package DoctorBackup;

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

public class HMS_CreatePatient_test {
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

		driver.findElement(By.xpath("//a[@href='hms/user-login.php']")).click();
		driver.findElement(By.xpath("//a[@href='registration.php']")).click();
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/AllTC.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet D1 = wb.getSheet("CreatePatient");
		String value1 = D1.getRow(2).getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys(value1);
		String value2 = D1.getRow(2).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys(value2);
		String value3 = D1.getRow(2).getCell(2).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys(value3);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[@for='rg-female']")).click();
		String value4 = D1.getRow(2).getCell(3).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(value4);
		Thread.sleep(1000);
		String value5 = D1.getRow(2).getCell(4).getStringCellValue();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(value5);
		String value6 = D1.getRow(2).getCell(5).getStringCellValue();
		driver.findElement(By.xpath("//input[@id='password_again']")).sendKeys(value6);
		driver.findElement(By.xpath("//label[@for='agree']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Alert popup = driver.switchTo().alert();
		popup.accept();
	}

}
