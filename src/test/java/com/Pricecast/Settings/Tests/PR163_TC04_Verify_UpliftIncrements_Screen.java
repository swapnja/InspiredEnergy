package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.UpliftsIncrements;
import com.Pricecast.PageObjects.BrokerSettings.supplyAndSuppliersSelection;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC04_Verify_UpliftIncrements_Screen extends AbstractTestNg {
	public PR163_TC04_Verify_UpliftIncrements_Screen() throws IOException {
	}	
//passed
	@Test
	public void UpliftIncrements_Gas() throws InterruptedException {
		UpliftsIncrements upliftIncrements = new UpliftsIncrements(webDriverHandler);
		supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
		upliftIncrements.selectSettings();
		sas.selectGasSupplier();
		upliftIncrements.addNewRow(12,1,"0.0;0.1;0.2;0.3;0.4;0.5;0.6;0.7;0.8;0.9;1.0","95");
		upliftIncrements.btnOk.waitClickable().click();
	} 
		//	passed
	@Test
	public void UpliftIncrements_Power() throws InterruptedException {
		UpliftsIncrements upliftIncrements = new UpliftsIncrements(webDriverHandler);
		supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
		upliftIncrements.selectSettings();
		sas.selectPowerSupplier();
		upliftIncrements.addNewRow(12,1,"0.0;0.1;0.2;0.3;0.4;0.5;0.6;0.7;0.8;0.9;1.0","All");
		upliftIncrements.btnOk.waitClickable().click();
	}	
	 //passed
	 @Test
	public void columnVerification_Gas() throws InterruptedException{
		UpliftsIncrements uplifts = new UpliftsIncrements(webDriverHandler);
		supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
		uplifts.selectSettings();
		sas.selectGasSupplier();
		uplifts.upliftIncrementsColumnVerification();
	}	
	//passed
	 @Test
	public void columnVerification_Power() throws InterruptedException{
		UpliftsIncrements uplifts = new UpliftsIncrements(webDriverHandler);
		supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
		uplifts.selectSettings();
		sas.selectPowerSupplier();
		uplifts.upliftIncrementsColumnVerification();
	}
	//passed
	@Test
	public void SupplierUplift_NumericValidation_Gas() throws InterruptedException {
		UpliftsIncrements uplifts = new UpliftsIncrements(webDriverHandler);
		supplyAndSuppliersSelection sas = new supplyAndSuppliersSelection(webDriverHandler);
		uplifts.selectSettings();
		sas.selectGasSupplier();
		uplifts.addNewRow(-155552,2,"-111111111111111111","All");
		uplifts.UpliftIncrements_NumericValidation();
		
	}
}

