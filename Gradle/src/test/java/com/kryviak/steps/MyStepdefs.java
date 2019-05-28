package com.kryviak.steps;

import com.kryviak.config.DriverThreadInit;
import com.kryviak.loginBO.LoginBO;
import com.kryviak.mailboxBO.MailboxBO;
import com.kryviak.models.MessageModel;
import com.kryviak.models.UserModel;
import com.kryviak.utils.XmlParser;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class MyStepdefs {

    XmlParser parser = new XmlParser();
    MailboxBO mailboxBO = new MailboxBO();
    UserModel userModel = new UserModel();
    LoginBO loginBO = new LoginBO();
    MessageModel messageModel;

    @Given("Message data")
    public void message_ata() {
        messageModel = parser.getMessageModelData();
    }

    @When("I enter correct {string} and {string}")
    public void iEnterCorrectAnd(String arg0, String arg1) {
        userModel.setUserLogin(arg0);
        userModel.setUserPassword(arg1);
    }

    @Then("Login Successfully")
    public void loginSuccessfully() {
        loginBO.login(userModel);
    }

    @When("I send message")
    public void iSendMessage() {
        mailboxBO.sendLetter(messageModel);
    }

    @Then("Delete the message")
    public void deleteTheMessage() {
        mailboxBO.deleteSentLetter(messageModel.getSubjectTo());
    }

    @And("Check if message sent")
    public void checkIfMessageSent() {
        Assert.assertTrue(mailboxBO.isMessageSent(messageModel.getSubjectTo()), "Message with subject [" +
                messageModel.getSubjectTo() + "] was not sent.");
    }

    @Then("Close browser")
    public void closeBrowser() {
        DriverThreadInit.getInstance().removeDriver();
    }
}
