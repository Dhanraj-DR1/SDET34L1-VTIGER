package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithWriteInExcelTest {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties property = new Properties();
		property.load(fis);
		
		String url = property.getProperty("url");
		String username = property.getProperty("userName");
		String password = property.getProperty("password");
		String timeout = property.getProperty("timeout");
		long longtimeout = Long.parseLong(timeout);
	
		Random ran = new Random();
		int random = ran.nextInt(1000);
		
		FileInputStream fis2=new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sheet = wb.getSheet("contact");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(1);
		String firstName = cell.getStringCellValue();
		
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(1);
		String lastname = cell1.getStringCellValue();
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longtimeout,TimeUnit.SECONDS);
		
		//Login to app
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		if(driver.getTitle().contains("Home"))
		{
			wb.getSheet("contact").getRow(7).createCell(4).setCellValue("HomePage is displayed");
			wb.getSheet("contact").getRow(7).createCell(5).setCellValue("TC Pass");
		}
		
		//Click on contact
		 driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		 if(driver.getTitle().contains("Contacts"))
		 {
			    wb.getSheet("contact").getRow(8).createCell(4).setCellValue("Contact page is dispalyed");
				wb.getSheet("contact").getRow(8).createCell(5).setCellValue("TC Pass");
			 
		 }
		 
		 //click on create contact
		 driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		 if(driver.getTitle().contains("Contacts"))
			 {
			    wb.getSheet("contact").getRow(9).createCell(4).setCellValue("Create Contact page is dispalyed");
				wb.getSheet("contact").getRow(9).createCell(5).setCellValue("TC Pass");
			 
			 
			 }
		 
	    //Save FN and LN
		 driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);
		 driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		
		 WebElement ActualLastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']"));
		 
		 if(ActualLastName.getText().equalsIgnoreCase(lastname))
		 {
			 wb.getSheet("contact").getRow(10).createCell(4).setCellValue("Contact created");
			 wb.getSheet("contact").getRow(10).createCell(5).setCellValue("TC Pass"); 
		 }
		 
		 WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(signout).perform();
		 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		 
		 
		 if(driver.getTitle().contains("vtiger"))
		 {
			 wb.getSheet("contact").getRow(11).createCell(4).setCellValue("Logout");
			 wb.getSheet("contact").getRow(11).createCell(5).setCellValue("TC Pass");  
		 }
		 
		
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Worksheet.xlsx");
		wb.write(fos);
		wb.close();
		driver.quit();
		
		 
		 
		
		
		
		
	
		
		
	}

}
