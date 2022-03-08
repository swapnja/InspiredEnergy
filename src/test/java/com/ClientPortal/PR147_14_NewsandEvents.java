package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_14_NewsandEvents extends AbstractTestNg {

    public PR147_14_NewsandEvents() throws IOException {
    }

    @Test
    public void NewEvents() throws InterruptedException, IOException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@title='Home']").waitClickable().click();
        driver.findElement(By.xpath("//*[@href='/core/Administration/Dashboard']")).click();
        driver.findElement(By.xpath("//*[@href='/Core/NewsandEventsAdministration/NewsandEvents']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='btnNewEvent']")).click();
        System.out.println("New Event popup should be displayed");
        WebElement w3 = driver.findElement(By.xpath("//*[@id='Title']"));
        w3.sendKeys("Test");
        driver.findElement(By.xpath("//*[@id='EventDate']")).click();
   //     Thread.sleep(1500);
      //  webDriverHandler.byXpath("//*[@id='EventDate']").waitClickable(15,100).click();
        //.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		webDriverHandler.byXpath("//div[starts-with(@class,'xdsoft_datetimepicker')][starts-with(@style,'display: block')]//div[@data-hour='18']").waitClickable(15,100).click();
		//Thread.sleep(1000);		
		webDriverHandler.byXpath("//*[@id='EventToDate']").waitClickable(15,100).click();
		Thread.sleep(1000);
		webDriverHandler.byXpath("//div[starts-with(@class,'xdsoft_datetimepicker')][starts-with(@style,'display: block')]//div[@data-hour='21']").waitClickable().click();
	
      //  webDriverHandler.byXpath("//div[starts-with(@class,'xdsoft_datetimepicker')][starts-with(@style,'display: block')]//div[@data-hour='18']").waitClickable().click();
        //Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='EventToDate']")).click();
        Thread.sleep(1500);
        WebElement w5 = driver.findElement(By.xpath("//div[starts-with(@class,'xdsoft_datetimepicker')][starts-with(@style,'display: block')]//div[@data-hour='21']"));
        w5.click();
        Thread.sleep(1000);
        WebElement w6 = driver.findElement(By.xpath("//*[@id='Url']"));
        w6.sendKeys("https://stestcumulus.inspiredenergy.co.uk/Core/Home/Loginsso");
        Thread.sleep(1000);
        // need to add category
        
        
        
        
        driver.findElement(By.xpath("//label[@class='switch']//span[@class='slider round']")).click();
        driver.findElement(By.xpath("//form[@id='newEventForm']//div[@class='modal-footer']//button[@class='btn btn-sm btn-primary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='btnDelete']")).click();
        driver.findElement(By.xpath("//div[@class='swal2-actions']//button[@class='swal2-confirm swal2-styled']")).click();
    }
}
