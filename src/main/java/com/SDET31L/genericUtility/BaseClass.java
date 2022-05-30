package com.SDET31L.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This classs contains implementation of all basic configuration annoatation
 * @author Dhanraj
 *
 */
public class BaseClass {
	
	 public String url;
	 public String username;
	 public String password;
	 public String browser;
	 public String timeout;
	 public long longtimeout;
	 public int randomNumber;
	 public JavaLibrary javaLibrary;
	 public WebDriver driver;
	 public LoginPage loginPage;
	 public HomePage homePage;
	 public SeleniumDriverLibrary seleniumDriverLibrary;
	 public static WebDriver staticdriver;
	 
	 
	/**
	 * This method is used to open Excel 
	 *  This method is used to open property file
	 * @throws IOException
	 */
	@BeforeSuite(groups = "baseclass")
	public void beforesuite1Test() throws IOException
	{
		FileLibrary.openPropertyFile(AllConstantPaths.PROPERTYFILEPATH);
		ExcelLibrary.openExcel(AllConstantPaths.EXCELFILEPATH);
	}

	/**
	 * This method is used to get all the normal execution configurations
	 * @throws IOException
	 */
	//@Parameters("browser")
	@BeforeClass(groups = "baseclass")
	public void beforeClass1Test() throws IOException {
		 javaLibrary=new JavaLibrary();
		 seleniumDriverLibrary=new SeleniumDriverLibrary();
		 url = FileLibrary.fetchDataFromPropertyFile("url");
		 //username = FileLibrary.fetchDataFromPropertyFile("userName");
		 username=System.getProperty("USERNAME");
		 password=System.getProperty("PASSWORD");
		 //password = FileLibrary.fetchDataFromPropertyFile("password");
		 browser = FileLibrary.fetchDataFromPropertyFile("browser");
	     timeout = FileLibrary.fetchDataFromPropertyFile("timeout");	
		 longtimeout = javaLibrary.stringToLong(timeout);
		 randomNumber = javaLibrary.getRandomNumber(1000);
		 
		 
		 switch(browser)
		 {
		 case "chrome":
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 break;
			 
		 case "firefox":
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
		   break;
		 
		 default:
			 
			 System.out.println("please specify the browser key");
			 WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 break;
	      }
		 
		 staticdriver=driver;
		 SeleniumDriverLibrary.navigateApp(url, driver);
		 SeleniumDriverLibrary.browserSetting(driver, longtimeout);
		 seleniumDriverLibrary.explicitlyWait(driver, longtimeout);
		 loginPage=new LoginPage(driver);
		 homePage=new HomePage(driver);

	}

	/**
	 * This method is used to login to the application
	 */
	@BeforeMethod(groups = "baseclass")
	public void beforeMethod1Test() 
	{
		loginPage.loginToApp(username, password);
	}
	/**
	 * This method is used to sign out the application
	 * @throws InterruptedException 
	 */
	@AfterMethod(groups = "baseclass")
	public void afterMethod1() throws InterruptedException 
	{
		
		homePage.signout(driver, seleniumDriverLibrary);
	}
	/**
	 * This method is used to close the entire browser
	 */
	@AfterClass(groups = "baseclass")
	public void afterClass1Test() 
	{
		SeleniumDriverLibrary.quitBrowser(driver);
	}
	/**
	 * This method is used to close the excel file
	 * save excel data
	 * @throws IOException
	 */
	@AfterSuite(groups = "baseclass")
	public void aftersuite1Test() throws IOException 
	{
	 ExcelLibrary.saveExcelData(AllConstantPaths.EXCELFILEPATH);
	 ExcelLibrary.closeTheExcel();
	
	}
		
	

}
