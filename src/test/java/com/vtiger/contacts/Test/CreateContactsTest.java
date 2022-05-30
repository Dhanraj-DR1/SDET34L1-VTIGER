package com.vtiger.contacts.Test;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.vtiger.objectRepository.ContactInformationPage;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateContactsTest extends BaseClass{
	
	
	ContactPage contactPage;
	CreateContactPage createContactPage;
	ContactInformationPage contactInformationPage;
	String lastName;
	
	@Test
	@Description("Description:-CreateContactsTest")
	@Epic("Epic:-CreateContactsTest")
	@Story("Story:-C")
	@Step("Step:-CreateContactsTest")
	@Severity(SeverityLevel.CRITICAL)

	public void createContactsTest() throws InterruptedException{
		
	    lastName = ExcelLibrary.getDataFromExcel("contact",1,1)+randomNumber;
		contactPage=new ContactPage(driver);
		createContactPage=new CreateContactPage(driver);
	    contactInformationPage=new ContactInformationPage(driver);
	    homePage.contactClick();
	    contactPage.createContactIconClick();
	    createContactPage.LastNameEnterSave(lastName);  
		
	}

}
