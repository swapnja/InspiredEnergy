package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.BrokerAccount;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC01_Verify_Broker_Account_Screen extends AbstractTestNg {
	public PR163_TC01_Verify_Broker_Account_Screen() throws IOException {
	}

	@Test
	public void BrokerAccount_Success() throws InterruptedException {
		BrokerAccount BA =  new BrokerAccount(webDriverHandler);
		BA.formFillup(
			"Gas Quotation Analysis [first_name] [last_name] [email] [phone] ",
			"Prices Are Subject To Change If There Is A Change In Wholesale Market Prices.",
			"Electricity Quotation Analysis [first_name] [last_name] [email] [phone]",
			"Prices Are Subject To Change If There Is A Change In Wholesale Market Prices.",
			"1.5",
			"15.15"
		);
		System.out.println("Broker Account functionality is working fine: BrokerAccount_Positive");
	}
	@Test
	public void BrokerAccount_RangeValidation() throws InterruptedException {
		BrokerAccount BA =  new BrokerAccount(webDriverHandler);
		BA.formFillup(
				"Gas Quotation Analysis [first_name] [last_name] [email] [phone] ",
				"Prices Are Subject To Change If There Is A Change In Wholesale Market Prices.",
				"Electricity Quotation Analysis [first_name] [last_name] [email] [phone]",
				"Prices Are Subject To Change If There Is A Change In Wholesale Market Prices.",
				"222222222222222221",
				"1111111111111111122211111"
			);		
		BA.BrokerAccount_RangeValidation();
		System.out.println("Broker Account functionality is working fine: BrokerAccount_RangeValidation");
	}

	@Test
	public void BrokerAccount_MandatoryValidations() throws InterruptedException {
	BrokerAccount BA =  new BrokerAccount(webDriverHandler);
		BA.formFillup(
				"Gas Quotation Analysis [first_name] [last_name] [email] [phone] ",
				"Prices Are Subject To Change If There Is A Change In Wholesale Market Prices.",
				"Electricity Quotation Analysis [first_name] [last_name] [email] [phone]",
				"Prices Are Subject To Change If There Is A Change In Wholesale Market Prices.",
				"15115151551515151551515157",
				"21522222122222522266777755"
			);
		BA.BrokerAccount_MandatoryValidation();
	}
	
	@Test
	public void BrokerAccount_NumericValidations() throws Exception {
	BrokerAccount BA =  new BrokerAccount(webDriverHandler);
		BA.formFillup(
				"Gas Quotation Analysis [first_name] [last_name] [email] [phone] ",
				"Prices Are Subject To Change If There Is A Change In Wholesale Market Prices.",
				"Electricity Quotation Analysis [first_name] [last_name] [email] [phone]",
				"Prices Are Subject To Change If There Is A Change In Wholesale Market Prices.",
				"15115151551515151551515157",
				"21522222122222522266777755"
		);
		BA.BrokerAccount_NumericValidation();
	}
/*
	@Test
	public void BrokerAccount_DefaultValidations() throws IOException {
	WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
	BrokerAccount BA =  new BrokerAccount(webDriverHandler);

	}*/

}