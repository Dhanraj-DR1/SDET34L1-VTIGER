package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET31L.genericUtility.SeleniumDriverLibrary;

public class CreateContactPage {
	
	@FindBy(xpath="//input[@name='lastname']")
    private WebElement lastNameTxt;
    
    @FindBy(xpath="//input[@name='account_name']/following-sibling::img")
    private WebElement organizationIcon;
    
    @FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
    private WebElement saveBtn;
    
    @FindBy(xpath="//input[@name='firstname']")
    private WebElement firstNameTxt;
    
    
    @FindBy(xpath="//input[@name='search_text']")
    private WebElement searchOrganizationTxt;
    
    @FindBy(xpath="//input[@name='search']")
    private WebElement searchNowBtn;
    
    @FindBy(xpath="//a[@id='1']")
    private WebElement savedOrganizationName;
    
    @FindBy(xpath="//input[@name='support_start_date']")
    private WebElement supportStartDateTxt;
    
    @FindBy(xpath="//input[@name='support_end_date']")
    private WebElement supportEndDateTxt;
    
    @FindBy(xpath="//input[@name='birthday']")
    private WebElement birthDateTxt;
    
    @FindBy(xpath="//b[.='Copy Other Address']/preceding-sibling::input")
    private WebElement copyOtherAddressRdBtn;
    
    @FindBy(xpath="//b[.='Copy Mailing Address']/preceding-sibling::input")
    private WebElement copyMailingAddressRdBtn;
    
    @FindBy(xpath="//span[@id='dtlview_Support Start Date']")
    private WebElement savedSupportStartDate;
    
    @FindBy(xpath="//span[@id=dtlview_Support End Date']")
    private WebElement savedEndDate;
    
    @FindBy(xpath="//span[@id='dtlview_Birthdate']")
    private WebElement savedBirthDate;
    


    @FindBy(name="mailingstreet")
    private WebElement mailingstreetTxt;
    
    @FindBy(id="mailingpobox")
    private WebElement mailingpoboxTxt;
    
    @FindBy(id="mailingcity")
    private WebElement mailingcityTxt;
    
    @FindBy(id="mailingstate")
    private WebElement mailingstateTxt;
    
    @FindBy(id="mailingzip")
    private WebElement mailingPostalCodeTxt;
    
    @FindBy(id="mailingcountry")
    private WebElement mailingcountryTxt;
    
    
    
    @FindBy(name="otherstreet")
    private WebElement otherstreetTxt;
    
    @FindBy(id="otherpobox")
    private WebElement otherpoboxTxt;
    
    @FindBy(id="othercity")
    private WebElement othercityTxt;
    
    @FindBy(id="otherstate")
    private WebElement otherstateTxt;
    
    @FindBy(id="otherzip")
    private WebElement otherPostalCodeTxt;
    
    @FindBy(id="othercountry")
    private WebElement othercountryTxt;
    
    
    public CreateContactPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
    public void firstName(String firstName)
    {
    	firstNameTxt.sendKeys(firstName);
    }
    public void lastName(String lastName)
    {
    	lastNameTxt.sendKeys(lastName);
    }
    public void organizationIconClick()
    {
    	

    	organizationIcon.click();
    }
    public void saveCreateContact()
    {
    	saveBtn.click();
    }
    public void LastNameEnterSave(String lastName) {
    	
    	//firstNameTxt.sendKeys(firstName);
    	lastNameTxt.sendKeys(lastName);
    	saveBtn.click();
    }
    
    public void searchOrganizationAndClick(String organizationName,WebDriver driver)
    {
    	searchOrganizationTxt.sendKeys(organizationName);
    	searchNowBtn.click();
    	driver.findElement(By.linkText(organizationName)).click();	
    	
    }
    
    public void supportStartDateTxtClick(String supportStartDate)
    {
    	supportStartDateTxt.sendKeys(supportStartDate);
    }
    public void supportEndDateTxtClick(String supportEndDate)
    {
     supportEndDateTxt.sendKeys(supportEndDate);
    }
    public void birthDateEnter(String birthDate)
    {
    	birthDateTxt.sendKeys(birthDate);
    }
    public void enterAddressAndcopyOtherAddressRdBtnClick(String street,String postBox,String city,String state,String postalcode,String country)
    {
    	otherstreetTxt.sendKeys(street);
    	otherpoboxTxt.sendKeys(postBox);
    	othercityTxt.sendKeys(city);
    	otherstateTxt.sendKeys(state);
    	otherPostalCodeTxt.sendKeys(postalcode);
    	othercountryTxt.sendKeys(country);
    	copyOtherAddressRdBtn.click();
    }
    public void enterAdressAndcopyMailingAddressRdBtnClick(String street,String postBox,String city,String state,String postalcode,String country) throws InterruptedException
    {
    	mailingstreetTxt.sendKeys(street);
    	mailingpoboxTxt.sendKeys(postBox);
    	mailingcityTxt.sendKeys(city);
    	mailingstateTxt.sendKeys(state);
    	mailingPostalCodeTxt.sendKeys(postalcode);
    	mailingcountryTxt.sendKeys(country);
    	copyMailingAddressRdBtn.click();
    }
    public WebElement savedSupportStartDate() {
    	return savedSupportStartDate;
    }
    public WebElement savedSupportEndDate() {
    	return savedEndDate;
    }
    public WebElement savedBirthDate() {
    	return savedBirthDate;
    }
}