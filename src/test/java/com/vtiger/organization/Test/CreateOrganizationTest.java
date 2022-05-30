package com.vtiger.organization.Test;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.OrganizationInformationpage;
import com.vtiger.objectRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass{
	
	OrganizationPage organizationPage;
	CreateOrganizationPage createOrganizationPage;
	OrganizationInformationpage organizationInformationpage;
	
	@Test
	public void createOrganizationTest() throws InterruptedException{
		
		organizationPage=new OrganizationPage(driver);
		createOrganizationPage=new CreateOrganizationPage(driver);
	    organizationInformationpage=new OrganizationInformationpage(driver);
		
		String organizationname = ExcelLibrary.getDataFromExcel("organisation", 1, 1)+randomNumber;
		
		homePage.organizationClick();
		//SeleniumDriverLibrary.waitUntilElementClickable(op.createOrganizationIcon());
		  
		organizationPage.createOrganizationIconClick();
	   
		createOrganizationPage.organizationNameAndSave(organizationname, seleniumDriverLibrary, driver);
		
	}

}
