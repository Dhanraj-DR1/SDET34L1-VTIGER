package com.SDET31L.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart"+Thread.currentThread().getId());
		ExtentSparkReporter spark=new ExtentSparkReporter("./executeReport/extentReport.html");
		spark.config().setDocumentTitle("DocumentTITLE");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("ReportName");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		
		report.setSystemInfo("Enviornment", "Testing Environment");
		report.setSystemInfo("ReporterName", "Dhanraj");
		report.setSystemInfo("Platform", "Windows 10");
		report.setSystemInfo("Unit Testing Tool", "TestNG");
		report.setSystemInfo("Build Management Tool", "Maven");
		report.setSystemInfo("Automation Tool", "selenium");
	
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("onTestStart"+Thread.currentThread().getId());
	    test = report.createTest(result.getMethod().getMethodName());
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess"+Thread.currentThread().getId());
		test.log(Status.PASS, result.getMethod().getMethodName()+"is pass");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		SeleniumDriverLibrary seleniumDriverLibrary=new SeleniumDriverLibrary();
		System.out.println("onTestSuccess"+Thread.currentThread().getId());
		test.log(Status.FAIL, result.getMethod().getMethodName()+"is failed");
		test.log(Status.FAIL, result.getThrowable());
		try {
			test.addScreenCaptureFromPath(seleniumDriverLibrary.takeScreenShot(	result.getMethod().getMethodName(), BaseClass.staticdriver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("onTestSuccess"+Thread.currentThread().getId());
		test.log(Status.SKIP, result.getMethod().getMethodName()+"is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage"+Thread.currentThread().getId());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onStart"+Thread.currentThread().getId());
		report.flush();
	}

}
