package com.InstantInsight;

import com.Base.ReadPropertyFile;
import com.Base.SeleniumHandlers.ElementHandler;
import com.Base.SeleniumHandlers.WebDriverHandler;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;


public class AutoInstantInsights {

    WebDriverHandler _webDriverHandler;
    Properties _prop = ReadPropertyFile.getProperties();;
    ElementHandler autoIIHeader;
    ElementHandler autoIISubHeader;
    ElementHandler btnPostMsg;
    ElementHandler btnSend;
    ElementHandler searchMsg;
    ElementHandler ddHashTag;
    ElementHandler searchHashTag;
    ElementHandler ddPeriod;
    ElementHandler tbStartDate;
    ElementHandler tbEndDate;
    ElementHandler getInTouch;
    ElementHandler characterCountSend;
    ElementHandler characterCountReply;
    ElementHandler tbMsg;
    ElementHandler modalPostHeader;
    ElementHandler tbPostModalMsg;
    ElementHandler modalPostAddImage;
    ElementHandler modalPostSend;
    ElementHandler modalPostCancel;
    ElementHandler modalSMHeader;
    ElementHandler modalSMClose;
    ElementHandler modalSMText;
    ElementHandler tbModalSMSubject;
    ElementHandler tbModalSMMsg;
    ElementHandler modalSMClickedMsg;
    ElementHandler modalSMSend;
    ElementHandler modalSMCancel;
    ElementHandler lastReplyButton;
    ElementHandler lastOpenLink;
    ElementHandler lastDeleteBtn;
    ElementHandler btnYes;
    ElementHandler btnOk;
    ElementHandler linkAdministrator;
    ElementHandler tabUsers;
    ElementHandler searchUser;
    ElementHandler ddRole;
    ElementHandler btnSave;
    ElementHandler linkHome;
    ElementHandler linkAllApps;
    ElementHandler autoII;
    ElementHandler msgSend;
    ElementHandler msgPost;
    ElementHandler msgReplySub;
    ElementHandler msgReplyText;

    public AutoInstantInsights (WebDriverHandler webDriverHandler) throws IOException {
        _webDriverHandler = webDriverHandler;
        autoIIHeader = _webDriverHandler.byXpath("//h5[contains (text(), 'Instant Insights')]");
        autoIISubHeader = _webDriverHandler.byXpath("//*[@id='mainSubHeader']");
        btnPostMsg = _webDriverHandler.byXpath("//button[contains (text(), ' Post Message')]");
        btnSend = _webDriverHandler.byXpath("//button[text() = 'Send']");
        searchMsg = _webDriverHandler.byXpath("//*[@id='chatFilterText']");
        ddHashTag = _webDriverHandler.byXpath("//button[contains (@class, 'dropdown-toggle')]");
        searchHashTag = _webDriverHandler.byXpath("//*[@id='chatFilterHashtag']");
        ddPeriod = _webDriverHandler.byXpath("//*[@id='chatFilterPeriod']");
        tbStartDate = _webDriverHandler.byXpath("//*[@id='MessageStartDateTime']");
        tbEndDate = _webDriverHandler.byXpath("//*[@id='MessageEndDateTime']");
        getInTouch = _webDriverHandler.byXpath("//span[contains(text(), 'Get in touch:')]");
        characterCountSend = _webDriverHandler.byXpath("//*[@id='postMessageSpanId']");
        characterCountReply = _webDriverHandler.byXpath("//*[@id='postSpecificUserSpanId']");
        tbMsg = _webDriverHandler.byXpath("//*[@id='postMessageTextBox']");
        btnYes = _webDriverHandler.byXpath("//button[text() = 'Yes']");
        btnOk = _webDriverHandler.byXpath("//button[text() = 'OK']");
        msgSend = _webDriverHandler.byXpath("//*[@id='postMessageTextBox-error']");
        msgPost = _webDriverHandler.byXpath("//*[@id='postPrivateMessageText-error']");
        msgReplySub = _webDriverHandler.byXpath("//*[@id='sendMessageSubject-error']");
        msgReplyText = _webDriverHandler.byXpath("//*[@id='sendMsgForm']//*[@id='postSpecificUserMessageBoxId-error']");
        //Post Modal
        modalPostHeader = _webDriverHandler.byXpath("//h5[contains (text(), 'Post Message')]");
        tbPostModalMsg = _webDriverHandler.byXpath("//*[contains(@class, 'ql-editor')]");
        modalPostAddImage = _webDriverHandler.byXpath("//*[@id='addImage']");
        modalPostSend = _webDriverHandler.byXpath("//*[@class='fa fa-save']");
        modalPostCancel = _webDriverHandler.byXpath("(//button[text() = 'Cancel'])[1]");
        //Send Reply
        modalSMHeader = _webDriverHandler.byXpath("//h5[contains (text(), 'SEND MESSAGE')]");
        modalSMClose = _webDriverHandler.byXpath("//*[@id='DivClose']");
        modalSMText = _webDriverHandler.byXpath("//label[contains (text(), 'Post your question here and we will get back to you as soon as possible:')]");
        tbModalSMSubject = _webDriverHandler.byXpath("//*[@id='sendMessageSubject']");
        tbModalSMMsg = _webDriverHandler.byXpath("//*[@class='modal-body container']//textarea");
        modalSMClickedMsg = _webDriverHandler.byXpath("//*[@id='chatMessageClickedText']");
        modalSMSend = _webDriverHandler.byXpath("//*[@id='sendMsgForm']//button[@type='submit']");
        modalSMCancel = _webDriverHandler.byXpath("(//button[text() = 'Cancel'])[1]");
        lastReplyButton = _webDriverHandler.byXpath("(//*[@class='fa fa-reply'])[last ()]");
        lastOpenLink = _webDriverHandler.byXpath("(//*[@class='chatcontent']//a)[last ()]");
        lastDeleteBtn = _webDriverHandler.byXpath("(//*[@class='fa fa-minus-circle'])[last ()]");
        //Switch User
        linkAdministrator = _webDriverHandler.byXpath("//a[@title='Administration']");
        tabUsers = _webDriverHandler.byXpath("//a[@href='/Core/UserAdministration/Users']");
        ddRole = _webDriverHandler.byXpath("//*[@id= 'RoleId']");
        btnSave = _webDriverHandler.byXpath("//button[text() = 'Save']");
        linkHome = _webDriverHandler.byXpath("//a[@title='Home']");
        linkAllApps = _webDriverHandler.byXpath("//*[@id= 'btnApps']");
        autoII = _webDriverHandler.byXpath("//*[@id='appTrayList']//a[@href='/InstantInsights/Home/Dashboard']");
        searchUser = _webDriverHandler.byXpath("//*[@type='search']");
    }

