package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET31L.genericUtility.JavaLibrary;
import com.SDET31L.genericUtility.SeleniumDriverLibrary;

public class CreateCompaignPage {
	SeleniumDriverLibrary seleniumDriverLibrary=new SeleniumDriverLibrary();
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignNameTxt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveCompaignBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement productSelectIcon;
	
	@FindBy(id="search_txt")
	private WebElement searchProductTxt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNowBtn;
	
	@FindBy(xpath="//a[@id='1']")
	private WebElement savedProductName;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement campaignConfirmationText;
	
	public CreateCompaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void campaignnameEnterSave(String campaignName) {
		campaignNameTxt.sendKeys(campaignName);
		saveCompaignBtn.click();
		
	}
	public void productSearchAndClick(String productName,WebDriver driver) throws InterruptedException  {
		searchProductTxt.sendKeys(productName);
		searchNowBtn.click();
		driver.findElement(By.linkText(productName)).click();	
	}
	
	public void saveCompaign(SeleniumDriverLibrary seleniumDriverLibrary,WebDriver driver) throws InterruptedException {
	 //JavaLibrary java = new JavaLibrary();
	 //java.customWait(saveCompaignBtn, 10, 1000);
	  saveCompaignBtn.click();
	  seleniumDriverLibrary.waitUntilvisibilityOfElement(driver, campaignConfirmationText, 30);
		
	}
	public void productSelectIcon() {
		productSelectIcon.click();
	}
	public void compaignNameEnter(String campaignName) {
		campaignNameTxt.sendKeys(campaignName);
	}
	public WebElement savedProductName() {
		return savedProductName;
	}
	
	
	
	

}
