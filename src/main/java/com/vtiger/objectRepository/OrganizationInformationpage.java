package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationpage {
	

	 @FindBy(xpath="//span[@id='dtlview_Organization Name']")
	    private WebElement organizationNameConfirmText;
	
	 public OrganizationInformationpage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver,this);
	    }
	 
	 public String organizationNameConfirmText() {
	    	return organizationNameConfirmText.getText();
	    }
	 


}
