package com.BulkScanning.PostRoonManagement;

import com.BulkScanning.CommonMethods.AbstractTestNg;
import com.BulkScanning.PageObject.PostRoomManagement.StatementsOfAccounts;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC008_VerifyStatementsOFAccounts extends AbstractTestNg {

    public TC008_VerifyStatementsOFAccounts() throws IOException {
    }

    @Test
    public void StatementsOfAccountsTable() {
        StatementsOfAccounts statementsOfAccounts = new StatementsOfAccounts(webDriverHandler);
        statementsOfAccounts.accessStatementsOfAccounts();
        statementsOfAccounts.loadStatementsOfAccounts();
        statementsOfAccounts.columnVerification();
    }

    @Test
    public void StatementsOfAccountsFilterApply() {
        StatementsOfAccounts statementsOfAccounts = new StatementsOfAccounts(webDriverHandler);
        statementsOfAccounts.accessStatementsOfAccounts();
        statementsOfAccounts.filterStatementsOfAccounts("Parent", "Not Applicable");
        statementsOfAccounts.filterStatementsOfAccounts("Customer", "Ability Tec Ltd", "Airtricity");
        statementsOfAccounts.filterStatementsOfAccounts("Supplier", "BES", "CNG");
    }

    @Test
    public void StatementsOfAccountsFilterReset() {
        StatementsOfAccounts statementsOfAccounts = new StatementsOfAccounts(webDriverHandler);
        statementsOfAccounts.accessStatementsOfAccounts();
        statementsOfAccounts.filterStatementsOfAccounts("Parent", "Not Applicable");
        statementsOfAccounts.filterStatementsOfAccounts("Customer", "Ability Tec Ltd", "Airtricity");
        statementsOfAccounts.filterStatementsOfAccounts("Supplier", "BES", "CNG");
        statementsOfAccounts.filterReset();
    }

    @Test
    public void StatementsOfAccountsSearch() {
        StatementsOfAccounts statementsOfAccounts = new StatementsOfAccounts(webDriverHandler);
        statementsOfAccounts.accessStatementsOfAccounts();
        statementsOfAccounts.searchSchedules("Mersey Care");
    }

    @Test
    public void StatementsOfAccountsErrorValidations() {
        StatementsOfAccounts statementsOfAccounts = new StatementsOfAccounts(webDriverHandler);
        statementsOfAccounts.accessStatementsOfAccounts();
        statementsOfAccounts.editSchedule("Mersey Care", "912");
        statementsOfAccounts.errorValidations();
    }

    @Test
    public void StatementsOfAccountsVerifyEdit() {
        StatementsOfAccounts statementsOfAccounts = new StatementsOfAccounts(webDriverHandler);
        statementsOfAccounts.accessStatementsOfAccounts();
        statementsOfAccounts.editSchedule("Mersey Care", "245");
        statementsOfAccounts.verifyEdit();
    }

    @Test
    public void StatementsOfAccountsEdit() {
        StatementsOfAccounts statementsOfAccounts = new StatementsOfAccounts(webDriverHandler);
        statementsOfAccounts.accessStatementsOfAccounts();
        statementsOfAccounts.editSchedule("Mersey Care", "912");
        statementsOfAccounts.changeAssignment("Me");
        statementsOfAccounts.addComment("Comment for Statement Of Accounts");
        statementsOfAccounts.downloadScanned();
        statementsOfAccounts.setAction("Mark As In-Use");
    }

    @Test
    public void StatementsOfAccountsMeta() {
        StatementsOfAccounts statementsOfAccounts = new StatementsOfAccounts(webDriverHandler);
        statementsOfAccounts.accessStatementsOfAccounts();
        statementsOfAccounts.editSchedule("Mersey Care", "51");
        statementsOfAccounts.verifyMetaData();
        statementsOfAccounts.editMetaData("INVOICE", "", "", "", "", "", "", "Water");
    }

    @Test
    public void StatementsOfAccountsBulkAction() {
        StatementsOfAccounts statementsOfAccounts = new StatementsOfAccounts(webDriverHandler);
        statementsOfAccounts.accessStatementsOfAccounts();
        statementsOfAccounts.filterStatementsOfAccounts("Customer", "Mersey Care");
        statementsOfAccounts.setBulkAction("IP Dev 2");
    }
}
