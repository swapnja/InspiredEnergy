package com.QueryManagement.Home;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Locations {

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
    ElementHandler tabLocations;

    ElementHandler btnLocation;
    ElementHandler tbAddresses;
    ElementHandler tbPostCode;
    ElementHandler btnApplyFilters;
    ElementHandler tbSearch;
    ElementHandler btnConfirm;
    ElementHandler btnCancel;
    ElementHandler btnYes;
    ElementHandler btnOK;

    public Locations(WebDriverHandler webDriverHandler) {
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
        headerQueryLinks = _webDriverHandler.byXpath("//*[@id = 'partialViewContent']/div/div/h4[contains(text(), 'Query Links')]");
        tabLocations = _webDriverHandler.byXpath("//a[@href = '#LocationsDiv']");

        btnLocation = _webDriverHandler.byXpath("//*[@onclick = 'showLocationForm()']");
        tbAddresses = _webDriverHandler.byXpath("//*[@id = 'TaskAddressFilterId']");
        tbPostCode = _webDriverHandler.byXpath("//*[@id = 'TaskPostCodeFilterId']");
        btnApplyFilters = _webDriverHandler.byXpath("//button[@onclick = 'bindLocationLinksTable()']");
        btnConfirm = _webDriverHandler.byXpath("//form[@id = 'queryTaskLocationForm']//button[contains(text(), 'Confirm')]");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'queryTaskLocationForm']//button[contains(text(), 'Cancel')]");
        btnYes = _webDriverHandler.byXpath("//button[contains(text(), 'Yes')]");
        btnOK = _webDriverHandler.byXpath("//button[contains(text(), 'OK')]");
    }

    public String[] tblILocations = new String[]{"Added date", "Added By", "Address", "Post Code", "Link Status", ""};
    public String[] arrLocations = new String[6];

    public void accessSubCategory(String category, String subCategory) {
        waitLoad();
        _webDriverHandler.byXpath("//a//span[contains(text(), '" + category + "')]").waitClickable().click();
        _webDriverHandler.byXpath("//a[contains(text(), '" + subCategory + "')]").waitClickable().click();
        waitLoad();
    }

    public void filter(String type, String data) {
        switch (type) {
            case "Id":
                tbFilterID.waitClickable().clear().sendKeys(data);
            case "":
                tbFilterID.waitClickable().clear().sendKeys(data);
            case "Utility":
                tbFilterUtility.waitClickable().clear().sendKeys(data);
            case "Sub Category":
                tbFilterSubcategory.waitClickable().clear().sendKeys(data);
            case "Next Action":
                tbFilterNextAction.waitClickable().clear().sendKeys(data);
            case "Due Date":
                tbFilterDueDate.waitClickable().clear().sendKeys(data);
            case "Status":
                tbFilterStatus.waitClickable().clear().sendKeys(data);
            case "CWO":
                tbFilterCWO.waitClickable().clear().sendKeys(data);
            case "Owner":
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
        tbFilterID.waitClickable().clear().sendKeys("" + id);
        waitLoad();
        btnEditEntry.waitClickable().click();
        waitLoad();
    }

    public void scrollToLocations() {
        headerQueryLinks.scrollDown();
        tabLocations.waitClickable().click();
        waitLoad();
    }

    public void accessAddLocations() {
        btnLocation.waitClickable().click();
        waitLoad();
    }

    public void columnVerification() {
        for (int i = 0; i < arrLocations.length; i++) {
            arrLocations[i] = _webDriverHandler.byXpath("//table[@id='LocationsTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblILocations[i].equals(arrLocations[i]))) {
                System.out.println(tblILocations[i]);
                System.out.println(arrLocations[i]);
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void locationFilters(String type, String text) {
        switch (type) {
            case "Address":
                    tbAddresses.waitClickable().sendKeys(text);
                break;
            case "Post Code":
                    tbPostCode.waitClickable().sendKeys(text);
                break;
        }
        btnApplyFilters.waitClickable().click();
        waitLoad();
    }

    public void locationFiltersReset() {
        tbAddresses.waitClickable().clear();
        tbPostCode.waitClickable().clear();
        btnApplyFilters.waitClickable().click();
    }

    public void addLocation() {
        for(int i = 1; i<3; i++) {
            _webDriverHandler.byXpath("//table[@id = 'LinkLocationTable']//tr["+i+"]/td//input").waitClickable().click();
        }
        btnConfirm.waitClickable().click();
        btnOK.waitClickable().click();
        waitLoad();
    }

    public void verifySelection(String data) {
        btnLocation.waitClickable().click();
        btnLocation.waitClickable().click();
        Assert.assertTrue(_webDriverHandler.byXpath("//tr[td[contains(text(), '" + data + "')]]//input").notPresent(), "Already selected entries are not shown.");
    }

    public void actionLocation(String actionType) {
        if (actionType.equalsIgnoreCase("Delete")) {
            for (int i = 1; i < 3; i++) {
                _webDriverHandler.byXpath("//table[@id = 'LocationsTable']//tr[1]//td//button[@title = '']").waitClickable().click();
                btnYes.waitClickable().click();
                waitLoad();
            }
        } else if (actionType.equalsIgnoreCase("Completed")) {
            for (int i = 1; i < 3; i++) {
                _webDriverHandler.byXpath("//table[@id = 'LocationsTable']//tr[" + i + "]//td//button[@title = 'Mark Completed']").waitClickable().click();
                btnYes.waitClickable().click();
                waitLoad();
            }
        } else {
            Assert.fail("No proper action was provided.");
        }
    }

    public void errorValidation() {
        btnLocation.waitClickable().click();
        waitLoad();
        btnConfirm.waitClickable().click();
        String errorMsg = _webDriverHandler.byXpath("//*[@id='swal2-content']").waitClickable().getText();
        Assert.assertEquals("Please select location to link.", errorMsg);
        btnOK.waitClickable().click();
        btnCancel.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
