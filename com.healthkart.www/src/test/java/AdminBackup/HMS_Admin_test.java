package AdminBackup;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HMS_Admin_test {
	
	public static WebDriver driver; 
	public static void main(String[] args) throws IOException {
			FileInputStream fiS1 = new FileInputStream("./src/test/resources/Credentials.properties");
			Properties prop = new Properties();
			prop.load(fiS1);
			
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
		}
	}

