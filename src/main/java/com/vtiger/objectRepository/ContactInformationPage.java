package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	 @FindBy(xpath="//span[@id='dtlview_Last Name']")
	    private WebElement lastNameConfirmText;
	 
	 @FindBy(xpath="//a[@href='index.php?module=Accounts&action=DetailView&record=7']")
	    private WebElement organizationNameConfirmText;
	
	 public ContactInformationPage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver,this);
	    }
	 
	 public String lastNameConfirmText() {
	    	return lastNameConfirmText.getText();
	    }
	 
	 public String  organizationNameConfirmText(){
	    	return organizationNameConfirmText.getText();
	    }
	 
	 
	 

}

