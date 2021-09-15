package com.QueryManagement.Home;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC05_Invoices extends AbstractTestNg {
    public PR058_TC05_Invoices() throws IOException {
    }

    @Test
    public void AccessInvoices() {
        Invoices invoices = new Invoices(webDriverHandler);
        invoices.accessSubCategory("Billing", "Bill too high");
        invoices.selectEntry(15);
        invoices.scrollToInvoices();
        invoices.columnVerification();
    }

    @Test
    public void QueryFilters() {
        Invoices invoices = new Invoices(webDriverHandler);
        invoices.accessSubCategory("Billing", "Bill too high");
        invoices.selectEntry(15);
        invoices.scrollToInvoices();
        invoices.accessAddInvoices();
        invoices.invoiceFilters("BatchID", "100", "1014", "101");
        invoices.invoiceFilters("Supplier", "Avanti Gas", "EDF", "Crown");
        invoices.invoiceFilters("Utility", "Electricity", "Water");
        invoices.invoiceFilters("Status", "Pass", "Reject", "PassUser");
        invoices.dateFilters("01/01/2021", "01/06/2021");
        invoices.invoiceFiltersReset();
    }

    @Test
    public void AddInvoice() {
        Invoices invoices = new Invoices(webDriverHandler);
        invoices.accessSubCategory("Billing", "Bill too high");
        invoices.selectEntry(15);
        invoices.scrollToInvoices();
        invoices.accessAddInvoices();
        invoices.addInvoice("INV05723162");
        invoices.verifySelection("SLINV1651604");
    }

    @Test
    public void EditInvoice() {
        Invoices invoices = new Invoices(webDriverHandler);
        invoices.accessSubCategory("Billing", "Bill too high");
        invoices.selectEntry(15);
        invoices.scrollToInvoices();
        invoices.actionInvoice("Completed", "SLINV1651604");
        invoices.actionInvoice("Delete", "SLINV1651604");
        invoices.actionInvoice("Completed", "INV05723162");
        invoices.actionInvoice("Delete", "INV05723162");
    }

    @Test
    public void ErrorValidation() {
        Invoices invoices = new Invoices(webDriverHandler);
        invoices.accessSubCategory("Billing", "Bill too high");
        invoices.selectEntry(15);
        invoices.scrollToInvoices();
        invoices.errorValidation();
    }
}
