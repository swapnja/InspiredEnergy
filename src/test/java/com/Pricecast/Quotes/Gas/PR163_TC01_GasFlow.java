package com.Pricecast.Quotes.Gas;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.GasQuote;
import org.testng.annotations.Test;

import java.io.IOException;


public class PR163_TC01_GasFlow extends AbstractTestNg {
    public PR163_TC01_GasFlow() throws IOException {
    }
//done
    @Test
    public void AddNewGasQuote_Success() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuote("AQ1 2WE", 20000, "British Gas");
        gasQuote.quoteSelection();
        gasQuote.excelFileDownload();
        gasQuote.pdfFileDownload();
    }
//done
    @Test
    public void AddNewGasQuote_Validation() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuoteValidation("AAAQ1 2WE", 22222200, "British Gas");
        gasQuote.gasQuote_Validation();
    }
//done
    @Test
    public void AddNewGasQuote_MandatoryValidation() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuoteMandatoryValidation("British Gas");
        gasQuote.gasQuote_MandatoryValidation();
    }
//done
    @Test
    public void AddNewGasQuote_AddUserDefinedQuotesCurrent() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuote("AQ1 2WE", 20000, "British Gas");
        gasQuote.quoteSelectionUserDefinedQuotes();
        gasQuote.addUserDefinedQuote("Current", 5, 2, 1);
    }
//done
    @Test
    public void AddNewGasQuote_AddUserDefinedQuotesRenewal() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuote("AQ1 2WE", 20000, "British Gas");
        gasQuote.quoteSelectionUserDefinedQuotes();
        gasQuote.addUserDefinedQuote("Renewal", 5, 2, 1);
    }
//done
    @Test
    public void AddNewGasQuote_AddUserDefinedQuotesDeemed() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuote("AQ1 2WE", 20000, "British Gas");
        gasQuote.quoteSelectionUserDefinedQuotes();
        gasQuote.addUserDefinedQuote("Deemed", 5, 2, 1);
    }
//done
    @Test
    public void AddNewGasQuote_AddUserDefinedQuotesBrokerBespoke() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuote("AQ1 2WE", 20000, "British Gas");
        gasQuote.quoteSelectionUserDefinedQuotes();
        gasQuote.addUserDefinedQuoteBespoke("Broker Bespoke", "British Gas", 5, 1, 1, 2);
    }
//done
    @Test
    public void AddNewGasQuote_AddUserDefinedQuotesCustomerOther() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuote("AQ1 2WE", 20000, "British Gas");
        gasQuote.quoteSelectionUserDefinedQuotes();
        gasQuote.addUserDefinedQuoteCustomer("Customer Other", "British Gas", 5, 1, 1);
    }
//done
    @Test
    public void AddNewGasQuote_QuoteComparisonCurrent() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuote("AQ1 2WE", 20000, "British Gas");
        gasQuote.quoteSelectionUserDefinedQuotes();
        gasQuote.addUserDefinedQuote("Current", 5, 2, 1);
        gasQuote.quoteComparison();
    }
//done
    @Test
    public void AddNewGasQuote_QuoteComparisonRenewal() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuote("AQ1 2WE", 20000, "British Gas");
        gasQuote.quoteSelectionUserDefinedQuotes();
        gasQuote.addUserDefinedQuote("Renewal", 5, 2, 1);
        gasQuote.quoteComparison();
    }
//done
    @Test
    public void AddNewGasQuote_QuoteComparisonDeemed() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuote("AQ1 2WE", 20000, "British Gas");
        gasQuote.quoteSelectionUserDefinedQuotes();
        gasQuote.addUserDefinedQuote("Deemed", 5, 2, 1);
        gasQuote.quoteComparison();
    }
//done
    @Test
    public void AddNewGasQuote_QuoteComparisonCustomerOther() {
        GasQuote gasQuote = new GasQuote(webDriverHandler);
        gasQuote.addNewGasQuote("AQ1 2WE", 20000, "British Gas");
        gasQuote.quoteSelectionUserDefinedQuotes();
        gasQuote.addUserDefinedQuoteCustomer("Customer Other", "British Gas", 5, 1, 1);
        gasQuote.quoteComparison();
    }
}
