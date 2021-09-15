package com.ClientPortal;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR147_20_VerifyTitle extends AbstractTestNg {

    public PR147_20_VerifyTitle() throws IOException {
    }

    @Test
    public void Header() {
        driver.findElement(By.xpath("//div[@class='navbar-brand']//h5[contains(text(),'Companies & Contacts')]"));
        String expectedTitle = "CLIENT PORTAL";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle))
            System.out.println("Title didn't match");
        else
            System.out.println("CLIENT PORTAL");
    }
}

