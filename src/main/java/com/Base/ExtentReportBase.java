package com.Base;

//D:\Jenkins\home\workspace\Unify\src\main\java\
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportBase {
		public static ExtentSparkReporter  spark ;
	    public static ExtentReports extent; 
	    public static ExtentTest test;

  @BeforeTest
  public void beforeMethod() {
	  test= extent.createTest("Weekly Automation suite");
  }

  @AfterMethod
  public void getResult(ITestResult result)
  {
      if(result.getStatus() == ITestResult.FAILURE)
      {
          test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED)+" Test case FAILED due to below issues:");
          test.fail(result.getThrowable());
      }
      else if(result.getStatus() == ITestResult.SUCCESS)
      {
          test.log(Status.PASS, MarkupHelper.createLabel(result.getTestClass().getName()+"-" + result.getName(),ExtentColor.GREEN));
      }
      else
      {
          test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE) +" Test Case SKIPPED");
          test.skip(result.getThrowable());
      }
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeSuite 
  public void setUp()
  {
      spark = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/extentReport.html");
      extent = new ExtentReports();
     
      extent.attachReporter(spark);

      extent.setSystemInfo("OS", "Windows");
      extent.setSystemInfo("Host Name", "Test");
      extent.setSystemInfo("Environment", "QA-Staging Envionment");
      extent.setSystemInfo("User Name", "Swapnja Gudle");

    //  spark.config().setChartVisibilityOnOpen(true);
      spark.config().setDocumentTitle("Extent report");
      spark.config().setReportName("Final Report");
  }

  @AfterSuite
  public void tearDown(){
  	 extent.flush();
     }

 
}
