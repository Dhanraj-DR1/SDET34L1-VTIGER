package com.SDET31L.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/*
 * This class is used to maintain all excel specific commands
 */
public class ExcelLibrary {
	
	static Workbook wb;
	/**
	 * This method is used to open excel 
	 * @param filepath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static void openExcel(String filepath) throws EncryptedDocumentException, IOException
	{
		FileInputStream fiExcel=new FileInputStream(filepath);
	     wb = WorkbookFactory.create(fiExcel);
	}
	
	/**
	 * This method is used to get data from excel
	 * @param sheetname
	 * @param ronNum
	 * @param cellNum
	 * @return
	 */
	public static String getDataFromExcel( String sheetname,int ronNum,int cellNum)
	{
       
	  String data = wb.getSheet(sheetname).getRow(ronNum).getCell(cellNum).getStringCellValue();
	  return data;
	}
	/**
	 * This method is used to set the data into excel
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 */
	public static void createDataIntoExcel(String sheetname,int rowNum,int cellNum,String value )
	{

	  wb.getSheet(sheetname).getRow(rowNum).createCell(cellNum).setCellValue(value);
	}
	/**
	 * This method is used to save the data into Excel
	 * @param filepath
	 * @throws IOException
	 */
	public static void saveExcelData(String fileSavePath) throws IOException
	{

		FileOutputStream fos=new FileOutputStream(fileSavePath);
		wb.write(fos);
		
	}
	/**
	 * This method is used to close the excel connection
	 * @throws IOException
	 */
	public static void closeTheExcel() throws IOException
	{
		wb.close();
	}
	/**
	 * this method use to fetch the multiple data from excel
	 * @param sheetName
	 * @return
	 */
	public static Object[][] getMultipleDataFromExcel(String sheetName)
	{
	 	  Sheet sh = wb.getSheet(sheetName);
	 	  Object[][] arr=new Object[sh.getLastRowNum()+1][sh.getRow(0).getLastCellNum()];
	 	  for(int i=0;i<=sh.getLastRowNum();i++)
	        {
	        	for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
	        	{
	        		arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
	        	}
	        }
		return arr;
	}
}
