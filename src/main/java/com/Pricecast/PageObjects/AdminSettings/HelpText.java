package com.Pricecast.PageObjects.AdminSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class HelpText {

    WebDriverHandler _webDriverHandler;
    ElementHandler adminSettings;
    ElementHandler linkHelpText;
    ElementHandler btnOk;
    ElementHandler btnAddNew;
    ElementHandler searchBox;
    ElementHandler btnBack;
    ElementHandler btnCancel;
    ElementHandler tbKey;
    ElementHandler tbText;
    ElementHandler btnAdd;
    ElementHandler btnDelete;
    ElementHandler btnDltYes;
    ElementHandler btnEdit;
    ElementHandler msgKey;
    ElementHandler msgText;

    public HelpText(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        adminSettings = _webDriverHandler.byXpath("//button[text() = 'Admin Settings']");
        linkHelpText = _webDriverHandler.byXpath("//a[@data-action='HelpText']");
        searchBox = _webDriverHandler.byXpath("//input[@type='search']");
        btnAddNew = _webDriverHandler.byXpath("//button[text()=' Add New Row']");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        btnBack = _webDriverHandler.byXpath("//*[@class='btn btn-sm btn-primary']");
        btnCancel = _webDriverHandler.byXpath("//*[contains(text(),'Cancel')]");
        tbKey = _webDriverHandler.byXpath("//*[@id='Key']");
        tbText = _webDriverHandler.byXpath("//*[@id='Text']");
        btnAdd = _webDriverHandler.byXpath("//*[@type='submit']");
        btnDelete = _webDriverHandler.byXpath("//*[@id='tblHelpText']//*[@title='Delete']");
        btnDltYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");
        btnEdit = _webDriverHandler.byXpath("//*[@id='tblHelpText']//*[@title='Edit']");
        msgKey = _webDriverHandler.byXpath("//*[@id='Key-error']");
        msgText = _webDriverHandler.byXpath("//*[@id='Text-error']");
    }

    public String[] tblHelpText = new String[] {"Key", "Text", "Actions"};
    public  String[] arrHelpText = new String[3];

    String strErrorKey = "Invalid Key";

    String strMandatoryKey = "The Key field is required.";
    String strMandatoryText = "The Text field is required.";

    public void search(String term){
        searchBox.clear().sendKeys(term);
        waitLoad();
    }

    public void accessAdminSettings(){
        waitLoad();
        adminSettings.waitClickable().click();
        waitLoad();
    }

    public void accessHelpText(){
        linkHelpText.waitClickable().click();
    }

    public void verifyHelpText(){
        waitLoad();
        if(
            searchBox.isDisplayed() &&
            btnAddNew.isDisplayed()
        )
        {
            columnVerification();
            System.out.println("\nMissing Sheets is loaded properly");
        }
        else {
            Assert.fail("\nPage is not loaded properly.");
        }
    }

    public void columnVerification() {
        for(int i = 0 ; i < arrHelpText.length ; i++) {
            arrHelpText[i] = _webDriverHandler.byXpath("//table[@id='tblHelpText']/thead/tr/th[" + (i + 1) + "]").getText();
            if(!(tblHelpText[i].equals(arrHelpText[i])))
            {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void addNewRow(String Key, String Text) {
        waitLoad();
        btnAddNew.waitClickable().click();
        tbKey.clear().sendKeys(Key);
        tbText.clear().sendKeys(Text);
        btnAdd.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void deleteRow(String Key){
        waitLoad();
        search(Key);
        btnDelete.waitClickable().click();
        btnDltYes.waitClickable().click();
    }

    public void editRow(String KeyOld, String Key, String Text){
        search(KeyOld);
        btnEdit.waitClickable().click();
        waitLoad();
        tbKey.clear().sendKeys(Key);
        tbText.clear().sendKeys(Text);
        btnAdd.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void addDuplicate(String Key, String Text){
        addNewRow(Key, Text);
        waitLoad();
        btnAddNew.waitClickable().click();
        waitLoad();
        tbKey.clear().sendKeys(Key);
        tbText.clear().sendKeys(Text);
        btnAdd.waitClickable().click();
        String strMesage = _webDriverHandler.byId("swal2-content").waitVisible().getText();
        System.out.println("****************************************\n"
                + strMesage + "\n");
        btnOk.waitClickable().click();
        btnCancel.waitClickable().click();
        search(Key);
        btnDelete.waitClickable().click();
        btnDltYes.waitClickable().click();
    }

    public void errorValidations(){
        waitLoad();
        btnAddNew.waitClickable().click();
        tbKey.clear().sendKeys("12");
        tbText.clear().sendKeys("Text");
        btnAdd.waitClickable().click();
        Assert.assertEquals(msgKey.getText(), strErrorKey);
        System.out.println("\nError validation is present for numeric input.");
        tbKey.clear().sendKeys("!@");
        Assert.assertEquals(msgKey.getText(), strErrorKey);
        System.out.println("\nError validation is present for symbols.");
        btnCancel.waitClickable().click();
    }

    public void mandatoryValidations(){
        waitLoad();
        btnAddNew.waitClickable().click();
        tbKey.clear().sendKeys("");
        tbText.clear().sendKeys("");
        btnAdd.waitClickable().click();
        Assert.assertEquals(msgKey.getText(), strMandatoryKey);
        Assert.assertEquals(msgText.getText(), strMandatoryText);
        System.out.println("\nMandatory validations are passed.");
        btnCancel.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
