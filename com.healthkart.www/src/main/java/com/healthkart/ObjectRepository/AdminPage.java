package com.healthkart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import net.bytebuddy.asm.Advice.This;

public class AdminPage {

		//Declaration
		@FindBy(xpath = "//h3[.='Admin Login']/..//a")
		private WebElement AdminLoginLink;
		
		@FindBy(xpath = "//input[@placeholder='Username']")
		private WebElement UsernameTxb;
		
		@FindBy(xpath = "//input[@placeholder='Password']")
		private WebElement PasswordTxb;
		
		@FindAll({@FindBy(xpath = "//button[@type='submit']"),@FindBy(xpath = "//input[@value='Login']")})
		private WebElement LoginBtnClk;
		
		//Initialization
		public AdminPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		//Utilization
		public WebElement getAdminLoginLink()
		{
			return AdminLoginLink;
		}
		public WebElement getUsernameTxb()
		{
			return UsernameTxb;
		}

		public WebElement getPasswordEdtTxt() 
		{
			return PasswordTxb;
		}

		public WebElement getLoginBtnClk() 
		{
			return LoginBtnClk;
		}
		//Business libraries
		/**
		 * login to application with username and password and click on save btn
		 * @param raj
		 * @param password
		 * @throws InterruptedException 
		 */
		public void loginToHMSApp(String Un,String Pwd) throws InterruptedException
		{
			Thread.sleep(2000);
			AdminLoginLink.click();
			Thread.sleep(2000);
			UsernameTxb.sendKeys(Un);
			PasswordTxb.sendKeys(Pwd);
			LoginBtnClk.click();
		}
}