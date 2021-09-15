package com.QueryManagement.Home;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;


public class BulkAction {

    WebDriverHandler _webDriverHandler;
    ElementHandler ddBulkProcess;
    ElementHandler ddAction;
    ElementHandler tbActionNote;
    ElementHandler ddCurrentlyWaitingOn;
    ElementHandler tbNextActionDate;
    ElementHandler uploadFile;
    ElementHandler ddOwner;
    ElementHandler btnConfirmBulkAssign;
    ElementHandler btnCancelBulkAssign;
    ElementHandler btnImport;
    ElementHandler btnCreateImport;
    ElementHandler btnDownloadTemplateCreateImport;
    ElementHandler btnImportCreateImport;
    ElementHandler btnCancelCreateImport;
    ElementHandler btnUpdateImport;
    ElementHandler btnDownloadTemplateUpdate;
    ElementHandler btnImportUpdate;
    ElementHandler btnCancelActionUpdate;
    ElementHandler btnActionImport;
    ElementHandler btnDownloadTemplateImportUpdate;
    ElementHandler btnImportImportUpdate;
    ElementHandler btnCancelImportUpdate;
    ElementHandler btnExport;
    ElementHandler tbImportReference;
    ElementHandler tbNotes;
    ElementHandler uploadExcel;
    ElementHandler btnCreateBulkAction;
    ElementHandler btnCancelBulkAction;
    ElementHandler tbFilterID;
    ElementHandler btnOk;

