package com.vtiger.practice;

import java.io.FileInputStream;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationByusingPropertyFileAndExcelTest {
	
	@Test
	public void createOrganozationByUsingProertyFile() throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		Properties property = new Properties();
		property.load(fis);
		String url = property.getProperty("url");
		String username = property.getProperty("userName");
		String password = property.getProperty("password");
		String browser = property.getProperty("browser");
		String timeout = property.getProperty("timeout");
		
		FileInputStream fis2 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sheet = wb.getSheet("organisation");
		
		Row row = sheet.getRow(5);
		Cell cell = row.getCell(1);
		String organisationname = cell.getStringCellValue();
		Row row1 = sheet.getRow(5);
		Cell cell1 = row1.getCell(2);
		String lastname = cell1.getStringCellValue();
		wb.close();
		
		 
		long Longtimeout = Long.parseLong(timeout);
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Longtimeout, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		Random ran = new Random();
		int random = ran.nextInt(1000);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organisationname+random);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		 WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(signout).perform();
		 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		 
		 driver.quit();
		
		
	}

}
