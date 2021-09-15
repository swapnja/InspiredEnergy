package com.BulkScanning.CommonMethods;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import com.Budgets.PageHandlers.CommonPageHandler;

import java.io.IOException;
import java.util.Properties;

public class CommonMethods {
	
	WebDriverHandler _webDriverHandler;
    String appendDate = TimeStampPageHandler.AppendTimeStamp();
    Properties _prop;
    private CommonPageHandler cph;	
	private ElementHandler filterCustomer;
	private ElementHandler filterSupplier;
	private ElementHandler filterStatus;
	private ElementHandler filterSchedule;
	private ElementHandler filterDateFrom;
	private ElementHandler filterDateTo;
	private ElementHandler filterAssignedTo;
	private ElementHandler selfilterCustomer;
	private ElementHandler selfilterSupplier;
	private ElementHandler selfilterStatus;
	private ElementHandler selfilterSchedule;
	private ElementHandler selfilterDateFrom;
	private ElementHandler selfilterDateTo;
	private ElementHandler selfilterAssignedTo;
	private ElementHandler apply;
	private ElementHandler reset;
	private ElementHandler exportExcel;
	private ElementHandler bulkAction;
	private ElementHandler bulkActionAssignee;
	private ElementHandler bulkActionProcess;

	private ElementHandler search;

	private ElementHandler selDateMonth;
	private ElementHandler selDateYear;

	public CommonMethods(WebDriverHandler webDriverHandler)throws IOException {
	_webDriverHandler = webDriverHandler;
	cph = new CommonPageHandler(webDriverHandler, _prop);
			
	filterCustomer = _webDriverHandler.byXpath("//select[@id='CustomerId']/..//button");
	filterSupplier = _webDriverHandler.byXpath("//select[@id='SupplierId']/..//button");
	filterStatus = _webDriverHandler.byXpath("//select[@id='StatusId']/..//button");
	filterSchedule = _webDriverHandler.byXpath("//select[@id='ScheduleId']/..//button");
	filterDateFrom = _webDriverHandler.byXpath("//input[@id='DateFrom']");
	filterDateTo = _webDriverHandler.byXpath("//input[@id='DateTo']");
	filterAssignedTo = _webDriverHandler.byXpath("//select[@id='AssignedToId']/..//button");
	
	selfilterCustomer = _webDriverHandler.byXpath("//select[@id='CustomerId']");
	selfilterSupplier = _webDriverHandler.byXpath("//select[@id='SupplierId']");
	selfilterStatus = _webDriverHandler.byXpath("//select[@id='StatusId']");
	selfilterSchedule = _webDriverHandler.byXpath("//select[@id='ScheduleId']");
	selfilterAssignedTo = _webDriverHandler.byXpath("//select[@id='AssignedToId']");
	
	apply = _webDriverHandler.byXpath("//button[text()='Apply']");
	reset = _webDriverHandler.byXpath("//button[text()='Reset']");
	exportExcel = _webDriverHandler.byXpath("//button[text()='Export Excel']");
	bulkAction = _webDriverHandler.byXpath("//select[@class='form-control form-control-sm overdue-edi-bulk-action']");
	bulkActionAssignee = _webDriverHandler.byXpath("//select[@id='ddlBulkAssignee']");
	bulkActionProcess = _webDriverHandler.byXpath("//button[text()='Process']");
	
	search = _webDriverHandler.byXpath("//input[@type='search']");
	
	selDateMonth = _webDriverHandler.byXpath("//select[@class='ui-datepicker-month']");
	selDateYear = _webDriverHandler.byXpath("//select[@class='ui-datepicker-year']");
	
	}
/*	
	public void selectByValue(WebElement we , String value){
		
		Select sel = new Select(we);
		sel.selectByValue(value);
	}
	
	public void selectByVisibleText(WebElement we , String text){
		
		Select sel = new Select(we);
		sel.selectByVisibleText(text);
	}
	
	public void selectMultiple(WebElement we , List<String> text){
		Select sel = new Select(we);
		sel.deselectAll();
		for(String t: text) {
			sel.selectByVisibleText(t);
		}
	}
	
	public void dateSelection(String date) {
		
		String splitter[] = date.split("-");
		String year = splitter[2];
		String month = splitter[1];
		String day = splitter[0]; 
		
		System.out.println(month);
		System.out.println(day);
		System.out.println(year);		
		
		selDateYear.click();
		selectByVisibleText(selDateYear,year);
		
		selDateMonth.click();
		selectByVisibleText(selDateMonth,month);
		
		_webDriverHandler.byXpath("//table[@class='ui-datepicker-calendar']//a[text()='"+day+"']");
	}
	
	public void selectCustomer(List<String> text) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(filterCustomer));
		filterCustomer.click();
		selectMultiple(selfilterCustomer,text);
		
	}
	public void selectSupplier(List<String> text) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(filterSupplier));
		filterSupplier.click();
		selectMultiple(selfilterSupplier,text);
		
	}
	public void selectStatus(List<String> text) {
	
		wait.until(ExpectedConditions.presenceOfElementLocated(filterStatus));
		filterStatus.click();
		selectMultiple(selfilterStatus,text);
	
	}
	public void selectSchedule(List<String> text) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(filterSchedule));
		filterSchedule.click();
		selectMultiple(selfilterSchedule,text);
		
	}
	public void selectDateFrom(List<String> text) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(filterDateFrom));
		filterDateFrom).click();
		selectMultiple(selfilterDateFrom,text);
		
	}
	public void selectDateFrom(String date) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(filterDateFrom));
		driver.findElement(filterDateFrom).click();
		dateSelection(date);
		
	}
	public void selectDateTo(String date) {
		
		wait.until(ExpectedConditions.presenceOfElementLocated(filterDateTo));
		driver.findElement(filterDateTo).click();
		dateSelection(date);
		
	}
	
	public void clickApplyButton() {
		
		apply.click();
	}
	
	public void clickResetButton() {
		
		reset.click();
	}
	
	public void clickExportExcelButton() {
		
		exportExcel.click();
	}
	/*
	public void bulkActionAssign(String user) {
		
		bulkAction.click();
		selectByVisibleText(bulkAction,"Bulk Assign");
		
		bulkActionAssignee.click();
		selectByVisibleText(bulkActionAssignee,user);
		
		bulkActionProcess.click();
		
	}
	*/
	public void searchAction(String text) {
		
		search.sendKeys(text);
	}
	
	public void viewAction(String id, String classname) {
		
		//driver.findElement(By.xpath("//button[contains(@class,'edit-document-schedule') and @data-id='"+id+"']/i")).click();
		
		_webDriverHandler.byXpath("//button[contains(@class,'"+classname+"') and @data-id='"+id+"']/i").click();
	}
}
