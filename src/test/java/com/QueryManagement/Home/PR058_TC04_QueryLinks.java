package com.QueryManagement.Home;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC04_QueryLinks extends AbstractTestNg {
    public PR058_TC04_QueryLinks() throws IOException {
    }

    @Test
    public void AccessQueryLinks() {
        QueryLinks queryLinks = new QueryLinks(webDriverHandler);
        queryLinks.accessSubCategory("Billing", "Bill too high");
        queryLinks.selectEntry(15);
        queryLinks.scrollToQueryLinks();
        queryLinks.columnVerification();
    }

    @Test
    public void QueryFilters() {
        QueryLinks queryLinks = new QueryLinks(webDriverHandler);
        queryLinks.accessSubCategory("Billing", "Bill too high");
        queryLinks.selectEntry(15);
        queryLinks.scrollToQueryLinks();
        queryLinks.accessAddQueries();
        queryLinks.queryFilters("Category", "Missing Data", "Disconnections", "PerfCategory");
        queryLinks.queryFilters("SubCategory", "Energy", "Power Factor", "Missing Invoice");
        queryLinks.queryFilters("Utility", "Gas", "Water");
        queryLinks.queryFilters("Status", "Open", "Resolved");
        queryLinks.queryFiltersReset();
    }

    @Test
    public void AddQuery() {
        QueryLinks queryLinks = new QueryLinks(webDriverHandler);
        queryLinks.accessSubCategory("Billing", "Bill too high");
        queryLinks.selectEntry(15);
        queryLinks.scrollToQueryLinks();
        queryLinks.accessAddQueries();
        queryLinks.addQuery("13567");
        queryLinks.verifySelection("13522");
    }

    @Test
    public void DeleteQuery() {
        QueryLinks queryLinks = new QueryLinks(webDriverHandler);
        queryLinks.accessSubCategory("Billing", "Bill too high");
        queryLinks.selectEntry(15);
        queryLinks.scrollToQueryLinks();
        queryLinks.deleteQuery("13567");
        queryLinks.deleteQuery("13522");
    }

    @Test
    public void ErrorValidation() {
        QueryLinks queryLinks = new QueryLinks(webDriverHandler);
        queryLinks.accessSubCategory("Billing", "Bill too high");
        queryLinks.selectEntry(15);
        queryLinks.scrollToQueryLinks();
        queryLinks.errorValidation();
    }
}