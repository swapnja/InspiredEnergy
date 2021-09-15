package com.QueryManagement.Dashboard;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC01_Verify_Query_Dashboard extends AbstractTestNg {

    public PR058_TC01_Verify_Query_Dashboard() throws IOException {
    }

    @Test
    public void VerifyDashboard() {
        QueryDashboard queryDashboard = new QueryDashboard(webDriverHandler);
        queryDashboard.waitLoad();
        queryDashboard.verifyDashboard();
    }

    @Test
    public void ToggleView() {
        QueryDashboard queryDashboard = new QueryDashboard(webDriverHandler);
        queryDashboard.waitLoad();
        queryDashboard.toggleView("Graph");
        queryDashboard.toggleView("List");
        queryDashboard.toggleView("Table");
    }

    @Test
    public void VerifyFilters() {
        QueryDashboard queryDashboard = new QueryDashboard(webDriverHandler);
        queryDashboard.waitLoad();
        queryDashboard.filters("Task", "Open Tasks");
        queryDashboard.filters("Plot", "Current");
        queryDashboard.filters("Customer", "IPL", "Boardlink Ltd.", "Customer");
        queryDashboard.filters("Supplier", "Engie", "BES", "Avanti Gas");
        queryDashboard.filters("Category", "Billing", "Meter");
        queryDashboard.filters("SubCategory", "Bill too high", "Meter Removal");
        queryDashboard.filters("CWO", "Customer", "Supplier");
        queryDashboard.resetFilter();
    }

    @Test
    public void Export() {
        QueryDashboard queryDashboard = new QueryDashboard(webDriverHandler);
        queryDashboard.waitLoad();
        queryDashboard.filters("Task", "Open Tasks");
        queryDashboard.filters("Plot", "Current");
        queryDashboard.filters("Customer", "IPL");
        queryDashboard.export();
    }

    @Test
    public void VerifyCards() {
        QueryDashboard queryDashboard = new QueryDashboard(webDriverHandler);
        queryDashboard.waitLoad();
        queryDashboard.selectCard("Forecast");
        queryDashboard.verifyCards("Supplier");
    }

    @Test
    public void VerifyListView() {
        QueryDashboard queryDashboard = new QueryDashboard(webDriverHandler);
        queryDashboard.waitLoad();
        queryDashboard.toggleView("List");
        queryDashboard.viewBy("Supplier");
        queryDashboard.sortBy("Forecast");
        queryDashboard.sortBy("Default");
        queryDashboard.export();
        queryDashboard.viewBy("Customer");
        queryDashboard.sortBy("Total");
        queryDashboard.sortBy("Default");
        queryDashboard.export();
        queryDashboard.viewBy("Licensee");
        queryDashboard.sortBy("Forecast");
        queryDashboard.sortBy("Total");
        queryDashboard.sortBy("Open");
        queryDashboard.sortBy("Closed");
        queryDashboard.sortBy("Default");
        queryDashboard.export();
    }

    @Test
    public void VerifyTableView() {
        QueryDashboard queryDashboard = new QueryDashboard(webDriverHandler);
        queryDashboard.waitLoad();
        queryDashboard.toggleView("Table");
        queryDashboard.columnVerification();
        queryDashboard.viewByTable("Licensee");
        queryDashboard.export();
        queryDashboard.viewByTable("Supplier");
        queryDashboard.search("EDF");
        queryDashboard.viewByTable("Customer");
        queryDashboard.export();
        queryDashboard.search("Gentoo Group Ltd");
        queryDashboard.export();
    }
}
