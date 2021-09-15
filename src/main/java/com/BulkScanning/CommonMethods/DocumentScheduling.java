package com.BulkScanning.CommonMethods;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

import java.io.IOException;

public class DocumentScheduling {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabScheduleManagement;
    ElementHandler searchScheduleManagement;
    ElementHandler ddFilterDocument;
    ElementHandler ddFilterSupplier;
    ElementHandler btnAddNewSchedule;
    ElementHandler tabSchedule;
    ElementHandler tbScheduleName;
    ElementHandler ddDocType;
    ElementHandler ddSupplier;
    ElementHandler ddSchedulePattern;
    ElementHandler tbNotes;
    ElementHandler ddRetrievalMethod;
    ElementHandler tbChaseEmail;
    ElementHandler btnCreateSchedule;
    ElementHandler editSchedule;
    ElementHandler deleteSchedule;
    ElementHandler btnYes;
    ElementHandler btnOK;
    //Monthly
    ElementHandler rbDOM;
    ElementHandler rbSD;
    ElementHandler ddDate;
    ElementHandler ddWeek;
    ElementHandler ddDay;
    //Weekly
    ElementHandler tbNoOfWeeks;
    //Daily
    ElementHandler tbNoOfDays;
    //Single
    ElementHandler tbOccurrenceDate;
    ElementHandler startDate;
    ElementHandler endContinuous;
    ElementHandler endNOO;
    ElementHandler endFED;
    ElementHandler tbNOO;
    ElementHandler endDate;
    //Assignment Tab
    ElementHandler tabAssignment;
    ElementHandler tbSearchCustomer;
    ElementHandler btnAddToSelection;
    ElementHandler btnAddMeterToSelection;
    ElementHandler btnRefineMeter;
    ElementHandler ddSites;
    ElementHandler ddMeters;
    ElementHandler ddFuelType;
    ElementHandler tbSearchMeter;
    ElementHandler chkBoxCustomer;
    ElementHandler chkBoxMeter;
    ElementHandler selDateMonth;
    ElementHandler selDateYear;

