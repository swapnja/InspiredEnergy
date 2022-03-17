
// home= pinnedApps
//All Application -AppTrayList changed from pinedApp to AppTrayList
package com.CompaniesAndContacts;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_03_AppDescription extends AbstractTestNg{

    public PR147_03_AppDescription() throws IOException {
    }

    @Test
    public void ToolTip() throws IOException, InterruptedException {
    	 webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@title='Home']").waitClickable().click();        
        Actions actions = new Actions(driver);
       // Thread.sleep(2000);
        WebElement w3 = driver.findElement(By.xpath("//*[@id='pinnedApps']//div[a[@href='/CompanyManagement/Home/Dashboard']]//div[@class='card-footer text-center']"));
       
        actions.moveToElement(w3).perform();
        System.out.println("Manage your customers and suppliers");
    }
}

////*[@id="appTrayList"]/div/div[5]/a/div/img