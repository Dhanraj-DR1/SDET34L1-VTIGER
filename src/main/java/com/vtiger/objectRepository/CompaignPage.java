package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaignPage {
	
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createCompaigncon;
	
	public CompaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}
	
	public void createCompaignIconClick() {
		createCompaigncon.click();
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	 
	
	
	
	

}