    String strErrorMessage = "The Message field is required.";

    String strErrorPostMessage = "The Message field is required.";

    String strErrorReplySubject = "The Subject field is required.";
    String strErrorReplyMessage = "The Message field is required.";

    public void verifyAutoII() {
        Assert.assertEquals(autoIIHeader.getText(), "Instant Insights", "Application Header does not match.");
        Assert.assertEquals(autoIISubHeader.getText(), "Wholesale Energy Market Monitor ", "Application Sub Header does not match.");
        System.out.println("Application Headers match.");
        if(searchMsg.isDisplayed() &&
                ddHashTag.isDisplayed() &&
                ddPeriod.isDisplayed() &&
                btnPostMsg.isDisplayed() &&
                lastDeleteBtn.isDisplayed()
         )
        {
            System.out.println("Auto Instant insight page is loaded properly.");
        }
        else {
            Assert.fail("Page not loaded properly.");
        }
    }

    public void searchMessage(String term) {
        searchMsg.sendKeys(term);
    }

    public void clearMessageFilter() {
        searchMsg.clear();
    }

    public void filterHashtags(String hashTag){
        ddHashTag.waitClickable(15,100).click();
        searchHashTag.waitClickable().sendKeys(hashTag);
        _webDriverHandler.byXpath("//label[@title='#"+hashTag+"']").click();
        searchHashTag.waitClickable().sendKeys(Keys.ESCAPE);
    }

    public void filterPeriod(String time){
        ddPeriod.waitClickable().selectByText(time);
        waitLoad();
    }

    public void filterPeriod(String startDate, String endDate){
        ddPeriod.waitClickable().selectByText("Custom");
        tbStartDate.waitClickable().clear().sendKeys(startDate, Keys.ESCAPE);
        tbEndDate.waitClickable().clear().sendKeys(endDate, Keys.ENTER);
        waitLoad();
    }

    public void verifyPostModal() {
        btnPostMsg.waitClickable().click();
        if(modalPostHeader.isDisplayed() && tbPostModalMsg.isDisplayed() && modalPostAddImage.isDisplayed() && modalPostSend.isDisplayed() && modalPostSend.isDisplayed())
        {
            System.out.println("Post Message Modal loaded properly.");
        }
        else {
            Assert.fail("Modal not loaded properly.");
        }
        modalPostCancel.waitClickable().click();
    }

