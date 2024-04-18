package com.healthkart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientPage {
	//Declaration	
	@FindBy(xpath="//span[contains(text(),'Patients')]")
	private WebElement PatientLink;
	
	@FindBy(xpath="//span[contains(text(),' Add Patient')]")
	private WebElement AddPatientLink;


	//Initialization
	public AddPatientPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getPatientLink()
	{
		return PatientLink;
	}
	public WebElement getAddPatientLink()
	{
		return AddPatientLink;
	}
	
	//Business libraries
	/**
	 * 
	 */
	public void addPatientNvgn()
	{
	PatientLink.click();
	AddPatientLink.click();
	}
}
