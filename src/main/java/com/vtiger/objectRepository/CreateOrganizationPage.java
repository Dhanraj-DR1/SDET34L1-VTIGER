package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET31L.genericUtility.SeleniumDriverLibrary;

public class CreateOrganizationPage {
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationNameTxt ;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveOrganizationBtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationConfirmation;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDropdown;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement typeDropdown;
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement savedOrganizationName;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationNameConfirmationText;

	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void organizationNameAndSave(String organizationName,SeleniumDriverLibrary seleniumDriverLibrary,WebDriver driver ) throws InterruptedException {
	
		organizationNameTxt.sendKeys(organizationName);
		saveOrganizationBtn.click();
		seleniumDriverLibrary.waitUntilvisibilityOfElement(driver, organizationNameConfirmationText, 30);
		
	}
	public void saveOrganization(SeleniumDriverLibrary seleniumDriverLibrary,WebDriver driver)
	{
		saveOrganizationBtn.click();
		seleniumDriverLibrary.waitUntilvisibilityOfElement(driver, organizationNameConfirmationText, 30);
	}
	public WebElement organizationConfirmation()
	{
		return organizationConfirmation;
	}
	public void organizationNameEnter(String organizationName)
	{
		organizationNameTxt.sendKeys(organizationName);
	}	
	public WebElement industryDropdown()
	{
		return industryDropdown;
	}
	public WebElement typeDropdown() {

		return typeDropdown;
	}
	public WebElement savedOrganizationName()
	{
		return savedOrganizationName;
	}
	
	
	
	
}
