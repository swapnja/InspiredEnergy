
package com.Budgets.PageHandlers;

import com.Base.SeleniumHandlers.WebDriverHandler;
import com.Base.TimeStampPageHandler;
import org.openqa.selenium.Keys;

import java.nio.file.Paths;
import java.util.Properties;

public class CommonPageHandler {

	String appendDate = TimeStampPageHandler.AppendTimeStamp();
	private WebDriverHandler _webDriverHandler;
	private Properties _prop;

	public CommonPageHandler(WebDriverHandler webDriverHandler, Properties prop) {
		_webDriverHandler = webDriverHandler;
		_prop = prop;
	}

	public void createBudgetMonthlyElectricity() {
		_webDriverHandler.byXpath(_prop.getProperty("NewBudget")).waitClickable().clickrepeat();
		_webDriverHandler.byXpath(_prop.getProperty("BudgetReference")).sendKeys("NewBudget " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetStartDate")).sendKeys("01/09/2018").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetEndDate")).sendKeys("31/08/2019").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("CalendarOutput")).selectByValue("Monthly");
		_webDriverHandler.byId(_prop.getProperty("Notes")).sendKeys("Automation Notes " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("Save")).waitClickable().click();
	}

	public void createBudgetVATElectricity() {
		_webDriverHandler.byXpath(_prop.getProperty("NewBudget")).waitClickable().clickrepeat();
		_webDriverHandler.byXpath(_prop.getProperty("BudgetReference")).sendKeys("NewBudget " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetStartDate")).sendKeys("01/09/2018").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetEndDate")).sendKeys("31/08/2019").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("CalendarOutput")).selectByValue("Monthly");
		_webDriverHandler.byXpath(_prop.getProperty("VATToggle")).click();
		_webDriverHandler.byId(_prop.getProperty("Notes")).sendKeys("Automation Notes " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("Save")).waitClickable().click();
	}
	
	public void createBudgetCustomElectricity() {
	
		_webDriverHandler.byXpath(_prop.getProperty("NewBudget")).waitClickable().clickrepeat();
		_webDriverHandler.byXpath(_prop.getProperty("BudgetReference")).sendKeys("NewBudget " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetStartDate")).sendKeys("01/09/2018").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetEndDate")).sendKeys("31/08/2019").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("CalendarOutput")).selectByValue("4-4-5");
		String CustomCalenderPath = Paths.get("BudgetTestData/CustomCalendar/CustomerCalendarValid.xlsx").toAbsolutePath().toString();
		_webDriverHandler.byXpath(_prop.getProperty("CustomCalender")).sendKeys(CustomCalenderPath);
		_webDriverHandler.byId(_prop.getProperty("Notes")).sendKeys("Automation Notes " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("Save")).waitClickable().click();
	}

	public void createBudgetMonthlyGas() {
		_webDriverHandler.byXpath(_prop.getProperty("NewBudget")).waitClickable().clickrepeat();
		_webDriverHandler.byId(_prop.getProperty("UtilityType")).selectByValue("1");
		_webDriverHandler.byXpath(_prop.getProperty("BudgetReference")).sendKeys("NewBudget " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetStartDate")).sendKeys("01/04/2019").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetEndDate")).sendKeys("31/03/2020").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("CalendarOutput")).selectByValue("Monthly");
		_webDriverHandler.byId(_prop.getProperty("Notes")).sendKeys("Automation Notes " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("Save")).waitClickable().click();
	}

	public void createBudgetVATGas() {
		_webDriverHandler.byXpath(_prop.getProperty("NewBudget")).waitClickable().clickrepeat();
		_webDriverHandler.byId(_prop.getProperty("UtilityType")).selectByValue("1");
		_webDriverHandler.byXpath(_prop.getProperty("BudgetReference")).sendKeys("NewBudget " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetStartDate")).sendKeys("01/04/2019").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetEndDate")).sendKeys("31/03/2020").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("CalendarOutput")).selectByValue("Monthly");
		_webDriverHandler.byXpath(_prop.getProperty("VATToggle")).click();
		_webDriverHandler.byId(_prop.getProperty("Notes")).sendKeys("Automation Notes " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("Save")).waitClickable().click();
	}
	
	public void createBudgetCustomGas() {
		_webDriverHandler.byXpath(_prop.getProperty("NewBudget")).waitClickable().clickrepeat();
		_webDriverHandler.byId(_prop.getProperty("UtilityType")).selectByValue("1");
		_webDriverHandler.byXpath(_prop.getProperty("BudgetReference")).sendKeys("NewBudget " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetStartDate")).sendKeys("01/09/2019").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("BudgetEndDate")).sendKeys("31/08/2020").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("CalendarOutput")).selectByValue("4-4-5");
		String CustomCalenderPath = Paths.get("BudgetTestData/CustomCalendar/CustomerCalendarValid.xlsx").toAbsolutePath().toString();
		_webDriverHandler.byXpath(_prop.getProperty("CustomCalender")).sendKeys(CustomCalenderPath);;
		_webDriverHandler.byId(_prop.getProperty("Notes")).sendKeys("Automation Notes " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("Save")).waitClickable().click();
	}

	public void createManualBudget(String utility, String meterCount, String cost) {
		_webDriverHandler.byXpath(_prop.getProperty("AddExisting")).waitClickable().clickrepeat();
		_webDriverHandler.byXpath(_prop.getProperty("ExistingUtilityType")).selectByText(utility);
		_webDriverHandler.byXpath(_prop.getProperty("ExistingReference")).sendKeys("NewBudget " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("ExistingStartDate")).sendKeys("01/09/2019").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("ExistingEndDate")).sendKeys("31/08/2020").sendKeys(Keys.ESCAPE);
		_webDriverHandler.byXpath(_prop.getProperty("No.Meters")).sendKeys(meterCount);
		_webDriverHandler.byXpath(_prop.getProperty("TotalCost")).sendKeys(cost);
		String ExistingBudgetPath = Paths.get("BudgetTestData/CustomCalendar/CustomerCalendarValid.xlsx").toAbsolutePath().toString();
		_webDriverHandler.byXpath(_prop.getProperty("UploadBudget")).sendKeys(ExistingBudgetPath);;
		_webDriverHandler.byXpath(_prop.getProperty("ExistingNote")).sendKeys("Automation Notes " + appendDate);
		_webDriverHandler.byXpath(_prop.getProperty("ExistingSave")).waitClickable().click();
		_webDriverHandler.byXpath(_prop.getProperty("OkInformation")).waitClickable().click();
	}

	public void selectFirstBudgetElectricity() {
		_webDriverHandler.byXpath(_prop.getProperty("CreateBudgetElectricity")).waitClickable(15, 100).click();
	}

	public void selectFirstBudgetGas() {
		_webDriverHandler.byXpath(_prop.getProperty("sortByGas")).click().click();
		
		_webDriverHandler.byXpath(_prop.getProperty("CreateBudgetGas")).waitClickable(15, 100).click();
	}

	public void filterBudgets(String filterText) {
		_webDriverHandler.byXpath(_prop.getProperty("searchTxtBox")).sendKeys(filterText);
		waitLoad();
	}

	public void waitLoad() {
		_webDriverHandler.byXpath(_prop.getProperty("Overlay")).waitVisible(10,100).waitInvisible(10, 100);

	}

}