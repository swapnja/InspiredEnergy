package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import com.Budgets.PageHandlers.CommonPageHandler;
import org.testng.Assert;

import java.util.Properties;

public class SupplierVoulumeBands {
	
	String appendDate = TimeStampPageHandler.AppendTimeStamp();
	Properties _prop;
	private CommonPageHandler cph;
	private WebDriverHandler _webDriverHandler;
	private ElementHandler buttonSettings;
	private ElementHandler buttonAddNewRow;
	private ElementHandler linkSupplierVolumeBands;
	private ElementHandler btnAdd;
	private ElementHandler btnOk;
	private ElementHandler minVol;
	private ElementHandler maxVol;
	private ElementHandler DDSupplierVolumneBandsRenewalFlag;
	private ElementHandler txtBoxSupplierVolumneBandsMaxVol;
	private ElementHandler txtBoxSupplierVolumneBandsMinVol;
	private ElementHandler ddSupplierVolumneBandsProduct;
		
	String strMandatoryMinVol = "Min Volume field is mandatory";
	String strMandatoryMaxVol = "Max Volume field is mandatory";
	
	String strRangeValidationMinVol = "Please enter a number between 0 and 1000000000";
	String strRangeValidationMaxVol = "Please enter a number between 0 and 1000000000";
	
	String strNumericValidationMinVol = "Please enter a valid Number";
	String strNumericValidationMaxVol = "Please enter a valid Number";
	
	
	public SupplierVoulumeBands(WebDriverHandler webDriverHandler) {
		cph = new CommonPageHandler(webDriverHandler, _prop);
		_webDriverHandler = webDriverHandler;
		
		buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
		linkSupplierVolumeBands =  _webDriverHandler.byXpath("//a[@data-action='SupplierVolumeBands']");
		buttonAddNewRow = _webDriverHandler.byXpath("//*[@id='btnAddNewBorkerSupplierSupplierVolumeBands']");
		
		btnAdd = _webDriverHandler.byXpath("//*[contains(text(),' Add')]");
		btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
		minVol = _webDriverHandler.byXpath("//*[@id='MinAQ-error']");
		maxVol = _webDriverHandler.byXpath("//*[@id='MaxAQ-error']");
		
		DDSupplierVolumneBandsRenewalFlag = _webDriverHandler.byXpath("//*[@id='RenewalFlag']");
		txtBoxSupplierVolumneBandsMaxVol = _webDriverHandler.byXpath("//*[@id='MaxAQ']");
		txtBoxSupplierVolumneBandsMinVol = _webDriverHandler.byXpath("//*[@id='MinAQ']");
		ddSupplierVolumneBandsProduct = _webDriverHandler.byXpath("//*[@id='SupplierProductFilterId']");
		
	}
	public String[] tblSupplierVolumeBands = new String[] { "Renewal Flag","Min Volume","Max Volume","Product","Actions" };
	public String[] arrTblLabelsSupplierVolumeBands = new String[5];

	public void SupplierVolumeBands_ColumnVerification() {
		for(int i = 0 ; i < arrTblLabelsSupplierVolumeBands.length ; i++) {
			arrTblLabelsSupplierVolumeBands[i] = _webDriverHandler.byXpath("//table[@id='tblBrokerSupplierSupplierVolumeBands']/thead/tr/th[" + (i + 1) + "]").getText();
			if(tblSupplierVolumeBands[i].equals(arrTblLabelsSupplierVolumeBands[i]))
			{
				System.out.println("Column names are matched");
			}			 
		}
	} 
	public void selectSettings() throws InterruptedException {
		waitLoad();
		buttonSettings.click();
		waitLoad();
		linkSupplierVolumeBands.click();		
	}
	public void SupplierVolumeBands_addNewRow(int RenewalFlag, int MinVol, int MaxVol,int product) throws InterruptedException
	{		
		waitLoad();
		buttonAddNewRow.waitClickable(10,100).click();
		DDSupplierVolumneBandsRenewalFlag.selectByValue("1");
		txtBoxSupplierVolumneBandsMinVol.clear().sendKeys(MinVol+"");
		txtBoxSupplierVolumneBandsMaxVol.clear().sendKeys(MaxVol+"");
		//DDsupplierPriceaheadProduct.selectByValue("All");
		btnAdd.waitClickable(10,100).click();
	//	btnOk.waitClickable(10,100).click();
	}
	public void SupplierVolumeBands_NumericaddNewRow(int RenewalFlag, int MinVol, int MaxVol,int product) throws InterruptedException
	{		
		waitLoad();
		buttonAddNewRow.waitClickable(10,100).click();
		DDSupplierVolumneBandsRenewalFlag.selectByValue("1");
		txtBoxSupplierVolumneBandsMinVol.clear().sendKeys(MinVol+"gfgf");
		txtBoxSupplierVolumneBandsMaxVol.clear().sendKeys(MaxVol+"wgfg");
		//DDsupplierPriceaheadProduct.selectByValue("All");
		btnAdd.waitClickable(10,100).click();
	//	btnOk.waitClickable(10,100).click();
	}
	public void blankAddNewRow(int RenewalFlag, int MinVol, int MaxVol,int product) throws InterruptedException {
		waitLoad();
		buttonAddNewRow.waitClickable(10, 100).click();
		DDSupplierVolumneBandsRenewalFlag.selectByValue("1");
		txtBoxSupplierVolumneBandsMinVol.clear();
		txtBoxSupplierVolumneBandsMaxVol.clear();
		Thread.sleep(1000);
		btnAdd.waitClickable(10,100).click();
	}
	public void SupplierVolumeBands_MandatoryValidation() {
		Assert.assertTrue(strMandatoryMinVol.equalsIgnoreCase(minVol.getText())); 
		System.out.println("Min Volumne is Mandatory fields on Supplier Volume Bands on the Screen");
		Assert.assertTrue(strMandatoryMaxVol.equalsIgnoreCase(maxVol.getText())); 
		System.out.println("Max Volumne is Mandatory fields on Supplier Volume Bands on the Screen");
	}
	public void SupplierVolumeBands_RangeValidation() {
		Assert.assertTrue(strRangeValidationMinVol.equalsIgnoreCase(minVol.getText())); 
		System.out.println("Range validation is present for Min Volumne on Supplier Volume Bands on the Screen");
		Assert.assertTrue(strRangeValidationMaxVol.equalsIgnoreCase(maxVol.getText())); 
		System.out.println("Range validation is present for Max Volumne on Supplier Volume Bands on the Screen");
	}
	public void SupplierVolumeBands_NumericValidation() {
		Assert.assertTrue(strNumericValidationMinVol.equalsIgnoreCase(minVol.getText())); 
		System.out.println("Numeric validation is present for Min Volumne on Supplier Volume Bands on the Screen");
		Assert.assertTrue(strNumericValidationMaxVol.equalsIgnoreCase(maxVol.getText())); 
		System.out.println("Numeric validation is present for Max Volumne on Supplier Volume Bands on the Screen");
	}
	public void waitLoad() {
		_webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
	}
}
