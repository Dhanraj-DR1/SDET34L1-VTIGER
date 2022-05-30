package com.vtiger.practice;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;

public class CreateContactWithWriteInExcelTest1 extends BaseClass {
	ContactPage cp;
	CreateContactPage createCp;
	
	
	@Test
	public  void createContactWithWriteInExcelTest() throws InterruptedException{
		
	
		String firstName = ExcelLibrary.getDataFromExcel("contact", 0, 1);
		String lastname = ExcelLibrary.getDataFromExcel("contact", 1, 1);
		
		
		 cp=new ContactPage(driver);
		 createCp=new CreateContactPage(driver);
		 ContactInformationPage cip=new ContactInformationPage(driver);
		
	
		if(driver.getTitle().contains("Home"))
		{
			ExcelLibrary.createDataIntoExcel("contact", 7, 4,"HomePage is displayed");
			ExcelLibrary.createDataIntoExcel("contact", 7, 5,"TC Pass");
			
		}

		//Click on contact
		homePage.contactClick();
		Thread.sleep(3000);
		 if(driver.getTitle().contains("Contacts"))
		 {
			 ExcelLibrary.createDataIntoExcel("contact", 8, 4,"Contact page is dispalyed");
			 ExcelLibrary.createDataIntoExcel("contact", 8, 5,"TC Pass");
					 
		 }
		 
		 //click on create contact
		cp.createContactIconClick();
		 if(driver.getTitle().contains("Contacts"))
			 {
			   
			  ExcelLibrary.createDataIntoExcel("contact", 9, 4, "create contact page is displayed");
			  ExcelLibrary.createDataIntoExcel("contact", 9, 5,"TC Pass");
			 
			 }
		 
	    //Save FN and LN
		 createCp.LastNameEnterSave(lastname);
		 Thread.sleep(5000);
	
		 if(cip.lastNameConfirmText().contains(lastname))
		 {
			
			 ExcelLibrary.createDataIntoExcel("contact", 10, 4,"Contact created");
			 ExcelLibrary.createDataIntoExcel("contact", 10, 5,"TC Pass");
				
		 }
		 
		 if(driver.getTitle().contains("vtiger"))
		 {
			 
			 ExcelLibrary.createDataIntoExcel("contact", 11, 4, "singout");
			 ExcelLibrary.createDataIntoExcel("contact", 11, 5,"TC Pass");
				
		 }
		
	}

}
