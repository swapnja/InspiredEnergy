package com.CarbonIntensity;

import org.testng.annotations.Test;

import java.io.IOException;

public class PR173_TC01_CarbonIntensityy extends AbstractTestNg{

    public PR173_TC01_CarbonIntensityy() throws IOException {
    }

    @Test
    public void VerifyPage() {
        CarbonIntensity carbonIntensity = new CarbonIntensity(webDriverHandler);
        carbonIntensity.loadGM();
        carbonIntensity.loadCI();
        carbonIntensity.loadRD();
        carbonIntensity.loadCInt();
        carbonIntensity.loadTD();
        carbonIntensity.loadPage();
    }

    @Test
    public void VerifyCIModal() throws InterruptedException {
        CarbonIntensity carbonIntensity = new CarbonIntensity(webDriverHandler);
        carbonIntensity.verifyModalCI();
    }

    @Test
    public void VerifyRegionalData() throws InterruptedException {
        CarbonIntensity carbonIntensity = new CarbonIntensity(webDriverHandler);
        carbonIntensity.accessRegionalChart("Regional Data", "London");
    }

    @Test
    public void VerifyGetInTouch() {
        CarbonIntensity carbonIntensity = new CarbonIntensity(webDriverHandler);
        carbonIntensity.accessGetInTouch();
    }
}