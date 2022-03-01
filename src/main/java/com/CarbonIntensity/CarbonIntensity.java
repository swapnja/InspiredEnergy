package com.CarbonIntensity;

import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CarbonIntensity {
    WebDriverHandler _webDriverHandler;
    ElementHandler cardHeaderGM;
    ElementHandler pieChartGM;
    ElementHandler pieLegendGM;
    ElementHandler cardHeaderCI;
    ElementHandler tableCI;
    ElementHandler cardHeaderRD;
    ElementHandler graphChartRD;
    ElementHandler graphLegendRD;
    ElementHandler cardHeaderCInt;
    ElementHandler graphChartCInt;
    ElementHandler graphLegendCInt;
    ElementHandler cardHeaderSmallCInt;
    ElementHandler dataTableGM;
    ElementHandler cardHeaderTD;
    ElementHandler graphChartTD;
    ElementHandler graphLegendTD;
    ElementHandler btnGetInTouch;
    ElementHandler lastUpdateCI;
    ElementHandler lastUpdateTD;
    ElementHandler footerMessage;
    ElementHandler modalHeaderCI;
    ElementHandler ddRegionModalCI;
    ElementHandler modalChartCI;
    ElementHandler modalLegendCI;
    ElementHandler defaultRegion;
    ElementHandler getInTouchMessage;
    ElementHandler btnOk;

    public CarbonIntensity(WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        cardHeaderGM = _webDriverHandler.byXpath("//h4[contains (text(), 'GB Generation Mix')]");
        pieChartGM = _webDriverHandler.byXpath("//*[@id='intesityPieChart']");
        pieLegendGM = _webDriverHandler.byXpath("//*[@id='intesityPieChartLegend']");
        cardHeaderCI = _webDriverHandler.byXpath("//h4[contains (text(), 'GB Carbon Index')]");
        tableCI = _webDriverHandler.byXpath("//*[@id='secCarbonImpact']");
        cardHeaderRD = _webDriverHandler.byXpath("//h4[contains (text(), 'Regional Data - Intensity Forecast and Generation Mix')]");
        graphChartRD = _webDriverHandler.byXpath("//*[@id='generationMixChart']");
        graphLegendRD = _webDriverHandler.byXpath("//*[@id='generationMixChartLegend']");
        cardHeaderCInt = _webDriverHandler.byXpath("//*[@class='card-body']//h4[contains(text(), 'GB Carbon Intensity')]");
        cardHeaderSmallCInt = _webDriverHandler.byXpath("//*[@class='card-body']//i[contains(text(), '5 DAYS PAST + 5 DAYS FUTURE')]");
        graphChartCInt = _webDriverHandler.byXpath("//*[@id='pastFutureIntensityChart']");
        graphLegendCInt = _webDriverHandler.byXpath("//*[@id='pastFutureIntensityChartLegend']");
        dataTableGM = _webDriverHandler.byXpath("//div[contains(@class, 'generationMix')]");
        cardHeaderTD = _webDriverHandler.byXpath("//h4[contains (text(), 'Temperature Data')]");
        graphChartTD = _webDriverHandler.byXpath("//*[@id='generationMixChart']");
        graphLegendTD = _webDriverHandler.byXpath("//*[@id='generationMixChartLegend']");
        btnGetInTouch = _webDriverHandler.byXpath("//*[@id='btnGetInTouch']");
        lastUpdateCI = _webDriverHandler.byXpath("//*[contains(@class, 'last-update')]//i[contains(text(), 'Last Update')]");
        lastUpdateTD = _webDriverHandler.byXpath("//div[h4]//i[contains(text(), 'Last Update')]");
        footerMessage = _webDriverHandler.byXpath("//div[@class='row mt-4']//div[@class='col-12 text-center']");
        modalHeaderCI = _webDriverHandler.byXpath("//*[@class='modal-header']//h5");
        ddRegionModalCI = _webDriverHandler.byXpath("//*[@id='regionDropDown']");
        modalChartCI = _webDriverHandler.byXpath("//*[@id='regionInsightCanvas']");
        modalLegendCI = _webDriverHandler.byXpath("//*[@id='legends']");
        defaultRegion = _webDriverHandler.byXpath("//*[@id='regionDropDown']/option[1]");
        getInTouchMessage = _webDriverHandler.byXpath("//*[@id='swal2-content']");
        btnOk = _webDriverHandler.byXpath("//button[text() = 'OK']");
    }

    public void loadGM() {
        if (cardHeaderGM.isDisplayed() && pieChartGM.isDisplayed() && pieLegendGM.isDisplayed()) {
            System.out.println("GB Generation Mix card is loaded properly.");
        } else {
            Assert.fail("GB Generation Mix card is not present.");
        }
    }

    public void loadCI() {
        if (cardHeaderCI.isDisplayed() && tableCI.isDisplayed()) {
            System.out.println("GB Carbon Index card is loaded properly.");
        } else {
            Assert.fail("GB Carbon Index card is not present.");
        }
    }

    public void loadRD() {
        if (cardHeaderRD.isDisplayed() && graphChartRD.isDisplayed() && graphLegendRD.isDisplayed()) {
            System.out.println("Regional Data card is loaded properly.");
        } else {
            Assert.fail("Regional Data card is not present.");
        }
    }

    public void loadCInt() {
        if (cardHeaderCInt.isDisplayed() && cardHeaderSmallCInt.isDisplayed() && graphChartCInt.isDisplayed() && graphLegendCInt.isDisplayed()) {
            System.out.println("GB Carbon Intensity trend card is loaded properly.");
        } else {
            Assert.fail("GB Carbon Intensity trend card is not present.");
        }
    }

    public void loadTD() {
        if (cardHeaderTD.isDisplayed() && graphChartTD.isDisplayed() && graphLegendTD.isDisplayed()) {
            System.out.println("Temperature Data card is loaded properly.");
        } else {
            Assert.fail("Temperature Data card is not present.");
        }
    }

    public void loadPage() {
        if (dataTableGM.isDisplayed() && lastUpdateCI.isDisplayed() && lastUpdateTD.isDisplayed() && btnGetInTouch.isDisplayed() && footerMessage.isDisplayed()) {
            System.out.println("All other functionality are loaded properly.");
        } else {
            Assert.fail("All functionality are not loaded properly.");
        }
    }

    public void openModalCI(String cardName) throws InterruptedException {
        Thread.sleep(1000);
        if (cardName == "GB Carbon Index") {
            tableCI.waitClickable().click();
        } else if (cardName == "Regional Data") {
            graphChartRD.waitClickable().click();
        }
        waitLoad();
    }

    public void verifyModalCI() throws InterruptedException {
        openModalCI("GB Carbon Index");
        String actHeader = "Carbon Intensity";
        String getHeader = modalHeaderCI.getText();
        if (getHeader.equals(actHeader) &&
                ddRegionModalCI.isDisplayed() &&
                modalChartCI.isDisplayed() &&
                modalLegendCI.isDisplayed() &&
                defaultRegion.isSelected()) {
            System.out.println("Carbon Intensity modal is loaded properly.");
        } else {
            Assert.fail("Carbon Intensity modal is not loaded properly.");
        }
    }

    public void accessRegionalChart(String cardName, String region) throws InterruptedException {
        openModalCI(cardName);
        ddRegionModalCI.selectByText(region);
    }

    public void accessGetInTouch() {
        btnGetInTouch.scrollDown();
        do {
            btnGetInTouch.waitClickable().click();
            try {
                waitLoad();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (getInTouchMessage.notPresent());
        System.out.println(getInTouchMessage.getText());
        btnOk.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}