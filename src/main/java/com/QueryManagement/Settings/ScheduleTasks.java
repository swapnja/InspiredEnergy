package com.QueryManagement.Settings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

public class ScheduleTasks {
    WebDriverHandler _webDriverHandler;
    ElementHandler btnSettings;
    ElementHandler tabScheduleTasks;
    ElementHandler tbSearch;
    ElementHandler btnNewSchedule;
    ElementHandler tbScheduleName;
    ElementHandler ddCustomers;
    ElementHandler ddCategory;
    ElementHandler ddSubCategory;
    ElementHandler ddReoccurrencePattern;
    ElementHandler ddReoccurrenceType;
    ElementHandler ddReoccurrenceDay;
    ElementHandler ddReoccurrenceDayOfWeek;
    ElementHandler ddReoccurrenceMonth;
    ElementHandler startDate;
    ElementHandler ddTime;
    ElementHandler endDate;
    ElementHandler btnCreate;
    ElementHandler btnCancel;
    ElementHandler btnSave;
    ElementHandler msgScheduleName;
    ElementHandler msgCustomer;
    ElementHandler msgCategory;
    ElementHandler msgSubCategory;
    ElementHandler msgReoccurrence;
    ElementHandler msgStartDate;
    ElementHandler msgTime;
    ElementHandler msgEndDate;
    ElementHandler btnOk;
    ElementHandler btnYes;

