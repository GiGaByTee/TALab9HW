package business;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pom.GmailHomePage;
import pom.GmailImportantPage;
import util.DriverManager;

public class MarkAndDeleteImportantMessageBO {

    private GmailHomePage gmailHomePage = new GmailHomePage();
    private GmailImportantPage gmailImportantPage = new GmailImportantPage();
    private static Logger LOG = Logger.getLogger(MarkAndDeleteImportantMessageBO.class.getName());

    public void markImportantMessages() throws InterruptedException {
        gmailHomePage.markMessagesAsImportant();
        DriverManager.refreshPage();
        LOG.info("3 conversation marked as important");
    }
    public void clickImportantButton(){
      gmailImportantPage.clickImporatantButton();
    }

//    public void chooseImportantMessages() {
//        gmailImportantPage.chooseSomeImportantMessages();
//        LOG.info("Messages was choosen");
//    }

    public void deleteImportantMessages() {
        gmailImportantPage.clickDeleteButton();
        LOG.info("Conversations are deleted");
    }


    public boolean messagesMarkedAsImportant() {
        return gmailHomePage.conversationWasMarked();
    }

    public boolean messagesDeleted() {
        return gmailImportantPage.verifyDeleteMessages();
    }



    public void chooseImportantMessages() throws InterruptedException {
        gmailHomePage.markMessagesAsImportant();
        LOG.info("3 conversation marked as important");
    }

    public void deleteSomeImportantMessages(){
        gmailImportantPage.chooseSomeImportantMessages();
        LOG.info("Messages was choosen");
        gmailImportantPage.clickDeleteButton();
        LOG.info("Conversations are deleted");
    }




}
