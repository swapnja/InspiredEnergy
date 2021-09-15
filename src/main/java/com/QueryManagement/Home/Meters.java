package com.QueryManagement.Home;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Meters {

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
    ElementHandler headerQueryLinks;
    ElementHandler tabIMeters;

    ElementHandler btnMeter;
    ElementHandler ddSupplier;
    ElementHandler ddUtility;
    ElementHandler btnSupplier;
    ElementHandler btnUtility;
    ElementHandler btnApplyFilters;
    ElementHandler tbSearch;
    ElementHandler btnConfirm;
    ElementHandler btnCancel;
    ElementHandler btnYes;
    ElementHandler btnOK;

    public Meters(WebDriverHandler webDriverHandler) {
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
        headerQueryLinks =  _webDriverHandler.byXpath("//*[@id = 'partialViewContent']/div/div/h4[contains(text(), 'Query Links')]");
        tabIMeters = _webDriverHandler.byXpath("//a[@href = '#MetersDiv']");

        btnMeter = _webDriverHandler.byXpath("//*[@onclick = 'showMetersForm()']");
        ddSupplier = _webDriverHandler.byXpath("//*[@id = 'SupplierIds']");
        ddUtility = _webDriverHandler.byXpath("//*[@id = 'UtilityTypes']");;
        btnSupplier = _webDriverHandler.byXpath("//*[@id = 'SupplierIds']//../div/button");
        btnUtility = _webDriverHandler.byXpath("//*[@id = 'UtilityTypes']//../div/button");
        btnApplyFilters = _webDriverHandler.byXpath("//button[@onclick = 'bindMetersLinksTable()']");
        tbSearch = _webDriverHandler.byXpath("//input[@type = 'search']");
        btnConfirm = _webDriverHandler.byXpath("//form[@id = 'queryTaskMeterForm']//button[contains(text(), 'Confirm')]");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'queryTaskMeterForm']//button[contains(text(), 'Cancel')]");
        btnYes = _webDriverHandler.byXpath("//button[contains(text(), 'Yes')]");
        btnOK = _webDriverHandler.byXpath("//button[contains(text(), 'OK')]");
    }

    public String[] tblMeters = new String[]{"Added date", "Added By", "Meter Reference", "Utility", "Post Code", "Link Status", ""};
    public String[] arrMeters = new String[7];

    public void accessSubCategory(String category, String subCategory) {
        waitLoad();
        _webDriverHandler.byXpath("//a//span[contains(text(), '" + category + "')]").waitClickable().click();
        _webDriverHandler.byXpath("//a[contains(text(), '" + subCategory + "')]").waitClickable().click();
        waitLoad();
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
        btnEditEntry.waitClickable().click();
        waitLoad();
    }

    public void scrollToMeters() {
        headerQueryLinks.scrollDown();
        tabIMeters.waitClickable().click();
        waitLoad();
    }

    public void accessAddMeters() {
        btnMeter.waitClickable().click();
        waitLoad();
    }

    public void columnVerification() {
        for (int i = 0; i < arrMeters.length; i++) {
            arrMeters[i] = _webDriverHandler.byXpath("//table[@id='TaskMetersTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblMeters[i].equals(arrMeters[i]))) {
                System.out.println(tblMeters[i]);
                System.out.println(arrMeters[i]);
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void meterFilters(String type, String... data) {
        switch (type) {
            case "Supplier":
                for (String text : data) {
                    ddSupplier.waitClickable().selectByText(text);
                }
                btnSupplier.waitClickable().click();
                btnSupplier.waitClickable().click();
                break;
            case "Utility":
                for (String text : data) {
                    ddUtility.waitClickable().selectByText(text);
                }
                btnUtility.waitClickable().click();
                btnUtility.waitClickable().click();
                break;
        }
        btnApplyFilters.waitClickable().click();
        waitLoad();
    }

    public void meterFiltersReset() {
        ddSupplier.waitClickable().deselectAll();
        ddUtility.waitClickable().deselectAll();
        btnApplyFilters.waitClickable().click();
    }

    public void meterSearch(String meterID) {
        tbSearch.waitClickable().clear().sendKeys(meterID);
        waitLoad();
    }

    public void addMeter(String meterID) {
        meterSearch(meterID);
        _webDriverHandler.byXpath("//tr[td[contains(text(), '"+ meterID +"')]]//input").waitClickable().click();
        btnConfirm.waitClickable().click();
        btnOK.waitClickable().click();
        waitLoad();
    }

    public void verifySelection(String meterID) {
        btnMeter.waitClickable().click();
        addMeter(meterID);
        btnMeter.waitClickable().click();
        meterSearch(meterID);
        Assert.assertTrue(_webDriverHandler.byXpath("//tr[td[contains(text(), '"+ meterID +"')]]//input").notPresent(), "Already selected entries are not shown.");
    }

    public void actionMeter(String actionType, String meterID) {
        if (actionType.equalsIgnoreCase("Delete")) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + meterID + "')]]//button[@title = '']").waitClickable().click();
        } else if (actionType.equalsIgnoreCase("Completed")) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + meterID + "')]]//button[@title = 'Mark Completed']").waitClickable().click();
        }
        else{
            Assert.fail("No proper action was provided.");
        }
        btnYes.waitClickable().click();
        waitLoad();
    }

    public void errorValidation() {
        btnMeter.waitClickable().click();
        waitLoad();
        btnConfirm.waitClickable().click();
        String errorMsg = _webDriverHandler.byXpath("//*[@id='swal2-content']").waitClickable().getText();
        Assert.assertEquals("Please select meters to link.", errorMsg);
        btnOK.waitClickable().click();
        btnCancel.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(15, 100).waitInvisible(15, 100);
    }
}