package com.Pricecast.Settings.Tests;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.BrokerSettings.BrokerStats;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC02_Verify_Broker_Stats_Screen extends AbstractTestNg {

    public PR163_TC02_Verify_Broker_Stats_Screen() throws IOException {
    }

    @Test
    public void AccessBrokerStats() {
        BrokerStats brokerStats = new BrokerStats(webDriverHandler);
        brokerStats.selectSettings();
        System.out.println("\nBroker Stats page is accessible.");
    }

    @Test
    public void BrokerStatsPageVerification() {
        BrokerStats brokerStats = new BrokerStats(webDriverHandler);
        brokerStats.selectSettings();
        brokerStats.verifyBrokerStats();
    }

    @Test
    public void showStats() {
        BrokerStats brokerStats = new BrokerStats(webDriverHandler);
        brokerStats.selectSettings();
        brokerStats.showStats("26/07/2020", "26/08/2020", true, "All");
    }
}
