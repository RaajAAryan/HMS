package com.healthkart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientDetailsPage {
	//declaration
	@FindBy(xpath="//input[@placeholder='Enter Patient Name']")
	private WebElement EnterPname;
	
	@FindBy(xpath="//input[@placeholder='Enter Patient Contact no']")
	private WebElement EnterPcontact;
	
	@FindBy(xpath="//input[@placeholder='Enter Patient Email id']")
	private WebElement EnterPemail;
	
	@FindBy(xpath="//label[@for='rg-male']")
	private WebElement ChooseGender;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Patient Address']")
	private WebElement EnterPaddress;
	
	@FindBy(xpath="//input[@placeholder='Enter Patient Age']")
	private WebElement EnterPAge;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Patient Medical History(if any)']")
	private WebElement EnterPMedicalHist;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement ClkSubmitBtn;
	
	//initialization
	public AddPatientDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getEnterPname()
	{
		return EnterPname;
	}
	public WebElement getEnterPcontact()
	{
		return EnterPcontact;
	}
	public WebElement getEnterPemail()
	{
		return EnterPemail;
	}
	public WebElement getChooseGender()
	{
		return ChooseGender;
	}
	public WebElement getEnterPaddress()
	{
		return EnterPaddress;
	}
	public WebElement getEnterPAge()
	{
		return EnterPAge;
	}
	public WebElement getEnterPMedicalHist()
	{
		return EnterPMedicalHist;
	}
	public WebElement getClkSubmitBtn()
	{
		return ClkSubmitBtn;
	}
	
	//Business libraries
	/** 
	 * @param value4=PatientName
	 * @param value5=PatientContact
	 * @param value6=PatientEmail
	 * @param value7=PatientAddress
	 * @param value8=PatientAge
	 * @param value9=PatientMedicalHistory
	 */
	public void EnterDetails(String value4, String value5, String value6, String value7, String value8, String value9)
	{
		EnterPname.sendKeys(value4);
		EnterPcontact.sendKeys(value5);
		EnterPemail.sendKeys(value6);
		ChooseGender.click();
		EnterPaddress.sendKeys(value7);
		EnterPAge.sendKeys(value8);
		EnterPMedicalHist.sendKeys(value9);
		ClkSubmitBtn.click();
	}
}
