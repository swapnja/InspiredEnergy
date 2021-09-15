package com.QueryManagement.Settings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;


public class CompanyConfiguration {
    WebDriverHandler _webDriverHandler;
    ElementHandler btnSettings;
    ElementHandler tabCompanyConfiguration;
    ElementHandler btnDocument;
    ElementHandler tbDocName;
    ElementHandler ddDocType;
    ElementHandler uploadDoc;
    ElementHandler btnDocCreate;
    ElementHandler btnDocCancel;
    ElementHandler btnDocSave;
    ElementHandler tbLastUpdated;
    ElementHandler tbUpdatedBy;
    ElementHandler msgDocName;
    ElementHandler msgDocType;
    ElementHandler msgUploadDoc;
    ElementHandler btnContact;
    ElementHandler tbConEmail;
    ElementHandler tbConName;
    ElementHandler tbConNumber;
    ElementHandler ddConType;
    ElementHandler btnConCreate;
    ElementHandler btnConCancel;
    ElementHandler btnConSave;
    ElementHandler msgEmail;
    ElementHandler msgConName;
    ElementHandler msgConNumber;
    ElementHandler msgConType;
    ElementHandler btnAssignment;
    ElementHandler ddAssignType;
    ElementHandler ddUser;
    ElementHandler ddContactType;
    ElementHandler btnAssignCreate;
    ElementHandler btnAssignCancel;
    ElementHandler btnAssignSave;
    ElementHandler msgAssignType;
    ElementHandler msgUser;
    ElementHandler msgContactType;
    ElementHandler btnOk;
    ElementHandler btnYes;

    public CompanyConfiguration(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        btnSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        tabCompanyConfiguration = _webDriverHandler.byXpath("//a[contains(text(), 'Company Configuration')]");
        btnDocument = _webDriverHandler.byXpath("//button[contains(text(), ' Document')]");
        tbDocName = _webDriverHandler.byXpath("//*[@id = 'Name']");
        ddDocType = _webDriverHandler.byXpath("//*[@id = 'documentFormType']");
        uploadDoc = _webDriverHandler.byXpath("//*[@id = 'documentFormFileId']");
        btnDocCreate = _webDriverHandler.byXpath("//form[@id = 'CompanyConfigDocumentFormId']//*[contains(text(), ' Create')]");
        btnDocCancel = _webDriverHandler.byXpath("//form[@id = 'CompanyConfigDocumentFormId']//*[contains(text(), 'Cancel')]");
        btnDocSave = _webDriverHandler.byXpath("//form[@id = 'CompanyConfigDocumentFormId']//*[contains(text(), ' Save')]");
        tbLastUpdated = _webDriverHandler.byXpath("//*[@id = 'LastUpdated']");
        tbUpdatedBy = _webDriverHandler.byXpath("//*[@id = 'UpdatedBy']");
        msgDocName = _webDriverHandler.byXpath("//*[@id = 'Name-error']");
        msgDocType = _webDriverHandler.byXpath("//*[@id = 'documentFormType-error']");
        msgUploadDoc = _webDriverHandler.byXpath("//*[@id = 'documentFormFileId-error']");
        btnContact = _webDriverHandler.byXpath("//button[contains(text(), ' Contact')]");
        tbConEmail = _webDriverHandler.byXpath("//*[@id = 'Email']");
        tbConName = _webDriverHandler.byXpath("//*[@id = 'ContactName']");
        tbConNumber = _webDriverHandler.byXpath("//*[@id = 'ContactNumber']");
        btnConCreate = _webDriverHandler.byXpath("//form[@id = 'CompanyConfigContactFormId']//*[contains(text(), ' Create')]");
        btnConCancel = _webDriverHandler.byXpath("//form[@id = 'CompanyConfigContactFormId']//*[contains(text(), 'Cancel')]");
        btnConSave = _webDriverHandler.byXpath("//form[@id = 'CompanyConfigContactFormId']//*[contains(text(), ' Save')]");
        ddConType = _webDriverHandler.byXpath("//*[@id = 'ContactTypeId']");
        msgEmail = _webDriverHandler.byXpath("//*[@id = 'Email-error']");
        msgConName = _webDriverHandler.byXpath("//*[@id = 'ContactName-error']");
        msgConNumber = _webDriverHandler.byXpath("//*[@id = 'ContactNumber-error']");
        msgConType = _webDriverHandler.byXpath("//*[@id = 'ContactTypeId-error']");
        btnAssignment = _webDriverHandler.byXpath("//button[contains(text(), ' Assignment')]");
        ddAssignType = _webDriverHandler.byXpath("//*[@id = 'AssignmentTypeId']");
        ddUser = _webDriverHandler.byXpath("//*[@id = 'UserId']");
        ddContactType = _webDriverHandler.byXpath("//*[@id = 'AccountManagerRoleId']");
        btnAssignCreate = _webDriverHandler.byXpath("//form[@id = 'CompanyConfigUserAssignmentFormId']//*[contains(text(), ' Create')]");
        btnAssignCancel = _webDriverHandler.byXpath("//form[@id = 'CompanyConfigUserAssignmentFormId']//*[contains(text(), 'Cancel')]");
        btnAssignSave = _webDriverHandler.byXpath("//form[@id = 'CompanyConfigUserAssignmentFormId']//*[contains(text(), ' Save')]");
        msgAssignType = _webDriverHandler.byXpath("//*[@id = 'AssignmentTypeId-error']");
        msgContactType = _webDriverHandler.byXpath("//*[@id = 'AccountManagerRoleId-error']");
        msgUser = _webDriverHandler.byXpath("//*[@id = 'UserId-error']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");
    }

