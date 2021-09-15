package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;


public class QueryDashboard {

    WebDriverHandler _webDriverHandler;
    ElementHandler ddTaskType;
    ElementHandler ddPlotType;
    ElementHandler btnCustomers;
    ElementHandler btnSuppliers;
    ElementHandler btnCategories;
    ElementHandler btnSubCategories;
    ElementHandler btnCurrentlyWaitingOn;
    ElementHandler ddCustomers;
    ElementHandler ddSuppliers;
    ElementHandler ddCategories;
    ElementHandler ddSubCategories;
    ElementHandler ddCurrentlyWaitingOn;
    ElementHandler btnExport;
    ElementHandler btnListView;
    ElementHandler btnGraphView;
    ElementHandler btnTableView;
    ElementHandler graphView;
    ElementHandler listView;
    ElementHandler tableView;
    ElementHandler ddViewBy;
    ElementHandler ddTableViewBy;
    ElementHandler ddSortBy;
    ElementHandler cardTotalSavings;
    ElementHandler cardForecastSavings;
    ElementHandler cardTasksOpen;
    ElementHandler cardTasksClosed;
    ElementHandler tbSearch;

    ElementHandler pieSupplier;
    ElementHandler pieUtility;
    ElementHandler pieCategory;
    ElementHandler pieSubCategory;

    public QueryDashboard(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        ddTaskType = _webDriverHandler.byXpath("//*[@id = 'selectTaskType']");
        ddPlotType = _webDriverHandler.byXpath("//*[@id = 'selectPlotType']");
        btnCustomers = _webDriverHandler.byXpath("//button[contains(@title, 'Customers')]");
        btnSuppliers = _webDriverHandler.byXpath("//button[contains(@title, 'Suppliers')]");
        btnCategories = _webDriverHandler.byXpath("//button[contains(@title, 'Categories')]");
        btnSubCategories = _webDriverHandler.byXpath("//button[contains(@title, 'Sub-Categories')]");
        btnCurrentlyWaitingOn = _webDriverHandler.byXpath("//button[contains(@title, 'Currently')]");
        ddCustomers = _webDriverHandler.byXpath("//*[@id = 'selectCustomerId']");
        ddSuppliers = _webDriverHandler.byXpath("//*[@id = 'selectSupplierId']");
        ddCategories = _webDriverHandler.byXpath("//*[@id = 'selectCategoryId']");
        ddSubCategories = _webDriverHandler.byXpath("//*[@id = 'selectSubCategoryId']");
        ddCurrentlyWaitingOn = _webDriverHandler.byXpath("//*[@id = 'selectAwatingOn']");
        btnExport = _webDriverHandler.byXpath("//*[@id = 'btnExportDashboard']");
        btnListView = _webDriverHandler.byXpath("//div[@id='partialViewContent']//*[@class='fa fa-list fa-2x']");
        btnGraphView = _webDriverHandler.byXpath("//div[@id='partialViewContent']//*[@class='fa fa-chart-bar fa-2x']");
        btnTableView = _webDriverHandler.byXpath("//div[@id='partialViewContent']//*[@class='fa fa-table fa-2x']");
        graphView = _webDriverHandler.byXpath("//div[@id='exportView']");
        listView = _webDriverHandler.byXpath("//div[@class='row']//select[@id='sortView']");
        tableView = _webDriverHandler.byXpath("//*[@id='tblNumericReport']");
        ddViewBy = _webDriverHandler.byXpath("//*[@id = 'changeView']");
        ddTableViewBy = _webDriverHandler.byXpath("//*[@id = 'changeTableView']");
        ddSortBy = _webDriverHandler.byXpath("//*[@id = 'sortView']");
        cardTotalSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_closed']//..");
        cardForecastSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_open']//..");
        cardTasksOpen = _webDriverHandler.byXpath("//div[@id = 'openTaskCount']//..");
        cardTasksClosed = _webDriverHandler.byXpath("//div[@id = 'closedTasksCount']//..");
        tbSearch = _webDriverHandler.byXpath("//input[@type='search']");

        pieSupplier = _webDriverHandler.byXpath("//*[@id = 'plotArea1']");
        pieUtility = _webDriverHandler.byXpath("//*[@id = 'plotArea4']");
        pieCategory = _webDriverHandler.byXpath("//*[@id = 'plotArea2']");
        pieSubCategory = _webDriverHandler.byXpath("//*[@id = 'plotArea3']");
    }

