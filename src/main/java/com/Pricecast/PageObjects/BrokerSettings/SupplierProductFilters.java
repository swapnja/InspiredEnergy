package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import com.Budgets.PageHandlers.CommonPageHandler;

import java.util.Properties;

public class SupplierProductFilters {
    String appendDate = TimeStampPageHandler.AppendTimeStamp();
    Properties _prop;
    private CommonPageHandler cph;
    private WebDriverHandler _webDriverHandler;
    private ElementHandler buttonSettings;
    private ElementHandler buttonAddNewRow;
    private ElementHandler linkSupplierProductFilter;
    private ElementHandler btnAdd;
    private ElementHandler btnOk;
    private ElementHandler DDSupplierProductFiltersRenewalFlag;
    private ElementHandler ddSupplierProductFiltersProduct;


    public SupplierProductFilters(WebDriverHandler webDriverHandler) {
        cph = new CommonPageHandler(webDriverHandler, _prop);
        _webDriverHandler = webDriverHandler;
        buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
        linkSupplierProductFilter = _webDriverHandler.byXpath("//a[@data-action='SupplierProductFilter']");
        buttonAddNewRow = _webDriverHandler.byXpath("//*[@id='btnAddNewBorkerSupplierProductFilter']");

        btnAdd = _webDriverHandler.byXpath("//*[contains(text(),' Add')]");
        btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");


        DDSupplierProductFiltersRenewalFlag = _webDriverHandler.byXpath("//*[@id='RenewalFlag']");
        ddSupplierProductFiltersProduct = _webDriverHandler.byXpath("//*[@id='SupplierProductFilterId']");

    }

    public String[] tblSupplierProductFilter = new String[]{"Renewal Flag", "Product", "Actions"};
    public String[] arrSupplierProductFilter = new String[3];

    public void SupplierProductFilters_ColumnVerification() {
        for (int i = 0; i < arrSupplierProductFilter.length; i++) {
            arrSupplierProductFilter[i] = _webDriverHandler.byXpath("//table[@id='tblBrokerSupplierProductFilter']/thead/tr/th[" + (i + 1) + "]").getText();
            if (tblSupplierProductFilter[i].equals(arrSupplierProductFilter[i])) {
                System.out.println("Column names are matched");
            }
        }
    }

    public void selectSettings() throws InterruptedException {
        Thread.sleep(1000);
        buttonSettings.click();
        Thread.sleep(2000);
        linkSupplierProductFilter.click();
    }

    public void SupplierProductFilter_addNewRow(int RenewalFlag, int Product) throws InterruptedException {
        Thread.sleep(2000);
        buttonAddNewRow.waitClickable(10, 100).click();
        DDSupplierProductFiltersRenewalFlag.selectByValue("1");
        btnAdd.waitClickable(10, 100).click();
        waitLoad();
        btnOk.waitClickable(10, 100).click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
