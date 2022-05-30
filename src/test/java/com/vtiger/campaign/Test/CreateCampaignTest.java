package com.vtiger.campaign.Test;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.vtiger.objectRepository.CompaignInforamtionPage;
import com.vtiger.objectRepository.CompaignPage;
import com.vtiger.objectRepository.CreateCompaignPage;

public class CreateCampaignTest extends BaseClass{
	
	String compaignName;
	CompaignPage compaignPage;
	CreateCompaignPage createCompaignPage;
	CompaignInforamtionPage compaignInforamtionPage;
 
	@Test
    public void createCompaignTest() throws InterruptedException {

	compaignName=ExcelLibrary.getDataFromExcel("compaign", 2, 1);
	
	compaignPage=new CompaignPage(driver);
	createCompaignPage=new CreateCompaignPage(driver);
    compaignInforamtionPage=new CompaignInforamtionPage(driver);
	
    homePage.compaignClick(driver,seleniumDriverLibrary);
    compaignPage.createCompaignIconClick();
    createCompaignPage.campaignnameEnterSave(compaignName); 
    String savedCompaignName=compaignInforamtionPage.compaignConfirmText();
    javaLibrary.ifvalidation(savedCompaignName, compaignName);
}

}
