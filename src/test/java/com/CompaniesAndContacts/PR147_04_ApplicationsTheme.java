package com.CompaniesAndContacts;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_04_ApplicationsTheme extends AbstractTestNg {

    public PR147_04_ApplicationsTheme() throws IOException {
    }

    @Test
    public void ApplicationTheme() throws IOException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@title='Home']").waitClickable(15,100).click();
        webDriverHandler.byXpath("//li[@class='nav-item']/a[@title='Administration']").click();
        webDriverHandler.byXpath("//div[@class='card tiles-max ']/a[@href='/Core/ApplicationAdministration/Applications']").click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//table[@id='appsTable']/tbody/tr[@id='6']").click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//label[@class='col-5 col-form-label' and contains(text(),'Quick Link:')]").click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement DefaultColour = driver.findElement(By.xpath("//*[@id='DefaultColour']"));
        js.executeScript("arguments[0].scrollIntoView(true);", DefaultColour);
        webDriverHandler.byXpath("//label[@class='col-5 col-form-label' and contains(text(),'Quick Link:')]").click();
        webDriverHandler.byId("DefaultColour").selectByValue("2");
        webDriverHandler.byXpath("//button[@type='submit']/i[@class='fa fa-save']").click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//button[@class='swal2-confirm swal2-styled' and contains(text(),'OK')]").click();
    }
}
