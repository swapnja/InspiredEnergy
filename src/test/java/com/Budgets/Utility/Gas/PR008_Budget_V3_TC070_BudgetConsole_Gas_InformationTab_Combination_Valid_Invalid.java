//Verify Information tab on Budget Console Screen 
package com.Budgets.Utility.Gas;

import com.Budgets.AbstractTestNg;
import com.Budgets.PageHandlers.CommonPageHandler;
import com.Budgets.PageHandlers.CustomersPageHandler;
import com.Budgets.PageHandlers.InformationImportHandler;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR008_Budget_V3_TC070_BudgetConsole_Gas_InformationTab_Combination_Valid_Invalid extends AbstractTestNg {

    public PR008_Budget_V3_TC070_BudgetConsole_Gas_InformationTab_Combination_Valid_Invalid() throws IOException {
    }
    @Test
    public void BudgetConsoleVerifyTest() throws InterruptedException, IOException {

	String xlPathMeter = Paths.get("BudgetTestData/Gas/Information/InformationTab_AAR/Meter_AAR.xlsx")
		.toAbsolutePath().toString();
	String xlPathConsumption = Paths.get("BudgetTestData/Gas/Information/InformationTab_AAR/Consumption_AAR.xlsx")
		.toAbsolutePath().toString();
	String xlPathRTB = Paths.get("BudgetTestData/Gas/Information/InformationTab_AAR/RateTimeBand_AAR.xlsx")
		.toAbsolutePath().toString();
	String xlPathContractCharges = Paths
		.get("BudgetTestData/Gas/Information/InformationTab_AAR/ContractCharges_AAR.xlsx").toAbsolutePath()
		.toString();
	String xlPathReference = Paths.get("BudgetTestData/Gas/Information/InformationTab_AAR/ReferencePrices_AAR.xlsx")
		.toAbsolutePath().toString();
	String xlPathConsumptionAdjustment = Paths
		.get("BudgetTestData/Gas/Information/InformationTab_AAR/ConsumptionAdjustment_AAR.xlsx")
		.toAbsolutePath().toString();

	CustomersPageHandler customersPageHandler = new CustomersPageHandler(webDriverHandler, prop);
	customersPageHandler.waitLoad();
	customersPageHandler.filterCustomers("Automation");
	customersPageHandler.selectFirstCustomer();
	CommonPageHandler budgetPageHandler = new CommonPageHandler(webDriverHandler, prop);
	budgetPageHandler.createBudgetMonthlyGas();
	InformationImportHandler iigh = new InformationImportHandler(webDriverHandler, prop);
	iigh.InformationErrorFileUpload("GasMeters", xlPathMeter);
	iigh.InformationErrorFileUpload("GasConsumption", xlPathConsumption);
	iigh.InformationErrorFileUpload("GasRateTimeBands", xlPathRTB);
	iigh.InformationErrorFileUpload("GasContractCharges", xlPathContractCharges);
	iigh.InformationErrorFileUpload("GasReferencePrices", xlPathReference);
	iigh.InformationErrorFileUpload("GasConsumptionAdjustment", xlPathConsumptionAdjustment);
	InformationImportHandler infoHand = new InformationImportHandler(webDriverHandler, prop);
	infoHand.InformationFailedCalculate();

//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
// 	
//  	ppdriver.findElement(By.xpath(prop.getProperty("BudgetIcon"))).click();
//  	Thread.sleep(5000);
//	driver.findElement(By.xpath(prop.getProperty("searchTxtBox"))).sendKeys("Automation");   
//    JavascriptExecutor executor = (JavascriptExecutor)driver;
//    executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(prop.getProperty("CustSingleRecord"))));
//    Thread.sleep(5000);
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//	   LocalDateTime now = LocalDateTime.now();
//	   String appendDate=dtf.format(now);
//	   
//	
//	
//	driver.findElement(By.xpath(prop.getProperty("NewBudget"))).click();
//	driver.findElement(By.xpath(prop.getProperty("BudgetReference"))).sendKeys("NewBudget"+appendDate);
//	Thread.sleep(3000);
//	
//	WebElement we1=	driver.findElement(By.xpath(prop.getProperty("BudgetStartDate")));
//	we1.sendKeys("01/09/2018");
//	we1.sendKeys(Keys.ESCAPE);
//	
//	WebElement we2=	driver.findElement(By.xpath(prop.getProperty("BudgetEndDate")));
//	we2.sendKeys("31/08/2019");
//	we2.sendKeys(Keys.ESCAPE);
//	
//	Thread.sleep(3000);
//	Select ddCalenderOutput=new Select(driver.findElement(By.id("CalendarOutput")));
//	Thread.sleep(2000);
//	ddCalenderOutput.selectByValue("Monthly");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath(prop.getProperty("InfoImportNotes"))).sendKeys("NewBudget");
//	driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//	
//	//Thread.sleep(5000);
//	driver.findElement(By.xpath(prop.getProperty("Meters"))).click();	
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox.click();
//    EImportTxtBox.sendKeys("Automation Green status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    
//    String xlPathMeter = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/Meter_Green.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFileMeter=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFileMeter.sendKeys(xlPathMeter);
//    
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(20000);
//	driver.findElement(By.xpath("//button[@id='btnUpload']")).click();
//	  Thread.sleep(10000);
//	driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
//	//*******************************************************************************	
//	Thread.sleep(5000);
//	driver.findElement(By.xpath(prop.getProperty("Consumption"))).click();
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox2=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox2.click();
//    EImportTxtBox2.sendKeys("Automation Green status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    
//    String xlPathConsumption = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/Consumption_Green.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFileConsumption=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFileConsumption.sendKeys(xlPathConsumption);
//    
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(20000);
//	driver.findElement(By.xpath("//button[@id='btnUpload']")).click();
//	Thread.sleep(10000);
//	driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
//	Thread.sleep(5000);
//	
//	//*******************************************************************************
//	Thread.sleep(5000);
//	driver.findElement(By.xpath(prop.getProperty("RTB"))).click();
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox3=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox3.click();
//    EImportTxtBox3.sendKeys("Automation Green status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    String xlPathRTB= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/RateTimeBand_Green.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFileRTB=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFileRTB.sendKeys(xlPathRTB);
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(20000);
//	driver.findElement(By.xpath("//button[@id='btnUpload']")).click();
//	Thread.sleep(10000);
//	driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
//	Thread.sleep(5000);
//	//*******************************************************************************	
//	Thread.sleep(5000);
//	driver.findElement(By.xpath(prop.getProperty("KVArh"))).click();
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox4=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox4.click();
//    EImportTxtBox4.sendKeys("Automation Green status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    String xlPathKVA= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/KVA_Green.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFileKVA=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFileKVA.sendKeys(xlPathKVA);
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(20000);
//	driver.findElement(By.xpath("//button[@id='btnUpload']")).click();
//	Thread.sleep(10000);
//	driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
//	Thread.sleep(5000);
//	//*******************************************************************************	
//	Thread.sleep(5000);
//	driver.findElement(By.xpath(prop.getProperty("ElectricityContract"))).click();
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox5=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox5.click();
//    EImportTxtBox5.sendKeys("Automation Green status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    
//    String xlPathContractCharges= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/ContractCharges_Green.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFileContractCharges=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFileContractCharges.sendKeys(xlPathContractCharges);
//    
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(20000);
//	driver.findElement(By.xpath("//button[@id='btnUpload']")).click();
//	Thread.sleep(10000);
//	driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
//	Thread.sleep(5000);
//	//*******************************************************************************
//	
//	Thread.sleep(5000);
//	driver.findElement(By.xpath(prop.getProperty("ElectricityReference"))).click();
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox7=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox7.click();
//    EImportTxtBox7.sendKeys("Automation Green status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    
//    String xlPathReference= Paths.get("BudgetTestData/Electricity/Information/InformationTab_Green/ReferencePrices_Green.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFileReference=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFileReference.sendKeys(xlPathReference);
//    
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(20000);
//	driver.findElement(By.xpath("//button[@id='btnUpload']")).click();
//	Thread.sleep(10000);
//	driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
//	Thread.sleep(5000);
//	
//	driver.findElement(By.xpath(prop.getProperty("PassPublishedContent"))).click();
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox8=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox.click();
//    EImportTxtBox.sendKeys("Automation Red status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    String xlPathPublishedView = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/PublishedView_Red.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFilePublishedView=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFilePublishedView.sendKeys(xlPathPublishedView);
//    
//    
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(10000);
//    driver.findElement(By.xpath(prop.getProperty("CancelImport"))).click();
//    Thread.sleep(5000);
//	
//	
//	driver.findElement(By.xpath(prop.getProperty("PassInspiredContent"))).click();
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox9=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox.click();
//    EImportTxtBox.sendKeys("Automation Red status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    String xlPathInspiredEnergyView = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/InspiredEnergyView_Red.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFileInspiredEnergyView=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFileInspiredEnergyView.sendKeys(xlPathInspiredEnergyView);
//    
//    
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(10000);
//    driver.findElement(By.xpath(prop.getProperty("CancelImport"))).click();
//    Thread.sleep(5000);
//	
//	
//	driver.findElement(By.xpath(prop.getProperty("tprFactorsTLF"))).click();
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox10=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox.click();
//    EImportTxtBox.sendKeys("Automation Red status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    
//    String xlPathTLF = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/TLF_Red.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFileTLF=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFileTLF.sendKeys(xlPathTLF);
//    
//    
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(10000);
//    driver.findElement(By.xpath(prop.getProperty("CancelImport"))).click();
//    Thread.sleep(5000);
//	
//	driver.findElement(By.xpath(prop.getProperty("tprFactorsDNOFactors"))).click();
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox11=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox.click();
//    EImportTxtBox.sendKeys("Automation Red status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    String xlPathDNOFactors = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/DNOFactors_Red.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFileDNOFactors=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFileDNOFactors.sendKeys(xlPathDNOFactors);
//    
//    
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(10000);
//    driver.findElement(By.xpath(prop.getProperty("CancelImport"))).click();
//    Thread.sleep(5000);
//	
//	
//	driver.findElement(By.xpath(prop.getProperty("tprFactorsDNORAGTimes"))).click();
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox12=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox.click();
//    EImportTxtBox.sendKeys("Automation Red status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    String xlPathDNORAGTimes = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/DNORAGTimes_Red.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFileDNORAGTimes=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFileDNORAGTimes.sendKeys(xlPathDNORAGTimes);
//    
//    
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(10000);
//    driver.findElement(By.xpath(prop.getProperty("CancelImport"))).click();
//    Thread.sleep(5000);
//	
//	
//	driver.findElement(By.xpath(prop.getProperty("ConsumptionAdjustment"))).click();
//	driver.findElement(By.xpath(prop.getProperty("ImportBtn"))).click();	
//	Thread.sleep(5000);
//	WebElement EImportTxtBox13=driver.findElement(By.xpath(prop.getProperty("ImportReferenceTxtBox")));
//    EImportTxtBox.click();
//    EImportTxtBox.sendKeys("Automation Red status import file");
//    driver.findElement(By.xpath("//*[@id='ImportNotes']")).sendKeys("Notes for an Automation Tests");
//    Thread.sleep(5000);
//    String xlPathConsumptionAdjustment = Paths.get("BudgetTestData/Electricity/Information/InformationTab_Red/ConsumptionAdjustment_Red.xlsx").toAbsolutePath().toString();
//    WebElement EChooseFileConsumptionAdjustment=driver.findElement(By.id(prop.getProperty("ChooseFile")));
//    EChooseFileConsumptionAdjustment.sendKeys(xlPathConsumptionAdjustment);
//    
//    
//    driver.findElement(By.xpath(prop.getProperty("Save"))).click();
//    Thread.sleep(10000);
//    Thread.sleep(10000);
//    driver.findElement(By.xpath(prop.getProperty("CancelImport"))).click();
//    Thread.sleep(5000);
//	Thread.sleep(5000);
//	
//	driver.findElement(By.xpath(prop.getProperty("Information"))).click();
//	Thread.sleep(5000);
//	
//	String ExpCalBtn="Calculate";
//	WebElement weCalBtn=driver.findElement(By.xpath(prop.getProperty("Calculate")));
//	String ActualCalBtn=weCalBtn.getText();
//	
//	if(ExpCalBtn.contentEquals(ActualCalBtn))
//	{
//		System.out.println("Calculate button is present on the screen");
//	}
//	else 
//	{
//		System.out.println("There is no Calculate button on Information tab for Red validation Imports");
//	}
//	Thread.sleep(10000);
//	}
    }
}