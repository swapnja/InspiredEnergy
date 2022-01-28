package com.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	public static final ExtentReports extentReports = new ExtentReports();

	/*
	 * public synchronized static ExtentReports createExtentReports() {
	 * ExtentSparkReporter reporter = new
	 * ExtentSparkReporter("./extent-reports/extent-report.html");
	 * reporter.config().setReportName("Automation Weekly execution Report");
	 * extentReports.attachReporter(reporter);
	 * extentReports.setSystemInfo("Envionmnet details", "Staging envionmnet");
	 * extentReports.setSystemInfo("Tester", "Swapnja Gudle"); return extentReports;
	 * 
	 * ExtentManager ExtentManager = null; return ExtentManager;
	 * 
	 * }
	 */
	/*
	public static ExtentReports createInstance() {
		//ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		ExtentSparkReporter reporter = new ExtentSparkReporter("D:/Jenkins/home/workspace/Unify/extent-reports/extent-report.html");
		
		reporter.config().setReportName("Automation Weekly execution Report");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Envionmnet details", "Staging envionmnet");
		extentReports.setSystemInfo("Tester", "Swapnja Gudle");
		return extentReports;
	}
*/
	public static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("Automation Weekly execution Report");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Envionmnet details", "Staging envionmnet");
		extentReports.setSystemInfo("Tester", "Swapnja Gudle");
		return extentReports;
		
	}
}