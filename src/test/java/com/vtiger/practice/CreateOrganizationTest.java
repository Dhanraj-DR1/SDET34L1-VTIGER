package com.vtiger.practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest 
	{
		@Test
		public void CreateOrganizationTest1() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	    
	    
	    driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    
	    Random ran= new Random();
	    int random = ran.nextInt(1000);
	    
	    String organizationName = "zen"+random;
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organizationName);
	    driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	    
	    String ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		   if(ele.contains("ze"))
		   {
			   System.out.println("pass");
		   }
		   else
		   {
			   System.out.println("fail");
		   }
		   
		  WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		  Actions act=new Actions(driver);
		  act.moveToElement(ele1).perform();
		  driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		  driver.quit();
		  
	    
	    
	                                             
	    
	    
	    
	
	    
	    
	
	    
	  
	}

}
