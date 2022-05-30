package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createDBandFetachinginVtigerTest {
	
	public static void main(String[] args) throws SQLException {
		String Username=null,Password=null,URl=null,Timeout=null,browserName=null;
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://loaclhost:3306/practice","root","root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select *from Vtiger;");
		
		while(result.next())
		{
	      URl=result.getString("URl");
          Username=result.getString("Username");
          Password=result.getString("Password");
          Timeout=result.getString("Timeout"); 
		}
		long longtimeout = Long.parseLong(Timeout);
		WebDriver driver = null;
		
		switch (browserName)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
		    WebDriverManager.firefoxdriver().setup();
		    driver=new FirefoxDriver();
		    break;
		}
		driver.get(URl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		String firstName = "sdet34";
		String lastName = "ydv";
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName );
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}	
		
		

}
