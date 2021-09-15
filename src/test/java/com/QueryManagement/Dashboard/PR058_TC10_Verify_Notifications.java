package com.QueryManagement.Dashboard;

import com.Base.SeleniumHandlers.WebDriverHandler;
import com.QueryManagement.AbstractTestNg;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR058_TC10_Verify_Notifications extends AbstractTestNg {

    public PR058_TC10_Verify_Notifications() throws IOException {
    }

    @Test
    public void accessCategory() {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        Notifications notifications = new Notifications(webDriverHandler);
        notifications.accessCategory();
    }

    @Test
    public void verifyCategory() {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        Notifications notifications = new Notifications(webDriverHandler);
        notifications.accessCategory();
        notifications.verifyCategory();
    }

    @Test
    public void verifySubCat()  {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        Notifications notifications = new Notifications(webDriverHandler);
        notifications.accessCategory();
        notifications.accessSubCategory("Action Calendar");
        notifications.verifyActionCalendar();
        notifications.accessSubCategory("Notifications");
        notifications.verifyNotifications();
    }

    @Test
    public void verifyViews()  {
        WebDriverHandler webDriverHandler = new WebDriverHandler(driver);
        Notifications notifications = new Notifications(webDriverHandler);
        notifications.accessCategory();
        notifications.accessSubCategory("Action Calendar");
        notifications.verifyViews();
    }
}
