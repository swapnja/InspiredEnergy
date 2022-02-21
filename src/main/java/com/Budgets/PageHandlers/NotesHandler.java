package com.Budgets.PageHandlers;

import com.Base.SeleniumHandlers.WebDriverHandler;

import java.io.IOException;
import java.util.Properties;

public class NotesHandler {
    WebDriverHandler _webDriverHandler;
    Properties _prop;

    public NotesHandler(WebDriverHandler webDriverHandler, Properties prop) throws IOException {
        _webDriverHandler = webDriverHandler;
        _prop = prop;
    }

    public void openNotes(String type){
        _webDriverHandler.byXpath(_prop.getProperty(type)).waitClickable().click();
        waitLoad();
    }

    public void addNotes(String Note, String type) {
        _webDriverHandler.byXpath(_prop.getProperty(type)).waitVisible().click().sendKeys(Note);
    }

    public void clearNotes(String type) {
        _webDriverHandler.byXpath(_prop.getProperty(type)).waitVisible(15,100).click().clear();
    }

    public void searchNotes(String searchtype, String search) {
        _webDriverHandler.byXpath(_prop.getProperty(searchtype)).waitVisible().sendKeys(search);
        waitLoad();
    }

    public void printSearch() {
        String searchResult = _webDriverHandler.byXpath(_prop.getProperty("FilteredNotesTable")).waitVisible().getText();
        System.out.println(searchResult);
    }

    public void modifyNotes(String Note, String type) {
        _webDriverHandler.byXpath(_prop.getProperty(type)).waitVisible().click().clear().sendKeys(Note);
    }

    public void appendNotes(String Note, String type) {
        _webDriverHandler.byXpath(_prop.getProperty(type)).waitVisible().click().sendKeys(" "+Note);
    }

    public String getCharLimit(String type) {
        String a = _webDriverHandler.byXpath(_prop.getProperty(type)).waitVisible().getAttribute("data-val-maxlength-max");
        return a;
    }

    public void addNotesinSearch(String Note, String type, String search, String searchsearchtype) {
        searchNotes(searchsearchtype, search);
        _webDriverHandler.byXpath(_prop.getProperty(type)).waitVisible().sendKeys(Note);
    }

    public void addBlankNotes(String type) {
        addNotes("", type);
    }

    public void informationSave(){
        waitInformation();
        _webDriverHandler.byXpath(_prop.getProperty("InformationSave")).waitClickable(10,100).click();
        _webDriverHandler.byXpath("//button[contains(text(),'OK')]").clickrepeat();
     //   waitLoad();
    }

    public void testCharlimit(String type) {
        waitInformation();
        modifyNotes("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.\n" +
                        "\n" +
                        "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores.",
                type);
        _webDriverHandler.byXpath(_prop.getProperty("InformationSave")).click();
        String a = _webDriverHandler.byId("Notes-error").waitVisible(10,100).getText();
        System.out.println("-------------------------- \n"+a);
      //  waitLoad();
    }

    public void testCharlimitImport(String type) {
        modifyNotes("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.\n" +
                        "\n" +
                        "Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores. More",
                type);
       _webDriverHandler.byXpath("//*[@class=\"modal-content\"]//*[@for=\"ImportNotes\"]").waitClickable(10,100).click();
        String a = _webDriverHandler.byId("ImportNotes-error").waitVisible().getText();
        System.out.println("-------------------------- \n"+a + " - Import");
       // waitLoad();
    }

    public void waitLoad() {
    	_webDriverHandler.byXpath(_prop.getProperty("Overlay")).waitVisible(10,100).waitInvisible(10,100);
    }

    public void waitInformation() {
        String stringRef = _webDriverHandler.byXpath(_prop.getProperty("Reference")).getText();
        String stringSD = _webDriverHandler.byXpath(_prop.getProperty("StartDate")).getText();
        String stringED = _webDriverHandler.byXpath(_prop.getProperty("EndDate")).getText();

        _webDriverHandler.byXpath(_prop.getProperty("Reference")).waitClickable().sendKeys(stringRef);
        _webDriverHandler.byXpath(_prop.getProperty("Reference")).waitClickable().sendKeys(stringRef);
        _webDriverHandler.byXpath(_prop.getProperty("StartDate")).waitClickable().sendKeys(stringSD);
        _webDriverHandler.byXpath(_prop.getProperty("StartDate")).waitClickable().sendKeys(stringSD);
        _webDriverHandler.byXpath(_prop.getProperty("EndDate")).waitClickable().sendKeys(stringED);
        _webDriverHandler.byXpath(_prop.getProperty("EndDate")).waitClickable().sendKeys(stringED);
        _webDriverHandler.byXpath(_prop.getProperty("CalendarOutput")).waitClickable().selectByText("Custom");
        _webDriverHandler.byXpath(_prop.getProperty("CalendarOutput")).waitClickable().selectByText("Monthly");
    }
}
