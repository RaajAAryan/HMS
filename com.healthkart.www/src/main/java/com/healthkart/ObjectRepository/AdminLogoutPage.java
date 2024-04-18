package com.healthkart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLogoutPage {
	//Declaration
	@FindBy(xpath="//i[@class='ti-angle-down']/..")
	private WebElement UserLookupIcon;

	@FindBy(xpath="//a[contains(text(),'Log Out')]/..")
	private WebElement AdminLogoutBtn;
	
	//Initialization
			public AdminLogoutPage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
	
	//Utilization
			public WebElement getUserLookupIcon()
			{
				return UserLookupIcon;
			}

			public WebElement getAdminLogoutBtn()
			{
				return AdminLogoutBtn;
			}
	//Business libraries
			/**
			 * 
			 */
			public void aLogout() 
			{
			UserLookupIcon.click();
			AdminLogoutBtn.click();
			}
}
