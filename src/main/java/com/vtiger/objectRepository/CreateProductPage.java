package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET31L.genericUtility.SeleniumDriverLibrary;

public class CreateProductPage {
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productNameTxt;
	
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveProductBtn;
	
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); 
	}
	
	public void productNameAndSave(String productName )
	{
		productNameTxt.sendKeys(productName);
		saveProductBtn.click();
	}
	public void saveProduct()
	{
		saveProductBtn.click();
	}
	

}
