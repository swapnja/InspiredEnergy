package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class SupplierDiscount {

	WebDriverHandler _webDriverHandler;
	public SupplierDiscount (WebDriverHandler webDriverHandler) {
		_webDriverHandler = webDriverHandler;
		buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
		linkSupplierDiscounts = _webDriverHandler.byXpath("//a[@data-action='SupplierDiscounts']");
		buttonAddNewRow = _webDriverHandler.byXpath("//*[@id='btnAddNewBorkerSupplierDiscounts']");
		txtBoxSupplierDiscountsMinVol = _webDriverHandler.byXpath("//*[@id='MinVol']");
		txtBoxSupplierDiscountsMaxVol = _webDriverHandler.byXpath("//*[@id='MaxVol']");
		txtBoxSupplierDiscountsDiscountValue = _webDriverHandler.byXpath("//*[@id='DiscountValue']");
		btnAdd = _webDriverHandler.byXpath("//*[@type='submit']");
		btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
		msgMinVol = _webDriverHandler.byXpath("//*[@id='MinVol-error']");
		msgMaxVol = _webDriverHandler.byXpath("//*[@id='MaxVol-error']");
		msgDiscount = _webDriverHandler.byXpath("//*[@id='DiscountValue-error']");
	}
	
	// Supplier Discount
	ElementHandler buttonSettings;
	ElementHandler linkSupplierDiscounts;
	ElementHandler buttonAddNewRow;
	ElementHandler ddSupplierDiscountsProduct;
	ElementHandler txtBoxSupplierDiscountsMaxVol;
	ElementHandler txtBoxSupplierDiscountsMinVol;
	ElementHandler txtBoxSupplierDiscountsDiscountValue;
	ElementHandler msgMinVol;
	ElementHandler msgMaxVol;
	ElementHandler msgDiscount;
	ElementHandler btnAdd;
	ElementHandler btnOk;

	String[] arrTblLabelsSupplierDiscounts = new String[5];
	String[] tblSupplierDiscounts = new String[] { "Product", "Min Volume", "Max Volume", "Discount", "Actions" };

	String strRangeMinVol = "Please enter a number in between 0 and 1000000000";
	String strRangeMaxVol = "Please enter a number in between 0 and 1000000000";
	String strRangeDiscount = "Please enter a number in between 0 and 1000000000";

	String strMandatoryMinVol = "Min Volume field is mandatory";
	String strMandatoryMaxVol = "Max Volume Field is mandatory";
	String strMandatoryDiscount = "Discount Field is mandatory";

	String strErrorMaxUplift = "The Max Volume field should be greater than or equal to Min Volume.";

	public void selectSettings() {
		waitLoad();
		buttonSettings.waitClickable().click();
		waitLoad();
		linkSupplierDiscounts.waitClickable().click();
	}

	public void addNewRow(String MinVolume, String MaxVolume, String Discount) throws InterruptedException
	{
		waitLoad();
		buttonAddNewRow.waitClickable().click();
		txtBoxSupplierDiscountsMinVol.waitClickable().clear().sendKeys(MinVolume);
		txtBoxSupplierDiscountsMaxVol.waitClickable().clear().sendKeys(MaxVolume);
		txtBoxSupplierDiscountsDiscountValue.waitClickable().clear().sendKeys(Discount);
		btnAdd.waitClickable().click();
		waitLoad();
		btnOk.waitClickable().click();
	}

	public void columnVerification(){
		for(int i = 0 ; i < arrTblLabelsSupplierDiscounts.length ; i++) {
			arrTblLabelsSupplierDiscounts[i] = _webDriverHandler.byXpath("//table[@id='tblBrokerSupplierDiscounts']/thead/tr/th[" + (i+1) + "]").getText();
			if(!(tblSupplierDiscounts[i].equals(arrTblLabelsSupplierDiscounts[i])))
			{
				Assert.fail("\nColumn names do not match.");
			}
		}
		System.out.println("\nColumn names match.");
	}

	public void addNewRowValidations(String MinVolume, String MaxVolume, String Discount) throws InterruptedException
	{
		waitLoad();
		buttonAddNewRow.waitClickable().click();
		txtBoxSupplierDiscountsMinVol.waitClickable().clear().sendKeys(MinVolume);
		txtBoxSupplierDiscountsMaxVol.waitClickable().clear().sendKeys(MaxVolume);
		txtBoxSupplierDiscountsDiscountValue.waitClickable().clear().sendKeys(Discount);
		btnAdd.waitClickable().click();
	}

	public void rangeValidations(){
		Assert.assertTrue(msgMinVol.isDisplayed() && msgMaxVol.isDisplayed() && msgDiscount.isDisplayed());
		System.out.println("\nError messages for \"Min Volume\", \"Max Volume\", \"Discount\" are displayed." );
		Assert.assertEquals(msgMinVol.getText(), strRangeMinVol);
		Assert.assertEquals(msgMaxVol.getText(), strRangeMaxVol);
		Assert.assertEquals(msgDiscount.getText(), strRangeDiscount);
		System.out.println("\nRange Validation for \"Min Volume\", \"Max Volume\", \"Discount\" are passed.");
	}

	public void mandatoryValidations(){
		Assert.assertEquals(msgMinVol.getText(), strMandatoryMinVol);
		Assert.assertEquals(msgMaxVol.getText(), strMandatoryMaxVol);
		Assert.assertEquals(msgDiscount.getText(), strMandatoryDiscount);
		System.out.println("\nMandatory validations are passed.");
	}

	public void greaterValidation(){
		Assert.assertEquals(msgMaxVol.getText(), strErrorMaxUplift);
		System.out.println(msgMaxVol.getText());
	}

	public void waitLoad() {
		_webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
	}
}