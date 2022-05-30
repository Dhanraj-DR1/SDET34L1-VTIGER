package com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProviderTest1 {
	
	@Test(dataProvider="loginData")
	public void practiceTest(String username,String password) {
		Reporter.log(username+" ---------->  " +password, true);               
		
	}
	
	@DataProvider(name="loginData")
	public Object[][] loginDataMethod() throws EncryptedDocumentException, IOException{
		Object[][] data = new Object[3][2];
		data[0][0]="ramesh";
		data[0][1]="123";
		
		data[1][0]="suresh";
		data[1][1]="23";
		
		data[2][0]="mahesh";
		data[2][1]="234";
		return data;
		
		/*ExcelLibrary.openExcel(AllConstantPaths.EXCELFILEPATH);
		return ExcelLibrary.getMultipleDataFromExcel("loginData");*/
	}

}
