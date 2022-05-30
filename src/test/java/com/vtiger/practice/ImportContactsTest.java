package com.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.SDET31L.genericUtility.BaseClass;
import com.SDET31L.genericUtility.SeleniumDriverLibrary;
import com.vtiger.objectRepository.ContactPage;
import com.vtiger.objectRepository.CreateContactPage;
import com.vtiger.objectRepository.HomePage;

public class ImportContactsTest extends BaseClass{
	@Test
	public void  importContactsTest() throws InterruptedException{
		HomePage hp=new HomePage(driver);
		ContactPage cp=new ContactPage(driver);
		CreateContactPage createCp=new CreateContactPage(driver);
	
		hp.contactClick();
	    cp.createContactIconClick();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@id='import_file']")).sendKeys("C:\\Users\\Dhanraj\\Desktop\\importContact.csv");
	    WebElement fileType = driver.findElement(By.xpath("//select[@id='type']"));
	    SeleniumDriverLibrary.dropDownHandle(fileType, "CSV");
	    WebElement characterEncoding = driver.findElement(By.xpath("//select[@id='file_encoding']"));
	    SeleniumDriverLibrary.dropDownHandle(characterEncoding, "ISO-8859-1");
	    WebElement delimiter = driver.findElement(By.xpath("//select[@id='delimiter']"));
	    SeleniumDriverLibrary.dropDownHandle(delimiter, ", (comma)");
	    driver.findElement(By.xpath("//input[@id='has_header']")).click();
	    driver.findElement(By.xpath("//input[@name='next']")).click();
	    
	    Thread.sleep(2000);
	    WebElement crmFiled1 = driver.findElement(By.xpath("(//select[@name='mapped_fields'])[1]"));
	    SeleniumDriverLibrary.dropDownHandle(crmFiled1,4);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@name='lastname_defaultvalue']")).sendKeys("AShok");
	    driver.findElement(By.xpath("//input[@name='import']")).click();
	 
	   
	    
		
		
	}

}
