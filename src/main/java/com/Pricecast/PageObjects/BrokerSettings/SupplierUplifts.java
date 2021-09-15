package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

import java.util.Properties;

public class SupplierUplifts {
    Properties _prop;
    private WebDriverHandler _webDriverHandler;
    private ElementHandler buttonSettings;
    private ElementHandler buttonAddNewRow;
    private ElementHandler linkSupplierUplifts;
    private ElementHandler txtBoxSupplierUpliftsDuration;
    private ElementHandler DDSupplierUpliftsRenewalFlag;
    private ElementHandler txtBoxSupplierUpliftsMinVol;
    private ElementHandler txtBoxSupplierUpliftsMaxVol;
    private ElementHandler txtSupplierUpliftsRateUplift;
    private ElementHandler txtSupplierUpliftsGrossUplift;
    private ElementHandler ddSupplierUpliftsProductMatch;
    private ElementHandler txtSupplierUpliftsFormula;
    private ElementHandler btnAdd;
    private ElementHandler btnOk;

    //Mandatory Messages
    private ElementHandler msgMinVolumne;
    private ElementHandler msgMaxVolumne;


    //Mandatory messages
    String strMandatoryMinVolumne = "Bulk Slider Increment field is mandatory";
    String strMandatoryMaxVolumne = "Bulk Slider Max Uplift field is mandatory";
    //Range validation messages
    String strRangeMinVolumne = "Please enter a number between 0 and 9999999";
    String strRangeMaxVolumne = "Please enter a number between 0 and 9999999";
    //Numeric validation messages
    String strNumericMinVolumne = "Please enter a number between 0 and 9999999";
    String strNumericMaxVolumne = "Please enter a number between 0 and 9999999";


    public SupplierUplifts(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        linkSupplierUplifts = _webDriverHandler.byXpath("//a[@data-action='SupplierUplifts']");
        buttonAddNewRow = _webDriverHandler.byXpath("//*[@id='btnAddSupplierUplift']");
        txtBoxSupplierUpliftsDuration = _webDriverHandler.byXpath("//*[@id='txtDuration']");
        DDSupplierUpliftsRenewalFlag = _webDriverHandler.byXpath("//*[@id='RenewalFlag']");
        txtBoxSupplierUpliftsMinVol = _webDriverHandler.byXpath("//*[@id='MinVolume']");
        txtBoxSupplierUpliftsMaxVol = _webDriverHandler.byXpath("//*[@id='MaxVolume']");
        txtSupplierUpliftsRateUplift = _webDriverHandler.byXpath("//*[@id='txtRateUplift']");
        txtSupplierUpliftsGrossUplift = _webDriverHandler.byXpath("//*[@id='txtGrossUplift']");
        ddSupplierUpliftsProductMatch = _webDriverHandler.byXpath("//*[@id='ProductMatch']");
        txtSupplierUpliftsFormula = _webDriverHandler.byXpath("//*[@id='txtFormula']");
        btnAdd = _webDriverHandler.byXpath("//*[contains(text(),' Add')]");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");

        //Messages
        msgMinVolumne = _webDriverHandler.byXpath("//*[@id='MinVolume-error']");
        msgMaxVolumne = _webDriverHandler.byXpath("//*[@id='MaxVolume-error']");
    }

    //Supplier Uplifts
    public String[] tblSupplierUplift = new String[]{"Duration", "Renewal Flag", "Min Volume", "Max Volume", "RateUplift", "GrossUplift", "Product", "Formula", "Actions"};
    public String[] arrTblLabelsSupplierUplifts = new String[9];

    public void SupplierUpliftsColumnVerification() {
        for (int i = 0; i < arrTblLabelsSupplierUplifts.length; i++) {
            arrTblLabelsSupplierUplifts[i] = _webDriverHandler.byXpath("//table[@id='tblSupplierUplift']/thead/tr/th[" + (i + 1) + "]").getText();
            if (tblSupplierUplift[i].equals(arrTblLabelsSupplierUplifts[i])) {
                System.out.println("Column names are matched");
            }
        }
    }

    public void selectSettings() throws InterruptedException {
        waitLoad();
        buttonSettings.click();
        waitLoad();
        linkSupplierUplifts.click();
    }

