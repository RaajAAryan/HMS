package genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		/**
		 * This method is used to maximize window
		 * @param driver
		 */		
	}
	
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
		/**
		 * This method is used to minimize window
		 * @param driver
		 */
	}
	
	public void navigateToWindow(WebDriver driver, String url) {
		driver.navigate().to(url);
		/**
		 * This method is trigger the url
		 * @param driver
		 * @param url
		 */
	}
	public void get(WebDriver driver, String url) {
		driver.get(url);
		/**
		 * This method is trigger the url
		 * @param driver
		 * @param url
		 */
	}
	public void close(WebDriver driver) {
		driver.close();
	}
	
	public void quit(WebDriver driver) {
		driver.quit();
	}
	
	public void navigateRefreshWindow(WebDriver driver) {
		driver.navigate().refresh();
		/**
		 * This method is used to refresh the page
		 * @param driver
		 */
	}
	
	public void navigateBackWindow(WebDriver driver) {
		driver.navigate().back();
		/**
		 * This method is used to go back to the previous window
		 * @param driver
		 */
	}
	
	public void navigateForwardWindow(WebDriver driver) {
		driver.navigate().forward();
		/**
		 * This method is used to move forward to next window
		 * @param driver
		 */
	}
	
	public int getRandomNumber()
	{
		Random ranNum= new Random();
		int num = ranNum.nextInt();
		return num;
	}
	public void ImplicitWait(WebDriver driver, int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/**
		 * This method is used to pass wait condition implicit wait
		 * @param driver
		 * @param sec
		 */
	}
	
	public void waitForPageLoad(WebDriver driver, int sec) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
		/**
		 * This method is used to pass wait condition pageLoadTimeout wait
		 * @param driver
		 * @param sec
		 */
	}
	
	public void waitUntilElementToBeVisisble(WebDriver driver, int sec, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
		/**
		 * This method is used to pass wait condition Explicit wait
		 * @param driver
		 * @param sec
		 * @param element
		 */
	}
	
	public void waitUntilElementToBeClickable(WebDriver driver, int sec, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		/**
		 * This method is used to pass wait condition Explicit wait
		 * @param driver
		 * @param sec
		 * @param element
		 */
	}
	
	public void waitUntilToGetTitle(WebDriver driver, int sec, String Title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.titleContains(Title));
		/**
		 * This method is used to pass wait condition Explicit wait
		 * @param driver
		 * @param Title
		 */

	}
	
	public void handleDropdown(WebElement element, String text) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
		/**
		 * This method is used to handle dropdown selectByVisibleText()
		 * @param driver
		 * @param text
		 */

	}
	
	public void handleDropdown(int Index, WebElement element) {
		Select s=new Select(element);
		s.selectByIndex(Index);
		/**
		 * This method is used to handle dropdown selectByindex()
		 * @param driver
		 * @param element
		 */

	}
	
	public void handleDropdown(String value, WebElement element) {
		Select s=new Select(element);
		s.selectByValue(value);
		/**
		 * This method is used to handle dropdown selectByValue()
		 * @param driver
		 * @param element
		 */
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
		/**
		 * This method is used to perform click action using Action class
		 * @param driver
		 * @param element
		 */
	}
	
	public void dragAnddrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();
		/**
		 * This method is used to DragandDrop of web elements using Action class
		 * @param driver
		 * @param element src
		 * @param element dest
		 */
	}
	
	public void dragAnddrop(WebDriver driver, WebElement element, int x, int y) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(element, x, y).perform();
		/**
		 * This method is used to dragANDdrop web elements
		 * @param driver
		 * @param element 
		 * @param x
		 * @param y
		 */
	}
	
	public void contextClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		/**
		 * This method is used to rightClick action on web elements
		 * @param driver
		 * @param element 
		*/
	}
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
		/**
		 * This method is used to doubleClick action on web elements
		 * @param driver
		 * @param element 
		*/
	}
	
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
		/**
		 * This method is used to clickAndHold action on web elements
		 * @param driver
		 * @param element 
		*/
	}
	
	public void moveToElement(WebDriver driver, WebElement element, int x, int y) {
		Actions act=new Actions(driver);
		act.moveToElement(element, x, y).perform();
		/**
		 * This method is used to moveToElement action on web elements
		 * @param driver
		 * @param element 
		 * @param x
		 * @param y
		*/
	}
	
	public void keyPress(WebDriver driver) {
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	 
	public void switchToWindow(WebDriver driver, String expWindow) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			String currentTitle = driver.switchTo().window(win).getTitle();
	
			if(currentTitle.contains(expWindow))
			{
				break;
			}
		}
	}
	
//	public String getScreenShotAs(WebDriver driver,String ScreenshotName) throws IOException {
//		TakesScreenshot tss=(TakesScreenshot) driver;
//		File src = tss.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./ScreenShots"+ScreenshotName+".png");
//		String srcPath = dest.getAbsolutePath();
//		FileUtils.copyFile(src, dest);
//		return srcPath;
//	}
	
	public static String getScreenShot(WebDriver driver,String ScreenshotName) throws Throwable {
		//listener implementation
		JavaUtility JUtils=new JavaUtility();
		TakesScreenshot tss=(TakesScreenshot) driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		String path="./ScreenShots/"+ScreenshotName+" "+JUtils.getSystemDateinFormat()+".png";
		File dest = new File(path);
		String srcPath = dest.getAbsolutePath();
		FileUtils.copyFile(src, dest);
		return srcPath;
	}	

	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,800)", "");
	}
	/**
	 * This method will scroll until specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
	}
	public void scrollTillBottom(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}
	/**
	 * scroll till element to be visible
	 * @param driver
	 * @param element
	 */
	public void scrollTillElementToBeVisible(WebDriver driver, WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()",element);
	}
	
	public void clickOnElement(WebDriver driver, WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click",element);
	}
	
	public void jseUsingSendKeys(WebDriver driver, WebElement element, String expData) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value=arguments[1]",element, expData);
	}
	
	public void scrollUpTillElementToBeVisible(WebDriver driver, WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		Point loc = element.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	public Robot robotObj() throws AWTException {
		Robot rb=new Robot();
		return rb;
	}
	/**
	 * this method will press Enter key
	 * @param driver
	 * @param index
	 * @throws AWTException 
	 */
	public void enterKey(WebDriver driver) throws AWTException {
		robotObj().keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterRelease(WebDriver driver) throws AWTException {
		robotObj().keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to cancel alert popup
	 * @param driver
	 */
	public void cencelAlert(WebDriver driver ) {
		driver.switchTo().alert().dismiss();
	}
	
}

