package com.CompaniesAndContacts;

import com.ClientPortal.PageObjects.AbstractTestNg;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

public class PR147_02_Advertisments extends AbstractTestNg {

    public PR147_02_Advertisments() throws IOException {
    }

    @Test
    public void Advert() throws InterruptedException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(15,100).waitInvisible(15,100);
		webDriverHandler.byXpath("//li[@class='nav-item']/a[@title='Administration']").click();
		webDriverHandler.byXpath("//div[@class='card tiles-max ']/a[@href='/Core/AdvertsAdministration/Adverts']").click();
		webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
		webDriverHandler.byXpath("//*[@id='btnNewAdvert']").waitClickable().click();
        System.out.println("New Advert popup should be displayed");
		webDriverHandler.byXpath("//*[@id='Title']").waitClickable().sendKeys("Automation Test");
		/*webDriverHandler.byXpath("//*[@id='Url']").waitClickable().sendKeys("https://stestcumulus.inspiredenergy.co.uk/Core/Home/Loginsso").sendKeys(Keys.TAB);
		Thread.sleep(1000);
		webDriverHandler.byXpath("//*[@id='DisplayFromDate']").waitClickable(15,100).click();
		Thread.sleep(1000);
		webDriverHandler.byXpath("//div[starts-with(@class,'xdsoft_datetimepicker')][starts-with(@style,'display: block')]//div[@data-hour='18']").waitClickable(15,100).click();
		Thread.sleep(1000);		
		webDriverHandler.byXpath("//*[@id='DisplayToDate']").waitClickable(15,100).click().sendKeys(Keys.TAB);
		Thread.sleep(1000);
		webDriverHandler.byXpath("//div[starts-with(@class,'xdsoft_datetimepicker')][starts-with(@style,'display: block')]//div[@data-hour='21']").waitClickable(15,100).click();
		Thread.sleep(1000);
		webDriverHandler.byXpath("//label[@class='switch']/span[@class='slider round']").click();
		String path = Paths.get("BudgetTestData\\Customer_Logo\\FF-logo_1.jpg").toAbsolutePath().toString();
		webDriverHandler.byXpath("//input[@type='file']").sendKeys(path);
		webDriverHandler.byXpath("//i[@class='fa fa-save']").click();
		webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
		webDriverHandler.byXpath("//button[@class='btn btn-sm btn-secondary']/i[@class='fa fa-save']").click();
		webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
		webDriverHandler.byXpath("//button[@class='swal2-confirm swal2-styled' and contains(text(),'OK')]").click();
		webDriverHandler.byXpath("//*[@id='btnDelete']").click();
		webDriverHandler.byXpath("//button[@class='swal2-confirm swal2-styled' and contains(text(),'Yes, please')]").click();
    }*/
}
}