    public void postMessage() {
        stop();
        btnPostMsg.waitClickable().click();
        tbPostModalMsg.waitClickable().click();
        tbPostModalMsg.waitClickable().sendKeys("Message in Post message modal. #automation");
        modalPostAddImage.sendKeys("I:\\asdasda.jpg");
        modalPostSend.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void verifyNewHashtag(String hashTag) {
        linkHome.waitClickable().click();
        linkAllApps.waitClickable().click();
        autoII.waitClickable().click();
        stop();
        ddHashTag.waitClickable().click();
        searchHashTag.waitClickable().sendKeys(hashTag);
        if(_webDriverHandler.byXpath("//label[@title='#"+hashTag+"']").isDisplayed())
        {
            System.out.println("New hashtag is available in dropdown");
        }
    }

    public void verifyCharacterCountMessage() {
        tbMsg.waitClickable().sendKeys("Character");
        String count = characterCountSend.getText();
        if (count.equalsIgnoreCase("Characters remaining: 991")){
            System.out.println("Character count is functionality is working.");
        }
        else {
            Assert.fail("Character count is wrong.");
        }
    }

    public void verifyCharacterCountReply() {
        lastReplyButton.waitClickable().click();
        tbModalSMMsg.waitClickable().sendKeys("Count");
        String count = characterCountReply.getText();
        if (count.equalsIgnoreCase("Characters remaining: 995")){
            System.out.println("Character count is functionality is working.");
        }
        else {
            Assert.fail("Character count is wrong.");
        }
    }

    public void sendMessage() {
        tbMsg.waitClickable().sendKeys("Message in the send post tb.");
        btnSend.waitClickable().click();
        System.out.println("**********************************\n");
        System.out.println("Message for Post is:");
        String strErrortext = _webDriverHandler.byId("swal2-content").waitVisible().getText();
        System.out.println(strErrortext);
        btnOk.waitClickable().click();
    }

    public void verifyReplyModal() {
        lastReplyButton.waitClickable().click();
        if(modalSMHeader.isDisplayed() && tbModalSMSubject.isDisplayed() && modalSMText.isDisplayed() && modalSMClickedMsg.isDisplayed() && modalSMClose.isDisplayed() && modalSMSend.isDisplayed() && modalSMCancel.isDisplayed())
        {
            System.out.println("Reply Modal loaded properly.");
        }
        else {
            Assert.fail("Modal not loaded properly.");
        }
        modalSMCancel.waitClickable().click();
    }

    public void deleteMessage(){
        lastDeleteBtn.waitClickable().click();
        btnYes.waitClickable().click();
        btnOk.waitClickable().click();
    }

    public void sendReply() {
        lastReplyButton.waitClickable().click();
        tbModalSMSubject.waitClickable().sendKeys("Subject for send reply tb.");
        tbModalSMMsg.waitClickable().sendKeys("Message in Post message modal.");
        modalSMSend.waitClickable().click();
        waitLoad();
        System.out.println("**********************************\n");
        System.out.println("Message for sending reply is:");
        String strErrortext = _webDriverHandler.byId("swal2-content").waitVisible().getText();
        System.out.println(strErrortext);
        btnOk.waitClickable().click();
    }

    public void switchUser(String access) {
        stop();
        linkAdministrator.waitClickable(10,100).click();
        tabUsers.waitClickable().click();
        waitLoad();
        String user = _prop.getProperty("value.AdminUser");
        searchUser.sendKeys(user);
        waitLoad();
        _webDriverHandler.byXpath("//*[@id='userTable']//tr[td[text()='"+user+"']]").click();
        ddRole.selectByText(access);
        btnSave.waitClickable().click();
        waitLoad();
        btnOk.waitClickable().click();
        linkHome.waitClickable().click();
        linkAllApps.waitClickable().click();
        autoII.waitClickable().click();
    }

    public void errorValidations(){
//        btnSend.waitClickable().click();
//        Assert.assertEquals(msgSend.getText(), strErrorMessage, "Error messages do not match.");
//        System.out.println("Error message for post is: " + msgSend.getText());
        btnPostMsg.waitClickable().click();
        modalPostSend.waitClickable().click();
        Assert.assertEquals(msgPost.getText(), strErrorPostMessage, "Error messages do not match.");
        System.out.println("Error message for post message modal is: " + msgPost.getText());
        modalPostCancel.waitClickable().click();
        //lastReplyButton.waitClickable().click();
        //modalSMSend.waitClickable().click();
        //Assert.assertEquals(msgReplySub.getText(), strErrorReplySubject, "Error messages do not match.");
        //Assert.assertEquals(msgReplyText.getText(), strErrorReplyMessage, "Error messages do not match.");
        //System.out.println("Error messages for send reply modal are: " + msgReplySub.getText()+"\n"+ msgReplyText.getText());
        //modalSMClose.waitClickable().click();
    }

    public void errorValidationsCustomer(){
        btnSend.waitClickable().click();
        Assert.assertEquals(msgSend.getText(), strErrorMessage, "Error messages do not match.");
        System.out.println("Error message for post is: " + msgSend.getText());
        lastReplyButton.waitClickable().click();
        modalSMSend.waitClickable().click();
        Assert.assertEquals(msgReplySub.getText(), strErrorReplySubject, "Error messages do not match.");
        Assert.assertEquals(msgReplyText.getText(), strErrorReplyMessage, "Error messages do not match.");
        System.out.println("Error messages for send reply modal are: " + msgReplySub.getText()+"\n"+ msgReplyText.getText());
        modalSMClose.waitClickable().click();
    }

    public void verifySuper() {
        if(
                btnSend.notPresent() &&
                tbMsg.notPresent() &&
                lastReplyButton.notPresent()
        )
        {
            System.out.println("Only Super User functionality is available.");
        }
        else {
            Assert.fail("Super user permissions are not working.");
        }
    }

    public void verifyCustomer() {
        Assert.assertEquals(autoIIHeader.getText(), "Instant Insights", "Application Header does not match.");
        Assert.assertEquals(autoIISubHeader.getText(), "Wholesale Energy Market Monitor ", "Application Sub Header does not match.");
        System.out.println("Application Headers match.");
        if(searchMsg.isDisplayed() &&
                ddHashTag.isDisplayed() &&
                ddPeriod.isDisplayed() &&
                btnSend.isDisplayed() &&
                tbMsg.isDisplayed() &&
                lastReplyButton.isDisplayed() &&
                characterCountSend.isDisplayed())
        {
            System.out.println("Auto Instant insight page is loaded properly.");
        }
        else {
            Assert.fail("Page not loaded properly.");
        }
        if(
                btnPostMsg.notPresent() &&
                        lastDeleteBtn.notPresent()
        )
        {
            System.out.println("Only Customer functionality is available.");
        }
        else {
            Assert.fail("Customer user permissions are not working.");
        }
    }

    public void verifyActive() {
        if(
                btnPostMsg.notPresent() &&
                lastDeleteBtn.notPresent()
        )
        {
            System.out.println("Only Active User functionality is available.");
        }
        else {
            Assert.fail("Active user permissions are not working.");
        }
    }

    public void verifyPassive() {
        if(
                btnSend.notPresent() &&
                tbMsg.notPresent() &&
                lastReplyButton.notPresent() &&
                btnPostMsg.notPresent() &&
                lastDeleteBtn.notPresent()
        )
        {
            System.out.println("Only Passive User functionality is available.");
        }
        else {
            Assert.fail("Passive user permissions are not working.");
        }
    }

    public void stop() {
        Assert.assertEquals(autoIIHeader.getText(), "Instant Insights", "Application Header does not match.");
        Assert.assertEquals(autoIISubHeader.getText(), "Wholesale Energy Market Monitor ", "Application Sub Header does not match.");
        Assert.assertEquals(autoIIHeader.getText(), "Instant Insights", "Application Header does not match.");
        Assert.assertEquals(autoIISubHeader.getText(), "Wholesale Energy Market Monitor ", "Application Sub Header does not match.");
        searchMsg.isDisplayed(); ddHashTag.isDisplayed(); ddPeriod.isDisplayed();
        searchMsg.isDisplayed(); ddHashTag.isDisplayed(); ddPeriod.isDisplayed();
        ddPeriod.waitClickable().click();
        ddHashTag.waitClickable().click();
        Assert.assertEquals(autoIIHeader.getText(), "Instant Insights", "Application Header does not match.");
        Assert.assertEquals(autoIISubHeader.getText(), "Wholesale Energy Market Monitor ", "Application Sub Header does not match.");
        Assert.assertEquals(autoIIHeader.getText(), "Instant Insights", "Application Header does not match.");
        Assert.assertEquals(autoIISubHeader.getText(), "Wholesale Energy Market Monitor ", "Application Sub Header does not match.");
        searchMsg.isDisplayed(); ddHashTag.isDisplayed(); ddPeriod.isDisplayed();
        searchMsg.isDisplayed(); ddHashTag.isDisplayed(); ddPeriod.isDisplayed();
        ddPeriod.waitClickable().click();
        ddHashTag.waitClickable().click();
    }

    public void waitLoad() {
        _webDriverHandler.byXpath("//*[@id='overlay']").waitVisible(30,100).waitInvisible(60,100);
    }
}
