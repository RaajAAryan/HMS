package com.healthkart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PMedicalHistoryPage {
	//Declaration
	@FindBy(xpath="//input[@placeholder='Blood Pressure']")
	private WebElement BloodPressure;

	@FindBy(xpath="//input[@name='bs']")
	private WebElement BloodSugar;
	
	@FindBy(xpath="//input[@placeholder='Weight']")
	private WebElement Weight;
	
	@FindBy(xpath="//input[@name='temp']")
	private WebElement BodyTemp;
	
	@FindBy(xpath="//textarea[@name='pres']")
	private WebElement Prescription;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement SubmitBtn;
	
	//Initialization
	public PMedicalHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getBloodPressure()
	{
		return BloodPressure;
	}
	public WebElement getBloodSugar()
	{
		return BloodSugar;
	}
	public WebElement getWeight()
	{
		return Weight;
	}
	public WebElement getBodyTemp()
	{
		return BodyTemp;
	}
	public WebElement getPrescription()
	{
		return Prescription;
	}
	public WebElement getSubmitBtn()
	{
		return SubmitBtn;
	}
	//Business libraries
	/** 
	 * 
	 */
	public void MedicalHistory(String value11, String value12, String value13, String value14, String value15  )
	{
		BloodPressure.sendKeys(value11);
		BloodSugar.sendKeys(value12);
		Weight.sendKeys(value13);
		BodyTemp.sendKeys(value14);
		Prescription.sendKeys(value15);
		SubmitBtn.click();
	}

}
