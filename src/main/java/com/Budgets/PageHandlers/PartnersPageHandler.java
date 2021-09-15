
package com.Budgets.PageHandlers;

import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;

import java.nio.file.Paths;
import java.util.Properties;

public class PartnersPageHandler {

	String appendDate = TimeStampPageHandler.AppendTimeStamp();
	private WebDriverHandler _webDriverHandler;
	private Properties _prop;

	public PartnersPageHandler(WebDriverHandler webDriverHandler, Properties prop) {
		_webDriverHandler = webDriverHandler;
		_prop = prop;
	}

	// public void createCustomer(String name, String crmId, String crmInstance,
	// String notes)
	public void createPartner() {
		_webDriverHandler.byId("btnNewPartner").waitClickable().clickrepeat();
		_webDriverHandler.byId("Name").sendKeys("Automation Customer:" + appendDate);
		_webDriverHandler.byId(_prop.getProperty("CRMID")).sendKeys("Automation CRMId:" + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("CRMInstancePartner")).selectByValue("Sugar Corportate");
		_webDriverHandler.byXpath(_prop.getProperty("BusinessPartnerType")).selectByValue("1");
		_webDriverHandler.byXpath(_prop.getProperty("Save")).waitClickable().click();
	}

	public void createPartner(String logoFormat) {
		_webDriverHandler.byId("btnNewPartner").waitClickable().clickrepeat();
		_webDriverHandler.byId("Name").sendKeys("Automation Customer:" + appendDate);
		_webDriverHandler.byId(_prop.getProperty("CRMID")).sendKeys("Automation CRMId:" + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("CRMInstancePartner")).selectByValue("Sugar Corportate");
		_webDriverHandler.byXpath(_prop.getProperty("BusinessPartnerType")).selectByValue("1");
		String filepath = logoUpload(logoFormat);
		try {
			_webDriverHandler.byId("LogoFile").sendKeys(filepath);
		} catch (Exception e) {
			System.out.println("Only file type with extension gif, png, jpg, jpeg are allowed. \n New Partner is being created without a logo.");
		}
		_webDriverHandler.byXpath(_prop.getProperty("Save")).waitClickable().click();
	}

	public String logoUpload(String logoFormat) {
		String filepath = null;
		switch (logoFormat) {
			case "jpg" :
				System.out.println("Uploading a JPG file.");
				String fileJpg = Paths.get(_prop.getProperty("logoJpg")).toAbsolutePath().toString();
				filepath = fileJpg;
				break;
			case "png" :
				System.out.println("Uploading a PNG file.");
				String filePng = Paths.get(_prop.getProperty("logoPng")).toAbsolutePath().toString();
				filepath = filePng;
				break;
			case "gif" :
				System.out.println("Uploading a GIF file.");
				String fileGif = Paths.get(_prop.getProperty("logoGif")).toAbsolutePath().toString();
				filepath = fileGif;
				break;
			case "jpeg" :
				System.out.println("Uploading a JPEG file.");
				String fileJpeg = Paths.get(_prop.getProperty("logoJpeg")).toAbsolutePath().toString();
				filepath = fileJpeg;
				break;
			default :
				System.out.println("Please provide correct file format: \n");
		}
		return filepath;
	}

	public void validateImage() {
		if (_webDriverHandler.byXpath(_prop.getProperty("InfoPageLogo")).isDisplayed()) {
			System.out.println("Logo is Uploaded");
		} else {
			System.out.println("Logo is Missing");
		}
	}

	public void deleteLogo() {
		_webDriverHandler.byXpath(_prop.getProperty("DeleteLogo")).click();
	}

	public void replaceLogo(String logoFormat) {
		String filepath = logoUpload(logoFormat);
		try {
			_webDriverHandler.byId("LogoFile").sendKeys(filepath);
		} catch (Exception e) {
			System.out.println("Only file type with extension gif, png, jpg, jpeg are allowed. \n Partner is being saved without a logo.");
		}
		_webDriverHandler.byXpath(_prop.getProperty("Save")).waitClickable().click();
		_webDriverHandler.byXpath(_prop.getProperty("OkInformation")).waitClickable().click();
	}

	public void selectCustomerByIndex(int pageNumber, int recordNumber) {
		// Page numbers and index don't work yet
		// This needs to be handled in the future
	}

	public void selectFirstPartner() {
		_webDriverHandler.byXpath(_prop.getProperty("searchTxtBox")).sendKeys("Automation");
		waitLoad();
		_webDriverHandler.byXpath(_prop.getProperty("FirstPartner")).waitClickable().click();
	}

	public void filterCustomers(String filterText) {
		// _webDriverHandler.byXpath(_prop.getProperty("searchTxtBox")).sendKeys(filterText);
		// waitLoad();
	}

	public void waitLoad() {
		_webDriverHandler.byXpath(_prop.getProperty("Overlay")).waitVisible().waitInvisible();	
	}
}