    public void addNewRow(int Duration, int RenewalFlag, int MinVolume, int MaxVolume, int RateUplift, int GrossUplift, String formula) throws InterruptedException {
        waitLoad();
        //wait for pop-up to be visible
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxSupplierUpliftsDuration.waitClickable().clear().sendKeys(Duration + "");
        DDSupplierUpliftsRenewalFlag.waitClickable().selectByValue(RenewalFlag + "");
        txtBoxSupplierUpliftsMinVol.waitClickable().clear().sendKeys(MinVolume + "");
        txtBoxSupplierUpliftsMaxVol.waitClickable().clear().sendKeys(MinVolume + "");
        txtSupplierUpliftsRateUplift.waitClickable().clear().sendKeys(String.valueOf(RateUplift));
        txtSupplierUpliftsGrossUplift.waitClickable().clear().sendKeys(GrossUplift + "");
        //ddSupplierUpliftsProductMatch.waitClickable().selectByValue(Product+"");
        txtSupplierUpliftsFormula.waitClickable().clear().sendKeys(formula);
        btnAdd.waitClickable(10, 100).click();
        //btnOk.click();
    }

    public void addNewRowNumeric(int Duration, int RenewalFlag, int MinVolume, int MaxVolume, int RateUplift, int GrossUplift, String formula) throws InterruptedException {
        waitLoad();
        //wait for pop-up to be visible
        buttonAddNewRow.waitClickable(10, 100).click();
        txtBoxSupplierUpliftsDuration.waitClickable().clear().sendKeys(Duration + "");
        DDSupplierUpliftsRenewalFlag.waitClickable().selectByValue(RenewalFlag + "");
        txtBoxSupplierUpliftsMinVol.waitClickable().clear().sendKeys(MinVolume + "absgsf");
        txtBoxSupplierUpliftsMaxVol.waitClickable().clear().sendKeys(MinVolume + "absgsf");
        txtSupplierUpliftsRateUplift.waitClickable().clear().sendKeys(String.valueOf(RateUplift));
        txtSupplierUpliftsGrossUplift.waitClickable().clear().sendKeys(GrossUplift + "");
        //ddSupplierUpliftsProductMatch.waitClickable().selectByValue(Product+"");
        txtSupplierUpliftsFormula.waitClickable().clear().sendKeys(formula);
        btnAdd.waitClickable(10, 100).click();
        //btnOk.click();
    }

    public void blankAddNewRow() throws InterruptedException {
        waitLoad();
        buttonAddNewRow.click();
        txtBoxSupplierUpliftsDuration.clear();
        txtBoxSupplierUpliftsMinVol.clear();
        txtBoxSupplierUpliftsMaxVol.clear();
        txtSupplierUpliftsRateUplift.clear();
        txtSupplierUpliftsGrossUplift.clear();
        txtSupplierUpliftsFormula.clear();
        btnAdd.waitClickable(10, 100).click();
    }

    public void SupplierUplift_RangeValidation() {
        Assert.assertTrue(msgMinVolumne.isDisplayed() && msgMaxVolumne.isDisplayed());
        System.out.println("Min and Max Volumne are present on the screen");
        Assert.assertEquals(msgMinVolumne.getText(), strRangeMinVolumne);
        Assert.assertEquals(msgMaxVolumne.getText(), strRangeMaxVolumne);
        System.out.println("Range Validation for Max Volumne and Min Volumne are Passed");
    }

    public void SupplierUplift_NumericValidation() throws Exception {
        if (msgMinVolumne.getText().equalsIgnoreCase(strRangeMinVolumne)
                && msgMaxVolumne.getText().equalsIgnoreCase(strRangeMaxVolumne)) {

            System.out.println("Range Validation for Min and Max Volumne failed");
        } else {
            throw new Exception("Manual Exception");
        }
    }

    public void SupplierUplift_MandatoryValidation() {
        if (msgMinVolumne.getText().equalsIgnoreCase(strMandatoryMinVolumne)
                && msgMinVolumne.getText().equalsIgnoreCase(strMandatoryMinVolumne)) {
            System.out.println("Min and Max vloumne are Mandatory fields on Supplier Uplift Screen");
        }
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}	

	
	
