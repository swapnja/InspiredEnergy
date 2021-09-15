package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Budgets.PageHandlers.CommonPageHandler;
import org.testng.Assert;

import java.util.Properties;

public class UpliftsIncrements {
    Properties _prop;
    private CommonPageHandler cph;
    private WebDriverHandler _webDriverHandler;
    private ElementHandler buttonAddNewRow;
    private ElementHandler txtBoxUpliftIncrementDuration;
    private ElementHandler DDUpliftIncrementRenewalFlag;
    private ElementHandler txtValidUplifts;
    private ElementHandler DDSupplierProductFilter;
    private ElementHandler buttonSettings;
    private ElementHandler linkUpliftIncrement;
    private ElementHandler btnAdd;
    private ElementHandler msgDuration;
    ;
    private ElementHandler msgValidUplifts;
    public static ElementHandler btnOk;

    //Range validation messages
    String strRangeDuration = "Please enter a number between 0 and 10000";
    //Numeric validation messages
    String strValidUplifts = "Please enter a semicolon separated list of numbers";

    public UpliftsIncrements(WebDriverHandler webDriverHandler) {
        cph = new CommonPageHandler(webDriverHandler, _prop);
        _webDriverHandler = webDriverHandler;
        buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        linkUpliftIncrement = _webDriverHandler.byXpath("//a[@data-action='UpliftIncrement']");
        //WebElements
        buttonAddNewRow = _webDriverHandler.byXpath("//*[@id='btnAddUpliftIncrement']");
        txtBoxUpliftIncrementDuration = _webDriverHandler.byXpath("//*[@id='Duration']");
        DDUpliftIncrementRenewalFlag = _webDriverHandler.byXpath("//*[@id='RenewalFlag']");
        txtValidUplifts = _webDriverHandler.byXpath("//*[@id='ValidUplifts']");
        DDSupplierProductFilter = _webDriverHandler.byXpath("//*[@id='SupplierProductFilterID']");
        btnAdd = _webDriverHandler.byXpath("//*[@id='upliftIncrementForm']//button[@type='submit']");
        //btnAdd = _webDriverHandler.byXpath("//*[contains(text(),' Add')]");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
        msgDuration = _webDriverHandler.byXpath("//*[@id='Duration-error']");
        msgValidUplifts = _webDriverHandler.byXpath("//*[@id='ValidUplifts-error']");
    }

    public String[] tblUpliftIncrements = new String[]{"Duration", "Renewal Flag", "Valid Uplifts", "Product", "Actions"};
    public String[] arrTblLabelsUpliftIncrements = new String[5];

    public void upliftIncrementsColumnVerification() {
        for (int i = 0; i < arrTblLabelsUpliftIncrements.length; i++) {
            arrTblLabelsUpliftIncrements[i] = _webDriverHandler.byXpath("//table[@id='tblUpliftIncrement']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!tblUpliftIncrements[i].equals(arrTblLabelsUpliftIncrements[i])) {
                System.out.println("Column names do not match.");
            }
        }
        System.out.println("Column names are matched.");
    }

    public void selectSettings() throws InterruptedException {
        waitLoad();
        buttonSettings.click();
        waitLoad();
        linkUpliftIncrement.click();
    }

    public void addNewRow(int Duration, int RenewalFlag, String ValidUplifts, String Product) throws InterruptedException {
        waitLoad();
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxUpliftIncrementDuration.clear().sendKeys(Duration + "");
        DDUpliftIncrementRenewalFlag.selectByIndex(1);
        txtValidUplifts.clear().sendKeys(ValidUplifts);
        DDSupplierProductFilter.selectByText("All");
        waitLoad();
        btnAdd.waitClickable(10, 100).click();
    }

    public void UpliftIncrements_NumericValidation() {
        Assert.assertTrue(strRangeDuration.equalsIgnoreCase(msgDuration.getText()));
        System.out.println("Numeric validation is present on the screen");
        Assert.assertTrue(strValidUplifts.equalsIgnoreCase(msgValidUplifts.getText()));
        System.out.println("Numeric Validation for Valid Input is Passed");
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}