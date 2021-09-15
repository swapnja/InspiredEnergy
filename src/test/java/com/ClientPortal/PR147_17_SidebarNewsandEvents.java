package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_17_SidebarNewsandEvents extends AbstractTestNg {

    public PR147_17_SidebarNewsandEvents() throws IOException {
    }

    @Test
    public void Sidebar() throws IOException {
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//*[@title='Home']").waitClickable().click();
        driver.findElement(By.xpath("//div[@class='card-header']/h3")).click();
        System.out.println("Title of the side bar should be News and Events");
        driver.findElement(By.xpath("//div[@class='card-footer text-center']/a[@href='/Core/Users/Profile']")).click();
    }
}