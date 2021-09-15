package com.QueryManagement.Home;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC08_Accounts extends AbstractTestNg {
    public PR058_TC08_Accounts() throws IOException {
    }

    @Test
    public void AccessAccounts() {
        Accounts accounts = new Accounts(webDriverHandler);
        accounts.accessSubCategory("Billing", "Bill too high");
        accounts.selectEntry(15);
        accounts.scrollToAccounts();
        accounts.columnVerification();
    }

    @Test
    public void AccountFilters() {
        Accounts accounts = new Accounts(webDriverHandler);
        accounts.accessSubCategory("Billing", "Bill too high");
        accounts.selectEntry(15);
        accounts.scrollToAccounts();
        accounts.accessAddAccounts();
        accounts.accountFilters("Supplier", "Avanti Gas", "EDF", "Crown");
        accounts.accountFilters("Utility", "Electricity", "Water");
        accounts.accountFiltersReset();
    }

    @Test
    public void AddAccount() {
        Accounts accounts = new Accounts(webDriverHandler);
        accounts.accessSubCategory("Billing", "Bill too high");
        accounts.selectEntry(15);
        accounts.scrollToAccounts();
        accounts.accessAddAccounts();
        accounts.addAccount("50339546");
        accounts.verifySelection("8888940876");
    }

    @Test
    public void EditAccount() {
        Accounts accounts = new Accounts(webDriverHandler);
        accounts.accessSubCategory("Billing", "Bill too high");
        accounts.selectEntry(15);
        accounts.scrollToAccounts();
        accounts.actionAccount("Completed", "50339546");
        accounts.actionAccount("Delete", "50339546");
        accounts.actionAccount("Completed", "8888940876");
        accounts.actionAccount("Delete", "8888940876");
    }

    @Test
    public void ErrorValidation() {
        Accounts accounts = new Accounts(webDriverHandler);
        accounts.accessSubCategory("Billing", "Bill too high");
        accounts.selectEntry(15);
        accounts.scrollToAccounts();
        accounts.errorValidation();
    }
}
