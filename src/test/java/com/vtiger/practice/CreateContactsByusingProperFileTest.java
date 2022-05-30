package com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsByusingProperFileTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		Properties property = new Properties();
		property.load(fis);
		
		String url = property.getProperty("url");
		String username = property.getProperty("userName");
		String password = property.getProperty("password");
		String browser = property.getProperty("browser");
		String timeout = property.getProperty("timeout");
		long Longtimeout = Long.parseLong(timeout);
      
		 WebDriver driver=null;
		 
		 switch(browser)
		 {
		 case "chrome":
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 
		 case "firefox":
		   WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		 
		 default:
			 System.out.println("please specify the browser key");
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
	      }
		 
		 driver.get(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Longtimeout, TimeUnit.SECONDS);
		 
		    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
		    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		    driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		    driver.findElement(By.xpath("//a[.='Contacts']")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		    
		    String firstname = "dhanrajj";
		    String lastname = "yadav";
		    driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
		    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		    driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		    
		   
		    WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act=new Actions(driver);
			act.moveToElement(ele1).perform();
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			driver.quit();
			 
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