    public String[] tblCompanyConfiguration = new String[]{"Company Type", "Company Name", "No. Contacts", "No. Documents", "Updated By", "Updated On", "Actions"};
    public String[] arrCompanyConfiguration = new String[7];

    String strErrorDocName = "The Document Name: field is required.";
    String strErrorDocType = "The Document Type: field is required.";
    String strErrorUploadDoc = "The Upload Document: field is required.";

    String strErrorEmail = "The Email Address: field is required.";
    String strErrorConName = "The Contact Name: field is required.";
    String strErrorConNumber = "The Contact Number: field is required.";
    String strErrorConType = "The Contact Type: field is required.";

    String strErrorAssignType = "The Assignment Type field is required.";
    String strErrorContactType = "The Contact Type: field is required.";
    String strErrorUser = "The User: field is required.";

    public void accessSettings() {
        waitLoad();
        do {
            btnSettings.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (tabCompanyConfiguration.notPresent());
    }

    public void accessCompanyConfiguration() {
        tabCompanyConfiguration.waitClickable().click();
        waitLoad();
    }

    public void selectEditEntry(String name) {
        while (_webDriverHandler.byXpath("//tr[td[contains(text(), '" + name + "')]]//button").notPresent()) {
            _webDriverHandler.byXpath("//a[contains(text(), 'Next')]").waitClickable().click();
            waitLoad();
        }
        _webDriverHandler.byXpath("//tr[td[contains(text(), '" + name + "')]]//button").waitClickable().click();
        waitLoad();
    }

    public void verifyCompanyPage() {
        if (!(btnDocument.isDisplayed() && btnContact.isDisplayed() && btnAssignment.isDisplayed() &&
                _webDriverHandler.byXpath("//li[@id = 'tblCompanyNameConfigDocument_next']//a").isDisplayed() &&
                _webDriverHandler.byXpath("//li[@id = 'tblCompanyNameConfigDocument_previous']//a").isDisplayed() &&
                _webDriverHandler.byXpath("//li[@id = 'tblCompanyNameConfigContact_next']//a").isDisplayed() &&
                _webDriverHandler.byXpath("//li[@id = 'tblCompanyNameConfigContact_previous']//a").isDisplayed() &&
                _webDriverHandler.byXpath("//li[@id = 'tblCompanyNameConfigContact_previous']//a").isDisplayed() &&
                _webDriverHandler.byXpath("//li[@id = 'tblCompanyNameConfigUserAssignment_previous']//a").isDisplayed() &&
                _webDriverHandler.byXpath("//li[@id = 'tblCompanyNameConfigUserAssignment_next']//a").isDisplayed() &&
                _webDriverHandler.byXpath("//*[@id = 'tblCompanyNameConfigDocument_length']").isDisplayed() &&
                _webDriverHandler.byXpath("//*[@id = 'tblCompanyNameConfigContact_length']").isDisplayed() &&
                _webDriverHandler.byXpath("//*[@id = 'tblCompanyNameConfigUserAssignment_length']").isDisplayed()
        )) {
            Assert.fail("Page not loaded properly.");
        }
    }

    public void addDocument(String name, String docType, String path, String[] attach, String[] send) {
        btnDocument.waitClickable().click();
        tbDocName.waitClickable().sendKeys(name);
        for (String a : attach) {
            _webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").click();
            _webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").sendKeys(Keys.HOME);
        }
        uploadDoc.sendKeys(path);
        ddDocType.waitClickable().selectByText(docType);
        for (String s : send) {
            _webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").click();
            _webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").sendKeys(Keys.HOME);
        }
        btnDocCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void deleteDoc(String name) {
        //_webDriverHandler.byXpath("//tr[td[text()='"+name+"']] [td[text()='"+date+"']]//button[@title='']").waitClickable().click();
        _webDriverHandler.byXpath("//tr[td[text()='" + name + "']]//button[@title='']").waitClickable().click();
        btnYes.waitClickable().click();
        waitLoad();
        btnOk.waitClickable().click();
    }

    public void downloadDoc(String name) {
        //_webDriverHandler.byXpath("//tr[td[text()='"+name+"']] [td[text()='"+date+"']]//button[@title='']").waitClickable().click();
        _webDriverHandler.byXpath("//tr[td[text()='" + name + "']]//button[@title='Download attached files']").waitClickable().click();
    }

    public void editDocument(String name, String newName, String docType, String[] attach, String[] send) {
        //_webDriverHandler.byXpath("//tr[td[text()='"+name+"']] [td[text()='"+date+"']]//button[@title='']").waitClickable().click();
        _webDriverHandler.byXpath("//tr[td[text()='" + name + "']]//button[@title='Edit']").waitClickable().click();
        waitLoad();
        if (!(tbLastUpdated.isDisplayed() && tbLastUpdated.getAttribute("readonly").equals("true") && tbUpdatedBy.isDisplayed() && tbUpdatedBy.getAttribute("disabled").equals("true"))) {
            Assert.fail("The last update section is not proper.");
        }
        tbDocName.waitClickable().clear().sendKeys(newName);
        for (String a : attach) {
            if (!_webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").isSelected()) {
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").click();
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").sendKeys(Keys.HOME);
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").sendKeys(Keys.HOME);
            }
        }
        ddDocType.waitClickable().selectByText(docType);
        for (String s : send) {
            if (!_webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").isSelected()) {
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").click();
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").sendKeys(Keys.HOME);
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigDocumentFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").sendKeys(Keys.HOME);
            }
        }
        btnDocSave.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void addContact(String email, String name, String number, String type, String[] attach, String[] send) {
        btnContact.waitClickable().click();
        //waitLoad();
        for (String a : attach) {
            _webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").click();
            _webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").sendKeys(Keys.HOME);
        }
        tbConEmail.waitClickable().sendKeys(email);
        tbConName.waitClickable().sendKeys(name);
        tbConNumber.waitClickable().sendKeys(number);
        ddConType.waitClickable().selectByText(type);
        for (String s : send) {
            _webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").click();
            _webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").sendKeys(Keys.HOME);
        }
        btnConCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void editContact(String email, String[] attach, String[] send) {
        //_webDriverHandler.byXpath("//tr[td[text()='"+name+"']] [td[text()='"+date+"']]//button[@title='']").waitClickable().click();
        _webDriverHandler.byXpath("//tr[td[text()='" + email + "']]//button[@title='Edit']").waitClickable().click();
        waitLoad();
        for (String a : attach) {
            if (_webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").isSelected()) {
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").click();
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").sendKeys(Keys.HOME);
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").sendKeys(Keys.HOME);
            }
        }
        if (!(tbLastUpdated.isDisplayed() && tbLastUpdated.getAttribute("readonly").equals("true") && tbUpdatedBy.isDisplayed() && tbUpdatedBy.getAttribute("disabled").equals("true") &&
                tbConEmail.isDisplayed() && tbConEmail.getAttribute("disabled").equals("true") && tbConName.isDisplayed() && tbConName.getAttribute("disabled").equals("true") &&
                tbConNumber.isDisplayed() && tbConNumber.getAttribute("disabled").equals("true") && ddConType.isDisplayed() && ddConType.getAttribute("disabled").equals("true"))) {
            Assert.fail("The last update section is not proper.");
        }
        for (String s : send) {
            if (_webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").isSelected()) {
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").click();
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").sendKeys(Keys.HOME);
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigContactFormId']//tr[td//span[text() = ' " + s + " ']]//td[4]//input").sendKeys(Keys.HOME);
            }
        }
        btnConSave.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void deleteContact(String email) {
        //_webDriverHandler.byXpath("//tr[td[text()='"+name+"']] [td[text()='"+date+"']]//button[@title='']").waitClickable().click();
        _webDriverHandler.byXpath("//tr[td[text()='" + email + "']]//button[@title='']").waitClickable().click();
        btnYes.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void addAssignment(String type, String UserType, String[] subCat) {
        btnAssignment.waitClickable().click();
        ddAssignType.waitClickable().selectByText(type);
        if (type.equals("User")){
            ddUser.waitClickable().selectByText(UserType);
        }
        else if (type.equals("Account Contact")) {
            ddContactType.waitClickable().selectByText(UserType);
        }
        else {
            Assert.fail("Proper Assignment Type is required.");
        }
        for (String a : subCat) {
            _webDriverHandler.byXpath("//*[@id = 'CompanyConfigUserAssignmentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//label").waitVisible().waitClickable().click();
            _webDriverHandler.byXpath("//*[@id = 'CompanyConfigUserAssignmentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//label").sendKeys(Keys.HOME);
            _webDriverHandler.byXpath("//*[@id = 'CompanyConfigUserAssignmentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//label").sendKeys(Keys.HOME);
        }
        btnAssignCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void editAssignment(String UserType, String type, String newUserType, String[] subCat) {
        //_webDriverHandler.byXpath("//tr[td[text()='"+name+"']] [td[text()='"+date+"']]//button[@title='']").waitClickable().click();
        _webDriverHandler.byXpath("//tr[td[text()='" + UserType + "']]//button[@title='Edit']").waitClickable().click();
        waitLoad();
        ddAssignType.waitClickable().selectByText(type);
        if (type.equals("User")){
            ddUser.waitClickable().selectByText(newUserType);
        }
        else if (type.equals("Account Contact")) {
            ddContactType.waitClickable().selectByText(newUserType);
        }
        else {
            Assert.fail("Proper Assignment Type is required.");
        }
        for (String a : subCat) {
            if (!_webDriverHandler.byXpath("//*[@id = 'CompanyConfigUserAssignmentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//input").isSelected()) {
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigUserAssignmentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//label").click();
                _webDriverHandler.byXpath("//*[@id = 'CompanyConfigUserAssignmentFormId']//tr[td//span[text() = ' " + a + " ']]//td[3]//label").sendKeys(Keys.HOME);
            }
        }
        btnAssignSave.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void deleteAssignment(String UserType) {
        //_webDriverHandler.byXpath("//tr[td[text()='"+name+"']] [td[text()='"+date+"']]//button[@title='']").waitClickable().click();
        _webDriverHandler.byXpath("//tr[td[text()='" + UserType + "']]//button[@title='']").waitClickable().click();
        btnYes.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void columnVerification() {
        for (int i = 0; i < arrCompanyConfiguration.length; i++) {
            arrCompanyConfiguration[i] = _webDriverHandler.byXpath("//table[@id='tblCompanyNameConfig']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblCompanyConfiguration[i].equals(arrCompanyConfiguration[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationDocument() {
        String[] tblDocument = new String[]{"Added Date", "Added By", "Document Name", "Document Type", "Last Updated", "Updated By", "Actions"};
        String[] arrDocument = new String[7];
        for (int i = 0; i < arrDocument.length; i++) {
            arrDocument[i] = _webDriverHandler.byXpath("//table[@id='tblCompanyNameConfigDocument']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblDocument[i].equals(arrDocument[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationContact() {
        String[] tblContact = new String[]{"Date Added", "Added By", "Contact Email", "Contact Number", "Contact Type", "Contact Name", "Actions"};
        String[] arrContact = new String[7];
        for (int i = 0; i < arrContact.length; i++) {
            arrContact[i] = _webDriverHandler.byXpath("//table[@id='tblCompanyNameConfigContact']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblContact[i].equals(arrContact[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void columnVerificationAssignment() {
        String[] tblAssignment = new String[]{"Date Added", "Added By", "User/Contact Type", "Sub-Category", "Actions"};
        String[] arrAssignment = new String[5];
        for (int i = 0; i < arrAssignment.length; i++) {
            arrAssignment[i] = _webDriverHandler.byXpath("//table[@id='tblCompanyNameConfigUserAssignment']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblAssignment[i].equals(arrAssignment[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void errorValidation() {
        btnDocument.waitClickable().click();
        btnDocCreate.waitClickable().click();
        Assert.assertEquals(msgDocName.getText(), strErrorDocName);
        Assert.assertEquals(msgDocType.getText(), strErrorDocType);
        Assert.assertEquals(msgUploadDoc.getText(), strErrorUploadDoc);
        btnDocCancel.waitClickable().click();

        btnContact.waitClickable().click();
        btnConCreate.waitClickable().click();
        Assert.assertEquals(msgEmail.getText(), strErrorEmail);
        Assert.assertEquals(msgConName.getText(), strErrorConName);
        Assert.assertEquals(msgConNumber.getText(), strErrorConNumber);
        Assert.assertEquals(msgConType.getText(), strErrorConType);
        btnConCancel.waitClickable().click();

        btnAssignment.waitClickable().click();
        _webDriverHandler.byXpath("//*[@id = 'CompanyConfigUserAssignmentFormId']//tr[td//span[text() = ' Account Query ']]//td[3]//label").click();
        btnAssignCreate.waitClickable().click();
        Assert.assertEquals(msgAssignType.getText(), strErrorAssignType);
        ddAssignType.waitClickable().selectByText("User");
        btnAssignCreate.waitClickable().click();
        Assert.assertEquals(msgUser.getText(), strErrorUser);
        ddAssignType.waitClickable().selectByText("Account Contact");
        btnAssignCreate.waitClickable().click();
        Assert.assertEquals(msgContactType.getText(), strErrorContactType);
        btnAssignCancel.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
