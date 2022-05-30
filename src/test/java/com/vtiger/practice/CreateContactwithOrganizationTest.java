package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactwithOrganizationTest {
	public static void main(String[] args) throws IOException, Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		Properties property = new Properties();
		property.load(fis);
		
		String url = property.getProperty("url");
		String username= property.getProperty("userName");
		String password =property.getProperty("password");
		String browser=property.getProperty("browser");
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
		
		Random random = new Random();
		int ran = random.nextInt(1000);
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organisationname+random);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
	
		//click on contact,create contact,enter lastname,click on organization(+)
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		String LN="RAj";
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LN+random);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		//handling child browser
		Set<String> sessionIDs = driver.getWindowHandles();
		for(String id:sessionIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains("Accounts&action"))
			{
				break;
			}
		}
		
		driver.findElement(By.id("search_txt")).sendKeys(organisationname);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		
		driver.findElement(By.xpath("//a[@id='1']")).click();
		
		
		WebDriverWait wait=new WebDriverWait(driver, Longtimeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(admin).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		driver.quit();
		
		
	}

}
