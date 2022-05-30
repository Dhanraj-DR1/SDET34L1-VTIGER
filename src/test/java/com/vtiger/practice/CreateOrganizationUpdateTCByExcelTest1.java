package com.vtiger.practice;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.vtiger.objectRepository.CreateOrganizationPage;
import com.vtiger.objectRepository.OrganizationPage;

public class CreateOrganizationUpdateTCByExcelTest1 extends BaseClass{
	OrganizationPage op;
	CreateOrganizationPage createOp;
	
	
	@Test
	public void CreateOrganizationUpdateTCByExcelTest() throws InterruptedException{
		
	    String organizationName = ExcelLibrary.getDataFromExcel("organisation", 1, 1);
	    String orgName = organizationName+randomNumber;
		
		OrganizationPage op=new OrganizationPage(driver);
		CreateOrganizationPage createOp=new CreateOrganizationPage(driver);
		
		if(driver.getTitle().contains("Home"))
		{
			
			ExcelLibrary.createDataIntoExcel("organisation", 13, 6,"HomePage is displayed");
			ExcelLibrary.createDataIntoExcel("organisation", 13, 6,"TC Pass");
		}
		
		
		//click on organization
		homePage.organizationClick();
	    //Thread.sleep(3000);
		
	    String title1 = driver.getTitle();
	    System.out.println(title1);
	    
	    if(title1.contains("Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM"))
		{
	    	ExcelLibrary.createDataIntoExcel("organisation", 14,6,"Organization Page is displayed");
			ExcelLibrary.createDataIntoExcel("organisation", 14,7,"TC Pass");
		}
		
	    
	    //click on create organization
	    Thread.sleep(3000);
	    op.createOrganizationIconClick();
	   
	    String title2= driver.getTitle();
	    
	    if(title2.contains("Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM"))
		{
		
			ExcelLibrary.createDataIntoExcel("organisation", 15,6,"Create Organization Page is displayed");
			ExcelLibrary.createDataIntoExcel("organisation", 15,7,"TC Pass");
		}
	    Thread.sleep(3000);
	    //enter organization name and save
	    createOp.organizationNameAndSave(orgName, seleniumDriverLibrary, driver);
	   
	    if(createOp.savedOrganizationName().getText().equalsIgnoreCase(orgName))
	    {
	    	ExcelLibrary.createDataIntoExcel("organisation", 16,6,"organizationName saved sucessfully");
			ExcelLibrary.createDataIntoExcel("organisation", 16,7,"TC Pass");
	    }
		
		 if(driver.getTitle().contains("vtiger"))
		 {
			 ExcelLibrary.createDataIntoExcel("organisation", 17,6,"Signout successfulyy");
			 ExcelLibrary.createDataIntoExcel("organisation", 17,7,"TC Pass");
		 }
	 
	
	}

}
