package com.vtiger.document.Test;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.SDET31L.genericUtility.SeleniumDriverLibrary;
import com.vtiger.objectRepository.CreateDocumentPage;
import com.vtiger.objectRepository.DocumentInformationPage;
import com.vtiger.objectRepository.DocumentPage;

public class CreateDocumentTest extends BaseClass{
	
	DocumentPage documentPage;
	CreateDocumentPage createDocumentPage;
	DocumentInformationPage documentInformationPage;
	String documentttile;
	String data;
	String path;
	
	
	@Test
	public  void createDocumentTest() throws InterruptedException{

		documentttile = ExcelLibrary.getDataFromExcel("documentt", 2, 1);
		data = ExcelLibrary.getDataFromExcel("documentt", 2, 3);
		path = ExcelLibrary.getDataFromExcel("documentt", 2, 2);
		
		documentPage=new DocumentPage(driver);
		createDocumentPage=new CreateDocumentPage(driver);
	    documentInformationPage=new DocumentInformationPage(driver);
		
	    homePage.documentClick();
	    documentPage.CreateDocumentIconclick();
	    createDocumentPage.enterDocumentTitle(documentttile);
	    
	    seleniumDriverLibrary.switchToFrame(driver, 0);
	   
	    createDocumentPage.DescriptionEnter(data+Keys.CONTROL+"a");
	    createDocumentPage.DescriptionEnter(Keys.CONTROL+"a");
	    
	    SeleniumDriverLibrary.switchBackToHomePage(driver);
	    createDocumentPage.boldItalicSelect();
	  
	    createDocumentPage.chooseFile(path);
	    createDocumentPage.saveDocument();
	}

}
