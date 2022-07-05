package com.QueryManagement.Settings;

import com.Base.SeleniumHandlers.WebDriverHandler;
import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR058_TC08_Verify_CompanyConfiguration extends AbstractTestNg {

    public PR058_TC08_Verify_CompanyConfiguration() throws IOException {
    }
//PAss
    @Test
    public void AccessCompanyConfiguration() {
        CompanyConfiguration companyConfiguration = new CompanyConfiguration(webDriverHandler);
       // companyConfiguration.accessSettings();
        companyConfiguration.accessCompanyConfiguration();
        companyConfiguration.columnVerification();
    }
//not done
    @Test
    public void VerifyCompanyPage() {
        CompanyConfiguration companyConfiguration = new CompanyConfiguration(webDriverHandler);
      //  companyConfiguration.accessSettings();
        companyConfiguration.accessCompanyConfiguration();
        companyConfiguration.selectEditEntry("Engie");
        companyConfiguration.verifyCompanyPage();
        companyConfiguration.columnVerificationDocument();
        companyConfiguration.columnVerificationContact();
        companyConfiguration.columnVerificationAssignment();
    }
//not done
    @Test
    public void AddDocuments() {
        CompanyConfiguration companyConfiguration = new CompanyConfiguration(webDriverHandler);
       // companyConfiguration.accessSettings();
        companyConfiguration.accessCompanyConfiguration();
        companyConfiguration.selectEditEntry("Engie");
        String path = Paths.get("PricecastTestData\\SupplierUplifts.docx").toAbsolutePath().toString();
        String[] accept = {"Faulty Meter",  "KT New Subcat", "Performance Major"};
        String[] send = {"Account Query",  "Meter Reading", "MOP Visit"};
        companyConfiguration.addDocument("Automation Test", "KT Session", path, accept, send);
        companyConfiguration.downloadDoc("Automation Test");
        companyConfiguration.deleteDoc("Automation Test");
    }
//not done
    @Test
    public void EditDocuments() {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        CompanyConfiguration companyConfiguration = new CompanyConfiguration(webDriverHandler);
        companyConfiguration.accessSettings();
        companyConfiguration.accessCompanyConfiguration();
        companyConfiguration.selectEditEntry("Engie");
        String path = Paths.get("PricecastTestData\\SupplierUplifts.docx").toAbsolutePath().toString();
        String[] accept = {"Faulty Meter",  "KT New Subcat", "Performance Major"};
        String[] send = {"Account Query",  "Meter Reading", "MOP Visit"};
        companyConfiguration.editDocument("For Edit", "After Edit", "LOA", accept, send);
        companyConfiguration.editDocument("After Edit", "For Edit", "KT Session", accept, send);
    }
//not done
    @Test
    public void AddContacts() {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        CompanyConfiguration companyConfiguration = new CompanyConfiguration(webDriverHandler);
     //   companyConfiguration.accessSettings();
        companyConfiguration.accessCompanyConfiguration();
        companyConfiguration.selectEditEntry("Engie");
        String[] attach = {"Faulty Meter",  "KT New Subcat", "Performance Major"};
        String[] send = {"Account Query",  "Meter Reading", "MOP Visit"};
        companyConfiguration.addContact("rahul.dash@cloudenergysoftware.com", "Me","1234567890", "Administrator", attach, send);
        companyConfiguration.deleteContact("rahul.dash@cloudenergysoftware.com");
    }
//not done
    @Test
    public void EditContacts() {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        CompanyConfiguration companyConfiguration = new CompanyConfiguration(webDriverHandler);
        companyConfiguration.accessSettings();
        companyConfiguration.accessCompanyConfiguration();
        companyConfiguration.selectEditEntry("Engie");
        String[] attach = {"Faulty Meter",  "KT New Subcat", "Performance Major"};
        String[] send = {"Account Query",  "Meter Reading", "MOP Visit"};
        companyConfiguration.editContact("fake.id@cloudenergysoftware.com", attach, send);
    }
//not done
    @Test
    public void AddEditAssignment() {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        CompanyConfiguration companyConfiguration = new CompanyConfiguration(webDriverHandler);
        companyConfiguration.accessSettings();
        companyConfiguration.accessCompanyConfiguration();
        companyConfiguration.selectEditEntry("Engie");
        String[] subCat = {"Account Query",  "KT New Subcat", "Payment Required"};
        companyConfiguration.addAssignment("User", "Rahul Dash", subCat);
        companyConfiguration.editAssignment("Rahul Dash", "User", "IP DEV TP2", subCat);
        companyConfiguration.editAssignment("IP DEV TP2", "Account Contact", "Test Manager", subCat);
        companyConfiguration.deleteAssignment("Test Manager");
    }
//not done
    @Test
    public void ErrorValidations() {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        CompanyConfiguration companyConfiguration = new CompanyConfiguration(webDriverHandler);
        companyConfiguration.accessSettings();
        companyConfiguration.accessCompanyConfiguration();
        companyConfiguration.selectEditEntry("Engie");
        companyConfiguration.errorValidation();
    }
}