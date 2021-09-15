package com.Pricecast.Quotes.Power;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.PowerQuote;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC01_PowerQuoteFlow extends AbstractTestNg {
    public PR163_TC01_PowerQuoteFlow() throws IOException {
    }

    @Test
    public void AddNewPowerQuote_Success() throws InterruptedException {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerQuote("1610027670402", 3, 123, "456", 15000, "British Gas");
        powerQuote.quoteSelection();
        powerQuote.excelFileDownload();
        powerQuote.pdfFileDownload();
    }

    @Test
    public void AddNewPowerQuote_MandatoryValidation() {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerQuoteMandatoryValidation();
        powerQuote.powerQuote_MandatoryValidation();
    }

    @Test
    public void AddNewPowerQuote_Validation() {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerValidation();
    }

    @Test
    public void AddNewPowerQuote_AddUserDefinedQuotesCurrent() throws InterruptedException {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerQuote("1610027670402", 3, 123, "456", 15000, "British Gas");
        powerQuote.quoteSelectionUserDefinedQuotes();
        powerQuote.addUserDefinedQuote("Current", 5, "Day", "Night", 5, 6, 40, 60, 23);
    }

    @Test
    public void AddNewPowerQuote_AddUserDefinedQuotesRenewal() throws InterruptedException {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerQuote("1610027670402", 3, 123, "456", 15000, "British Gas");
        powerQuote.quoteSelectionUserDefinedQuotes();
        powerQuote.addUserDefinedQuote("Renewal", 5, "Day", "Night", 5, 6, 40, 60, 23);
    }

    @Test
    public void AddNewPowerQuote_AddUserDefinedQuotesDeemed() throws InterruptedException {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerQuote("1610027670402", 3, 123, "456", 15000, "British Gas");
        powerQuote.quoteSelectionUserDefinedQuotes();
        powerQuote.addUserDefinedQuote("Deemed", 5, "Day", "Night", 5, 6, 40, 60, 23);
    }

    @Test
    public void AddNewPowerQuote_AddUserDefinedQuotesBrokerBespoke() throws InterruptedException {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerQuote("1610027670402", 3, 123, "456", 15000, "British Gas");
        powerQuote.quoteSelectionUserDefinedQuotes();
        powerQuote.addUserDefinedQuoteBespoke("Broker Bespoke", "Axis", 5, "Day", "Night", 5, 6, 40, 60, 12, 23, 15);
    }

    @Test
    public void AddNewPowerQuote_AddUserDefinedQuotesCustomerOther() throws InterruptedException {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerQuote("1610027670402", 3, 123, "456", 15000, "British Gas");
        powerQuote.quoteSelectionUserDefinedQuotes();
        powerQuote.addUserDefinedQuoteCustomer("Customer Other", "British Gas", 5, "Day", "Night", 5, 6, 40, 60, 13);
    }

    @Test
    public void AddNewPowerQuote_QuoteComparisonCurrent() throws InterruptedException {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerQuote("1610027670402", 3, 123, "456", 15000, "British Gas");
        powerQuote.quoteSelectionUserDefinedQuotes();
        powerQuote.addUserDefinedQuote("Current", 5, "Day", "Night", 5, 6, 40, 60, 23);
        powerQuote.quoteComparison();
    }

    @Test
    public void AddNewPowerQuote_QuoteComparisonRenewal() throws InterruptedException {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerQuote("1610027670402", 3, 123, "456", 15000, "British Gas");
        powerQuote.quoteSelectionUserDefinedQuotes();
        powerQuote.addUserDefinedQuote("Renewal", 5, "Day", "Night", 5, 6, 40, 60, 23);
        powerQuote.quoteComparison();
    }

    @Test
    public void AddNewPowerQuote_QuoteComparisonDeemed() throws InterruptedException {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerQuote("1610027670402", 3, 123, "456", 15000, "British Gas");
        powerQuote.quoteSelectionUserDefinedQuotes();
        powerQuote.addUserDefinedQuote("Deemed", 5, "Day", "Night", 5, 6, 40, 60, 23);
        powerQuote.quoteComparison();
    }

    @Test
    public void AddNewPowerQuote_QuoteComparisonCustomerOther() throws InterruptedException {
        PowerQuote powerQuote = new PowerQuote(webDriverHandler);
        powerQuote.AddNewPowerQuote("1610027670402", 3, 123, "456", 15000, "British Gas");
        powerQuote.quoteSelectionUserDefinedQuotes();
        powerQuote.addUserDefinedQuoteCustomer("Customer Other", "British Gas", 5, "Day", "Night", 5, 6, 40, 60, 13);
        powerQuote.quoteComparison();
    }
}
