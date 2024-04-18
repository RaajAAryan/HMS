package com.healthkart.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Declaration
public class DoctorLoginPage {
@FindBy(xpath="//a[@href='hms/doctor/']")
private WebElement DoctorLoginLink;

@FindBy(xpath="//input[@placeholder='Username']")
private WebElement Dusername;

@FindBy(xpath="//input[@placeholder='Password']")
private WebElement Dpassword;

@FindBy(xpath="//button[@type='submit']")
private WebElement DLoginBtn;

//Initialization
public DoctorLoginPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

//Utilization
public WebElement getDoctorLoginLink()
{
	return DoctorLoginLink;
}
public WebElement getDusername()
{
	return Dusername;
}
public WebElement getDpassword()
{
	return Dpassword;
}
public WebElement getDLoginBtn()
{
return DLoginBtn;
}
//Business libraries
/** 
 * @param value1
 * @param value2
 */

public void DocLogin(String value1, String value2)
{
	DoctorLoginLink.click();
	Dusername.sendKeys(value1);
	Dpassword.sendKeys(value2);
	DLoginBtn.click();
}
}