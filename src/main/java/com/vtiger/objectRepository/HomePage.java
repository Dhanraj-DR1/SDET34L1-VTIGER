package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET31L.genericUtility.SeleniumDriverLibrary;

public class HomePage {
	//SeleniumDriverLibrary seleniumDriverLibrary=new SeleniumDriverLibrary();
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactLink;
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationLink;
	
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement productLink;
	
	@FindBy(xpath="//a[@href='index.php?module=Documents&action=index']")
	private WebElement documentLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreDropDown; 
	
	@FindBy(xpath="//a[@href='index.php?module=Campaigns&action=index']")
	private WebElement  compaignLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutLink;
	
	@FindBy(xpath="//td[@class='dvtSelectedCell']")
	private WebElement organizationHeaderText;
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void contactClick() throws InterruptedException
	{
	
		contactLink.click();
		
	}
	public void organizationClick() throws InterruptedException
	{ 
	
		organizationLink.click();
	}
	public void productClick()
	{
		
		
		productLink.click();
	}
	public void documentClick()
	{
		documentLink.click();
	}
	public void compaignClick(WebDriver driver,SeleniumDriverLibrary seleniumDriverLibrary) {
		seleniumDriverLibrary.mouseHoverOntheElement(driver, moreDropDown);
		compaignLink.click();
	}
	public void signout(WebDriver driver,SeleniumDriverLibrary seleniumDriverLibrary) throws InterruptedException 
	{
	    
		seleniumDriverLibrary.waitUntilvisibilityOfElement(driver,adminIcon,30);
		seleniumDriverLibrary.mouseHoverOntheElement(driver, adminIcon);
		signoutLink.click();
		
	}
	
	
	
	
	

}
