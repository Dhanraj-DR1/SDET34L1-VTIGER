package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("Cred");
        for(int i=0;i<=sheet.getLastRowNum();i++)
        {
        	for(int j=i;j<sheet.getRow(i).getLastCellNum();j++)
        	{
        		System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
        	}
        }
		
	}

}
