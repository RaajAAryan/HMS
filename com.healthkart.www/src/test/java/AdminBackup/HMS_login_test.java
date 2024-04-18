package AdminBackup;

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

public class HMS_login_test {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
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
	}	
}
