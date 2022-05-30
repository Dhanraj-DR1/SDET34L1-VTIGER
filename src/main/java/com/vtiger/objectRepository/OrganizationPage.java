package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganizationIcon;
	

	public  OrganizationPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void createOrganizationIconClick() throws InterruptedException
	{
		//SeleniumDriverLibrary.waitUntilElementClickable(createOrganizationIcon);
		createOrganizationIcon.click();
	}
	public WebElement createOrganizationIcon()
	{
		return createOrganizationIcon;
	}
	

}
