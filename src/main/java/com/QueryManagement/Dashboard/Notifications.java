package com.QueryManagement.Dashboard;


import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.testng.Assert;

public class Notifications {

    WebDriverHandler _webDriverHandler;
    ElementHandler tabNotifications;
    ElementHandler subTabActionCalendar;
    ElementHandler subTabNotifications;

    ElementHandler btnToday;
    ElementHandler btnNextDay;
    ElementHandler btnPastDay;
    ElementHandler linkDate;
    ElementHandler btnDaily;
    ElementHandler btnWeekly;
    ElementHandler btnMonthly;

    ElementHandler btnArchive;

    ElementHandler cardTotalSavings;
    ElementHandler cardForecastSavings;
    ElementHandler cardTasksOpen;
    ElementHandler cardTasksClosed;

    public Notifications (WebDriverHandler webDriverHandler) {
        _webDriverHandler = webDriverHandler;
        tabNotifications = _webDriverHandler.byXpath("//a//span[contains(text(), 'Notifications')]");
        subTabActionCalendar = _webDriverHandler.byXpath("//a[contains(text(), 'Action Calendar')]");
        subTabNotifications = _webDriverHandler.byXpath("//a[contains(text(), 'Notifications')]");

        btnToday = _webDriverHandler.byXpath("//*[contains(@class, 'today-button')]");
        btnNextDay = _webDriverHandler.byXpath("//*[contains(@class, 'next-button')]");
        btnPastDay = _webDriverHandler.byXpath("//*[contains(@class, 'prev-button')]");
        linkDate = _webDriverHandler.byXpath("//*[@id = 'datepickertoggle']");
        btnDaily = _webDriverHandler.byXpath("//*[contains(@class, 'timeGridDay-button')]");
        btnWeekly = _webDriverHandler.byXpath("//*[contains(@class, 'timeGridWeek-button')]");
        btnMonthly = _webDriverHandler.byXpath("//*[contains(@class, 'dayGridMonth-button')]");

        btnArchive = _webDriverHandler.byXpath("//*[contains(text(), 'Archive Selected')]");

        cardTotalSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_closed']//..");
        cardForecastSavings = _webDriverHandler.byXpath("//div[@id = 'totalEstimation_open']//..");
        cardTasksOpen = _webDriverHandler.byXpath("//div[@id = 'openTaskCount']//..");
        cardTasksClosed = _webDriverHandler.byXpath("//div[@id = 'closedTasksCount']//..");
    }

    public String[] tblSubNotifications = new String[]{"", "Date Time", "Task ID", "Notifications"};
    public String[] arrSubNotifications = new String[4];

    public String[] tblSubCalendar = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public String[] arrSubCalendar = new String[7];

    public void accessCategory() {
        waitLoad();
        tabNotifications.waitClickable().click();
    }

    public void accessSubCategory(String subCategory) {
        switch(subCategory){
            case "Action Calendar":
                subTabActionCalendar.waitClickable().click();
                break;
            case "Notifications":
                subTabNotifications.waitClickable().click();
                break;
        }
        waitLoad();
    }

    public void verifyCategory() {
        waitExec();
        if (subTabActionCalendar.isDisplayed() && subTabNotifications.isDisplayed()) {
            System.out.println("The category is loaded properly.");
        } else {
            Assert.fail("Category not loaded properly.");
        }
    }

    public void columnVerification() {
        for (int i = 0; i < arrSubNotifications.length; i++) {
            arrSubNotifications[i] = _webDriverHandler.byXpath("//table[@id='tblNotifications']/thead/tr/th[" + (i + 1) + "]").getText();
            if (!(tblSubNotifications[i].equals(arrSubNotifications[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void verifyActionCalendar() {
        if (btnToday.isDisplayed() && btnNextDay.isDisplayed() && btnPastDay.isDisplayed() && linkDate.isDisplayed()
                && btnDaily.isDisplayed() && btnWeekly.isDisplayed() && btnMonthly.isDisplayed()) {
            System.out.println("The sub category is loaded properly.");
        } else {
            Assert.fail("Category not loaded properly.");
        }
        for (int i = 0; i < arrSubCalendar.length; i++) {
            arrSubCalendar[i] = _webDriverHandler.byXpath("//*[contains(@class, 'fc-head-container')]//thead//tr//th[" + (i + 1) + "]").getText();
            if (!(tblSubCalendar[i].equals(arrSubCalendar[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
    }

    public void verifyNotifications() {
        if (btnArchive.isDisplayed()) {
            System.out.println("The sub category is loaded properly.");
        } else {
            Assert.fail("Category not loaded properly.");
        }
        columnVerification();
    }

    public void verifyViews() {
        btnWeekly.waitClickable().click();
        for (int i = 0; i < arrSubCalendar.length; i++) {
            arrSubCalendar[i] = _webDriverHandler.byXpath("//*[contains(@class, 'fc-head-container')]//thead//tr//th[" + (i + 2) + "]").getText();
            if (!(tblSubCalendar[i].equals(arrSubCalendar[i]))) {
                Assert.fail("\nColumn names do not match.");
            }
        }
        System.out.println("\nColumn names match.");
        System.out.println(linkDate.getText() +"\n");
        btnDaily.waitClickable().click();
        System.out.println(linkDate.getText());
    }

    public void waitExec() {
        cardTotalSavings.isDisplayed(); cardForecastSavings.isDisplayed(); cardTasksOpen.isDisplayed(); cardTasksClosed.isDisplayed();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible().waitInvisible();
    }
}
