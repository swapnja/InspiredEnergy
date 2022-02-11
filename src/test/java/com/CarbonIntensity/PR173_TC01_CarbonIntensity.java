package com.CarbonIntensity;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Base.ExtentTestManager;


public class PR173_TC01_CarbonIntensity extends AbstractTestNg{

//ExtentTestManager etm = new ExtentTestManager();
    public PR173_TC01_CarbonIntensity() throws IOException {
    	//ExtentTestManager.startTest("Carbon Intensity Tests","CI Suite");
    	
    }

    @Test(description="Verify if the SAmpleeeeeeeeeeeeeeeeeeeeeeeeeeee")
    public void VerifyPage() {
    	//ExtentTestManager.startTest("Carbon Intensity Tests-VerifyPage Scenarios");
    	//etm.startTest("VerifyPage", "CarbonIntensity test1");
        CarbonIntensity carbonIntensity = new CarbonIntensity(webDriverHandler);
        carbonIntensity.loadGM();
        carbonIntensity.loadCI();
        carbonIntensity.loadRD();
        carbonIntensity.loadCInt();
        carbonIntensity.loadTD();
        carbonIntensity.loadPage();
    }

	
	 @Test public void VerifyCIModal() throws InterruptedException {
     ExtentTestManager.startTest("Carbon Intensity Tests-VerifyCIModal Scenarios");
	 CarbonIntensity carbonIntensity = new CarbonIntensity(webDriverHandler);
	 carbonIntensity.verifyModalCI(); }
	 


	/*
	 * @Test public void VerifyRegionalData() throws InterruptedException {
	 * CarbonIntensity carbonIntensity = new CarbonIntensity(webDriverHandler);
	 * carbonIntensity.accessRegionalChart("Regional Data", "London"); }
	 */
	
    @Test
    public void VerifyGetInTouch() {
    	ExtentTestManager.startTest("Carbon Intensity Tests-VerifyGetTouch Scenarios");
        CarbonIntensity carbonIntensity = new CarbonIntensity(webDriverHandler);
        carbonIntensity.accessGetInTouch();
    } 
}