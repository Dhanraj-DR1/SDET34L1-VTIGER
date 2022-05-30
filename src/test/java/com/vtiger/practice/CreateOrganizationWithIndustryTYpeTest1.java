package com.vtiger.practice;

import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SDET31L.genericUtility.AllConstantPaths;
import com.SDET31L.genericUtility.FileLibrary;
import com.SDET31L.genericUtility.JavaLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryTYpeTest1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
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
		Sheet sh = wb.getSheet("organisation");
		Row row = sh.getRow(5);
		Cell cell = row.getCell(1);
		String organizationname = cell.getStringCellValue();
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
		
		//Login to app
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	    driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	    Thread.sleep(2000);
	    
	    //click on org,craete org
	    driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    
	   Random ran=new Random();
	   int random = ran.nextInt(1000);
	    	
	    
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationname+random);
	    
	    WebElement ele = driver.findElement(By.xpath("//select[@name='industry']"));
	    Select s=new Select(ele);
	    s.selectByValue("Education");
	    
	    
	    WebElement ele2 = driver.findElement(By.xpath("//select[@name='accounttype']"));
	    Select s1=new Select(ele2);
	    s1.selectByVisibleText("Press");
	    
	    driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	   
	    WebDriverWait wait=new WebDriverWait(driver, longtimeout);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	    WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(signout).perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	    driver.quit();
	}

}
