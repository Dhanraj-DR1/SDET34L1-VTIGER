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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignByusingPropertyFileAndExcelTest {
	
public static void main(String[] args) throws IOException {
	
    
	FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
	Properties property = new Properties();
	property.load(fis);
	
	String url = property.getProperty("url");
	String username = property.getProperty("userName");
	String password = property.getProperty("password");
	String browser = property.getProperty("browser");
	String timeout = property.getProperty("timeout");
	long Longtimeout = Long.parseLong(timeout);
	

	FileInputStream fis2 = new FileInputStream("./src/test/resources/Worksheet.xlsx");
	Workbook wb = WorkbookFactory.create(fis2);
	Sheet sheet = wb.getSheet("organisation");
	Row row1=sheet.getRow(7);
	Cell cell1=row1.getCell(2);
	String compaignName=cell1.getStringCellValue();
	
	WebDriver driver=null;
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	 
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Longtimeout, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
    driver.findElement(By.xpath("//input[@id='submitButton']")).click();
    
    //mouseover on more
    WebElement more=driver.findElement(By.xpath("//a[@href='javascript:;']"));
    Actions act=new Actions(driver);
    act.moveToElement(more).click().perform();
    
    driver.findElement(By.xpath("//a[.='Campaigns']")).click();
    driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
    driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(compaignName);
    
    //mouseover on adminstrator image
    WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act2=new Actions(driver);
	act2.moveToElement(ele1).perform();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
    driver.quit();	
}

}
