package com.rmgyantra.ProjectTest;

	import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

	public class  CreateProjectInDBAndVerifyInGUITest{

		public static void main(String[] args) throws SQLException, IOException {
			    
			        JavaLibrary javaLibrary=new JavaLibrary();
			        ExcelLibrary.openExcel(AllConstantPaths.EXCELFILEPATH);
	               // String projectName = ExcelLibrary.getDataFromExcel("CreateProject", 3, 1);
	                String projectManager = ExcelLibrary.getDataFromExcel("CreateProject", 3, 2);
					FileLibrary.openPropertyFile(AllConstantPaths.RMGYANTRA_PROPERTYFILE_PATH);
			        String url = FileLibrary.fetchDataFromPropertyFile("url");
			        String username = FileLibrary.fetchDataFromPropertyFile("userName");
			        String password = FileLibrary.fetchDataFromPropertyFile("password");
					FileLibrary.openPropertyFile(AllConstantPaths.RMGYANTRA_PROPERTYFILE_PATH);
				    DatabaseLibrary.openDBConnection(AllConstantPaths.DATABASEURL+FileLibrary.fetchDataFromPropertyFile("dbName"),FileLibrary.fetchDataFromPropertyFile("dbUserName"),FileLibrary.fetchDataFromPropertyFile("dbPassword"));
					
					
					String query= "insert into project(project_id,created_by,created_on,project_name,status,team_size) values('TY_project','Harsh','29/04/2022','ck','On Going','3')";	
					
					DatabaseLibrary.setDataInDataBase(query);
					DatabaseLibrary.closeDBConnecction();
					
					WebDriverManager.chromedriver().setup();
					WebDriver driver=new FirefoxDriver();
					SeleniumDriverLibrary.navigateApp(url, driver);
					SeleniumDriverLibrary.browserSetting(driver, 10);
					driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
					driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
					driver.findElement(By.xpath("//button[.='Sign in']")).click();
					driver.findElement(By.xpath("//a[.='Projects']")).click();
					
					
					List<WebElement> projectname = driver.findElements(By.xpath("//table//tbody/tr/td[4]"));
					 for (WebElement project1 : projectname) {
						if (project1.getText().equalsIgnoreCase("Harsh")) {
							System.out.println("project name is visible in GUI");
							System.out.println("test case pass");
							break;
						}
					}
					SeleniumDriverLibrary.quitBrowser(driver);
		}

	}


