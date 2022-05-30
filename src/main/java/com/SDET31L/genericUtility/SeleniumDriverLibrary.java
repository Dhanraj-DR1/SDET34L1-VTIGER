package com.SDET31L.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to maintain all webdriver common actions
 * @author Dhanraj
 *
 */
public class SeleniumDriverLibrary {
	
	
	 WebDriverWait wait;
	static Select select;
	 Actions act;
	 JavascriptExecutor js;
	/**
	 * This method is used to navigate to the application
	 * @param url
	 * @param driver
	 */
	public static void navigateApp(String url,WebDriver driver)
	{
		driver.get(url);
	}
	/**
	 * This method is used to maximize the browser and implicit wait
	 * @param driver
	 */
	public static void browserSetting(WebDriver driver,long longtimeout)
	{
		maximizeBrowser(driver);
		waitTillPageLoad(longtimeout, driver);
	}
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to implicitly wait till page laod 
	 * @param longTimeout
	 * @param driver
	 */
	public static void waitTillPageLoad(long longTimeout,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
	}
	/**
	 * This method use to initialize Action class
	 * @param driver
	 */
	public  void intializeActions(WebDriver driver)
	{
		act=new Actions(driver);
	}
	/**
	 * This method is used to mouse hover on the element
	 * @param driver
	 * @param element
	 */
	public  void mouseHoverOntheElement(WebDriver driver,WebElement element)
	{
	    act=new Actions(driver);
		act.moveToElement(element).perform();
				
	}
	/**
	 * This method is used to double click on the element
	 * @param element
	 */
	
	public  void doubleClick(WebElement element)
	{
		act.doubleClick(element).perform();
	}
	/**
	 * This method is used to double click
	 */
	public  void doubleClick()
	{
		act.doubleClick().perform();
	}
	/**
	 * This method is used to close the browser
	 * @param driver
	 */
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	/**
	 * This method is used to handle dropdown based on index
	 * @param element
	 * @param index
	 */
	public static void dropDownHandle(WebElement element,int index)
	{
		select=new Select(element);
	    select.selectByIndex(index);
	}
	/**
	 *  This method is used to handle dropdown based on visibletext
	 * @param element
	 * @param visibletext
	 */
	public static void dropDownHandle(WebElement element,String visibletext)
	{
		
		select=new Select(element);
	    select.selectByVisibleText(visibletext);  
	}   
	/**
	 *  This method is used to handle dropdown based on value
	 * @param value
	 * @param element
	 */
	public static void dropDownHandle(String value,WebElement element)
	{
		select=new Select(element);
		select.deselectByValue(value);
	}
	/**
	 * This method is used initialize webdriverwait
	 * @param driver
	 * @param longtimeout
	 */
	public void explicitlyWait(WebDriver driver, long longtimeout)
	{
		 wait=new WebDriverWait(driver, longtimeout);
	}
	/**
	 *  This method is used to wait till visibility of element
	 * @param element
	 */
	public  void waitUntilvisibilityOfElement(WebDriver driver,WebElement element,long longtimeout)
	{
		 wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**-
	 * This method is used to wait till element is clickable
	 * @param element
	 */
	public void waitUntilElementClickable(WebElement element,WebDriver driver, long longtimeout)
	{
		
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to switch to the window based on title
	 * @param driver
	 * @param partialText
	 */
	public static void switchToWindowBAsedonTitle(WebDriver driver,String partialText)
	{
		Set<String> sessionIDs = driver.getWindowHandles();
		for(String id:sessionIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText));
			{
				break;
			}
		}
	}
	public static void switchToWindowBasedonTitle(WebDriver driver,String partialText)
	{
		String parentwindow = driver.getWindowHandle();
		Set<String> sessionIDs = driver.getWindowHandles();
		Iterator<String> i1 = sessionIDs.iterator();
		while(i1.hasNext())
		{
			String childWindow = i1.next();
			if(!parentwindow.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
				break;
			}
			
		}
	
	}
	
	/**
	 * This method is used to switch the frame by index
	 * @param driver
	 * @param index
	 */
	public static void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch to the frame by using index
	 * @param driver
	 * @param nameOrId
	 */
	public static void switchToFrame(WebDriver driver,String nameOrId )
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method is used to switch to the home page
	 * @param driver
	 */
	public static void switchBackToHomePage(WebDriver driver)
	    
	{
		driver.switchTo().defaultContent();
		
	}
    /**
     * This method is used to accept the alert notification
     * @param driver
     */
	public static void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	/**
	 * This method is used to dismiss the alert notification
	 * @param driver
	 */
	public static void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
		
	}
	/**
	 * This method is used to send data to the alert notification
	 * @param driver
	 * @param data
	 */
	public static void alertsendData(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
		
	}
	/**
	 * This method is used to get text from  the alert notification
	 * @param driver
	 */
	public static void getalertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
		
	}
	/**
	 * This method is used to right click
	 */
	public void rightClick()
	{
		act.contextClick().perform();
	}
	/**
	 * This method is used to right click on the element
	 * @param element
	 */
	public  void rightClick(WebElement element)
	{
		act.contextClick(element).perform();
	}
	/**
	 * This method is used to take screenshot of the page
	 * @param fileName
	 * @param driver
	 * @return 
	 * @throws IOException
	 */
	public  String  takeScreenShot(String fileName,WebDriver driver) throws IOException
	{
		
		JavaLibrary jl=new JavaLibrary();
		TakesScreenshot ts=(TakesScreenshot)driver; 
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dst = new File("./screenshot/"+fileName+"_"+jl.dateTimeInformat()+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
	}
	/**
	 * This method is used to initialize javascript executor
	 * @param driver
	 */
	public void InitializeJs(WebDriver driver) 
	{
		 js=(JavascriptExecutor)driver;
		
	}
	/**
	 * This method is used to navigate to app through Javascript executor
	 * @param url
	 */
	public void navigateToAppThroughJs(String url)
	{
		js.executeScript("window.location=arguments[0]",url);
	}
	/**
	 * This method is used to enter data through Javascript executor
	 * @param driver
	 * @param element
	 * @param value
	 */
	public  void enterDataThroughJs(WebDriver driver,WebElement element, String value)
	{
		js.executeScript("arguments[0].value=arguments[1]",element,value);
	}
	/**
	 * This method is used to click through Javascript executor
	 * @param driver
	 * @param element
	 */
	public  void clickThroughJs(WebElement element)
	{
		 js.executeScript("arguments[0].click()",element);
	}
	/**
	 * This method is used to scroll till element by using Javascript executor
	 * @param element
	 */
	public  void scrollTillElement(WebElement element)
	{
		
        js.executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * This method is used to scroll page till end of the page through Javascript executor
	 * @param element
	 */
	public void scrollPageTillEnd(WebElement element)
	{
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        
	}
	
	
	
		
	}	


