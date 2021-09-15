package com.Pricecast.PageObjects.Tariffs;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.nio.file.Paths;
import java.util.Properties;

public class Tariff {
	Properties prop;
	WebDriverHandler _webDriverHandler;

	ElementHandler supplyType;
	ElementHandler supplier;
	ElementHandler linkTariff;
	ElementHandler btnUploadNewSheet;
	ElementHandler searchBox;
	ElementHandler ddTariffType;
	ElementHandler ddSheetType;
	ElementHandler calendarStartDate;
	ElementHandler calendarWindowStart;
	ElementHandler calendarWindowEnd;
	ElementHandler btnUpload;
	ElementHandler btnCancel;
	ElementHandler btnchooseFile;
	ElementHandler btnOk;
	ElementHandler headerTariffPopup;
	ElementHandler statusGas;
	ElementHandler statusPower;
	ElementHandler status;
	ElementHandler delete;
	ElementHandler btnDltYes;

public Tariff (WebDriverHandler webDriverHandler) {
	_webDriverHandler = webDriverHandler;
	supplyType = _webDriverHandler.byXpath("//*[@id='ddlEnergyType1']");
	supplier = _webDriverHandler.byXpath("//*[@id='ddlSupplier1']");
	linkTariff = _webDriverHandler.byXpath("//a[contains(text(),'Tariff')]");
	btnUploadNewSheet = _webDriverHandler.byXpath("//*[@id='btnUploadTariff']");
	ddTariffType = _webDriverHandler.byXpath("//*[@id='ddlRenewalFlag1']");
	ddSheetType = _webDriverHandler.byXpath("//*[@id='ddlSheetType1']");
	calendarStartDate = _webDriverHandler.byXpath("//*[@id='txtStartDate1']");
	calendarWindowStart = _webDriverHandler.byXpath("//*[@id='txtWindowStart1']");
	calendarWindowEnd = _webDriverHandler.byXpath("//*[@id='txtWindowEnd1']");
	btnUpload = _webDriverHandler.byXpath("(//button[@type='submit'])[2]");
	btnCancel = _webDriverHandler.byXpath("(//*[contains(text(),'Cancel')])[2]");
	btnchooseFile = _webDriverHandler.byXpath("//*[@id='txtTariffSheet']");
	headerTariffPopup = _webDriverHandler.byXpath("//*[contains(text(),'Upload Tariff Sheet')]");
	btnOk = _webDriverHandler.byXpath("//button[contains(text(),'OK')]");
	searchBox = _webDriverHandler.byXpath("//input[@type='search']");
	status = _webDriverHandler.byXpath("(//*[@id='tblTariffs']//tr//a)[2]");
	statusGas = _webDriverHandler.byXpath("(//*[@id='tblTariffs']//tr[td/text()='Gas']//a)[2]");
	statusPower = _webDriverHandler.byXpath("(//*[@id='tblTariffs']//tr[td/text()='Power']//a)[2]"); ////*[@id = 'tblTariffs']//tr[td/text()='Gas']//a[@onclick='reuploadTariff']
	delete = _webDriverHandler.byXpath("//*[@title='Delete']");
	btnDltYes = _webDriverHandler.byXpath("//button[contains(text(),'Yes')]");
}

	public String[] tblTariff = new String[] {"File Name", "File Date", "Supplier", "Tariffs used for", "Supply Type", "Start Date", "Window Type", "Window Start", "Window End", "Sheet Type", "Status", "Delete"};
	public  String[] arrTariff = new String[12];

	public void TariffAccess(){
		waitLoad();
		linkTariff.waitClickable().click();
	}

	public void TariffColumnVerification() {
		for(int i = 0 ; i < arrTariff.length ; i++) {
			arrTariff[i] = _webDriverHandler.byXpath("//table[@id='tblTariffs']/thead/tr/th[" + (i + 1) + "]").getText();
			if(!(tblTariff[i].equals(arrTariff[i])))
			{
				Assert.	fail("\nColumn names do not match.");
			}
		}
		System.out.println("\nColumn names match.");
	}

	public void verifySorting(){
		for(int i = 0 ; i < arrTariff.length ; i++) {
			_webDriverHandler.byXpath("//table[@id='tblTariffs']/thead/tr/th[" + (i + 1) + "]").click();
			System.out.println("Sorting is available for " +_webDriverHandler.byXpath("//table[@id='tblTariffs']/thead/tr/th[" + (i + 1) + "]").getText()+ " column.");
		}
	}

