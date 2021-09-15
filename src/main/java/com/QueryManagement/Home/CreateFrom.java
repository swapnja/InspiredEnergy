package com.QueryManagement.Home;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class CreateFrom {

    WebDriverHandler _webDriverHandler;
    ElementHandler tbFilterID;
    ElementHandler tbFilterUtility;
    ElementHandler tbFilterSubcategory;
    ElementHandler tbFilterNextAction;
    ElementHandler tbFilterDueDate;
    ElementHandler tbFilterStatus;
    ElementHandler tbFilterCWO;
    ElementHandler tbFilterOwner;
    ElementHandler btnEditEntry;

    ElementHandler btnCreateFrom;
    ElementHandler ddCustomer;
    ElementHandler ddCategory;
    ElementHandler ddSubCategory;
    ElementHandler ddSupplier;
    ElementHandler ddUtilityType;
    ElementHandler tbSummary;
    ElementHandler ddCWO;
    ElementHandler tglCustomerView;
    ElementHandler tglCustomerViewCheck;
    ElementHandler tglSupplierView;
    ElementHandler tglSupplierViewCheck;
    ElementHandler tbNextActionDate;
    ElementHandler tbDueDate;

    ElementHandler baseCustomer;
    ElementHandler baseCategory;
    ElementHandler baseSubCategory;
    ElementHandler baseSupplier;
    ElementHandler baseUtilityType;
    ElementHandler baseSummary;
    ElementHandler baseCWO;
    ElementHandler baseDueDate;
    ElementHandler baseNextActionDate;
    ElementHandler baseCV;
    ElementHandler baseSV;

    ElementHandler tabActions;
    ElementHandler tabDocuments;
    ElementHandler tabContacts;
    ElementHandler tabQueryLinks;
    ElementHandler tabInvoices;
    ElementHandler tabLocations;
    ElementHandler tabMeters;
    ElementHandler tabAccounts;
    ElementHandler btnCreate;
    ElementHandler btnCancel;

    String dataCustomer;
    String dataCategory;
    String dataSubCategory;
    String dataSupplier;
    String dataUtilityType;
    String dataSummary;
    //String dataCWO;
    //String dataNextActionDate;
    //String dataDueDate;
    boolean dataCV;
    boolean dataSV;

    public CreateFrom (WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tbFilterID = _webDriverHandler.byXpath("//*[@id = 'filterId']");
        tbFilterUtility = _webDriverHandler.byXpath("//*[@id = 'filterUtility']");
        tbFilterSubcategory = _webDriverHandler.byXpath("//*[@id = 'filterSubCategory']");
        tbFilterNextAction = _webDriverHandler.byXpath("//*[@id = 'filterNext']");
        tbFilterDueDate = _webDriverHandler.byXpath("//*[@id = filterDue");
        tbFilterStatus = _webDriverHandler.byXpath("//*[@id = 'filterStatus']");
        tbFilterCWO = _webDriverHandler.byXpath("//*[@id = 'filterCurrently']");
        tbFilterOwner = _webDriverHandler.byXpath("//*[@id = 'filterOwner']");
        btnEditEntry = _webDriverHandler.byXpath("//button[@title='Edit']");

        btnCreateFrom = _webDriverHandler.byXpath("//button[contains(text(),' Create From')]");
        ddCustomer = _webDriverHandler.byXpath("//*[@id='CustomerIdFromTaskInitial']");
        ddCategory = _webDriverHandler.byXpath("//*[@id='CategoryIdFromTaskInitial']");
        ddSubCategory = _webDriverHandler.byXpath("//*[@id='SubCategoryIdFromTaskInitial']");
        ddSupplier = _webDriverHandler.byXpath("//*[@id='SupplierIdFromTaskInitial']");
        tbSummary = _webDriverHandler.byXpath("//*[@id = 'SummaryTaskFromInitial']");
        ddUtilityType = _webDriverHandler.byXpath("//*[@id = 'UtilityTypeFromTaskInitial']");
        ddCWO = _webDriverHandler.byXpath("//*[@id = 'AwaitingTaskFromInitial']");
        tglCustomerView = _webDriverHandler.byXpath("//label[input[@name='CustomerAccessTaskFromInitial']]");
        tglCustomerViewCheck = _webDriverHandler.byXpath("//label[input[@name='CustomerAccessTaskFromInitial']]//input");
        tglSupplierView = _webDriverHandler.byXpath("//label[input[@name='SupplierAccessTaskFromInitial']]");
        tglSupplierViewCheck = _webDriverHandler.byXpath("//label[input[@name='SupplierAccessTaskFromInitial']]//input");
       tbNextActionDate = _webDriverHandler.byXpath("//*[@id = 'NextActionDateFromTaskInitial']");
       tbDueDate = _webDriverHandler.byXpath("//*[@id = 'DueDateFromTaskInitial']");

        baseCustomer = _webDriverHandler.byXpath("//div[@id = 'partialViewContent']//h3");
        baseCategory = _webDriverHandler.byXpath("//*[@id='CategoryName' and @type = 'hidden']");
        baseSubCategory = _webDriverHandler.byXpath("//*[@id='SubCategoryName' and @type = 'hidden']");
        baseSupplier = _webDriverHandler.byXpath("//*[@id='SupplierName']");
        baseUtilityType = _webDriverHandler.byXpath("//*[@id = 'Utilities']");
        baseSummary = _webDriverHandler.byXpath("//*[@id='Summary']");
        baseCWO = _webDriverHandler.byXpath("//*[@id='Awaiting']");
        baseDueDate = _webDriverHandler.byXpath("//*[@id = 'DueDate']");
        baseNextActionDate = _webDriverHandler.byXpath("//*[@id = 'NextActionDate']");
        baseCV = _webDriverHandler.byXpath("//*[@id='CustomerAccess']");
        baseSV = _webDriverHandler.byXpath("//*[@id = 'SupplierAccess']");

        tabActions = _webDriverHandler.byXpath("//a[@href = '#actions']");
        tabDocuments = _webDriverHandler.byXpath("//a[@href = '#documents']");
        tabContacts = _webDriverHandler.byXpath("//a[@href = '#contacts']");
        tabQueryLinks = _webDriverHandler.byXpath("//a[@href = '#tasklinks']");
        tabInvoices = _webDriverHandler.byXpath("//a[@href = '#invoices']");
        tabLocations = _webDriverHandler.byXpath("//a[@href = '#dvLocations']");
        tabMeters = _webDriverHandler.byXpath("//a[@href = '#meters']");
        tabAccounts = _webDriverHandler.byXpath("//a[@href = '#accounts']");
        btnCreate = _webDriverHandler.byXpath("//*[text() = ' Create']");
        btnCancel = _webDriverHandler.byXpath("//*[@id = 'createTaskFromForm']//*[text() = 'Cancel']");
    }

    public void accessSubCategory(String category, String subCategory) {
        waitLoad();
        _webDriverHandler.byXpath("//a//span[contains(text(), '" + category + "')]").waitClickable().click();
        _webDriverHandler.byXpath("//a[contains(text(), '" + subCategory + "')]").waitClickable().click();
    }

    public void filter(String type, String data) {
        switch (type){
            case "Id" :
                tbFilterID.waitClickable().clear().sendKeys(data);
            case "" :
                tbFilterID.waitClickable().clear().sendKeys(data);
            case "Utility" :
                tbFilterUtility.waitClickable().clear().sendKeys(data);
            case "Sub Category" :
                tbFilterSubcategory.waitClickable().clear().sendKeys(data);
            case "Next Action" :
                tbFilterNextAction.waitClickable().clear().sendKeys(data);
            case "Due Date" :
                tbFilterDueDate.waitClickable().clear().sendKeys(data);
            case "Status" :
                tbFilterStatus.waitClickable().clear().sendKeys(data);
            case "CWO" :
                tbFilterCWO.waitClickable().clear().sendKeys(data);
            case "Owner" :
                tbFilterOwner.waitClickable().clear().sendKeys(data);
        }
    }

    public void clearFilter() {
        tbFilterID.waitClickable().clear();
        tbFilterID.waitClickable().clear();
        tbFilterUtility.waitClickable().clear();
        tbFilterSubcategory.waitClickable().clear();
        tbFilterNextAction.waitClickable().clear();
        tbFilterDueDate.waitClickable().clear();
        tbFilterStatus.waitClickable().clear();
        tbFilterCWO.waitClickable().clear();
        tbFilterOwner.waitClickable().clear();
    }

    public void selectEntry(int id) {
        tbFilterID.waitClickable().clear().sendKeys(""+id);
        waitLoad();
        _webDriverHandler.byXpath("//tbody//tr[@id = '"+ id +"']//button[@title='Edit']").waitClickable().click();
        waitLoad();
    }

    public void getBaseData() {
        dataCustomer = baseCustomer.waitClickable().getText();
        dataCategory = baseCategory.getAttribute("value");
        dataSubCategory = baseSubCategory.getAttribute("value");
        dataSupplier = baseSupplier.getAttribute("value").trim();
        dataUtilityType = baseUtilityType.getAttribute("value");
        dataSummary = baseSummary.waitClickable().getAttribute("value");
        //dataCWO = baseCWO.waitClickable().getSelectedText();
        //dataNextActionDate = baseNextActionDate.waitClickable().getAttribute("value");
        //dataDueDate = baseDueDate.waitClickable().getAttribute("value");
        dataCV = baseCV.isSelected();
        dataSV = baseSV.isSelected();

//        System.out.println(dataCustomer + "\n" + dataCategory + "\n" + dataSubCategory + "\n" + dataSupplier + "\n" + dataUtilityType + "\n"
//                + dataSummary + "\n" + dataCWO + "\n" + dataDueDate + "\n" + dataCV + "\n" + dataSV);
    }

    public void verifyCreateFrom() {
        btnCreateFrom.waitClickable().click();
        Assert.assertEquals(dataCustomer, ddCustomer.getSelectedText());
        Assert.assertEquals(dataCategory, ddCategory.getSelectedText());
        Assert.assertEquals(dataSubCategory, ddSubCategory.getSelectedText());
        if (dataSupplier.equals("None")) {
            Assert.assertEquals(ddSupplier.getSelectedText(), ":: Select Supplier ::");
        } else {
            Assert.assertEquals(dataSupplier, ddSupplier.getSelectedText());
        }
        if (dataUtilityType.equals("None")) {
            Assert.assertEquals(ddUtilityType.getSelectedText(), ":: Select Utility Type ::");
        } else {
            Assert.assertEquals(dataUtilityType, ddUtilityType.getSelectedText());
        }
        Assert.assertEquals(dataSummary, tbSummary.getText());
//        Assert.assertEquals(dataCWO, ddCWO.getSelectedText());
//        Assert.assertEquals(dataDueDate, tbDueDate.getText());
//        Assert.assertEquals(dataNextActionDate, tbNextActionDate.getText());
        Assert.assertEquals(dataCV, tglCustomerViewCheck.isSelected());
        Assert.assertEquals(dataSV, tglSupplierViewCheck.isSelected());
    }

    public void linkActions(String... actionNote) {
        tabActions.waitClickable().click();
        try{waitLoad();}catch (Exception e){}
        if (actionNote.length > 0) {
            for (String t : actionNote) {
                _webDriverHandler.byXpath("//*[@id = 'tblActions']//tr[td[contains(text(),'" + t + "')]]//input").waitClickable().click();
            }
        } else {
            _webDriverHandler.byXpath("//*[@id = 'tblActions']//tbody//tr[1]//input").waitClickable().click();
        }
    }

    public void linkDocuments(String... docRef) {
        tabDocuments.waitClickable().click();
        try{waitLoad();}catch (Exception e){}
        if (docRef.length > 0) {
            for (String t : docRef) {
                _webDriverHandler.byXpath("//*[@id = 'tblDocuments']//tr[td[contains(text(),'" + t + "')]]//input").waitClickable().click();
            }
        } else {
            _webDriverHandler.byXpath("//*[@id = 'tblDocuments']//tbody//tr[1]//input").waitClickable().click();
        }
    }

    public void linkContacts(String... email) {
        tabContacts.waitClickable().click();
        try{waitLoad();}catch (Exception e){}
        if (email.length > 0) {
            for (String t : email) {
                _webDriverHandler.byXpath("//*[@id = 'tblContacts']//tr[td[contains(text(),'" + t + "')]]//input").waitClickable().click();
            }
        } else {
            _webDriverHandler.byXpath("//*[@id = 'tblContacts']//tbody//tr[1]//input").waitClickable().click();
        }
    }

    public void linkQueryLinks(String... queryId) {
        tabQueryLinks.waitClickable().click();
        try{waitLoad();}catch (Exception e){}
        if (queryId.length > 0) {
            for (String t : queryId) {
                _webDriverHandler.byXpath("//*[@id = 'tblTaskLinks']//tr[td[contains(text(),'" + t + "')]]//input").waitClickable().click();
            }
        } else {
            _webDriverHandler.byXpath("//*[@id = 'tblTaskLinks']//tbody//tr[1]//input").waitClickable().click();
        }
    }

    public void linkInvoices(String... invoiceNumber) {
        tabInvoices.waitClickable().click();
        try{waitLoad();}catch (Exception e){}
        if (invoiceNumber.length > 0) {
            for (String t : invoiceNumber) {
                _webDriverHandler.byXpath("//*[@id = 'tblInvoices']//tr[td[contains(text(),'" + t + "')]]//input").waitClickable().click();
            }
        } else {
            _webDriverHandler.byXpath("//*[@id = 'tblInvoices']//tbody//tr[1]//input").waitClickable().click();
        }
    }

    public void linkLocations(String... address) {
        tabLocations.waitClickable().click();
        try{waitLoad();}catch (Exception e){}
        if (address.length > 0) {
            for (String t : address) {
                _webDriverHandler.byXpath("//*[@id = 'tblLocations']//tr[td[contains(text(),'" + t + "')]]//input").waitClickable().click();
            }
        } else {
            _webDriverHandler.byXpath("//*[@id = 'tblLocations']//tbody//tr[1]//input").waitClickable().click();
        }
    }

    public void linkMeters(String... meterRef) {
        tabMeters.waitClickable().click();
        try{waitLoad();}catch (Exception e){}
        if (meterRef.length > 0) {
            for (String t : meterRef) {
                _webDriverHandler.byXpath("//*[@id = 'tblMeters']//tr[td[contains(text(),'" + t + "')]]//input").waitClickable().click();
            }
        } else {
            _webDriverHandler.byXpath("//*[@id = 'tblMeters']//tbody//tr[1]//input").waitClickable().click();
        }
    }

    public void linkAccounts(String... accountNumber) {
        tabAccounts.waitClickable().click();
        try{waitLoad();}catch (Exception e){}
        if (accountNumber.length > 0) {
            for (String t : accountNumber) {
                _webDriverHandler.byXpath("//*[@id = 'tblAccounts']//tr[td[contains(text(),'" + t + "')]]//input").waitClickable().click();
            }
        } else {
            _webDriverHandler.byXpath("//*[@id = 'tblAccounts']//tbody//tr[1]//input").waitClickable().click();
        }
    }

//    public void errorValidation() {
//        tbEstimated.waitClickable().clear().sendKeys("estimated");
//        tbActual.waitClickable().clear().sendKeys("actual");
//        tbAnnualised.waitClickable().clear().sendKeys("annualised");
//        tbActual.waitClickable().click();
//        Assert.assertEquals(msgEstimated.getText(), strErrorEstimated, "Estimated Saving validation is wrong.");
//        Assert.assertEquals(msgActual.getText(), strErrorActual, "Actual Saving validation is wrong.");
//        Assert.assertEquals(msgAnnualised.getText(), strErrorAnnualised, "Annualised Saving validation is wrong.");
//        btnAddAction.waitClickable().click();
//        btnCreate.waitClickable().click();
//        Assert.assertEquals(msgAction.getText(), strErrorAction, "Annualised Saving validation is wrong.");
//        //Work Left
//    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
