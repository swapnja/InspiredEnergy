 package com.Base;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/**
 * extentTestMap holds the information of thread ids and ExtentTest instances.
 * ExtentReports instance created by calling createExtentReports() method from ExtentManager.
*/
public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports    extent        = ExtentManager.createExtentReports();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest startTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
} 