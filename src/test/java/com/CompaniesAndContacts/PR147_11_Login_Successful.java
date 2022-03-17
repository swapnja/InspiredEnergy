package com.CompaniesAndContacts;

import com.ClientPortal.PageObjects.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;


public class PR147_11_Login_Successful extends AbstractTestNg {

    public PR147_11_Login_Successful() throws IOException {
    }

    @Test
    public void login_Success() {
        System.out.println("Happened! Login.");
    }
}
