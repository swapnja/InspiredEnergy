package com.QueryManagement.Home;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC06_Locations extends AbstractTestNg {
    public PR058_TC06_Locations() throws IOException {
    }

    @Test
    public void AccessLocations() {
        Locations locations = new Locations(webDriverHandler);
        locations.accessSubCategory("Billing", "Bill too high");
        locations.selectEntry(15);
        locations.scrollToLocations();
        locations.columnVerification();
    }

    @Test
    public void QueryFilters() {
        Locations locations = new Locations(webDriverHandler);
        locations.accessSubCategory("Billing", "Bill too high");
        locations.selectEntry(15);
        locations.scrollToLocations();
        locations.accessAddLocations();
        locations.locationFilters("", "");
        locations.locationFiltersReset();
    }

    @Test
    public void AddLocation() {
        Locations locations = new Locations(webDriverHandler);
        locations.accessSubCategory("Billing", "Bill too high");
        locations.selectEntry(15);
        locations.scrollToLocations();
        locations.accessAddLocations();
        locations.addLocation();
        //locations.verifySelection();
    }

    @Test
    public void EditLocation() {
        Locations locations = new Locations(webDriverHandler);
        locations.accessSubCategory("Billing", "Bill too high");
        locations.selectEntry(15);
        locations.scrollToLocations();
        locations.actionLocation("Completed");
        locations.actionLocation("Delete");
    }

    @Test
    public void ErrorValidation() {
        Locations locations = new Locations(webDriverHandler);
        locations.accessSubCategory("Billing", "Bill too high");
        locations.selectEntry(15);
        locations.scrollToLocations();
        locations.errorValidation();
    }
}