    public BulkAction(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        ddBulkProcess = _webDriverHandler.byXpath("//*[@id = 'ddlBulkActions']");
        ddAction = _webDriverHandler.byXpath("//*[@id = 'QueryActionTypeId']");
        tbActionNote = _webDriverHandler.byXpath("//*[@id = 'ActionNote']");
        ddCurrentlyWaitingOn = _webDriverHandler.byXpath("//*[@id = 'AwaitingOnAction']");
        tbNextActionDate = _webDriverHandler.byXpath("//*[@id = 'NextActionDateOnAction']");
        uploadFile = _webDriverHandler.byXpath("//*[@id = 'ActionFiles']");
        ddOwner = _webDriverHandler.byXpath("//*[@id = 'OwnerId']");
        btnConfirmBulkAssign = _webDriverHandler.byXpath("//*[@id = 'btnTaskBulkAssignSave']");
        btnCancelBulkAssign = _webDriverHandler.byXpath("//*[@id='TaskBulkAssignForm']//button[contains(text(), 'Cancel')]");
        btnImport  = _webDriverHandler.byXpath("//button//i[@class='fa fa-upload']");
        btnCreateImport = _webDriverHandler.byXpath("//a[text() = 'Create Import']");
        btnDownloadTemplateCreateImport = _webDriverHandler.byXpath("//*[@id = 'QueryListBulkDownloadTemplateBtnId']");
        btnImportCreateImport = _webDriverHandler.byXpath("//*[@id = 'BulkImportCreateForm']//button[contains(text(), 'Import')]");
        btnCancelCreateImport = _webDriverHandler.byXpath("//*[@id='BulkImportCreateForm']//button[contains(text(), 'Cancel')]");
        btnUpdateImport = _webDriverHandler.byXpath("//a[text() = 'Update Import']");
        btnDownloadTemplateUpdate = _webDriverHandler.byXpath("//*[@id = 'QueryListBulkUpdateTemplate']");
        btnImportUpdate = _webDriverHandler.byXpath("//*[@id = 'BulkImportUpdateForm']//button[contains(text(), 'Import')]");
        btnCancelActionUpdate = _webDriverHandler.byXpath("//*[@id='BulkActionImportForm']//button[contains(text(), 'Cancel')]");
        btnActionImport = _webDriverHandler.byXpath("//a[text() = 'Action Import']");
        btnDownloadTemplateImportUpdate = _webDriverHandler.byXpath("//*[@id = 'QueryListBulkUpdateTemplate']");
        btnImportImportUpdate = _webDriverHandler.byXpath("//*[@id = 'BulkImportUpdateForm']//button[contains(text(), 'Import')]");
        btnCancelImportUpdate = _webDriverHandler.byXpath("//*[@id='BulkImportUpdateForm']//button[contains(text(), 'Cancel')]");
        btnExport = _webDriverHandler.byXpath("//*[@id = 'QueryListExportBtnId']");
        tbImportReference = _webDriverHandler.byXpath("//*[@id = 'ImportReference']");
        tbNotes = _webDriverHandler.byXpath("//*[@id = 'Notes']");
        uploadExcel = _webDriverHandler.byXpath("//*[@id = 'ImportExcelUpload']");
        btnCreateBulkAction = _webDriverHandler.byXpath("//*[@id = 'btnTaskBulkActionSave']");
        btnCancelBulkAction = _webDriverHandler.byXpath("//*[@id='TaskBulkActionForm']//button[contains(text(), 'Cancel')]");
        tbFilterID = _webDriverHandler.byXpath("//*[@id = 'filterId']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
    }

    public void accessSubCategory(String category, String subCategory) {
        waitLoad();
        _webDriverHandler.byXpath("//a//span[contains(text(), '" + category + "')]").waitClickable().click();
        _webDriverHandler.byXpath("//a[contains(text(), '" + subCategory + "')]").waitClickable().click();
        waitLoad();
    }

    public void select(String... selectionId) {
        for (String s : selectionId) {
            tbFilterID.waitClickable().clear().sendKeys(s);
            waitLoad();
            _webDriverHandler.byXpath("//tr[@id = '"+s+"']//input[@type='checkbox']").waitClickable().click();
        }
    }

    public void select() {
            _webDriverHandler.byXpath("//th//input[@type='checkbox']").waitClickable().click();
    }

    public void bulkAction(String action, String note, String currentlyWO, String date, String path, String... selectionId) {
        select(selectionId);
        ddBulkProcess.waitClickable().selectByIndex(1);
        waitLoad();
        ddAction.waitClickable().selectByText(action);
        tbActionNote.waitClickable().sendKeys(note);
        ddCurrentlyWaitingOn.waitClickable().selectByText(currentlyWO);
        tbNextActionDate.waitClickable().sendKeys(date);
        uploadFile.waitClickable().clear().sendKeys(path);
        //btnCreateBulkAction.waitClickable().click();
    }

    public void bulkAssign(String owner) {
        select();
        waitLoad();
        ddBulkProcess.waitClickable().selectByIndex(2);
        waitLoad();
        ddOwner.waitClickable().selectByText(owner);
        //btnConfirmBulkAssign.waitClickable().click();
    }

    public void  selectionError() {
        ddBulkProcess.waitClickable().selectByIndex(1);
        String messageAction = _webDriverHandler.byXpath("//*[@id='swal2-content']").getText();
        System.out.println("____________________________________\n" + messageAction);
        btnOk.waitClickable().click();
        ddBulkProcess.waitClickable().selectByIndex(2);
        String messageAssign = _webDriverHandler.byXpath("//*[@id='swal2-content']").getText();
        System.out.println("____________________________________\n" + messageAssign);
        btnOk.waitClickable().click();
    }

    public void Export() {
        btnExport.waitClickable().click();
        waitLoad();
    }

    public void bulkCreateImport(String references, String note, String path) {
        btnImport.waitClickable().click();
        btnCreateImport.waitClickable().click();
        waitLoad();
        btnDownloadTemplateCreateImport.waitClickable().click();
        tbImportReference.waitClickable().sendKeys(references);
        tbNotes.waitClickable().sendKeys(note);
        uploadExcel.waitClickable().sendKeys(path);
        btnImportCreateImport.waitClickable().click();
    }

    public void bulkUpdateImport(String references, String note, String path) {
        btnImport.waitClickable().click();
        btnUpdateImport.waitClickable().click();
        waitLoad();
        btnDownloadTemplateUpdate.waitClickable().click();
        tbImportReference.waitClickable().sendKeys(references);
        tbNotes.waitClickable().sendKeys(note);
        uploadExcel.waitClickable().sendKeys(path);
        btnImportUpdate.waitClickable().click();
    }

    public void bulkActionImport(String references, String note, String path) {
        btnImport.waitClickable().click();
        btnActionImport.waitClickable().click();
        waitLoad();
        btnDownloadTemplateImportUpdate.waitClickable().click();
        tbImportReference.waitClickable().sendKeys(references);
        tbNotes.waitClickable().sendKeys(note);
        uploadExcel.waitClickable().sendKeys(path);
        btnImportImportUpdate.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}