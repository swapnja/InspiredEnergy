package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import com.Budgets.PageHandlers.CommonPageHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.Properties;

public class SupplierPriceAhead {
	String appendDate = TimeStampPageHandler.AppendTimeStamp();
	Properties _prop;
	private CommonPageHandler cph;
	private WebDriverHandler _webDriverHandler;
	private ElementHandler buttonSettings;
	private ElementHandler buttonAddNewRow;
	private ElementHandler linkSupplierPriceAhead;
	private ElementHandler btnAdd;
	private ElementHandler btnOk;
	private ElementHandler DDsupplierPriceaheadRenewalFlag;
	private ElementHandler txtBoxsupplierPriceaheadmaxDays;
	private ElementHandler calendarsupplierPriceaheadMaxStartDate;
	private ElementHandler DDsupplierPriceaheadProduct;
	private ElementHandler maxDays;
	
	//Mandatory messages
	String strMandatoryMaxDays = "Max Days field is mandatory";
	String strNumericMaxDays = "Please enter valid Number";
	String strRangeMaxDays = "Please enter valid Number";
	//String strRangeMaxDays = "Please enter number of days between 0-365";
	
	public SupplierPriceAhead(WebDriverHandler webDriverHandler) {
	cph = new CommonPageHandler(webDriverHandler, _prop);
	_webDriverHandler = webDriverHandler;
	buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
	linkSupplierPriceAhead = _webDriverHandler.byXpath("//a[@data-action='SupplierPriceAhead']");
	buttonAddNewRow = _webDriverHandler.byXpath("//*[@id='btnAddNewSupplierPriceAhead']");
	
	DDsupplierPriceaheadRenewalFlag = _webDriverHandler.byXpath("//*[@id='RenewalFlag']");
	txtBoxsupplierPriceaheadmaxDays = _webDriverHandler.byXpath("//*[@id='MaxDays']");
	calendarsupplierPriceaheadMaxStartDate = _webDriverHandler.byXpath("//*[@id='MaxStartDate']");		
	DDsupplierPriceaheadProduct = _webDriverHandler.byXpath("//*[@id='SupplierProductFilterID']");	
	btnAdd = _webDriverHandler.byXpath("//*[contains(text(),' Add')]");
	btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
	maxDays = _webDriverHandler.byXpath("//*[@id='MaxDays-error']");
	}
	//Messages
	 
	public String[] tblSupplierPriceAhead = new String[] { "Renewal Flag","Max Days","Max Start Date (DD/MM/YYYY)","Product","Actions" };
	public String[] arrTblLabelsSupplierPriceAhead = new String[5];

	public void SupplierPriceAhead_ColumnVerification() {
		for(int i = 0 ; i < arrTblLabelsSupplierPriceAhead.length ; i++) {
			arrTblLabelsSupplierPriceAhead[i] = _webDriverHandler.byXpath("//table[@id='tblSupplierPriceAhead']/thead/tr/th[" + (i + 1) + "]").getText();
			if(tblSupplierPriceAhead[i].equals(arrTblLabelsSupplierPriceAhead[i]))
			{
				System.out.println("Column names are matched");
			}			 
		}
	}

	public void selectSettings() throws InterruptedException {
		waitLoad();
		buttonSettings.click();
		waitLoad();
		linkSupplierPriceAhead.click();		
	}

	public void SupplierPriceAhead_addNewRow(int RenewalFlag, int MaxDays, String MaxStartDate, String product) throws InterruptedException
	{		
		waitLoad();
		buttonAddNewRow.waitClickable(10,100).click();
		DDsupplierPriceaheadRenewalFlag.selectByValue("1");
		txtBoxsupplierPriceaheadmaxDays.clear().sendKeys(MaxDays+"");
		calendarsupplierPriceaheadMaxStartDate.clear().sendKeys(MaxStartDate).sendKeys(Keys.ESCAPE);
		DDsupplierPriceaheadProduct.selectByText(product);
		btnAdd.waitClickable(10,100).click();
		waitLoad();
		btnOk.waitClickable().click();
	}

	public void SupplierPriceAhead_Validations(int RenewalFlag, String MaxDays, String MaxStartDate, String product) throws InterruptedException
	{
		waitLoad();
		buttonAddNewRow.waitClickable(10,100).click();
		DDsupplierPriceaheadRenewalFlag.selectByValue("1");
		txtBoxsupplierPriceaheadmaxDays.clear().sendKeys(MaxDays+"");
		calendarsupplierPriceaheadMaxStartDate.clear().sendKeys(MaxStartDate).sendKeys(Keys.ESCAPE);
		DDsupplierPriceaheadProduct.selectByText(product);
		btnAdd.waitClickable(10,100).click();
	}

	public void blankAddNewRow() throws InterruptedException {
		waitLoad();
		buttonAddNewRow.waitClickable(10,100).click();
		DDsupplierPriceaheadRenewalFlag.selectByValue("1");
		txtBoxsupplierPriceaheadmaxDays.clear();
		calendarsupplierPriceaheadMaxStartDate.clear().sendKeys(Keys.ESCAPE);
		waitLoad();
		btnAdd.waitClickable(10,100).click();
	}
	public void SupplierPriceAhead_RangeValidation() {		
		Assert.assertTrue(strRangeMaxDays.equalsIgnoreCase(maxDays.getText()));
		System.out.println("Mandatory Validation for Max days are Passed");	
	}
	public void SupplierPriceAhead_NumericValidation() {		
		Assert.assertTrue(strNumericMaxDays.equalsIgnoreCase(maxDays.getText()));
		System.out.println("Mandatory Validation for Max days are Passed");	
	}
	public void SupplierPriceAhead_MandatoryValidation() {
		Assert.assertTrue(strMandatoryMaxDays.equalsIgnoreCase(maxDays.getText())); 
		System.out.println("Max days is Mandatory fields on Supplier Price Ahead on the Screen");
	}

	public void waitLoad() {
		_webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
	}
}
