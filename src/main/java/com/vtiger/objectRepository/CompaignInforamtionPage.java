package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaignInforamtionPage {
	
	
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
    private WebElement compaignConfirmText;
	
	@FindBy(xpath="//a[@href='index.php?module=Products&action=DetailView&record=46']")
    private WebElement productConfirmText;
	
	

 public CompaignInforamtionPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
 
 public String compaignConfirmText() {
    	return compaignConfirmText.getText();
    }
 
 public String productConfirmText() {
 	return productConfirmText.getText();
 }

 
 
 
 
 
 


}
