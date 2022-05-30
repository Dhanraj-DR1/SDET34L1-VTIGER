package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateprojectInGUIAndVerifyInDB {
	public static void main(String[] args) throws SQLException {
		
		        WebDriverManager.firefoxdriver().setup();
	            WebDriver driver=new FirefoxDriver();
	            
				driver.get("http://localhost:8084");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
				driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
				WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
				WebDriverWait wait=new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(submit));
				submit.click();
				
				driver.findElement(By.xpath("//a[.='Projects']")).click();
				driver.findElement(By.xpath("//span[.='Create Project']")).click();
				driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("TY_PROJECT_01");
				driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("dhanraj");
				
				WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
				Select s = new Select(ele);
				s.selectByIndex(1);
				driver.findElement(By.xpath("//input[@value='Add Project']")).click();
				
				//step1: create object for implementation class
				
				Driver driver1=new Driver();
				
				//step2:Register the driver with JDBC
				
			    DriverManager.registerDriver(driver1);
				
			
				//step3:Establish the database connection
				Connection Connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
				
				//step4:create statement
				Statement statement = Connection.createStatement();
				
				//step5:Execute Query
				ResultSet result = statement.executeQuery("select * from project;");
				
				//step6:validate
				while(result.next())
				{
					System.out.println(result.getString(2));
				
				}
				
				//step7:close the connection
				Connection.close();	
				
	}

}
