package com.ClientPortal;

import com.Base.SeleniumHandlers.ElementHandler;
import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_09_LicenseeApplicationsPinned extends AbstractTestNg {

    public PR147_09_LicenseeApplicationsPinned() throws IOException {
    }

    @Test
    public void LicenseeAppPinned() throws InterruptedException, IOException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(15,100).waitInvisible(15,100);
        webDriverHandler.byXpath("//*[@title='Home']").waitClickable(15,100).click();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        webDriverHandler.byXpath("//*[@href='/core/Administration/Dashboard']").click();
        webDriverHandler.byXpath("//*[@href='/Core/LicenseeAdministration/Licensees']").click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(15,100).waitInvisible(15,100);
        webDriverHandler.byXpath("//table[@id='companyTable']/tbody/tr[@id='1']/td[2]").click();
        webDriverHandler.byXpath("//*[@href='#applicationContent']").click();
        Thread.sleep(1000);
        ElementHandler w4;
        w4 = webDriverHandler.byXpath("//div[@class='table-responsive']//table//tbody//tr[4]//td[4]//label//span");
        
        Thread.sleep(1000);
        if (!w4.isSelected()) {
            w4.waitClickable().click();
            System.out.println("connections");
        } else {
            w4.waitClickable().click();
            System.out.println("ELSE");
        }
        ElementHandler w5;
        w5 = webDriverHandler.byXpath("//div[@class='table-responsive']//table//tbody//tr[2]//td[4]//label//span");
        Thread.sleep(1000);
        if (!w5.isSelected()) {
            w5.waitClickable(15,100).click();
            System.out.println("Bdget");
        } else {
            w5.waitClickable().click();
            System.out.println("ELSE");
        }
	 /* JavascriptExecutor js = (JavascriptExecutor) driver;
	  WebElement save=webDriverHandler.byXpath("//form[@id='saveCompanyEventCategoryForm']//div[@class='col-12']//button"));
	  js.executeScript("arguments[0].scrollIntoView(true);",save);
	  */
        Thread.sleep(1000);
        webDriverHandler.byXpath("//*[@href='#categoryContent']").click();
        Thread.sleep(1000);
        webDriverHandler.byXpath("//table[@id='eventCategoriesTable']//tbody//th[@class='bg-group']//button[@class='btn btn-sm text-light float-right' and contains(text(),'Reset All')]").click();
        Thread.sleep(1000);
        webDriverHandler.byXpath("//table[@id='eventCategoriesTable']//tbody//th[@class='bg-group']//button[@class='btn btn-sm text-light float-right' and contains(text(),'Enable All')]").click();
        Thread.sleep(1000);
        webDriverHandler.byXpath("//form[@id='saveCompanyEventCategoryForm']//div[@class='col-12']//button").click();
        webDriverHandler.byXpath("//button[@class='swal2-confirm swal2-styled' and contains(text(),'OK')]").click();
    }

}

