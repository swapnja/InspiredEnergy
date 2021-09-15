package com.Pricecast.PageObjects.BrokerSettings;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class GasSuppliers {

	WebDriverHandler _webDriverHandler;
	public GasSuppliers (WebDriverHandler webDriverHandler) {
		_webDriverHandler = webDriverHandler;
		buttonSettings = _webDriverHandler.byXpath("//*[@id='btnSetting']");
		linkGasSuppliers = _webDriverHandler.byXpath("//a[@data-action='GasSupplier']");
		searchBox = _webDriverHandler.byXpath("//input[@type='search']");
		buttonEdit = _webDriverHandler.byXpath("//*[@type='button'][@title='Edit']");
		shrtcdDD = _webDriverHandler.byXpath("//*[@id='ShortCode']");
		txtBoxQuoteComment = _webDriverHandler.byXpath("//*[@id='QuoteComment']");
		txtBoxMinUplift = _webDriverHandler.byXpath("//*[@id='MinUplift']");
		txtBoxMaxUplift = _webDriverHandler.byXpath("//*[@id='MaxUplift']");
		txtBoxUpliftIncrement = _webDriverHandler.byXpath("//*[@id='UpliftIncrement']");
		btnSave = _webDriverHandler.byXpath("//*[@type='submit']");
		btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
		matrixUploadtgl = _webDriverHandler.byXpath("(//div[@class='col-7']//label)[1]");
		matrixUploadtglCheck = _webDriverHandler.byXpath("//div[@class='col-7']//input[@id='_MatrixFlag']");
		bespokePricetgl = _webDriverHandler.byXpath("(//div[@class='col-7']//label)[2]");
		bespokePricetglCheck = _webDriverHandler.byXpath("//div[@class='col-7']//input[@id='_BespokeFlag']");
		buttonMap = _webDriverHandler.byXpath("//*[@type='button'][@title='Map']");
		buttonEditMap = _webDriverHandler.byXpath("//*[@class='fa fa-edit edit-mapping']");
		searchBoxMapping = _webDriverHandler.byXpath("//*[@id='TariffMappings_filter']//input[@type='search']");
		mappingtgl = _webDriverHandler.byXpath("//div[@class='col-7']//label");
		mappingtglCheck = _webDriverHandler.byXpath("//div[@class='col-7']//input[@id='enabled']");
		btnCancel = _webDriverHandler.byXpath("//*[@class='btn btn-sm btn-danger']"); ////*[@id='editGasSupplierForm']//button[@class='btn btn-sm btn-danger']
		msgMinUplift = _webDriverHandler.byXpath("//*[@id='MinUplift-error']");
		msgMaxUplift = _webDriverHandler.byXpath("//*[@id='MaxUplift-error']");
		msgUpliftIncrement = _webDriverHandler.byXpath("//*[@id='UpliftIncrement-error']");
		msgQuoteComment = _webDriverHandler.byXpath("//*[@id='QuoteComment-error']");
		msgShortCode = _webDriverHandler.byXpath("//*[@id='ShortCode-error']");
	}
	ElementHandler buttonSettings;
	ElementHandler linkGasSuppliers;
	ElementHandler buttonEdit;
	ElementHandler shrtcdDD;
	ElementHandler txtBoxQuoteComment;
	ElementHandler txtBoxMinUplift;
	ElementHandler txtBoxMaxUplift;
	ElementHandler txtBoxUpliftIncrement;
	ElementHandler searchBox;
	ElementHandler searchBoxMapping;
	ElementHandler btnSave;
	ElementHandler btnOk;
	ElementHandler matrixUploadtgl;
	ElementHandler matrixUploadtglCheck;
	ElementHandler bespokePricetgl;
	ElementHandler bespokePricetglCheck;
	ElementHandler mappingtgl;
	ElementHandler mappingtglCheck;
	ElementHandler buttonMap;
	ElementHandler buttonEditMap;
	ElementHandler btnCancel;
	ElementHandler msgMinUplift;
	ElementHandler msgMaxUplift;
	ElementHandler msgUpliftIncrement;
	ElementHandler msgQuoteComment;
	ElementHandler msgShortCode;

	String[] arrTblLabelsGasSuppliers = new String[8];
	String[] tblGasSuppliers = new String[] { "Supplier", "Gas Matrix Upload?", "Bespoke Gas Pricing?", "Quote Text", "Min Uplift", "Max Uplift", "Uplift Increment", "Actions" };

	String strRangeMinUplift = "Please enter a number in between 0 and 1000000000";
	String strRangeMaxUplift = "Please enter a number in between 0 and 1000000000";
	String strRangeUpliftIncrement = "Please enter a number in between 0 and 1000000000";

	String strMandatoryShortCode = "Short code field is mandatory";
	String strMandatoryQuoteComment = "Quote Comment field is mandatory";
	String strMandatoryMinUplift = "Min Uplift field is mandatory";
	String strMandatoryMaxUplift = "Max Uplift field is mandatory";
	String strMandatoryUpliftIncrement = "Uplift Increment field is mandatory";

	String strErrorMaxUplift = "The Max Uplift field should be greater than or equal to Min Uplift.";

	public void selectSettings() {
		waitLoad();
		buttonSettings.waitClickable().click();
		waitLoad();
		linkGasSuppliers.waitClickable().click();
	}

	public void columnVerification(){
		for(int i = 0 ; i < arrTblLabelsGasSuppliers.length ; i++) {
			arrTblLabelsGasSuppliers[i] = _webDriverHandler.byXpath("//table[@id='tblGasSupplier']/thead/tr/th[" + (i+1) + "]").getText();
			if(!(tblGasSuppliers[i].equals(arrTblLabelsGasSuppliers[i])))
			{
				Assert.fail("\nColumn names do not match.");
			}
		}
		System.out.println("\nColumn names match.");
	}

	public void searchSupplier(String Term){
		waitLoad();
		searchBox.clear().sendKeys(Term);
		waitLoad();
	}

	public void searchMapping(String Term){
		waitLoad();
		searchBoxMapping.sendKeys(Term);
		waitLoad();
	}

	public void toggleMatrixUpload(boolean Status){
		if(Status){
			if(!matrixUploadtglCheck.isSelected()){
				matrixUploadtgl.click();
				System.out.println("\nGas Matrix Upload is now enabled.");
			}
			else {
				System.out.println("\nGas Matrix Upload is already enabled.");
			}
		}
		else {
			if(matrixUploadtglCheck.isSelected()){
				matrixUploadtgl.click();
				System.out.println("\nGas Matrix Upload is now disabled.");
			}
			else {
				System.out.println("\nGas Matrix Upload is already disabled.");
			}
		}
	}

	public void toggleBespokePricing (boolean Status){
		if(Status){
			if(!bespokePricetglCheck.isSelected()){
				bespokePricetgl.click();
				System.out.println("\nGas Matrix Upload is now enabled.");
			}
			else {
				System.out.println("\nGas Matrix Upload is already enabled.");
			}
		}
		else {
			if(bespokePricetglCheck.isSelected()){
				bespokePricetgl.click();
				System.out.println("\nGas Matrix Upload is now disabled.");
			}
			else {
				System.out.println("\nGas Matrix Upload is already disabled.");
			}
		}
	}

	public void toggleMapping(boolean Status){
		if(Status){
			if(!mappingtglCheck.isSelected()){
				mappingtgl.click();
				System.out.println("\nThis mapping is now enabled.");
			}
			else {
				System.out.println("\nThis mapping is already enabled.");
			}
		}
		else {
			if(mappingtglCheck.isSelected()){
				mappingtgl.click();
				System.out.println("\nThis mapping is now disabled.");
			}
			else {
				System.out.println("\nThis mapping is already disabled.");
			}
		}
	}

	public void saveSupplier(){
		btnSave.waitClickable().click();
		btnOk.waitClickable().click();
	}

	public void cancelSupplier(){
		btnCancel.waitClickable().clickrepeat();
	}

	public void editSupplier (String Supplier, String ShortCode, String MNUL, String MXUL, String ULI, boolean Matrix, boolean Bespoke) {
		searchSupplier(Supplier);
		buttonEdit.waitClickable().click();
		shrtcdDD.selectByValue(ShortCode);
		txtBoxQuoteComment.clear().sendKeys("This is the Quote comment using Automation.");
		txtBoxMinUplift.clear().sendKeys(MNUL);
		txtBoxMaxUplift.clear().sendKeys(MXUL);
		txtBoxUpliftIncrement.clear().sendKeys(ULI);
		toggleMatrixUpload(Matrix);
		toggleBespokePricing(Bespoke);
		saveSupplier();
	}

	public void editSupplierNoTgl(String Supplier, String ShortCode, String QuoteTxt, String MNUL, String MXUL, String ULI) {
		searchSupplier(Supplier);
		buttonEdit.waitClickable().click();
		shrtcdDD.selectByValue(ShortCode);
		txtBoxQuoteComment.clear().sendKeys(QuoteTxt);
		txtBoxMinUplift.clear().sendKeys(MNUL);
		txtBoxMaxUplift.clear().sendKeys(MXUL);
		txtBoxUpliftIncrement.clear().sendKeys(ULI);
		btnSave.waitClickable().click();
	}

	public void mapSupplier (String Supplier, String Mapping, boolean MapStatus) {
		searchSupplier(Supplier);
		buttonMap.waitClickable().click();
		searchMapping(Mapping);
		buttonEditMap.waitClickable().click();
		toggleMapping(MapStatus);
		btnSave.waitClickable().click();
		waitLoad();
		btnOk.waitClickable().click();
		btnCancel.waitClickable().click();
	}

	public void rangeValidations(){
		Assert.assertTrue(msgMinUplift.isDisplayed() && msgMaxUplift.isDisplayed() && msgUpliftIncrement.isDisplayed());
		System.out.println("\nError messages for \"Min Uplift\", \"Max Uplift\", \"Uplift Increment\" are displayed." );
		Assert.assertEquals(msgMinUplift.getText(), strRangeMinUplift);
		Assert.assertEquals(msgMaxUplift.getText(), strRangeMaxUplift);
		Assert.assertEquals(msgUpliftIncrement.getText(), strRangeUpliftIncrement);
		System.out.println("\nRange Validation for \"Min Uplift\", \"Max Uplift\", \"Uplift Increment\" are passed.");
	}

	public void mandatoryValidations(){
		Assert.assertEquals(msgShortCode.getText(), strMandatoryShortCode);
		Assert.assertEquals(msgQuoteComment.getText(), strMandatoryQuoteComment);
		Assert.assertEquals(msgMinUplift.getText(), strMandatoryMinUplift);
		Assert.assertEquals(msgMaxUplift.getText(), strMandatoryMaxUplift);
		Assert.assertEquals(msgUpliftIncrement.getText(), strMandatoryUpliftIncrement);
		System.out.println("\nMandatory validations are passed.");
	}

	public void greaterValidation(){
		Assert.assertEquals(msgMaxUplift.getText(), strErrorMaxUplift);
		System.out.println(msgMaxUplift.getText());
	}

	public void waitLoad() {
		_webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
	}
}