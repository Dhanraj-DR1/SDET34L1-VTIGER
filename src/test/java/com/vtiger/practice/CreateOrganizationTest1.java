package com.vtiger.practice;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.OrganizationPage;

public class CreateOrganizationTest1 extends BaseClass{
	HomePage hp=new HomePage(driver);
	OrganizationPage op;
	CreateOrganizationPage createOp;
	
	@Test
	public void createOrganizationTest() throws InterruptedException{
		
		op=new OrganizationPage(driver);
	    createOp=new CreateOrganizationPage(driver);
		
		String organizationname = ExcelLibrary.getDataFromExcel("organisation", 1, 1)+randomNumber;
		
		hp.organizationClick();
	    Thread.sleep(4000);
	    op.createOrganizationIconClick();
	   
	    createOp.organizationNameAndSave(organizationname, seleniumDriverLibrary, driver);
		
	    Thread.sleep(5000);

	}

}
