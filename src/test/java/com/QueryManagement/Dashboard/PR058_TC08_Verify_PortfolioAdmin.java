package com.QueryManagement.Dashboard;

import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC08_Verify_PortfolioAdmin extends AbstractTestNg {
    
    public PR058_TC08_Verify_PortfolioAdmin() throws IOException {
    }

    @Test
    public void accessCategory() {
        PortfolioAdmin portfolioAdmin = new PortfolioAdmin(webDriverHandler);
        portfolioAdmin.accessCategory();
    }

    @Test
    public void verifyCategory() {
        PortfolioAdmin portfolioAdmin = new PortfolioAdmin(webDriverHandler);
        portfolioAdmin.accessCategory();
        portfolioAdmin.verifyCategory();
    }

    @Test
    public void verifySubCat() {
        PortfolioAdmin portfolioAdmin = new PortfolioAdmin(webDriverHandler);
        portfolioAdmin.accessCategory();
        portfolioAdmin.verifySubCategory("LOA");
        portfolioAdmin.verifySubCategory("NS");
        portfolioAdmin.verifySubCategory("VATD");
    }
}