    public DocumentScheduling(WebDriverHandler webDriverHandler) throws IOException {
        _webDriverHandler = webDriverHandler;
        tabScheduleManagement = _webDriverHandler.byXpath("//a[contains(text(), 'Schedule Management')]");
        searchScheduleManagement = _webDriverHandler.byXpath("//*[@id='scheduleListTable_filter']//input");
        ddFilterDocument = _webDriverHandler.byXpath("//*[@id='lstFilter_Document']");
        ddFilterSupplier = _webDriverHandler.byXpath("//*[@id='lstFilter_Supplier']");
        btnAddNewSchedule = _webDriverHandler.byXpath("//*[@id='btnAddNew']");
        tabSchedule = _webDriverHandler.byXpath("//a[@href = '#scheduleTab']");
        tbScheduleName = _webDriverHandler.byXpath("//*[@id='ScheduleName']");
        ddDocType = _webDriverHandler.byXpath("//*[@id='ddlDocType']");
        ddSupplier = _webDriverHandler.byXpath("//*[@id='ddlSupplier']");
        ddSchedulePattern = _webDriverHandler.byXpath("//*[@id='ddlSchedulePattern']");
        tbNotes = _webDriverHandler.byXpath("//*[@id='Notes']");
        ddRetrievalMethod = _webDriverHandler.byXpath("//*[@id='RetreivalDeliveryID']");
        tbChaseEmail = _webDriverHandler.byXpath("//*[@id='ChaseEmail']");
        btnCreateSchedule = _webDriverHandler.byXpath("//*[@id='btnCreateSchedule']");
        rbDOM = _webDriverHandler.byXpath("//label[input[@id='rbDOM']]");
        rbSD = _webDriverHandler.byXpath("//label[input[@id='rbSD']]");
        ddDate = _webDriverHandler.byXpath("//*[@id='div_DOMList']//select");
        ddWeek = _webDriverHandler.byXpath("//*[@id='Monthly.Frequency_No']");
        ddDay = _webDriverHandler.byXpath("//*[@id='Monthly_Frequency_Name']");
        startDate = _webDriverHandler.byXpath("//*[@id='txtSchStartDate']");
        endContinuous = _webDriverHandler.byXpath("//label[input[@id='rbCont']]");
        endNOO = _webDriverHandler.byXpath("//label[input[@id='rbNOC']]");
        tbNOO = _webDriverHandler.byXpath("//*[@id='Occurances']");
        endFED = _webDriverHandler.byXpath("//label[input[@id='rbFED']]");
        endDate = _webDriverHandler.byXpath("//*[@id='txtSchEndDate']");
        tbNoOfWeeks = _webDriverHandler.byXpath("//*[@id='Weekly_Frequency_No']");
        tbNoOfDays = _webDriverHandler.byXpath("//*[@id='Daily_Frequency_No']");
        tbOccurrenceDate = _webDriverHandler.byXpath("//*[@id='OccuranceDate']");
        tabAssignment = _webDriverHandler.byXpath("//a[@href = '#assignmentTab']");
        tbSearchCustomer = _webDriverHandler.byXpath("//*[@id='txtSearchCustomer']");
        btnAddToSelection = _webDriverHandler.byXpath("//*[@id='btnAddSelection']");
        btnRefineMeter = _webDriverHandler.byXpath("//*[contains(@class, 'btnFilterCustomers')]");
        ddSites = _webDriverHandler.byXpath("//div[span//select[@id='SiteID']]//button");
        ddMeters = _webDriverHandler.byXpath("//div[span//select[@id='MeterNo']]//button");
        ddFuelType = _webDriverHandler.byXpath("//div[span//select[@id='Fuel']]//button");
        btnAddMeterToSelection = _webDriverHandler.byXpath("//*[@id='btnAddMeterSelection']");
        tbSearchMeter = _webDriverHandler.byXpath("//*[@id='meterSelectTable_filter']//input");
        editSchedule = _webDriverHandler.byXpath("//*[contains(@class, 'fa fa-edit')]");
        deleteSchedule = _webDriverHandler.byXpath("//*[contains(@class, 'fa fa-trash')]");
        btnYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");
        chkBoxCustomer = _webDriverHandler.byXpath("//*[@id='chkCustomerChild']");
        chkBoxMeter = _webDriverHandler.byXpath("//*[@class='chkMeterChild']");
        selDateMonth = _webDriverHandler.byXpath("//select[@class='ui-datepicker-month']");
        selDateYear = _webDriverHandler.byXpath("//select[@class='ui-datepicker-year']");
        btnOK = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    }

    public String[] tblScheduleManagement = new String[] {"Id", "Name", "Document", "Supplier", "Schedule", ""};
    public  String[] arrScheduleManagement = new String[6];

    public void accessScheduleManagement(){
        do{
            tabScheduleManagement.waitClickable().click();
            try{
            	waitLoad();
            	}catch (Exception e)
            {}
        }
        while (searchScheduleManagement.notPresent());
    }

    public void searchSchedules(String term) {
        searchScheduleManagement.waitClickable().sendKeys(term);
        waitLoad();
    }

    public void editSchedules(String term) {
        searchSchedules(term);
        editSchedule.waitClickable().click();
        waitLoad();
    }

    public void deleteSchedules(String term) {
        searchSchedules(term);
        deleteSchedule.waitClickable().click();
        btnYes.waitClickable().click();
        waitLoad();
    }