    public String[] tblTableView = new String[]{"Supplier Name", "Total Savings", "Annualised Savings", "Forecast Savings", "Annualised Forecast Savings", "Task Open", "Task Closed"};
    public String[] arrTableView = new String[7];

    public void verifyDashboard() {
        if (cardTotalSavings.isDisplayed() && cardForecastSavings.isDisplayed() && cardTasksOpen.isDisplayed() && cardTasksClosed.isDisplayed() &&
                btnListView.isDisplayed() && btnExport.isDisplayed() && ddTaskType.isDisplayed() && ddPlotType.isDisplayed() && ddCustomers.isDisplayed()
                && ddSuppliers.isDisplayed() && ddCategories.isDisplayed() && ddSubCategories.isDisplayed() && ddCurrentlyWaitingOn.isDisplayed()) {
            System.out.println("The Dashboard page has loaded properly.");
        }
        else {
            Assert.fail("The dashboard page is not loaded properly.");
        }
    }

    public void toggleView(String view) {
        switch (view) {
            case "Graph":
                if (graphView.notPresent()) {
                    btnGraphView.waitClickable().click();
                    waitLoad();
                }
                break;
            case "List":
                if (listView.notPresent()) {
                    btnListView.waitClickable().click();
                    waitLoad();
                }
                break;
            case "Table":
                if (listView.notPresent()) {
                    btnListView.waitClickable().click();
                    waitLoad();
                    btnTableView.waitClickable().click();
                    waitLoad();
                }
                else if(listView.isDisplayed()) {
                    btnTableView.waitClickable().click();
                    waitLoad();
                }
                break;
        }
    }

    public void filters(String type, String... data) {
        switch (type) {
            case "Task":
                ddTaskType.waitClickable().selectByText(data[0]);
                try { waitLoad(); } catch (Exception ignored) { }
                break;
            case "Plot":
                ddPlotType.waitClickable().selectByText(data[0]);
                try { waitLoad(); } catch (Exception ignored) { }
                break;
            case "Customer":
                for (String text : data) {
                    ddCustomers.waitClickable().selectByText(text);
                }
                try { waitLoad(); } catch (Exception ignored) { }
                btnCustomers.waitClickable().click();
                btnCustomers.waitClickable().click();
                break;
            case "Supplier":
                for (String text : data) {
                    ddSuppliers.waitClickable().selectByText(text);
                }
                try { waitLoad(); } catch (Exception ignored) { }
                btnSuppliers.waitClickable().click();
                btnSuppliers.waitClickable().click();
                break;
            case "Category":
                for (String text : data) {
                    ddCategories.waitClickable().selectByText(text);
                }
                try { waitLoad(); } catch (Exception ignored) { }
                btnCategories.waitClickable().click();
                btnCategories.waitClickable().click();
                break;
            case "SubCategory":
                for (String text : data) {
                    ddSubCategories.waitClickable().selectByText(text);
                }
                try { waitLoad(); } catch (Exception ignored) { }
                btnSubCategories.waitClickable().click();
                btnSubCategories.waitClickable().click();
                break;
            case "CWO":
                for (String text : data) {
                    ddCurrentlyWaitingOn.waitClickable().selectByText(text);
                }
                try { waitLoad(); } catch (Exception ignored) { }
                btnCurrentlyWaitingOn.waitClickable().click();
                btnCurrentlyWaitingOn.waitClickable().click();
                break;
        }
    }

