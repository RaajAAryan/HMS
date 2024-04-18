package com.healthkart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePatientPage {
	
	//Declaration
	@FindBy(xpath="//a[@href='hms/user-login.php']")
	private WebElement DoctorLoginLink;

	@FindBy(xpath="//a[@href='registration.php']")
	private WebElement RegistrationLink;
	
	@FindBy(xpath="//input[@placeholder='Full Name']")
	private WebElement EnterFullName;
	
	@FindBy(xpath="//input[@placeholder='Address']")
	private WebElement EnterAddress;
	
	@FindBy(xpath="//input[@placeholder='City']")
	private WebElement EnterCity;
	
	@FindBy(xpath="//label[@for='rg-female']")
	private WebElement SelectGender;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement EnterEmailID;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement EnterPassword;
	
	@FindBy(xpath="//input[@id='password_again']")
	private WebElement ConfirmPassword;
	
//	@FindBy(xpath="//label[@for='agree']")
//	private WebElement AgreeChBx;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement SubmitBtn;
	
	//Initialization
	public CreatePatientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);	
	}
	
	//Utilization
	public WebElement getDoctorLoginLink()
	{
		return DoctorLoginLink;
	}
	public WebElement getRegistrationLink()
	{
		return RegistrationLink;
	}
	public WebElement getEnterFullName()
	{
		return EnterFullName;
	}
	public WebElement getEnterAddress()
	{
		return EnterAddress;
	}
	public WebElement getEnterCity()
	{
		return EnterCity;
	}
	public WebElement getSelectGender()
	{
		return SelectGender;
	}
	public WebElement getEnterPassword()
	{
		return EnterPassword;
	}
	public WebElement getConfirmPassword()
	{
		return ConfirmPassword;
	}
	public WebElement getSubmitBtn()
	{
		return SubmitBtn;
	}
	//Business Libraries
	/**
	 * 
	 */
	public void createPat(String value1, String value2, String value3, String value4, String value5, String value6 )
	{
		DoctorLoginLink.click();
		RegistrationLink.click();
		EnterFullName.sendKeys(value1);
		EnterAddress.sendKeys(value2);
		EnterCity.sendKeys(value3);
		SelectGender.sendKeys(value4);
		EnterPassword.sendKeys(value5);
		ConfirmPassword.sendKeys(value6);
		SubmitBtn.click();
		
	}
}
