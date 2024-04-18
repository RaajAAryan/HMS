package com.healthkart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPatientsPage {
	//Declaration
	@FindBy(xpath="//a[@href='dashboard.php']")
	private WebElement PDashboard;
	
	@FindBy(xpath="//span[contains(text(),'Patients')]")
	private WebElement PatientLnk;
	
	@FindBy(xpath="//span[contains(text(),'Manage Patient')]")
	private WebElement ManageP;
	
	@FindBy(xpath="//tbody/tr[last()]//i[@class='fa fa-eye']")
	private WebElement ViewPatientLookup;
	
	@FindBy(xpath="//button[@class='btn btn-primary waves-effect waves-light w-lg']")
	private WebElement SubmitBtn;

	//Initialization
	public ViewPatientsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public WebElement getPDashboard()
	{
		return PDashboard;
	}
	public WebElement getPatientLnk()
	{
		return PatientLnk;
	}
	public WebElement getManageP()
	{
		return ManageP;
	}
	public WebElement getViewPatientLookup()
	{
		return ViewPatientLookup;
	}
	public WebElement getSubmitBtn()
	{
		return SubmitBtn;
	}
	//Business libraries
	/** 
	 * 
	 */
	public void ViewPatient()
	{
		PDashboard.click();
		PatientLnk.click();
		ManageP.click();
		ViewPatientLookup.click();
		SubmitBtn.click();
	}
}
