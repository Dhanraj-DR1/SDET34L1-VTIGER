package com.vtiger.contact.Test;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;

public class CreateContactWithBirthDateTest extends BaseClass{
	@Test(groups="regression")
	public void createContactWithBirthDate() throws InterruptedException{
		
		ContactPage contactPage=new ContactPage(driver);
		CreateContactPage createContactPage=new CreateContactPage(driver);

		String lastName = ExcelLibrary.getDataFromExcel("contact", 1, 1)+randomNumber;
		String birthDate = ExcelLibrary.getDataFromExcel("contact", 2, 1);
	
	    homePage.contactClick();
	    contactPage.createContactIconClick();
	    createContactPage.lastName(lastName);
	    createContactPage.birthDateEnter(birthDate);
	    createContactPage.saveCreateContact();
       
	    
	}

}
