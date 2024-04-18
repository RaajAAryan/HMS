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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HMS_DoctorLogin_test {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
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
		
		//Doctor Login
		driver.findElement(By.xpath("//a[@href='hms/doctor/']")).click();
		//driver.switchTo().window(Url)
		FileInputStream fis2 = new FileInputStream("./src/test/resources/AllTC.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis2);
		Sheet D2 = wb1.getSheet("Doctor");
		String value1 = D2.getRow(2).getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(value1);
		String value2 = D2.getRow(2).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(value2);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Add Patient
		driver.findElement(By.xpath("//span[contains(text(),'Patients')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),' Add Patient')]")).click();
		
		//Enter all the required details to create patient profile.
		FileInputStream fis3 = new FileInputStream("./src/test/resources/AllTC.xlsx");
		Workbook wb2 = WorkbookFactory.create(fis3);
		Sheet D3 = wb2.getSheet("Patient");
		String value4 = D3.getRow(1).getCell(0).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Name']")).sendKeys(value4);
		String value5 = D3.getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Contact no']")).sendKeys(value5);
		String value6 = D3.getRow(1).getCell(2).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Email id']")).sendKeys(value6);
		driver.findElement(By.xpath("//label[@for='rg-male']")).click();
		Thread.sleep(3000);
		String value7 = D3.getRow(1).getCell(3).getStringCellValue();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Patient Address']")).sendKeys(value7);
		String value8 = D3.getRow(1).getCell(4).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Age']")).sendKeys(value8);
		String value9 = D3.getRow(1).getCell(5).getStringCellValue();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Patient Medical History(if any)']")).sendKeys(value9);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		driver.findElement(By.xpath("//a[@href='dashboard.php']")).click();
		
		//Manage Patients
		driver.findElement(By.xpath("//span[contains(text(),'Patients')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Manage Patient')]")).click();
		driver.findElement(By.xpath("//a[@href='edit-patient.php?editid=881']")).click();
		String value10 = D3.getRow(1).getCell(6).getStringCellValue();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Patient Medical History(if any)']")).sendKeys(value10);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		driver.findElement(By.xpath("//a[@href='dashboard.php']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Patients')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Manage Patient')]")).click();
		driver.findElement(By.xpath("//a[@href='view-patient.php?viewid=881']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary waves-effect waves-light w-lg']")).click();
		
		String value11 = D3.getRow(1).getCell(7).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Blood Pressure']")).sendKeys(value11);
		String value12 = D3.getRow(2).getCell(7).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='bs']")).sendKeys(value12);
		String value13 = D3.getRow(3).getCell(7).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='Weight']")).sendKeys(value13);
		String value14 = D3.getRow(4).getCell(7).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='temp']")).sendKeys(value14);
		String value15 = D3.getRow(5).getCell(7).getStringCellValue();
		driver.findElement(By.xpath("//textarea[@name='pres']")).sendKeys(value15);
		WebElement popup = driver.findElement(By.xpath("//button[@name='submit']"));
		popup.click();
		Alert Up = driver.switchTo().alert();
		Up.accept();
	}

}