package com.vtiger.practice;

import org.testng.Assert;
import org.testng.Reporter;

public class TestNgAssertTest {

	public void practice1Test() {
		Reporter.log("a-practice1");
		Reporter.log("b-practice1");
		Reporter.log("c-practice1");
		Assert.fail();
		Reporter.log("d-practice1");
		Reporter.log("e-practice1");
		Reporter.log("f-practice1");	
	}
	public void practice2Test() {
		Reporter.log("e-practice2");
		Reporter.log("d-practice2");
		Reporter.log("c-practice2");
		Assert.fail();
		Reporter.log("b-practice2");
		Reporter.log("a-practice2");
	}
	public void practice3Test(){
		Reporter.log("a-practice3");
		Reporter.log("b-practice3");
		Reporter.log("c-practice3");
		Reporter.log("d-practice3");
		Assert.fail();
		Reporter.log("e-practice3");
		Reporter.log("3");
	}
	public void practice4Test(){
		Reporter.log("a-practice1");
		Reporter.log("b-practice1");
		Reporter.log("c-practice1");
		Reporter.log("d-practice1");
		Assert.fail();
		Reporter.log("e-practice1");
		Reporter.log("f-practice1");
	}
	
}

