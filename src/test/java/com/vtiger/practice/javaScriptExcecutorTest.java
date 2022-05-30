package com.vtiger.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SDET31L.genericUtility.JavaLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExcecutorTest {
	
	public static void main(String[] args) throws IOException {
		JavaLibrary jl=new JavaLibrary();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
        js.executeScript("window.location='http://localhost:8888'");
		//SeleniumDriverLibrary.navigateToAppThroughJs("http://localhost:8888");
        driver.manage().window().maximize();
        js.executeScript("arguments[0].value=arguments[1]",driver.findElement(By.name("user_name")),"admin");
        js.executeScript("arguments[0].value=arguments[1]",driver.findElement(By.name("user_password")),"admin");
        js.executeScript("arguments[0].click()",driver.findElement(By.id("submitButton")));
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//b[contains(., 'Upcoming Activities')]")));
        
       //getting class name of the script
        String fileName = new javaScriptExcecutor().getClass().getName();
      
		//convert webdriver object to TakeScreenshot
		TakesScreenshot ts=(TakesScreenshot)driver; 
		
		//call getScreenshotAs method to cretae image file
        File src = ts.getScreenshotAs(OutputType.FILE);
        
      
        //Move image file to new destination
        File dst = new File("./screenshot/"+fileName+"_"+jl.dateTimeInformat()+".png");
        
        //copy file at destinaltion
		FileUtils.copyFile(src, dst);
		
		
        
      
		
	}

}
