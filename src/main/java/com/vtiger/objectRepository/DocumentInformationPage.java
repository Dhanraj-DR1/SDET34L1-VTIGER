package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInformationPage {
	
	
	@FindBy(xpath="//span[@id='dtlview_Title']")
    private WebElement documentConfirmText;

 public DocumentInformationPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
 
 public String documentConfirmText() {
    	return documentConfirmText.getText();
    }
 
 

}
