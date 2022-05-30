package com.SDET31L.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * This class contains only java specific re
 * @author Dhanraj
 *
 */
public class JavaLibrary {
	/**
	 * This method is used to convert string value to long datatype
	 * @param value
	 * @return
	 */
	public long stringToLong(String value) {
		return Long.parseLong(value);
		
	}
	/**
	 * This method is get the random number
	 * @param limit
	 * @return
	 */

	public int getRandomNumber(int limit) {
		Random ran=new Random();
		return ran.nextInt(limit);	
	}
	/**
	 * This method is used to print statement
	 * @param message
	 */
	public  void printStatement(String message)
	{
		System.out.println(message);
	} 
	/**
	 * This is used to validate actual result with expected result
	 * @param actualResult
	 * @param expectedResult
	 */
	public void ifvalidation(String actualResult,String expectedResult)
	{
	 if(actualResult.contains(expectedResult))
	   {
		 
		   System.out.println("TC pass");
	   }
	   else
	   {
		   System.out.println("fail");
	   }
	}
	/**
	 * This method is used to write data into the excel
	 * @param sessionId
	 * @param ExpectedsessionId
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param expectedResult
	 * @param status
	 */
	public  void assertionThroughIfCondition(String sessionId,String ExpectedsessionId,String sheetName,int rowNum,int cellNum,String expectedResult,String status)
	{
		if(sessionId.contains(ExpectedsessionId))
		{
			ExcelLibrary.createDataIntoExcel(sheetName, rowNum, cellNum, expectedResult);
			ExcelLibrary.createDataIntoExcel(sheetName, rowNum, cellNum, status);
			
			
		}
			
	}
	/**
	 * This method is used to wait until element CLickable
	 * @param element
	 * @param polingTime
	 * @param duration
	 * @throws InterruptedException
	 */
	public  void customWait(WebElement element,long polingTime,int duration) throws InterruptedException{
		int  count=0;
		
		while(count<=duration) {

	      try {
		
		   element.click();
		   break;
		}
		catch(Exception e) {
			Thread.sleep(polingTime*500);//1second=pass 1000 
			count++;
		}
	}}
		/**
		 * This method is used to get date format
		 * @return
		 */
		public  String dateTimeInformat(){
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
			Date date = new Date();
			String D = formatter.format(date);
			System.out.println(D);
			return D;
		}	
		
	}

