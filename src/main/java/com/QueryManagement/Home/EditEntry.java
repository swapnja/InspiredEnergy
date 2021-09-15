package com.QueryManagement.Home;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class EditEntry {

    WebDriverHandler _webDriverHandler;
    ElementHandler btnCreateNew;
    ElementHandler tbFilterID;
    ElementHandler tbFilterUtility;
    ElementHandler tbFilterSubcategory;
    ElementHandler tbFilterNextAction;
    ElementHandler tbFilterDueDate;
    ElementHandler tbFilterStatus;
    ElementHandler tbFilterCWO;
    ElementHandler tbFilterOwner;
    ElementHandler btnEditEntry;
    ElementHandler btnActionEntry;
    ElementHandler ddQuerySource;
    ElementHandler tbEstimated;
    ElementHandler msgEstimated;
    ElementHandler tbActual;
    ElementHandler msgActual;
    ElementHandler tbAnnualised;
    ElementHandler msgAnnualised;
    ElementHandler btnAddNote;
    ElementHandler tbNote;
    ElementHandler ddCurrentlyWaitingOn;
    ElementHandler btnAddAction;
    ElementHandler ddAction;
    ElementHandler msgAction;
    ElementHandler tbActionNote;
    ElementHandler btnUpload;
    ElementHandler tglAnotherAction;
    ElementHandler tglAnotherActionCheck;
    ElementHandler btnCreate;
    ElementHandler btnCancel;
    ElementHandler btnSave;
    ElementHandler btnExit;
    ElementHandler btnYesExit;
    ElementHandler btnSaveExit;
    ElementHandler btnCancelExit;
    ElementHandler btnOk;
    ElementHandler btnYes;

    ElementHandler btnDocument;
    ElementHandler tglExisting;
    ElementHandler tglExistingCheck;
    ElementHandler tbDocumentRef;
    ElementHandler ddDocumentType;
    ElementHandler uploadDocument;
    ElementHandler ddDocumentSelect;
    ElementHandler tglCustomerView;
    ElementHandler tglCustomerViewCheck;
    ElementHandler tglSupplierView;
    ElementHandler tglSupplierViewCheck;
    ElementHandler tglAttachOnUpdate;
    ElementHandler tglAttachOnUpdateCheck;
    ElementHandler btnConfirmDoc;
    ElementHandler btnCancelDoc;
    ElementHandler msgDocRef;
    ElementHandler msgDocType;
    ElementHandler msgUploadDoc;
    ElementHandler msgDocSelect;

    ElementHandler btnContact;
    ElementHandler ddContactType;
    ElementHandler tbContactName;
    ElementHandler tbEmail;
    ElementHandler tbNumber;
    ElementHandler tbContactNote;
    ElementHandler ddContactSelect;
    ElementHandler btnConfirmCon;
    ElementHandler btnCancelCon;
    ElementHandler msgConName;
    ElementHandler msgConType;
    ElementHandler msgEmail;
    ElementHandler msgNumber;

    public EditEntry(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        btnCreateNew = _webDriverHandler.byXpath("//button[text()= ' Create New']");
        tbFilterID = _webDriverHandler.byXpath("//*[@id = 'filterId']");
        tbFilterUtility = _webDriverHandler.byXpath("//*[@id = 'filterUtility']");
        tbFilterSubcategory = _webDriverHandler.byXpath("//*[@id = 'filterSubCategory']");
        tbFilterNextAction = _webDriverHandler.byXpath("//*[@id = 'filterNext']");
        tbFilterDueDate = _webDriverHandler.byXpath("//*[@id = filterDue");
        tbFilterStatus = _webDriverHandler.byXpath("//*[@id = 'filterStatus']");
        tbFilterCWO = _webDriverHandler.byXpath("//*[@id = 'filterCurrently']");
        tbFilterOwner = _webDriverHandler.byXpath("//*[@id = 'filterOwner']");
        btnEditEntry = _webDriverHandler.byXpath("//button[@title='Edit']");
        btnActionEntry = _webDriverHandler.byXpath("//button[@title='Quick Action']");
        ddQuerySource = _webDriverHandler.byXpath("//*[@id = 'QuerySource']");
        tbEstimated = _webDriverHandler.byXpath("//*[@id = 'EstimatedSaving']");
        msgEstimated = _webDriverHandler.byXpath("//*[@id = 'EstimatedSaving-error']");
        tbActual = _webDriverHandler.byXpath("//*[@id = 'ActualSaving']");
        msgActual = _webDriverHandler.byXpath("//*[@id = 'ActualSaving-error']");
        tbAnnualised = _webDriverHandler.byXpath("//*[@id = 'AnnualisedSaving']");
        msgAnnualised = _webDriverHandler.byXpath("//*[@id = 'AnnualisedSaving-error']");
        btnAddNote = _webDriverHandler.byXpath("//button[@onclick = 'ShowQueryTaskAddNoteForm()']");
        tbNote = _webDriverHandler.byXpath("//*[@id='AddNoteAction']");
        ddCurrentlyWaitingOn = _webDriverHandler.byXpath("//*[@id = 'AddNoteAwaitingOn']");
        btnAddAction = _webDriverHandler.byXpath("//button[@onclick = 'ShowQueryTaskActionForm()']");
        ddAction = _webDriverHandler.byXpath("//*[@id = 'QueryActionTypeId']");
        msgAction = _webDriverHandler.byXpath("//*[@id = 'QueryActionTypeId-error']");
        tbActionNote = _webDriverHandler.byXpath("//*[@id = 'ActionNote']");
        btnUpload = _webDriverHandler.byXpath("//*[@id = 'ActionFiles']");
        tglAnotherAction = _webDriverHandler.byXpath("//label[input[@id = 'AddAnother']]");
        tglAnotherActionCheck = _webDriverHandler.byXpath("//label[input[@id = 'AddAnother']]//input");
        btnCreate = _webDriverHandler.byXpath("//*[text() = '  Create']");
        btnCancel = _webDriverHandler.byXpath("//*[text() = 'Cancel']");
        btnSave = _webDriverHandler.byXpath("//*[text() = '  Save']");
        btnExit = _webDriverHandler.byXpath("//*[text() = 'Exit']");
        btnYesExit = _webDriverHandler.byXpath("//input[@value = 'Yes - Exit']");
        btnSaveExit = _webDriverHandler.byXpath("//input[@value = 'Save and Exit']");
        btnCancelExit = _webDriverHandler.byXpath("//input[@value = 'Cancel']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");

        btnDocument = _webDriverHandler.byXpath("//button[contains(text(),'Document')]");
        tglExisting = _webDriverHandler.byXpath("//label[input[@name='AddExisting']]");
        tglExistingCheck = _webDriverHandler.byXpath("//label[input[@name='AddExisting']]//input");
        tbDocumentRef = _webDriverHandler.byXpath("//*[@id = 'DocumentName']");
        ddDocumentType = _webDriverHandler.byXpath("//*[@id = 'DocumentTypeId']");
        ddDocumentSelect = _webDriverHandler.byXpath("//*[@id = 'DocumentId']");
        uploadDocument = _webDriverHandler.byXpath("//*[@id = 'File']");
        tglCustomerView = _webDriverHandler.byXpath("//label[input[@name='ClientView']]");
        tglCustomerViewCheck = _webDriverHandler.byXpath("//label[input[@name='ClientView']]//input");
        tglSupplierView = _webDriverHandler.byXpath("//label[input[@name='SupplierView']]");
        tglSupplierViewCheck = _webDriverHandler.byXpath("//label[input[@name='SupplierView']]//input");
        tglAttachOnUpdate = _webDriverHandler.byXpath("//label[input[@name='AttachOnUpdate']]");
        tglAttachOnUpdateCheck = _webDriverHandler.byXpath("//label[input[@name='AttachOnUpdate']]//input");
        btnConfirmDoc = _webDriverHandler.byXpath("//form[@id = 'TaskDocumentForm']//*[text() = '  Confirm']");
        btnCancelDoc = _webDriverHandler.byXpath("//form[@id = 'TaskDocumentForm']//*[text() = 'Cancel']");
        msgDocRef = _webDriverHandler.byXpath("//*[@id = 'DocumentName-error']");
        msgDocType = _webDriverHandler.byXpath("//*[@id = 'DocumentTypeId-error']");
        msgUploadDoc = _webDriverHandler.byXpath("//*[@id = 'File-error']");
        msgDocSelect = _webDriverHandler.byXpath("//*[@id = 'DocumentId-error']");

        btnContact = _webDriverHandler.byXpath("//button[contains(text(),'Contact')]");
        ddContactType = _webDriverHandler.byXpath("//*[@id = 'ContactTypeId']");
        tbContactName = _webDriverHandler.byXpath("//*[@id = 'ContactName']");
        tbEmail = _webDriverHandler.byXpath("//*[@id = 'ContactEmail']");
        tbNumber = _webDriverHandler.byXpath("//*[@id = 'ContactPhone']");
        tbContactNote = _webDriverHandler.byXpath("//*[@id = 'ContactNote']");
        ddContactSelect = _webDriverHandler.byXpath("//*[@id = 'ContactId']");
        btnConfirmCon = _webDriverHandler.byXpath("//form[@id = 'TaskContactForm']//*[text() = '  Confirm']");
        btnCancelCon = _webDriverHandler.byXpath("//form[@id = 'TaskContactForm']//*[text() = 'Cancel']");
        msgConName = _webDriverHandler.byXpath("//*[@id = 'ContactTypeId-error']");
        msgConType = _webDriverHandler.byXpath("//*[@id = 'ContactName-error']");
        msgEmail = _webDriverHandler.byXpath("//*[@id = 'ContactEmail-error']");
        msgNumber = _webDriverHandler.byXpath("//*[@id = 'ContactPhone-error']");
    }

    String strErrorEstimated = "The field Estimated Saving: must be a number.";
    String strErrorActual = "The field Actual Saving: must be a number.";
    String strErrorAnnualised = "The field Annualised Saving: must be a number.";
    String strErrorAction = "The Action: field is required.";

    String strErrorDocName = "The Document Reference: field is mandatory";
    String strErrorDocType = "The Document Type: field is mandatory";
    String strErrorUploadDoc = "The Upload Document: field is mandatory";
    String strErrorDocSelect = "The Select Document: field is mandatory";

    String strErrorConName = "The Select Contact Type: field is mandatory";
    String strErrorConType = "The Contact Name: field is mandatory";
    String strErrorEmail = "The Contact Email: field is mandatory";
    String strErrorNumber = "The Contact Number: field is mandatory";

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

    public void editBaseData(String querySource, String estimated, String actual, String annualised) {
        ddQuerySource.waitClickable().selectByText(querySource);
        tbEstimated.waitClickable().clear().sendKeys(estimated);
        tbActual.waitClickable().clear().sendKeys(actual);
        tbAnnualised.waitClickable().clear().sendKeys(annualised);
        btnSave.waitClickable().click();
    }

    public void exitValidation(String exitType, String estimated, String actual, String annualised) {
        String actualEstimated = tbEstimated.getAttribute("value");
        String actualActual = tbActual.getAttribute("value");
        String actualAnnual = tbAnnualised.getAttribute("value");
        String actualSummary =  _webDriverHandler.byXpath("//*[@id='Summary']").getText();
        String actualEnterTextArea =  _webDriverHandler.byXpath("//*[contains(@id, 'EnterTextArea')]").getText();
        tbEstimated.waitClickable().clear().sendKeys(estimated);
        tbActual.waitClickable().clear().sendKeys(actual);
        tbAnnualised.waitClickable().clear().sendKeys(annualised);
        btnExit.waitClickable().click();
        switch(exitType){
            case "Yes":
                btnYesExit.waitClickable().click();
                waitLoad();
                selectEntry(472);
                Assert.assertEquals(actualEstimated, tbEstimated.getAttribute("value"));
                Assert.assertEquals(actualActual, tbActual.getAttribute("value"));
                Assert.assertEquals(actualAnnual, tbAnnualised.getAttribute("value"));
                Assert.assertEquals(actualSummary, _webDriverHandler.byXpath("//*[@id='Summary']").getText());
                Assert.assertEquals(actualEnterTextArea, _webDriverHandler.byXpath("//*[contains(@id, 'EnterTextArea')]").getText());
                break;
            case "Save":
                btnSaveExit.waitClickable().click();
                btnOk.waitClickable().click();
                waitLoad();
                selectEntry(472);
                Assert.assertEquals(estimated, tbEstimated.getAttribute("value"));
                Assert.assertEquals(actual, tbActual.getAttribute("value"));
                Assert.assertEquals(annualised, tbAnnualised.getAttribute("value"));
                break;
            case "Cancel":
                btnCancelExit.waitClickable().click();
                try{
                    waitLoad();
                    Assert.fail("There should not be a loader on Cancel.");
                }catch (Exception e){}
                break;
            default:
                Assert.fail("Proper Exit type is not given.");
        }
    }

    public void addNote(String note, String CWO) {
        btnAddNote.waitClickable().click();
        waitLoad();
        tbNote.waitClickable().sendKeys(note);
        ddCurrentlyWaitingOn.waitClickable().selectByText(CWO);
        btnCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void editNote(String note, boolean SW, boolean CW, boolean del) {
        if (!SW) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + note + "')]]//label[input[contains(@class, 'supplier')]]").waitClickable().click();
            waitLoad();
        }
        if (!CW) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + note + "')]]//label[input[contains(@class, 'customer')]]").waitClickable().click();
            waitLoad();
        }
        if (del) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + note + "')]]//button[@title='']").waitClickable().click();
            btnYes.waitClickable().click();
        }
    }

    public void addAction(String action, String actionNote, String path, boolean anotherAction) {
        try{
            btnAddAction.waitClickable().click();
            waitLoad();
        }
        catch(Exception e){
        }
        ddAction.waitClickable().selectByText(action);
        tbActionNote.waitClickable().clear().sendKeys(actionNote);
        btnUpload.waitClickable().sendKeys(path);
        if (anotherAction) {
            tglAnotherAction.waitClickable().click();
        }
        btnCreate.waitClickable().click();
        btnYes.waitClickable().click();
        waitLoad();
        btnOk.waitClickable().click();
        waitLoad();
        if (anotherAction) {
            addAction("Resolve for Customer", "The Note to put inside the Action Note again.", path, false);
        }
    }

    public void editAction(String actionNote, boolean DL, boolean SW, boolean CW, boolean del) {
        btnAddAction.waitClickable().sendKeys(Keys.PAGE_DOWN);
        if (!SW) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + actionNote + "')]]//label[input[contains(@class, 'supplier')]]").waitClickable().click();
            waitLoad();
        }
        if (!CW) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + actionNote + "')]]//label[input[contains(@class, 'customer')]]").waitClickable().click();
            waitLoad();
        }
        if (DL) {
            try{
                _webDriverHandler.byXpath("//tr[td[contains(text(), '" + actionNote + "')]]//button[1]").waitClickable().click();
            }
            catch (Exception e){
                System.out.println("No attachment available.");
            }
        }
        if (del) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + actionNote + "')]]//button[@title='']").waitClickable().click();
            btnYes.waitClickable().click();
        }
    }

    public void errorValidation() {
        tbEstimated.waitClickable().clear().sendKeys("estimated");
        tbActual.waitClickable().clear().sendKeys("actual");
        tbAnnualised.waitClickable().clear().sendKeys("annualised");
        tbActual.waitClickable().click();
        Assert.assertEquals(msgEstimated.getText(), strErrorEstimated, "Estimated Saving validation is wrong.");
        Assert.assertEquals(msgActual.getText(), strErrorActual, "Actual Saving validation is wrong.");
        Assert.assertEquals(msgAnnualised.getText(), strErrorAnnualised, "Annualised Saving validation is wrong.");
        btnAddAction.waitClickable().click();
        btnCreate.waitClickable().click();
        Assert.assertEquals(msgAction.getText(), strErrorAction, "Annualised Saving validation is wrong.");
        //Work Left
    }

    public void scrollToDocument() {
//        try {
//            btnCreateFrom.waitClickable().click();
//            btnCancelDoc.waitClickable().click();
//        }
//        catch (Exception e) {
//            btnCreateFrom.waitClickable().sendKeys(Keys.PAGE_DOWN);
//        }
        do {
            btnDocument.waitClickable().sendKeys(Keys.PAGE_DOWN);
        } while (_webDriverHandler.byXpath("//*[@id = 'tblTaskDocument_paginate']").notPresent());
    }

    public void newDocument(String docRef, String docType, String path, boolean CV, boolean SV, boolean AOU) {
        btnDocument.waitClickable().click();
        waitLoad();
         if (tglExistingCheck.isSelected()) {
                tglExisting.waitClickable().click();
         }
        tbDocumentRef.waitClickable().sendKeys(docRef);
        ddDocumentType.waitClickable().selectByText(docType);
        uploadDocument.waitClickable().sendKeys(path);
        if (CV) {
            if (!tglCustomerViewCheck.isSelected()) {
                tglCustomerView.waitClickable().click();
            }
        } else {
            if (tglCustomerViewCheck.isSelected()) {
                tglCustomerView.waitClickable().click();
            }
        }
        if (SV) {
            if (!tglSupplierViewCheck.isSelected()) {
                tglSupplierView.waitClickable().click();
            }
        } else {
            if (tglSupplierViewCheck.isSelected()) {
                tglSupplierView.waitClickable().click();
            }
        }
        if (AOU) {
            if (!tglAttachOnUpdateCheck.isSelected()) {
                tglAttachOnUpdate.waitClickable().click();
            }
        } else {
            if (tglAttachOnUpdateCheck.isSelected()) {
                tglAttachOnUpdate.waitClickable().click();
            }
        }
        btnConfirmDoc.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void existingDocument(String docSelect, boolean CV, boolean SV, boolean AOU) {
        btnDocument.waitClickable().click();
        waitLoad();
        if (!tglExistingCheck.isSelected()) {
            tglExisting.waitClickable().click();
        }
        ddDocumentSelect.waitClickable().selectByText(docSelect);
        if (CV) {
            if (!tglCustomerViewCheck.isSelected()) {
                tglCustomerView.waitClickable().click();
            }
        } else {
            if (tglCustomerViewCheck.isSelected()) {
                tglCustomerView.waitClickable().click();
            }
        }
        if (SV) {
            if (!tglSupplierViewCheck.isSelected()) {
                tglSupplierView.waitClickable().click();
            }
        } else {
            if (tglSupplierViewCheck.isSelected()) {
                tglSupplierView.waitClickable().click();
            }
        }
        if (AOU) {
            if (!tglAttachOnUpdateCheck.isSelected()) {
                tglAttachOnUpdate.waitClickable().click();
            }
        } else {
            if (tglAttachOnUpdateCheck.isSelected()) {
                tglAttachOnUpdate.waitClickable().click();
            }
        }
        btnConfirmDoc.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void accessDocument(String document, String action) {
        if (action.equals("Delete")) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + document + "')]]//button[2]").waitClickable().click();
            btnYes.waitClickable().click();
            waitLoad();
        }
        else {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + document + "')]]//button[1]").waitClickable().click();
        }
    }

    public void scrollToContact() {
//        try {
//            btnContact.waitClickable().click();
//            btnCancelCon.waitClickable().click();
//        }
//        catch (Exception e) {
//            btnContact.waitClickable().sendKeys(Keys.PAGE_DOWN);
//        }
        do {
            btnContact.waitClickable().sendKeys(Keys.PAGE_DOWN);
        } while (_webDriverHandler.byXpath("//*[@id = 'tblTaskContact_paginate']").notPresent());
    }

    public void newContact(String conName, String conType, String email, String number, String note) {
        btnContact.waitClickable().click();
        waitLoad();
        if (tglExistingCheck.isSelected()) {
            tglExisting.waitClickable().click();
        }
        ddContactType.waitClickable().selectByText(conType);
        tbContactName.waitClickable().sendKeys(conName);
        tbEmail.waitClickable().sendKeys(email);
        tbNumber.waitClickable().sendKeys(number);
        tbContactNote.waitClickable().sendKeys(note);
        btnConfirmCon.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void existingContact(String conSelect, String note) {
        btnContact.waitClickable().click();
        waitLoad();
        if (!tglExistingCheck.isSelected()) {
            tglExisting.waitClickable().click();
        }
        ddContactSelect.waitClickable().selectByText(conSelect);
        tbContactNote.waitClickable().sendKeys(note);;
        btnConfirmCon.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void accessContact(String email, String action) {
        if (action.equals("Delete")) {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + email + "')]]//button[@title = '']").waitClickable().click();
            btnYes.waitClickable().click();
            waitLoad();
        }
        else {
            _webDriverHandler.byXpath("//tr[td[contains(text(), '" + email + "')]]//label[input[@type = 'checkbox']]").waitClickable().click();
            waitLoad();
        }
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}