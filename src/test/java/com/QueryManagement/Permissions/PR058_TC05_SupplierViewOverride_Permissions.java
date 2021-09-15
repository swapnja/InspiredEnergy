package com.QueryManagement.Permissions;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC05_SupplierViewOverride_Permissions extends AbstractTestNg {

    public PR058_TC05_SupplierViewOverride_Permissions() throws IOException {
    }

    Permission permission;

    @BeforeClass
    public void setRole () {
        permission = new Permission(webDriverHandler);
        webDriverHandler.byXpath("//a[@title = 'Administration']").waitClickable().click();
        webDriverHandler.byXpath("//a[@href = '/Core/UserAdministration/Users']").click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//input[@type = 'search']").waitClickable().clear().sendKeys("ip-dev-tp2@inspiredenergy.co.uk");
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//tr//td/..").waitClickable().click();
        webDriverHandler.byXpath("//*[@id='RoleId']").waitClickable().selectByText("AllPermissionRole");
        webDriverHandler.byXpath("//*[@type='submit']").waitClickable().click();
        webDriverHandler.byXpath("//button[text() = 'OK']").waitClickable().click();
    }

    String xpath = "Permisssions_28__Id";

    @Test
    public void VerifyView(){
        NextActionDate nextActionDate = new NextActionDate(webDriverHandler);
        permission.accessUserRoles();
        permission.accessPermissions("AllPermissionRole");
        permission.toggleView(xpath, true);
        permission.accessQMP();
        permission.accessSubCategory("Accounting", "Account Query");
        permission.selectEntry(64);
        nextActionDate.verifyView(true);
        permission.accessUserRoles();
        permission.accessPermissions("AllPermissionRole");
        permission.toggleView(xpath, false);
        permission.accessQMP();
        permission.accessSubCategory("Accounting", "Account Query");
        permission.selectEntry(64);
        nextActionDate.verifyView(false);
    }

    @Test
    public void VerifyCreate(){
        NextActionDate nextActionDate = new NextActionDate(webDriverHandler);
        permission.accessUserRoles();
        permission.accessPermissions("AllPermissionRole");
        permission.toggleView(xpath, true);
        permission.accessQMP();
        permission.accessSubCategory("Accounting", "Account Query");
        permission.selectEntry(64);
        nextActionDate.verifyView(true);
        permission.accessUserRoles();
        permission.accessPermissions("AllPermissionRole");
        permission.toggleView(xpath, false);
        permission.accessQMP();
        permission.accessSubCategory("Accounting", "Account Query");
        permission.selectEntry(64);
        nextActionDate.verifyView(false);
    }

    @Test
    public void VerifyEdit(){
        NextActionDate nextActionDate = new NextActionDate(webDriverHandler);
        permission.accessUserRoles();
        permission.accessPermissions("AllPermissionRole");
        permission.toggleView(xpath, true);
        permission.accessQMP();
        permission.accessSubCategory("Accounting", "Account Query");
        permission.selectEntry(64);
        nextActionDate.verifyView(true);
        permission.accessUserRoles();
        permission.accessPermissions("AllPermissionRole");
        permission.toggleView(xpath, false);
        permission.accessQMP();
        permission.accessSubCategory("Accounting", "Account Query");
        permission.selectEntry(64);
        nextActionDate.verifyView(false);
    }

    @Test
    public void VerifyDelete(){
        NextActionDate nextActionDate = new NextActionDate(webDriverHandler);
        permission.accessUserRoles();
        permission.accessPermissions("AllPermissionRole");
        permission.toggleView(xpath, true);
        permission.accessQMP();
        permission.accessSubCategory("Accounting", "Account Query");
        permission.selectEntry(64);
        nextActionDate.verifyView(true);
        permission.accessUserRoles();
        permission.accessPermissions("AllPermissionRole");
        permission.toggleView(xpath, false);
        permission.accessQMP();
        permission.accessSubCategory("Accounting", "Account Query");
        permission.selectEntry(64);
        nextActionDate.verifyView(false);
    }

    @AfterClass
    public void resetRole () {
        webDriverHandler.byXpath("//a[@title = 'Administration']").waitClickable().click();
        webDriverHandler.byXpath("//a[@href = '/Core/UserAdministration/Users']").click();
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//input[@type = 'search']").waitClickable().clear().sendKeys("ip-dev-tp2@inspiredenergy.co.uk");
        webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
        webDriverHandler.byXpath("//tr//td/..").waitClickable().click();
        webDriverHandler.byXpath("//*[@id='RoleId']").waitClickable().selectByText("(Default)");
        webDriverHandler.byXpath("//*[@type='submit']").waitClickable().click();
        webDriverHandler.byXpath("//button[text() = 'OK']").waitClickable().click();
    }
}
