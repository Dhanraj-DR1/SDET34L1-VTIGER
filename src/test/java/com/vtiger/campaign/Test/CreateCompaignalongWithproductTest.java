package com.vtiger.campaign.Test;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.SDET31L.genericUtility.SeleniumDriverLibrary;
import com.vtiger.objectRepository.CompaignInforamtionPage;
import com.vtiger.objectRepository.CompaignPage;
import com.vtiger.objectRepository.CreateCompaignPage;
import com.vtiger.objectRepository.CreateProductPage;
import com.vtiger.objectRepository.ProductPage;

public class CreateCompaignalongWithproductTest extends BaseClass{
	ProductPage productPg;
	CreateProductPage createproductPg;
	CompaignPage compaignPage;
	CreateCompaignPage createCompaignPage;
	ProductPage productPage;
	CreateProductPage createProductPage;
	CompaignInforamtionPage compaignInforamtionPage;
	String productName ;
	String compaignName;
	
	
	@Test
	public  void createCompaignalongWithproductTest() throws InterruptedException {
		
            
	     productName = ExcelLibrary.getDataFromExcel("compaign", 4, 1)+randomNumber;
	     compaignName = ExcelLibrary.getDataFromExcel("compaign", 2, 1)+randomNumber;
		
		
		 productPg=new ProductPage(driver);
		 createproductPg=new CreateProductPage(driver);
		 compaignPage=new CompaignPage(driver);
		 createCompaignPage=new CreateCompaignPage(driver);
		 productPage =new ProductPage(driver);
		 createProductPage=new CreateProductPage(driver);
		 compaignInforamtionPage=new CompaignInforamtionPage(driver);

		 homePage.productClick();
		 productPage.CreateProductIconClick();
		 createProductPage.productNameAndSave(productName);
		 
	    
	     homePage.compaignClick(driver,seleniumDriverLibrary);
	     compaignPage.createCompaignIconClick();
	     createCompaignPage.compaignNameEnter(compaignName);
	     createCompaignPage.productSelectIcon();
	  
	     SeleniumDriverLibrary.switchToWindowBasedonTitle(driver, "Products");
	     createCompaignPage.productSearchAndClick(productName, driver);
	     SeleniumDriverLibrary.switchToWindowBAsedonTitle(driver, "Campaigns");
	     createCompaignPage.saveCompaign(seleniumDriverLibrary, driver); 

	}	
}


