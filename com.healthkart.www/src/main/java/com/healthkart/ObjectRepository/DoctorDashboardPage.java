package com.healthkart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage {

	//Declaration
	@FindBy(xpath = "//a[@href='dashboard.php']")
	private WebElement DoctorsDashboard;
				
	@FindBy(xpath ="//a[@href='manage-doctors.php']")
	private WebElement ManageDoctorsLink;

	@FindBy(xpath="//tbody//tr[last()]//i[@class='fa fa-pencil']/..")
	private WebElement EditDoctorsLink;

	@FindBy(xpath="//input[@name='docemail']")
	private WebElement EditDoctorsEmail;

	@FindBy(xpath="//button[@name='submit']")
	private WebElement UpdateBtn;

	//Initialization
			public DoctorDashboardPage(WebDriver driver)
			{
				PageFactory.initElements(driver,this);
			}
	
	//Utilization
			public WebElement getDoctorsDashboard()
			{
				return DoctorsDashboard;
			}
			
			public WebElement getManageDoctorsLink()
			{
				return ManageDoctorsLink;
			}
			
			public WebElement getEditDoctorsLink()
			{
				return EditDoctorsLink;
			}
			
			public WebElement getEditDoctorsEmail()
			{
				return EditDoctorsEmail;
			}
			
			public WebElement getUpdateBtn()
			{
				return UpdateBtn;
			}
	//Business libraries
			/**
			 * @param value8=email
			 */
	
	public void DoctorDashboard(String value8)
	{
	DoctorsDashboard.click();
	ManageDoctorsLink.click();
	EditDoctorsLink.click();
	EditDoctorsEmail.sendKeys(value8);
	UpdateBtn.click();
	}
}

