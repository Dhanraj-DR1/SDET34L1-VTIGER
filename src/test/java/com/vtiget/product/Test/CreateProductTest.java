package com.vtiget.product.Test;

import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.vtiger.objectRepository.CreateProductPage;
import com.vtiger.objectRepository.ProductInformationPage;
import com.vtiger.objectRepository.ProductPage;

public class CreateProductTest extends BaseClass{
	 ProductPage productPage;
	 CreateProductPage createProdcutPage;
	 String productName ;
	 ProductInformationPage productInformationPage;
	
	@Test
	public void createProductTest(){
		
		
		 productName = ExcelLibrary.getDataFromExcel("product", 1, 1)+randomNumber;
		 productPage=new ProductPage(driver);
		 createProdcutPage=new CreateProductPage(driver);
		 productInformationPage=new ProductInformationPage(driver);

		 homePage.productClick();
		 productPage.CreateProductIconClick();
		 createProdcutPage.productNameAndSave(productName);
	
	
	}

}