    public void resetFilter(){
        ddCustomers.waitClickable().deselectAll();
        ddSuppliers.waitClickable().deselectAll();
        ddCategories.waitClickable().deselectAll();
        ddSubCategories.waitClickable().deselectAll();
        ddCurrentlyWaitingOn.waitClickable().deselectAll();
    }

    public void export() {
        btnExport.scrollDown();
        btnExport.waitClickable().click();
        waitLoad();
    }

    public void viewBy(String view) {
        if(listView.isDisplayed()){
            switch(view) {
                case "Supplier":
                    ddViewBy.waitClickable().selectByText("Supplier");
                    break;
                case "Customer":
                    ddViewBy.waitClickable().selectByText("Customer");
                    break;
                case "Licensee":
                    ddViewBy.waitClickable().selectByText("Licensee");
                    break;
            }
            try{waitLoad();}catch (Exception e){System.out.println(""+e);}
        }
        else {
            System.out.println("List view is not enabled.");
            btnListView.waitClickable().click();
            viewBy(view);
        }
    }

    public void sortBy(String sort) {
        if(listView.isDisplayed()){
            switch(sort) {
                case "Default":
                    ddSortBy.waitClickable().selectByIndex(1);
                    break;
                case "Total":
                    ddSortBy.waitClickable().selectByText("Total Savings");
                    break;
                case "Forecast":
                    ddSortBy.waitClickable().selectByText("Forecast Savings");
                    break;
                case "Open":
                    ddSortBy.waitClickable().selectByText("Tasks Open");
                    break;
                case "Closed":
                    ddSortBy.waitClickable().selectByText("Tasks Closed");
                    break;
            }
            try{waitLoad();}catch (Exception ignored){}
        }
        else {
            System.out.println("List view is not enabled.");
            btnListView.waitClickable().click();
            viewBy(sort);
        }
    }

    public void search(String search) {
        tbSearch.waitClickable().sendKeys(search);
        waitLoad();
    }

    public void columnVerification() {
        for (int i = 0; i < arrTableView.length; i++) {
            arrTableView[i] = _webDriverHandler.byXpath("//table[@id='tblNumericReport']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblTableView[i].equals(arrTableView[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void viewByTable(String view) {
        if(tableView.isDisplayed()) {
            switch(view) {
                case "Supplier":
                    ddTableViewBy.waitClickable().selectByText("Supplier");
                    break;
                case "Customer":
                    ddTableViewBy.waitClickable().selectByText("Customer");
                    break;
                case "Licensee":
                    ddTableViewBy.waitClickable().selectByText("Licensee");
                    break;
            }
            try{waitLoad();}catch (Exception ignored){}
        }
        else {
            System.out.println("Table view is not enabled.");
            btnTableView.waitClickable().click();
            viewBy(view);
        }
    }

    public void selectCard(String card) {
        switch (card) {
            case "Total":
                cardTotalSavings.waitClickable().click();
                break;
            case "Forecast":
                cardForecastSavings.waitClickable().click();
                break;
            case "Open":
                cardTasksOpen.waitClickable().click();
                break;
            case "Close":
                cardTasksClosed.waitClickable().click();
                break;
        }
        waitLoad();
    }

    public void verifyCards(String... selection) {
        if(pieSupplier.isDisplayed() && pieSupplier.isDisplayed() && pieCategory.isDisplayed() && pieSubCategory.isDisplayed()){
            System.out.println("All charts are displayed.");
        }
        else {
            Assert.fail("Charts are wrong.");
        }
        switch (selection[0]) {
            case "Supplier":
                pieSupplier.waitClickable().click();
                break;
            case "Utility":
                pieUtility.waitClickable().click();
                break;
            case "Category":
                pieCategory.waitClickable().click();
                break;
            case "SubCategory":
                pieSubCategory.waitClickable().click();
                break;
        }
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible(15,100);
    }
}