    public ScheduleTasks(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        btnSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        tabScheduleTasks = _webDriverHandler.byXpath("//a[contains(text(), 'Schedule Tasks')]");
        tbSearch = _webDriverHandler.byXpath("//input[@type='search']");
        btnNewSchedule = _webDriverHandler.byXpath("//button[text() = ' Schedule']");
        tbScheduleName = _webDriverHandler.byXpath("//*[@id='Name']");
        ddCustomers = _webDriverHandler.byXpath("//button[contains(@class, 'multiselect dropdown-toggle')]");
        ddCategory = _webDriverHandler.byXpath("//*[@id='CategoryId']");
        ddSubCategory = _webDriverHandler.byXpath("//*[@id='SubCategoryId']");
        ddReoccurrencePattern = _webDriverHandler.byXpath("//*[@id='ReoccurancePattern']");
        ddReoccurrenceType = _webDriverHandler.byXpath("//*[@id='ReoccuranceType']");
        ddReoccurrenceDayOfWeek = _webDriverHandler.byXpath("//*[@id='IntervalDayOfWeek']");
        ddReoccurrenceDay = _webDriverHandler.byXpath("//*[@id='IntervalDay']");
        ddReoccurrenceMonth = _webDriverHandler.byXpath("//*[@id='IntervalMonth']");
        startDate = _webDriverHandler.byXpath("//*[@id='StartDate']");
        ddTime = _webDriverHandler.byXpath("//*[@id='ReoccuranceTime']");
        endDate = _webDriverHandler.byXpath("//*[@id='EndDate']");
        btnCreate = _webDriverHandler.byXpath("//form[@id = 'modalAddNewAction']//*[contains(text(), ' Create')]");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'modalAddNewAction']//*[contains(text(), 'Cancel')]");
        btnSave = _webDriverHandler.byXpath("//form[@id = 'modalAddNewAction']//*[contains(text(), ' Save')]");
        msgScheduleName = _webDriverHandler.byXpath("//*[@id='Name-error']");
        msgCustomer = _webDriverHandler.byXpath("//*[@id='Customers_dropdown-error']");
        msgCategory = _webDriverHandler.byXpath("//*[@id='CategoryId-error']");
        msgSubCategory = _webDriverHandler.byXpath("//*[@id='SubCategoryId-error']");
        msgReoccurrence = _webDriverHandler.byXpath("//*[@id='ReoccurancePattern-error']");
        msgStartDate = _webDriverHandler.byXpath("//*[@id='StartDate-error']");
        msgTime = _webDriverHandler.byXpath("//*[@id='ReoccuranceTime-error']");
        msgEndDate = _webDriverHandler.byXpath("//*[@id='EndDate-error']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");
    }

    public String[] tblSubCategories = new String[]{"Customer Name", "Schedule Name", "Sub-Category", "Next Run Date", "Reoccurance Pattern", "Updated On", "Actions"};
    public String[] arrSubCategories = new String[7];

    String strErrorScheduleName = "The Schedule Name: field is required.";
    String strErrorCustomer = "The Customer: field is required.";
    String strErrorCategory = "The Category: field is required.";
    String strErrorSubCategory = "The Sub-category: field is required.";
    String strErrorReoccurrence = "The Reoccurance Pattern: field is required.";
    String strErrorStartDate = "The Start Date: field is required.";
    String strErrorTime = "The Time: field is required.";
    String strErrorEndDate = "The End Date: field is required.";

    public void accessSettings() {
        waitLoad();
        do{
            btnSettings.waitClickable().click();
            try{waitLoad();}
            catch (Exception e){}
        }
        while(tabScheduleTasks.notPresent());
    }

    public void accessScheduleTasks() {
        tabScheduleTasks.waitClickable().click();
        waitLoad();
    }

    public void search(String name) {
        tbSearch.waitClickable().clear().sendKeys(name);
        waitLoad();
    }

    public void createScheduleTasks(String name, String category, String subCategory, String[] reoccurrence, String startDt, String time, String endDt, String... customer) {
        btnNewSchedule.waitClickable().click();
        tbScheduleName.waitClickable().sendKeys(name);
        ddCustomers.waitClickable().click();
        for (String c : customer) {
            if (!(_webDriverHandler.byXpath("//label[contains(text(), ' " + c + "')]//input").isSelected())) {
                _webDriverHandler.byXpath("//label[contains(text(), ' " + c + "')]").click();
            }
        }
        ddCategory.waitClickable().selectByText(category);
        waitLoad();
        ddSubCategory.waitClickable().selectByText(subCategory);
        ddReoccurrencePattern.waitClickable().selectByText(reoccurrence[0]);
        switch (reoccurrence[0]) {
            case "Weekly":
                ddReoccurrenceDay.waitClickable().selectByText(reoccurrence[1]);
                break;
            case "Monthly":
                ddReoccurrenceType.waitClickable().selectByText(reoccurrence[1]);
                try{
                    ddReoccurrenceDay.waitClickable().selectByText(reoccurrence[2]);
                }
                catch (TimeoutException e){
                    ddReoccurrenceDayOfWeek.waitClickable().selectByText(reoccurrence[2]);
                }
                break;
            case "Annual":
                ddReoccurrenceMonth.waitClickable().selectByText(reoccurrence[1]);
                ddReoccurrenceType.waitClickable().selectByText(reoccurrence[2]);
                try{
                    ddReoccurrenceDay.waitClickable().selectByText(reoccurrence[3]);
                }
                catch (TimeoutException e){
                    ddReoccurrenceDayOfWeek.waitClickable().selectByText(reoccurrence[3]);
                }
                break;
        }
        startDate.waitClickable().sendKeys(startDt, Keys.ESCAPE);
        ddTime.waitClickable().selectByText(time);
        endDate.waitClickable().sendKeys(endDt, Keys.ESCAPE);
        btnCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void deleteScheduleTasks(String name) {
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + name + "')]]//button[@title = 'Delete']").waitClickable().click();
        btnYes.waitClickable().click();
        waitLoad();
    }

    public void editScheduleTasks(String name, String newName, String category, String subCategory, String[] reoccurrence, String startDt, String time, String endDt, String... customer)  {
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + name + "')]]//button[@title = 'Edit']").waitClickable().click();
        tbScheduleName.waitClickable().clear().sendKeys(newName);
        ddCustomers.waitClickable().click();
        for (String c : customer) {
            if (!(_webDriverHandler.byXpath("//label[contains(text(), ' " + c + "')]//input").isSelected())) {
                _webDriverHandler.byXpath("//label[contains(text(), ' " + c + "')]").click();
            }
        }
        ddCategory.waitClickable().selectByText(category);
        waitLoad();
        ddSubCategory.waitClickable().selectByText(subCategory);
        ddReoccurrencePattern.waitClickable().selectByText(reoccurrence[0]);
        switch (reoccurrence[0]) {
            case "Weekly":
                ddReoccurrenceDay.waitClickable().selectByText(reoccurrence[1]);
                break;
            case "Monthly":
                ddReoccurrenceType.waitClickable().selectByText(reoccurrence[1]);
                try{
                    ddReoccurrenceDay.waitClickable().selectByText(reoccurrence[2]);
                }
                catch (TimeoutException e){
                    ddReoccurrenceDayOfWeek.waitClickable().selectByText(reoccurrence[2]);
                }
                break;
            case "Annual":
                ddReoccurrenceMonth.waitClickable().selectByText(reoccurrence[1]);
                ddReoccurrenceType.waitClickable().selectByText(reoccurrence[2]);
                try{
                    ddReoccurrenceDay.waitClickable().selectByText(reoccurrence[3]);
                }
                catch (TimeoutException e){
                    ddReoccurrenceDayOfWeek.waitClickable().selectByText(reoccurrence[3]);
                }
                break;
        }
        startDate.waitClickable().clear().sendKeys(startDt, Keys.ESCAPE);
        ddTime.waitClickable().selectByText(time);
        endDate.waitClickable().clear().sendKeys(endDt, Keys.ESCAPE);
        //btnSave.waitClickable().click();
        //btnOk.waitClickable().click();
        //waitLoad();
    }

    public void copyScheduleTasks(String name, String newName, String category, String subCategory, String[] reoccurrence, String startDt, String time, String endDt, String... customer)  {
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + name + "')]]//button[@title = 'Copy']").waitClickable().click();
        tbScheduleName.waitClickable().clear().sendKeys(newName);
        ddCustomers.waitClickable().click();
        for (String c : customer) {
            if (!(_webDriverHandler.byXpath("//label[contains(text(), ' " + c + "')]//input").isSelected())) {
                _webDriverHandler.byXpath("//label[contains(text(), ' " + c + "')]").click();
            }
        }
        ddCategory.waitClickable().selectByText(category);
        waitLoad();
        ddSubCategory.waitClickable().selectByText(subCategory);
        ddReoccurrencePattern.waitClickable().selectByText(reoccurrence[0]);
        switch (reoccurrence[0]) {
            case "Weekly":
                ddReoccurrenceDay.waitClickable().selectByText(reoccurrence[1]);
                break;
            case "Monthly":
                ddReoccurrenceType.waitClickable().selectByText(reoccurrence[1]);
                try{
                    ddReoccurrenceDay.waitClickable().selectByText(reoccurrence[2]);
                }
                catch (TimeoutException e){
                    ddReoccurrenceDayOfWeek.waitClickable().selectByText(reoccurrence[2]);
                }
                break;
            case "Annual":
                ddReoccurrenceMonth.waitClickable().selectByText(reoccurrence[1]);
                ddReoccurrenceType.waitClickable().selectByText(reoccurrence[2]);
                try{
                    ddReoccurrenceDay.waitClickable().selectByText(reoccurrence[3]);
                }
                catch (TimeoutException e){
                    ddReoccurrenceDayOfWeek.waitClickable().selectByText(reoccurrence[3]);
                }
                break;
        }
        startDate.waitClickable().clear().sendKeys(startDt, Keys.ESCAPE);
        ddTime.waitClickable().selectByText(time);
        endDate.waitClickable().clear().sendKeys(endDt, Keys.ESCAPE);
        btnCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void columnVerification() {
        for (int i = 0; i < arrSubCategories.length; i++) {
            arrSubCategories[i] = _webDriverHandler.byXpath("//table[@id='tblScheduleTask']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubCategories[i].equals(arrSubCategories[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void errorValidation() {
        btnNewSchedule.waitClickable().click();
        btnCreate.waitClickable().click();
        if (msgScheduleName.getText().equalsIgnoreCase(strErrorScheduleName) && msgCustomer.getText().equals(strErrorCustomer) && msgCategory.getText().equals(strErrorCategory) && msgTime.getText().equals(strErrorTime)
        && msgSubCategory.getText().equals(strErrorSubCategory) && msgReoccurrence.getText().equals(strErrorReoccurrence) && msgStartDate.getText().equals(strErrorStartDate) && msgEndDate.getText().equals(strErrorEndDate)) {
            System.out.println("Proper error messages are shown.");
        }
        else{
            Assert.fail();
        }
        btnCancel.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}