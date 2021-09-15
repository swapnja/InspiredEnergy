package com.BulkScanning.CommonMethods;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;

import java.io.IOException;

public class PostRoomCommonMethods extends CommonMethods {
	
	
	private ElementHandler awaitingEDILabel;
	private ElementHandler matchedArchivedItemLabel;
	private ElementHandler manualEntryLabel;
	
	//Summary Section
	private ElementHandler id;
	private ElementHandler received;
	
	private ElementHandler selAssignTo;
	private ElementHandler linkAssignToMe;
	
	private ElementHandler currentStatus;
	private ElementHandler selAction;
	
	//Action dropdown options fields
	private ElementHandler lblChaseMessage;
	private ElementHandler txtaMessage;
	private ElementHandler btnMessageSubmit;
	private ElementHandler btnCantSendInput;
	private ElementHandler lblCantSendInput;
	private ElementHandler lblDuplicateInvest;
	
	private ElementHandler lblEmail;
	private ElementHandler txtEmailToId;
	private ElementHandler txtEmailToCC;
	private ElementHandler btnEmailAttach;
	private ElementHandler txtaEmailMessage;
	private ElementHandler btnEmailSubmit;
	
	//Meta data section
	private ElementHandler invNumber;
	private ElementHandler taxPointDate ;
	private ElementHandler accNumber;
	private ElementHandler meterNumber;
	private ElementHandler client;
	private ElementHandler supplier;
	private ElementHandler utilityType;
	private ElementHandler btnEditMetaData;
	
	//Scanned Document section
	private ElementHandler scanDocLabel;
	private ElementHandler scanDoc;
	private ElementHandler scanDocDownload;
	
	//Related Scheduled EDIs(OnlyAwaitingEDI)
	
