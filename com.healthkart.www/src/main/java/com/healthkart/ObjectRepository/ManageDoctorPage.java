package com.healthkart.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class ManageDoctorPage {
	
	//declaration
	@FindBy(xpath = "//span[.=' Doctors ']/following-sibling::i[@class='icon-arrow']")
	private WebElement DoctorsNvgn;

	@FindBy(xpath = "//a[@href='add-doctor.php']")
	private WebElement AddDoctorsLink;

	@FindBy(xpath = "//select[@name='Doctorspecialization']")
	private WebElement SplDropDown;

	@FindBy(xpath = "//input[@placeholder='Enter Doctor Name']")
	private WebElement EnterDoctorName;

	@FindBy(xpath = "//textarea[@placeholder='Enter Doctor Clinic Address']")
	private WebElement EnterClinicAddress;

	@FindBy(xpath = "//input[@placeholder='Enter Doctor Consultancy Fees']")
	private WebElement EnterConsutationfees;

	@FindBy(xpath = "//input[@placeholder='Enter Doctor Contact no']")
	private WebElement EnterContactNo;

	@FindBy(xpath = "//input[@placeholder='Enter Doctor Email id']")
	private WebElement EnterEmailID;

	@FindBy(xpath = "//input[@placeholder='New Password']")
	private WebElement EnterNewPwd;

	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	private WebElement EnterConfirmPwd;

	@FindBy(xpath = "//button[@id='submit']")
	private WebElement SubmitBtnClk;
	
	//Initialization
	public ManageDoctorPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getDoctorsNvgn()
	{
		return DoctorsNvgn;
	}
	public WebElement getAddDoctorsLink()
	{
		return AddDoctorsLink;
	}

	public WebElement getDoctorSpecializationDropDown() 
	{
		return SplDropDown;
	}

	public WebElement getEnterDoctorName() 
	{
		return EnterDoctorName;
	}
	
	public WebElement getEnterClinicAddress() 
	{
		return EnterClinicAddress;
	}
	
	public WebElement getEnterContactNo() 
	{
		return EnterContactNo;
	}
	
	public WebElement getEnterConsutationfees() 
	{
		return EnterConsutationfees;
	}
	
	public WebElement getEnterEmailID() 
	{
		return EnterEmailID;
	}
	
	public WebElement getEnterNewPwd() 
	{
		return EnterNewPwd;
	}
	
	public WebElement getEnterConfirmPwd() 
	{
		return EnterConfirmPwd;
	}
	
	public WebElement getSubmitBtnClk()
	{
		return SubmitBtnClk;
	}
	
	//Business libraries
	/**
	 * 
	 * @param value1
	 * @param value2
	 * @param value3
	 * @param value4
	 * @param value5
	 * @param value6
	 * @param value7
	 * @throws InterruptedException 
	 */
	public void EditDoctorDetails(WebDriverUtility WDUtil, String Specialization, String value1, String value2, String value3, String value4, String value5, String value6,String value7) throws InterruptedException
	{
		DoctorsNvgn.click();
		Thread.sleep(400);
		AddDoctorsLink.click();
		WDUtil.handleDropdown(SplDropDown, Specialization);;
		EnterDoctorName.sendKeys(value1);
		EnterClinicAddress.sendKeys(value2);
		EnterContactNo.sendKeys(value3);
		EnterConsutationfees.sendKeys(value4);
		EnterEmailID.sendKeys(value5);
		EnterNewPwd.sendKeys(value6);
		EnterConfirmPwd.sendKeys(value7);
		SubmitBtnClk.click();
	}
}
