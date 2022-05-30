package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Listener {

	
	@Test()
	public static void practiceTest2() {
		 Reporter.log("hey hey",true);
		
	}
	
	 
	@Test()
	public static void  practiceTest3() {
		 Reporter.log("BYe bye",true);
		 Assert.assertEquals("A", "C");
	}
	
	@Test()
	public static void practiceTest4() {
		Reporter.log("Good-Bye",true);
	}
}
