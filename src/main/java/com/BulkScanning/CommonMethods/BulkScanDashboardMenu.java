package com.BulkScanning.CommonMethods;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import com.Budgets.PageHandlers.CommonPageHandler;

import java.util.Properties;

public class BulkScanDashboardMenu {

	WebDriverHandler _webDriverHandler;
    String appendDate = TimeStampPageHandler.AppendTimeStamp();
    Properties _prop;
    private CommonPageHandler cph;
//	WebDriver driver;
//	WebDriverWait wait;
//	Actions actions;
	
	//Bulk Scanning Pin
	private ElementHandler bulkScanPin;
	private ElementHandler bulkSchedule;		
							
	// Menu
	private ElementHandler scheduleManagement;
	private ElementHandler documentSchedule;
	private ElementHandler overdueEDI;
	
	private ElementHandler awaitingEDI;
	private ElementHandler matchedArchive;
	private ElementHandler manualInvoiceEntry;
	private ElementHandler otherDocumentEntry;
	private ElementHandler invoiceEntryIssue;
	private ElementHandler duplicateDocument;
	private ElementHandler duplicateInvestigation;
	
	private ElementHandler emailProcessing;
	private ElementHandler qualityAssurance;
	private ElementHandler submitted;
	
	//Menu - Tables
	private ElementHandler tblSchedule;
	private ElementHandler tblDocSchedule;
	private ElementHandler tblOverdueEDI;
	private ElementHandler tblAwaitingEDI;
	private ElementHandler tblMatchedArchived;
	private ElementHandler tblManualInvoiceEntry;
	
	public BulkScanDashboardMenu(WebDriverHandler webDriverHandler){
		
		cph = new CommonPageHandler(webDriverHandler, _prop);
		_webDriverHandler = webDriverHandler;
	
		//Bulk Scanning Pin
		bulkScanPin = _webDriverHandler.byXpath("//a[@href='/BulkScanningAndStamping/Home/Dashboard']");
		bulkSchedule = _webDriverHandler.byXpath("//head/title[text()='Bulk Scanning & Stamping - Unify']");
		
		// Menu
		scheduleManagement = _webDriverHandler.byXpath("//a[text()='Schedule Management']");
		documentSchedule = _webDriverHandler.byXpath("//a[text()='Document Schedule']");
		overdueEDI = _webDriverHandler.byXpath("//a[text()='Overdue EDIs']");
		
		//awaitingEDI = _webDriverHandler.byXpath("//*[contains(text(),'Awaiting EDI')]");
		awaitingEDI = _webDriverHandler.byXpath("//a[@data-action='PostRoomManagement/AwaitingEDI/Index']");
		matchedArchive = _webDriverHandler.byXpath("//a[text()='Matched Archive']");
		manualInvoiceEntry = _webDriverHandler.byXpath("//a[text()='Manual Invoice Entry']");
		otherDocumentEntry = _webDriverHandler.byXpath("//a[text()='Other Document Entry']");
		invoiceEntryIssue = _webDriverHandler.byXpath("//a[text()='Invoice Entry Issues']");
		duplicateDocument = _webDriverHandler.byXpath("//a[text()='Duplicate Documents']");
		duplicateInvestigation = _webDriverHandler.byXpath("//a[text()='Duplicate Investigation']");
		
		emailProcessing = _webDriverHandler.byXpath("//a[text()='Email Processing']");
		qualityAssurance = _webDriverHandler.byXpath("//a[text()='Quality Assurance']");
		submitted = _webDriverHandler.byXpath("//a[text()='Submitted']");
		
		//Menu - Tables
		tblSchedule = _webDriverHandler.byXpath("//table[@id='scheduleListTable']");
		tblDocSchedule = _webDriverHandler.byXpath("//table[contains(@class,'document-schedule-table')]");
		tblOverdueEDI = _webDriverHandler.byXpath("//table[contains(@class,'overdue-edi-table')]");
		tblAwaitingEDI = _webDriverHandler.byXpath("//table[contains(@class,'awaiting-edi-table')]");
		tblMatchedArchived = _webDriverHandler.byXpath("//table[contains(@class,'matched-archive-table')]");
		tblManualInvoiceEntry = _webDriverHandler.byXpath("//table[contains(@class,'manual-invoice-table')]");
	
	}
	/*
	public void navigateMenu(String menu) throws InterruptedException{
		
		bulkScanPin.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(bulkSchedule));
		
		switch(menu) {
		
		case "Schedule" :
			actions.moveToElement(scheduleManagement).build().perform();
			actions.click().perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(tblSchedule));
			break;
		case "DocSchedule" :
			actions.moveToElement(documentSchedule).build().perform();
			actions.click().perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(tblDocSchedule));
			break;
		case "OverdueEDI" :
			actions.moveToElement(overdueEDI).build().perform();
			actions.click().perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(tblOverdueEDI));
			break;
		case "AwaitingEDI" :
			actions.moveToElement(awaitingEDI).build().perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(awaitingEDI));
			actions.click().perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(tblAwaitingEDI));
			break;
			
		}
			
		*/
	
}
