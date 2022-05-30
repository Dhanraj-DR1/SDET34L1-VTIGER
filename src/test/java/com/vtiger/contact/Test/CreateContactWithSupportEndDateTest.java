package com.vtiger.contact.Test;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;

public class CreateContactWithSupportEndDateTest extends BaseClass{
	@Test(groups="regression")
	public  void createContactWithSupportEndDate() throws InterruptedException{
	
		
		ContactPage contactPage=new ContactPage(driver);
		CreateContactPage createContactPage=new CreateContactPage(driver);

		String lastName = ExcelLibrary.getDataFromExcel("contact", 1, 1)+randomNumber;
		String supportEndData = ExcelLibrary.getDataFromExcel("contact", 4, 1);
		
		homePage.contactClick();
		contactPage.createContactIconClick();
		createContactPage.lastName(lastName);
		createContactPage.supportEndDateTxtClick(supportEndData);
		createContactPage.saveCreateContact();
	   
	  
	}

}