	public void search(String term){
		searchBox.clear().sendKeys(term);
	}

	public void fileUpload(String path) {
		btnchooseFile.sendKeys(path);
	}

	public String statusCheck(){
		String statusCheck = status.waitClickable().getText();
		return statusCheck;
	}

	public void reprocessTariff(String Utility, String Filename){
		waitLoad();
		search(Filename);
		if(Utility=="Gas"){
			statusGas.waitClickable().staleElementHandler().click();
		}
		else {
			statusPower.waitClickable().staleElementHandler().click();
		}
	}

	public void deleteTariff(String Filename){
		search(Filename);
		try{waitProcessing();
		waitProcessing();}
		catch (Exception e){
			System.out.println(""+e);
		}
		delete.waitVisible().waitClickable().click();
		btnDltYes.waitVisible().waitClickable().click();
	}
	
	public void UploadNewSheet(String filePath, String Utility, String Supplier, String TariffType, String SheetType, String StartDate, String WindowStart, String WindowEnd) {
		waitLoad();
		btnUploadNewSheet.waitClickable().click();
		String path = Paths.get(filePath).toAbsolutePath().toString();
		fileUpload(path);
		waitLoad();
		supplyType.selectByText(Utility);
		supplier.selectByText(Supplier);
		waitLoad();
		ddTariffType.selectByText(TariffType);
		ddSheetType.selectByText(SheetType);
		calendarStartDate.clear().sendKeys(StartDate);
		calendarWindowStart.sendKeys(WindowStart);
		calendarWindowEnd.sendKeys(WindowEnd).sendKeys(Keys.ESCAPE);
		btnUpload.waitClickable().click();
		String strErrortext = _webDriverHandler.byId("swal2-content").waitVisible().getText();
		Assert.assertEquals(strErrortext, "Successful");
		btnOk.waitClickable().click();
	}

	public void UploadSheetsExcel (String FileName, String Utility, String Supplier, String TariffType, String SheetType, String StartDate, String WindowStart, String WindowEnd) {
		btnUploadNewSheet.waitClickable().click();
		String path = Paths.get("PricecastTestData\\Tariff\\"+Utility+"\\"+FileName).toAbsolutePath().toString();
		fileUpload(path);
		waitLoad();
		supplyType.selectByText(Utility);
		supplier.selectByText(Supplier);
		waitLoad();
		ddTariffType.selectByText(TariffType);
		if(SheetType=="")
		{ddSheetType.selectByIndex(1);}
		else
		{ddSheetType.selectByText(SheetType);}
		calendarStartDate.clear().sendKeys(StartDate);
		calendarWindowStart.sendKeys(WindowStart);
		calendarWindowEnd.sendKeys(WindowEnd).sendKeys(Keys.ESCAPE);
		btnUpload.waitClickable().click();
		String strErrortext = _webDriverHandler.byId("swal2-content").waitVisible().getText();
		Assert.assertEquals(strErrortext, "Successful");
		btnOk.waitClickable().click();
	}

	public void DuplicateUpload(String filePath, String Utility, String Supplier, String TariffType, String SheetType, String StartDate, String WindowStart, String WindowEnd) throws InterruptedException {
		UploadNewSheet(filePath, Utility, Supplier, TariffType, SheetType, StartDate, WindowStart, WindowEnd);
		String pathDup = Paths.get(filePath).toAbsolutePath().toString();
		btnUploadNewSheet.waitClickable().click();
		Thread.sleep(2000);
		fileUpload(pathDup);
		waitLoad();
		supplyType.selectByText(Utility);
		supplier.selectByText(Supplier);
		waitLoad();
		ddTariffType.selectByText(TariffType);
		ddSheetType.selectByText(SheetType);
		calendarStartDate.clear().sendKeys(StartDate);
		calendarWindowStart.sendKeys(WindowStart);
		calendarWindowEnd.sendKeys(WindowEnd).sendKeys(Keys.ESCAPE);
		btnUpload.waitClickable().click();
		String strErrortext = _webDriverHandler.byId("swal2-content").waitVisible().getText();
		System.out.println("**********************************\n" + "Error message is: \n"
				+ strErrortext + "\n");
		btnOk.waitClickable().click();
		btnCancel.waitClickable().click();
	}

	public void waitProcessing() {
		_webDriverHandler.byXpath("//*[@id='tblTariffs_processing']").waitVisible().waitInvisible();
	}
	public void waitLoad() {
		_webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
	}
}
