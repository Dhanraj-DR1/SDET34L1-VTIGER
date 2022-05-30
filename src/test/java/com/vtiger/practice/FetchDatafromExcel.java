package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDatafromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException   {
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh= wb.getSheet("organisation");
		Row row =sh.getRow(5);
		Cell cell =row.getCell(1);
		String organizationName = cell.getStringCellValue();
		System.out.println(organizationName);
		
		
		wb.close();
	
		
		
		
		
		
		
	}

}
