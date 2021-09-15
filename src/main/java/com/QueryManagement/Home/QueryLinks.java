package com.QueryManagement.Home;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class QueryLinks {

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
    ElementHandler headerQueryLink;
    ElementHandler tabQueryLink;

    ElementHandler btnAddQueries;
    ElementHandler ddCategory;
    ElementHandler ddSubCategory;
    ElementHandler ddUtility;
    ElementHandler ddStatus;
    ElementHandler btnCategory;
    ElementHandler btnSubCategory;
    ElementHandler btnUtility;
    ElementHandler btnStatus;
    ElementHandler btnApplyFilters;
    ElementHandler tbSearch;
    ElementHandler btnConfirm;
    ElementHandler btnCancel;
    ElementHandler btnYes;
    ElementHandler btnOK;

    public QueryLinks(WebDriverHandler webDriverHandler) {
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
        headerQueryLink  =  _webDriverHandler.byXpath("//*[@id = 'partialViewContent']/div/div/h4[contains(text(), 'Query Links')]");
        tabQueryLink = _webDriverHandler.byXpath("//a[@href = '#QueryLinksDiv']");

        btnAddQueries = _webDriverHandler.byXpath("//*[@onclick = 'ShowQueryLinkForm()']");
        ddCategory = _webDriverHandler.byXpath("//*[@id = 'Categories_dropdown']");
        ddSubCategory = _webDriverHandler.byXpath("//*[@id = 'SubCategories_dropdown']");
        ddUtility = _webDriverHandler.byXpath("//*[@id = 'Utility_dropdown']");
        ddStatus = _webDriverHandler.byXpath("//*[@id = 'Status_dropdown']");
        btnCategory = _webDriverHandler.byXpath("//*[@id = 'Categories_dropdown']//../div/button");
        btnSubCategory = _webDriverHandler.byXpath("//*[@id = 'SubCategories_dropdown']//../div/button");
        btnUtility = _webDriverHandler.byXpath("//*[@id = 'Utility_dropdown']//../div/button");
        btnStatus = _webDriverHandler.byXpath("//*[@id = 'Status_dropdown']//../div/button");
        btnApplyFilters = _webDriverHandler.byXpath("//button[@onclick = 'bindQueryLinksTable()']");
        tbSearch = _webDriverHandler.byXpath("//input[@type = 'search']");
        btnConfirm = _webDriverHandler.byXpath("//form[@id = 'queryLinkForm']//button[contains(text(), 'Confirm')]");
        btnCancel = _webDriverHandler.byXpath("//form[@id = 'queryLinkForm']//button[contains(text(), 'Cancel')]");
        btnYes = _webDriverHandler.byXpath("//button[contains(text(), 'Yes')]");
        btnOK = _webDriverHandler.byXpath("//button[contains(text(), 'OK')]");
    }

    public String[] tblQueryLinks = new String[]{"Link date", "Link Added By", "Query ID", "Category", "Sub Category", "Utility", "Status", ""};
    public String[] arrQueryLinks = new String[8];

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

    public void scrollToQueryLinks() {
        headerQueryLink.scrollDown();
        tabQueryLink.waitClickable().click();
    }

    public void accessAddQueries() {
        btnAddQueries.waitClickable().click();
        waitLoad();
    }

    public void columnVerification() {
        for (int i = 0; i < arrQueryLinks.length; i++) {
            arrQueryLinks[i] = _webDriverHandler.byXpath("//table[@id='QueryLinkTable']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblQueryLinks[i].equals(arrQueryLinks[i]))) {
                System.out.println(tblQueryLinks[i]);
                System.out.println(arrQueryLinks[i]);
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void queryFilters(String type, String... data) {
        switch (type) {
            case "Category":
                for (String text : data) {
                    ddCategory.waitClickable().selectByText(text);
                }
                waitLoad();
                btnCategory.waitClickable().click();
                btnCategory.waitClickable().click();
                break;
            case "SubCategory":
                for (String text : data) {
                    ddSubCategory.waitClickable().selectByText(text);
                }
                btnSubCategory.waitClickable().click();
                btnSubCategory.waitClickable().click();
                break;
            case "Utility":
                for (String text : data) {
                    ddUtility.waitClickable().selectByText(text);
                }
                btnUtility.waitClickable().click();
                btnUtility.waitClickable().click();
                break;
            case "Status":
                for (String text : data) {
                    ddStatus.waitClickable().selectByText(text);
                }
                btnStatus.waitClickable().click();
                btnStatus.waitClickable().click();
                break;
        }
        btnApplyFilters.waitClickable().click();
        waitLoad();
    }

    public void queryFiltersReset() {
        ddCategory.waitClickable().deselectAll();
        ddSubCategory.waitClickable().deselectAll();
        ddUtility.waitClickable().deselectAll();
        ddStatus.waitClickable().deselectAll();
        btnApplyFilters.waitClickable().click();
    }

    public void querySearch(String queryID) {
        tbSearch.waitClickable().clear().sendKeys(queryID);
        waitLoad();
    }

    public void addQuery(String queryID) {
        querySearch(queryID);
        _webDriverHandler.byXpath("//tr[@id = '"+ queryID +"']//input").waitClickable().click();
        btnConfirm.waitClickable().click();
        waitLoad();
    }

    public void verifySelection(String queryID) {
        btnAddQueries.waitClickable().click();
        addQuery(queryID);
        btnAddQueries.waitClickable().click();
        querySearch(queryID);
        Assert.assertTrue(_webDriverHandler.byXpath("//tr[@id = '"+ queryID +"']//input").notPresent(), "Already selected entries are not shown.");
    }

    public void deleteQuery(String queryID) {
        _webDriverHandler.byXpath("//tr[td//a[contains(text(), '"+ queryID +"')]]//button").waitClickable().click();
        btnYes.waitClickable().click();
        waitLoad();
    }

    public void errorValidation() {
        btnAddQueries.waitClickable().click();
        waitLoad();
        btnConfirm.waitClickable().click();
        String errorMsg = _webDriverHandler.byXpath("//*[@id='swal2-content']").waitClickable().getText();
        Assert.assertEquals("Please select atleast 1 records", errorMsg);
        btnOK.waitClickable().click();
        btnCancel.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();;
    }
}