	private ElementHandler relSchEDILabel;
	private ElementHandler relSchEDIId;
	private ElementHandler relSchEDISupplier;
	private ElementHandler relSchEDISchedule;
	private ElementHandler relSchEDIDate;
	private ElementHandler relSchEDIDaysOverdue;
	private ElementHandler relSchEDILastChasedDate;
	private ElementHandler relSchEDIStatus;
	private ElementHandler relSchEDIAssigned;
	private ElementHandler relSchEDIEdit;
	private ElementHandler btnSaveMetaDate;
	public PostRoomCommonMethods(WebDriverHandler webDriverHandler) throws IOException {
		super(webDriverHandler);
		// TODO Auto-generated constructor stub
	}
	/*
	public PostRoomCommonMethods(WebDriverHandler webDriverHandler) {
		
	//	super(webDriverHandler);

	awaitingEDILabel = _webDriverHandler.byXpath("//h2[text() = 'Awaiting EDI']");
	matchedArchivedItemLabel = _webDriverHandler.byXpath("//h2[text() = 'Matched Scan']");
	manualEntryLabel = _webDriverHandler.byXpath("//h2[text() = 'Manual Invoice Entry']");
	
	//Summary Section
	id = _webDriverHandler.byXpath("//h6[text()='Id : ']/span");
	received = _webDriverHandler.byXpath("//h6[text()='Received: ']/span");
	
	selAssignTo = _webDriverHandler.byXpath("//select[@id='AssignedTo'");
	linkAssignToMe = _webDriverHandler.byXpath("//a[@class='assign-to-me']");
	
	currentStatus = _webDriverHandler.byXpath("//input[@id='Status']");
	selAction = _webDriverHandler.byXpath("//select[@id='Action'");
	
	//Action dropdown options fields
	lblChaseMessage = _webDriverHandler.byXpath("//h5[text()='Confirmed Chase']");
	txtaMessage = _webDriverHandler.byXpath("//textarea[@id='Message']");
	btnMessageSubmit = _webDriverHandler.byXpath("//button[text()='Submit']");
	btnCantSendInput = _webDriverHandler.byXpath("//button[contains(@class,'submit-chase-comment')]");
	lblCantSendInput = _webDriverHandler.byXpath("//h5[text()='Can't Input Details']");
	lblDuplicateInvest = _webDriverHandler.byXpath("//h5[text()='Duplicate Investigation Required']");
	
	lblEmail = _webDriverHandler.byXpath("//h5[text()='Send Chase Email']");
	txtEmailToId = _webDriverHandler.byXpath("//input[@id='To']");
	txtEmailToCC = _webDriverHandler.byXpath("//input[@id='CC']");
	btnEmailAttach = _webDriverHandler.byXpath("//input[@id='files']");
	txtaEmailMessage = _webDriverHandler.byXpath("//textarea[@id='Message']");
	btnEmailSubmit = _webDriverHandler.byXpath("//button[contains(@class,'send-chase-email')]");
	
	//Meta data section
	invNumber = _webDriverHandler.byXpath("//input[@id='InvoiceNumber']");
	taxPointDate = _webDriverHandler.byXpath("//input[@id='TaxPointDate']");
	accNumber = _webDriverHandler.byXpath("//input[@id='AccountNumber']");
	meterNumber = _webDriverHandler.byXpath("//input[@id='MeterNumber']");
	client = _webDriverHandler.byXpath("//input[@id='Client']");
	supplier = _webDriverHandler.byXpath("//input[@id='Supplier']");
	utilityType = _webDriverHandler.byXpath("//input[@id='UtilityType']");
	btnEditMetaData = _webDriverHandler.byXpath("//h6/i[@id='btnEditMetadata']");
	btnSaveMetaDate= _webDriverHandler.byXpath("//button[text()='Save']");
	
	//Scanned Document section
	scanDocLabel = _webDriverHandler.byXpath("//h6[text()='Scanned Document ']/a");
	scanDoc = _webDriverHandler.byXpath("//html/body/embed");
	scanDocDownload = _webDriverHandler.byXpath("//div[@id='dashboardPartial']//h6[text()='Scanned Document ']/a");
	
	//Related Scheduled EDIs(OnlyAwaitingEDI)
	
	relSchEDILabel = _webDriverHandler.byXpath("//div[@id='dashboardPartial']//h4[text()='Related Scheduled EDIs']");
	relSchEDIId = _webDriverHandler.byXpath("//div[@id='dashboardPartial']//table/tbody/tr/td[1]");
	relSchEDISupplier = _webDriverHandler.byXpath("//div[@id='dashboardPartial']//table/tbody/tr/td[2]");
	relSchEDISchedule = _webDriverHandler.byXpath("//div[@id='dashboardPartial']//table/tbody/tr/td[3]");
	relSchEDIDate= _webDriverHandler.byXpath("//div[@id='dashboardPartial']//table/tbody/tr/td[4]");
	relSchEDIDaysOverdue = _webDriverHandler.byXpath("//div[@id='dashboardPartial']//table/tbody/tr/td[5]");
	relSchEDILastChasedDate= _webDriverHandler.byXpath("//div[@id='dashboardPartial']//table/tbody/tr/td[6]");
	relSchEDIStatus= _webDriverHandler.byXpath("//div[@id='dashboardPartial']//table/tbody/tr/td[7]");
	relSchEDIAssigned= _webDriverHandler.byXpath("//div[@id='dashboardPartial']//table/tbody/tr/td[8]");
	relSchEDIEdit = _webDriverHandler.byXpath("//div[@id='dashboardPartial']//table/tbody/tr/td[9]/button[contains(@class,'edit-awaiting-edi')]");

	}
/*
	public void assignToDropdown(String assign) {
		
		String assignValue = selAssignTo._webDriverHandler.byXpath("//option[text()='"+ assign +"']").getAttribute("value");
		
		//System.out.println(assignValue);
		
		selectByValue(selAssignTo, assignValue);
	}
	
	public void actionDropdown(String action,String chaseMsg, String[] inputEmail) {
		
		selAction.click();
		switch(action){
		case "Mark As Chased" :
			selMarkedAsChase(action,chaseMsg);
			break;
		case "Send Chase Email" :
			selSendEmail(action, inputEmail);
			break;
		case "Retry Match" :
			selectByVisibleText(selAction, action);
			break;
		case "Set In Progress" :
			selectByVisibleText(selAction, action);
			break;
		case "Mark as Done" :
			selectByVisibleText(selAction, action);
			break;
		case "Send to Can't Input" :
			selMarkedAsChase(action,chaseMsg);
			break;
		case "Archive Scanned Document" :
			selectByVisibleText(selAction, action);
			break;
		case "Send to Duplicate Investigation" :
			selMarkedAsChase(action,chaseMsg);
			break;
		}
	}
	public void selMarkedAsChase(String action,String chaseMsg) {
		
		selectByVisibleText(selAction, action);
		wait.until(ExpectedConditions.presenceOfElementLocated(lblChaseMessage));
		
		txtaMessage.sendKeys(chaseMsg);
		btnMessageSubmit.click();
		
	}
	
	public void selSendEmail(String action,String[] inputEmail) {
		
		selectByVisibleText(selAction, action);
		wait.until(ExpectedConditions.presenceOfElementLocated(lblEmail));
		
		txtEmailToId.sendKeys(inputEmail[0]);
		txtEmailToCC.sendKeys(inputEmail[1]);
		txtaEmailMessage.sendKeys(inputEmail[2]);
		//Email Attachment Pending
		btnEmailSubmit.click();
		
	}
	
	public void selCantSendInput(String action,String chaseMsg) {
		
		selectByVisibleText(selAction, action);
		wait.until(ExpectedConditions.presenceOfElementLocated(lblCantSendInput));
		
		txtaMessage.sendKeys(chaseMsg);
		btnMessageSubmit.click();
		
	}
	
	public void selSendToDuplicateInvestigation(String action,String chaseMsg) {
		
		selectByVisibleText(selAction, action);
		wait.until(ExpectedConditions.presenceOfElementLocated(lblDuplicateInvest));
		
		txtaMessage.sendKeys(chaseMsg);
		btnMessageSubmit.click();
		
	}
	
	public void editMetaData(String[] lstMetaData) {
		btnEditMetaData.click();
		
		invNumber.sendKeys(lstMetaData[0]);
		taxPointDate.sendKeys(lstMetaData[1]);
		accNumber.sendKeys(lstMetaData[2]);
		meterNumber.sendKeys(lstMetaData[3]);
		client.sendKeys(lstMetaData[4]);
		supplier.sendKeys(lstMetaData[5]);
		utilityType.sendKeys(lstMetaData[6]);
		
		btnSaveMetaDate.click();
	} */
}