    public void columnVerification() {
        for(int i = 0 ; i < arrScheduleManagement.length ; i++) {
            arrScheduleManagement[i] = _webDriverHandler.byXpath("//table[@id='scheduleListTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblScheduleManagement[i].equals(arrScheduleManagement[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void filterByDocument(String option){
        ddFilterDocument.selectByText(option);
        waitLoad();
    }

    public void filterBySuppliers(String option){
        ddFilterSupplier.selectByText(option);
        waitLoad();
    }

    public void resetDocFilter(){
        ddFilterDocument.selectByValue("");
        waitLoad();
    }

    public void resetSupFilter(){
        ddFilterSupplier.selectByValue("");
        waitLoad();
    }

    public void addScheduleStart(String name, String supplier, String docType) {
        btnAddNewSchedule.waitClickable().click();
        waitLoad();
        tbScheduleName.waitClickable().sendKeys(name);
        ddSupplier.waitClickable().selectByText(supplier);
        waitLoad();
        ddDocType.waitClickable().selectByText(docType);
    }

    public void dateSelection(String date) {
        String splitter[] = date.split("/");
        String year = splitter[2];
        String month = splitter[1];
        String day = splitter[0];
        selDateYear.click().selectByText(year);
        selDateMonth.click().selectByText(month);
        _webDriverHandler.byXpath("//table[@class='ui-datepicker-calendar']//a[text()='"+day+"']").click();
    }

    public void selectEnd() {
        endContinuous.waitClickable().click();
    }

    public void selectEnd(String type, String data) {
        if(type.equalsIgnoreCase("Fixed End Date"))
        {
            endFED.waitClickable().click();
            endDate.waitClickable().click();
            dateSelection(data);
        }
        else if(type.equalsIgnoreCase("Number of Occurances")){
            endNOO.waitClickable().click();
            tbNOO.waitClickable().sendKeys(data);
        }
        else{
            System.out.println("Please provide proper End condition.");
        }
    }

    public void patternMonthly(String date, String dateStart) {
        ddSchedulePattern.waitClickable().selectByValue("1");
        rbDOM.waitClickable().click();
        ddDate.waitClickable().selectByValue(date);
        startDate.waitClickable().click();
        dateSelection(dateStart);
    }

    public void patternMonthly(String week, String day, String dateStart) {
        ddSchedulePattern.waitClickable().selectByValue("1");
        rbSD.waitClickable().click();
        ddWeek.waitClickable().selectByText(week);
        ddDay.waitClickable().selectByText(day);
        startDate.waitClickable().sendKeys(dateStart);
    }

    public void patternWeekly(String noOfWeeks, String day, String dateStart) {
        ddSchedulePattern.waitClickable().selectByValue("2");
        tbNoOfWeeks.waitClickable().sendKeys(noOfWeeks);
        _webDriverHandler.byXpath("//label[span[contains(text(), '"+day+"')]]").waitClickable().click();
        startDate.waitClickable().sendKeys(dateStart);
    }

    public void patternDaily(String noOfDays, String dateStart) {
        ddSchedulePattern.waitClickable().selectByValue("3");
        tbNoOfDays.waitClickable().sendKeys(noOfDays);
        startDate.waitClickable().sendKeys(dateStart);
    }

    public void patternSingleOccurrence(String dateStart) {
        ddSchedulePattern.waitClickable().selectByValue("4");
        tbOccurrenceDate.waitClickable().click();
        dateSelection(dateStart);
    }

    public void assignmentCustomer(String customer) {
        tabAssignment.waitClickable().click();
        tbSearchCustomer.waitClickable().sendKeys(customer);
        chkBoxCustomer.waitClickable().click();
        btnAddToSelection.waitClickable().click();
        tabSchedule.waitClickable().click();
    }

    public void assignmentMeter(String customer, String site, String meter, String fuel) {
        tabAssignment.waitClickable().click();
        tbSearchCustomer.waitClickable().sendKeys(customer);
        btnRefineMeter.waitClickable().click();
        waitLoad();
        ddSites.waitClickable().click();
        _webDriverHandler.byXpath("//label[contains(text(), '"+site+"')]").waitClickable().click();
        ddMeters.waitClickable().click();
        _webDriverHandler.byXpath("//label[contains(text(), '"+meter+"')]").waitClickable().click();
        ddFuelType.waitClickable().click();
        _webDriverHandler.byXpath("//label[contains(text(), '"+fuel+"')]").waitClickable().click();
        chkBoxMeter.waitClickable().click();
        btnAddMeterToSelection.waitClickable().click();
        tabSchedule.waitClickable().click();
    }

    public void addScheduleEnd(String notes, String retrieval, String chaseEmail) {
        tbNotes.waitClickable().sendKeys(notes);
        ddRetrievalMethod.waitClickable().selectByText(retrieval);
        tbChaseEmail.waitClickable().sendKeys(chaseEmail);
        btnCreateSchedule.waitClickable().click();
        btnOK.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30,100).waitInvisible(10,100);
    }
}
