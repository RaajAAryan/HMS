package com.healthkart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatientsPage {
	//Declaration
	@FindBy(xpath="//a[@href='dashboard.php']")
	private WebElement PatientDash;
	
	@FindBy(xpath="//span[contains(text(),'Patients')]")
	private WebElement PatientNvgn;
	
	@FindBy(xpath="//span[contains(text(),'Manage Patient')]")
	private WebElement ManagePatientNvgn;
	
	@FindBy(xpath="//tbody/tr[last()]//i[ @class='fa fa-edit']")
	private WebElement PatEditLookup;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Patient Medical History(if any)']")
	private WebElement PMedicalHistory;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement PatSubmitBtn;

	//Initialization
	public ManagePatientsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getPatientDash()
	{
		return PatientDash;
	}
	public WebElement getPatientNvgn()
	{
		return PatientNvgn;
	}
	public WebElement getManagePatientNvgn()
	{
		return ManagePatientNvgn;
	}
	public WebElement getPatEditLookup()
	{
		return PatEditLookup;
	}
	public WebElement getPMedicalHistory()
	{
		return PMedicalHistory;
	}
	public WebElement getPatSubmitBtn()
	{
		return PatSubmitBtn;
	}
	
	//Business Libraries
	/**
	 * 
	 */
	public void mangPatient(String value10)
	{
		PatientDash.click();
		PatientNvgn.click();
		ManagePatientNvgn.click();
		PatEditLookup.click();
		PMedicalHistory.sendKeys(value10);
		PatSubmitBtn.click();
		
	}
}
