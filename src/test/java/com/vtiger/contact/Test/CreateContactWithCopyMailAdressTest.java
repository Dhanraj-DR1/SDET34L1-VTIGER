	package com.vtiger.contact.Test;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;

public class CreateContactWithCopyMailAdressTest extends BaseClass{
	@Test(groups="sanity")
	public void createContactWithCopyMailAdress() throws InterruptedException{
		
		ContactPage contactPage=new ContactPage(driver);
		CreateContactPage createContactPage=new CreateContactPage(driver);
		
		String lastName = ExcelLibrary.getDataFromExcel("contact", 1, 1)+randomNumber;
		
		String street=ExcelLibrary.getDataFromExcel("contact1", 1, 0)+randomNumber;
	    String postBox=ExcelLibrary.getDataFromExcel("contact1", 1, 1)+randomNumber;
	    String city=ExcelLibrary.getDataFromExcel("contact1", 1, 2)+randomNumber;
	    String state=ExcelLibrary.getDataFromExcel("contact1", 1, 3)+randomNumber;
	    String postalcode=ExcelLibrary.getDataFromExcel("contact1", 1, 4)+randomNumber;
	    String country=ExcelLibrary.getDataFromExcel("contact1", 1, 5)+randomNumber;
	    
		homePage.contactClick();
		contactPage.createContactIconClick();
		createContactPage.lastName(lastName);
		createContactPage.enterAdressAndcopyMailingAddressRdBtnClick(street,postBox,city,state,postalcode,country);
		createContactPage.saveCreateContact();
	
	}

}
