package com.vtiger.contacts.Test;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.SDET31L.genericUtility.SeleniumDriverLibrary;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.OrganizationPage;

public class CreateContactwithOrganizationTest extends BaseClass{
	ContactPage contactPage;
	OrganizationPage organizationPage;
	CreateContactPage createContactPage;
	CreateOrganizationPage createOrganizationPage;
	String organisationName;
	String lastname;
	ContactInformationPage contactInformationPage;
	
	
	
	@Test
	public  void  createContactwithOrganizationTest() throws InterruptedException{
	
	
		organisationName = ExcelLibrary.getDataFromExcel("organisation", 1, 1)+randomNumber;
		lastname = ExcelLibrary.getDataFromExcel("organisation", 2, 1)+randomNumber;
	
		contactPage=new ContactPage(driver);
		createContactPage=new CreateContactPage(driver);
		organizationPage=new OrganizationPage(driver);
		createOrganizationPage=new CreateOrganizationPage(driver);
	    contactInformationPage=new ContactInformationPage(driver);
		
		homePage.organizationClick();
		organizationPage.createOrganizationIconClick();
		createOrganizationPage.organizationNameAndSave(organisationName, seleniumDriverLibrary, driver);
	
		homePage.contactClick();
		contactPage.createContactIconClick();
		createContactPage.lastName(lastname);
		
		createContactPage.organizationIconClick();
		SeleniumDriverLibrary.switchToWindowBasedonTitle(driver, "Accounts");
		createContactPage.searchOrganizationAndClick(organisationName, driver);
		SeleniumDriverLibrary.switchToWindowBAsedonTitle(driver, "Campaigns");
		createContactPage.saveCreateContact();
		
	}

}
