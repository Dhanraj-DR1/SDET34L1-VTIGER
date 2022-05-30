package com.vtiger.organization.Test;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.SDET31L.genericUtility.SeleniumDriverLibrary;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.OrganizationInformationpage;
import com.vtiger.objectRepository.OrganizationPage;

public class CreateOrganizationWithIndustryTYpeTest extends BaseClass{
	OrganizationPage organizationPage;
	CreateOrganizationPage createOrganizationPage;
	OrganizationInformationpage organizationInformationpage;
	
	
	@Test
	public void  createOrganizationWithIndustryTYpeTest() throws InterruptedException{
		
	
		String organizationname = ExcelLibrary.getDataFromExcel("organisation", 1, 1)+randomNumber;
		
		organizationPage=new OrganizationPage(driver);
		createOrganizationPage=new CreateOrganizationPage(driver);
	    organizationInformationpage=new OrganizationInformationpage(driver);
		
	    
	    homePage.organizationClick();
	    organizationPage.createOrganizationIconClick();
	   
	    createOrganizationPage.organizationNameEnter(organizationname);
	   
	    SeleniumDriverLibrary.dropDownHandle(createOrganizationPage.industryDropdown(), "Education");
	    SeleniumDriverLibrary.dropDownHandle(createOrganizationPage.typeDropdown(), "Press");
	    createOrganizationPage.saveOrganization(seleniumDriverLibrary, driver);
	    
	}

}
