package com.QueryManagement.Home;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class CreateNewTask {

    WebDriverHandler _webDriverHandler;
    ElementHandler btnCreateNew;
    ElementHandler ddCustomer;
    ElementHandler ddCategory;
    ElementHandler ddSubCategory;
    ElementHandler ddSupplier;
    ElementHandler ddUtilityType;
    ElementHandler tbSummary;
    ElementHandler tglCustomerView;
    ElementHandler tglCustomerViewCheck;
    ElementHandler tglSupplierView;
    ElementHandler tglSupplierViewCheck;
    ElementHandler ddCurrentlyWaitingOn;
    ElementHandler tbNextActionDate;
    ElementHandler tbDueDate;
    ElementHandler msgCustomer;
    ElementHandler msgCategory;
    ElementHandler msgSubCategory;
    ElementHandler msgSummary;
    ElementHandler btnCreate;
    ElementHandler btnCancel;
    ElementHandler btnSave;
    ElementHandler btnOk;
    ElementHandler btnYes;

    public CreateNewTask(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        btnCreateNew = _webDriverHandler.byXpath("//button[text()= ' Create New']");
        ddCustomer = _webDriverHandler.byXpath("//*[@id = 'CustomerIdTaskInitial']");
        ddCategory = _webDriverHandler.byXpath("//*[@id = 'CategoryIdTaskInitial']");
        ddSubCategory = _webDriverHandler.byXpath("//*[@id = 'SubCategoryIdTaskInitial']");
        ddSupplier = _webDriverHandler.byXpath("//*[@id = 'SupplierIdTaskInitial']");
        ddUtilityType = _webDriverHandler.byXpath("//*[@id = 'UtilityTypeTaskInitial']");
        tbSummary = _webDriverHandler.byXpath("//*[@id = 'SummaryTaskInitial']");
        tglCustomerView = _webDriverHandler.byXpath("//label[input[@name='CustomerAccessTaskInitial']]");
        tglCustomerViewCheck = _webDriverHandler.byXpath("//label[input[@name='CustomerAccessTaskInitial']]//input");
        tglSupplierView = _webDriverHandler.byXpath("//label[input[@name='SupplierAccessTaskInitial']]");
        tglSupplierViewCheck = _webDriverHandler.byXpath("//label[input[@name='SupplierAccessTaskInitial']]//input");
        ddCurrentlyWaitingOn = _webDriverHandler.byXpath("//*[@id = 'AwaitingTaskInitial']");
        tbNextActionDate = _webDriverHandler.byXpath("//*[@id = 'NextActionDateTaskInitial']");
        tbDueDate = _webDriverHandler.byXpath("//*[@id = 'DueDateTaskInitial']");
        msgCustomer = _webDriverHandler.byXpath("//*[@id = 'CustomerIdTaskInitial-error']");
        msgCategory = _webDriverHandler.byXpath("//*[@id = 'CategoryIdTaskInitial-error']");
        msgSubCategory = _webDriverHandler.byXpath("//*[@id = 'SubCategoryIdTaskInitial-error']");
        msgSummary = _webDriverHandler.byXpath("//*[@id = 'SummaryTaskInitial-error']");
        btnCreate = _webDriverHandler.byXpath("//*[text() = '  Create']");
        btnCancel = _webDriverHandler.byXpath("//*[@id = 'newTaskForm']//*[text() = 'Cancel']");
        //btnSave = _webDriverHandler.byXpath("//*[@id = 'newTaskForm']//*[text() = 'Save']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");
    }

    String strErrorCustomer = "The Customer: field is required.";
    String strErrorCategory = "The Category: field is required.";
    String strErrorSubCategory = "The Sub-Category: field is required.";
    String strErrorSummary = "The Summary: field is required.";

    public void accessCreateNew() {
        waitLoad();
        do {
            btnCreateNew.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
            }
        }
        while (ddCategory.notPresent() && ddCustomer.notPresent());
    }

    public void verifyCreateNewModal() {
        if (ddCustomer.isDisplayed() && ddCategory.isDisplayed() && ddSubCategory.isDisplayed() && ddSupplier.isDisplayed() && ddUtilityType.isDisplayed() &&
            tbSummary.isDisplayed() && tglCustomerView.isDisplayed() && tglSupplierView.isDisplayed() && ddCurrentlyWaitingOn.isDisplayed() &&
            ddCurrentlyWaitingOn.getAttribute("disabled").equals("true") && tbNextActionDate.isDisplayed() && tbNextActionDate.getAttribute("disabled")
            .equals("true") && tbDueDate.isDisplayed() && tbDueDate.getAttribute("disabled").equals("true")) {
            System.out.println("Create New modal is loaded properly.");
        }
    }

    public void errorValidation() {
        btnCreate.waitClickable().click();
        Assert.assertEquals(msgCustomer.getText(), strErrorCustomer, "Customer validation is wrong.");
        Assert.assertEquals(msgCategory.getText(), strErrorCategory, "Category validation is wrong.");
        Assert.assertEquals(msgSubCategory.getText(), strErrorSubCategory, "Sub Category validation is wrong.");
        Assert.assertEquals(msgSummary.getText(), strErrorSummary, "Supplier validation is wrong.");
    }

    public void createNewTask(String customer, String category, String subCategory, String supplier, String summary, boolean SV, boolean CV, String utility) {
        ddCustomer.waitClickable().selectByText(customer);
        ddCategory.waitClickable().selectByText(category);
        waitLoad();
        ddSubCategory.waitClickable().selectByText(subCategory);
        waitLoad();
        ddSupplier.waitClickable().selectByText(supplier);
        ddUtilityType.waitClickable().selectByText(utility);
        tbSummary.waitClickable().clear().sendKeys(summary);
        if (SV) {
            if (!tglSupplierViewCheck.isSelected()) {
                tglSupplierView.waitClickable().click();
            }
        } else {
            if (tglSupplierViewCheck.isSelected()) {
                tglSupplierView.waitClickable().click();
            }
        }
        if (CV) {
            if (!tglCustomerViewCheck.isSelected()) {
                tglCustomerView.waitClickable().click();
            }
        } else {
            if (tglCustomerViewCheck.isSelected()) {
                tglCustomerView.waitClickable().click();
            }
        }
        btnCreate.waitClickable().click();
        waitLoad();
        btnCreate.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}