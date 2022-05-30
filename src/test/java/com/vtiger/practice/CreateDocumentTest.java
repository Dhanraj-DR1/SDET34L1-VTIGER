package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.SDET31L.genericUtility.SeleniumDriverLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest {
	@Test
	public  void createDocumentTest() throws IOException, InterruptedException{
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties property = new Properties();
		property.load(fis);
		String url = property.getProperty("url");
		String username = property.getProperty("userName");
		String password = property.getProperty("password");
		String timeout = property.getProperty("timeout");
		long longtimeout = Long.parseLong(timeout);
		
		
		FileInputStream fis1=new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("documentt");
		Row row = sh.getRow(2);
		Cell cell = row.getCell(1);
		String documenttitle = cell.getStringCellValue();
		
		String data = sh.getRow(2).getCell(3).getStringCellValue();
		String path = sh.getRow(2).getCell(2).getStringCellValue();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
		
		//Login to app
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	    Thread.sleep(2000);
	    
	  // String filename = new CreateDocumentTest().getClass().getName();
	    //click on document
	    driver.findElement(By.xpath("//a[@href='index.php?module=Documents&action=index']")).click();
	    //SeleniumDriverLibrary.takeScreenShot(filename, driver);
	    
	    //click on create document
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	    
	    //enter title
	    driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(documenttitle);
	    
	    Thread.sleep(2000);
	    SeleniumDriverLibrary.switchToFrame(driver, 0);
	    WebElement textarea = driver.findElement(By.xpath("//html[@dir='ltr']"));
	    textarea.sendKeys(data);
	    textarea.sendKeys(Keys.CONTROL+"a");
	    
	    
	   
	    driver.switchTo().defaultContent();
	    driver.findElement(By.xpath("//a[@id='cke_5']")).click();
	    driver.findElement(By.xpath("//a[@id='cke_6']")).click();
	    
	    
	    driver.findElement(By.xpath("//input[@id='filename_I__']")).sendKeys(path);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	    
	    driver.quit();
	   	
	}

}
