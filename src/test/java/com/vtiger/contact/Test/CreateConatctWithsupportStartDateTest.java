package com.vtiger.contact.Test;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;

public class CreateConatctWithsupportStartDateTest extends BaseClass{

	@Test(groups="sanity")
	public void  createConatctWithsupportStartDate() throws InterruptedException {
		
		ContactPage contactPage=new ContactPage(driver);
		CreateContactPage createContactPage=new CreateContactPage(driver);

		String lastName = ExcelLibrary.getDataFromExcel("contact", 1, 1)+randomNumber;
		String supportStartDate = ExcelLibrary.getDataFromExcel("contact", 3, 1);
		
	    homePage.contactClick();
	    contactPage.createContactIconClick();
	    createContactPage.lastName(lastName);
	    createContactPage.supportStartDateTxtClick(supportStartDate);
	    createContactPage.saveCreateContact();
	    javaLibrary.ifvalidation("createCp.savedSupportStartDate().getText()", supportStartDate);
	   
	}

}
