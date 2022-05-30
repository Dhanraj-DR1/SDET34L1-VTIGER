package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

public class CreateOrganizationUpdateTCByExcelTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		
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
		Sheet sheet = wb.getSheet("organisation");
		Row row = sheet.getRow(5);
		Cell cell = row.getCell(1);
		String organizationName = cell.getStringCellValue();
		
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
			wb.getSheet("organisation").getRow(13).createCell(6).setCellValue("HomePage is displayed");
			wb.getSheet("organisation").getRow(13).createCell(7).setCellValue("TC Pass");
		}
		
		
		//click on organization
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	    Thread.sleep(2000);
	    
	    String title1 = driver.getTitle();
	    System.out.println(title1);
	    
	    if(title1.contains("Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM"))
		{
			wb.getSheet("organisation").getRow(14).createCell(6).setCellValue("Organization Page is displayed");
			wb.getSheet("organisation").getRow(14).createCell(7).setCellValue("TC Pass");
		}
		
	    
	    //click on create organization
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    
	    
	    String title2= driver.getTitle();
	    System.out.println(title2);
	    if(title2.contains("Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM"))
		{
			wb.getSheet("organisation").getRow(15).createCell(6).setCellValue("Create Organization Page is displayed");
			wb.getSheet("organisation").getRow(15).createCell(7).setCellValue("TC Pass");
		}
	
	    //enter organization name and save
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationName);
	    driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	    WebElement Actualorgname = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']"));
	    if(Actualorgname.getText().equalsIgnoreCase(organizationName))
	    		{
	    	wb.getSheet("organisation").getRow(16).createCell(6).setCellValue("Organization Name is saved");
			wb.getSheet("organisation").getRow(16).createCell(7).setCellValue("TC Pass");
	    		}
	    
	
	  
	    WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(signout).perform();
		 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		 
		 
		 if(driver.getTitle().contains("vtiger"))
		 {
			 wb.getSheet("organisation").getRow(17).createCell(6).setCellValue("Logout");
			 wb.getSheet("organisation").getRow(17).createCell(7).setCellValue("TC Pass");  
		 }
	 
	     

	   FileOutputStream fos=new FileOutputStream("./src/test/resources/Worksheet.xlsx");
	    wb.write(fos);
	    wb.close();
		driver.quit();
			
	    
	    
	    
		
	}

}
