package com.CarbonIntensity;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Base.ExtentTestManager;


public class PR173_TC01_CarbonIntensity extends AbstractTestNg{
//ExtentTestManager etm = new ExtentTestManager();
    public PR173_TC01_CarbonIntensity() throws IOException {
    }

    @Test
    public void VerifyPage() {
    	ExtentTestManager.startTest("Crabon","CarbonTestFor SAmple");
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
	 CarbonIntensity carbonIntensity = new CarbonIntensity(webDriverHandler);
	 carbonIntensity.verifyModalCI(); }
	 


	/*
	 * @Test public void VerifyRegionalData() throws InterruptedException {
	 * CarbonIntensity carbonIntensity = new CarbonIntensity(webDriverHandler);
	 * carbonIntensity.accessRegionalChart("Regional Data", "London"); }
	 */
	
    @Test
    public void VerifyGetInTouch() {
        CarbonIntensity carbonIntensity = new CarbonIntensity(webDriverHandler);
        carbonIntensity.accessGetInTouch();
    } 
}