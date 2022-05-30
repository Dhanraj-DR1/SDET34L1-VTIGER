package com.rmgyantra.ProjectTest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET31L.genericUtility.AllConstantPaths;
import com.SDET31L.genericUtility.DatabaseLibrary;
import com.SDET31L.genericUtility.ExcelLibrary;
import com.SDET31L.genericUtility.FileLibrary;
import com.SDET31L.genericUtility.JavaLibrary;
import com.SDET31L.genericUtility.SeleniumDriverLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateprojectInGUIAndVerifyInDB {
	public static void main(String[] args) throws SQLException, IOException {
		        
		        JavaLibrary javalibrary=new JavaLibrary();
		        SeleniumDriverLibrary seleniumDriverLibrary=new SeleniumDriverLibrary();
		        WebDriverManager.firefoxdriver().setup();
	            WebDriver driver=new FirefoxDriver();
	            
	            ExcelLibrary.openExcel(AllConstantPaths.EXCELFILEPATH);
	            String projectName = ExcelLibrary.getDataFromExcel("CreateProject", 3, 1);
	            String projectManager = ExcelLibrary.getDataFromExcel("CreateProject", 3, 2);
	            FileLibrary.openPropertyFile(AllConstantPaths.RMGYANTRA_PROPERTYFILE_PATH);
	            String url = FileLibrary.fetchDataFromPropertyFile("url");
	            String username = FileLibrary.fetchDataFromPropertyFile("userName");
	            String password = FileLibrary.fetchDataFromPropertyFile("password");
	            SeleniumDriverLibrary.navigateApp(url, driver);
	            SeleniumDriverLibrary.browserSetting(driver,10);
				
				driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
				WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
				seleniumDriverLibrary.mouseHoverOntheElement(driver, submit);
				submit.click();
				
				driver.findElement(By.xpath("//a[.='Projects']")).click();
				driver.findElement(By.xpath("//span[.='Create Project']")).click();
				driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName+javalibrary.getRandomNumber(1000));
				driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys(projectManager);
				
				WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
				SeleniumDriverLibrary.dropDownHandle(ele, 1);
				driver.findElement(By.xpath("//input[@value='Add Project']")).click();
				
				FileLibrary.openPropertyFile(AllConstantPaths.RMGYANTRA_PROPERTYFILE_PATH);
				DatabaseLibrary.openDBConnection( AllConstantPaths.DATABASEURL+FileLibrary.fetchDataFromPropertyFile("dbName"),
				FileLibrary.fetchDataFromPropertyFile("dbUserName"),FileLibrary.fetchDataFromPropertyFile("dbPassword"));
				
				DatabaseLibrary.getDataFromDataBase("select * from project","created_by");
				/*//step5:Execute Query
				ResultSet result = statement.executeQuery("select * from project;");
				+
				//step6:validate
				while(result.next())
				{
					System.out.println(result.getString(2));
				
				}*/
				
				//step7:close the connection
				DatabaseLibrary.closeDBConnecction();
				
	}

}
