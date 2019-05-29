package com.sofia.cucumber;

import com.sofia.businesslayer.HomeEmailPageBO;
import com.sofia.businesslayer.LoginBO;
import com.sofia.utilmanager.driver.DriverManager;
import com.sofia.utilmanager.property.Property;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static com.sofia.utilmanager.jsonparser.JsonParser.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class loginAndUndoDeleteStepDef {
    private static final int CHECKBOX_AMOUNT = getCheckboxAmount();
    private static HomeEmailPageBO homePage = new HomeEmailPageBO();

    @Given("^login page is open$")
    public void setStartedPage() {
        DriverManager.getDriverInstance().get(Property.getProperty("login_page"));
    }

    @Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersUsernameAndPassword(String arg0, String arg1) {
        LoginBO signIn = new LoginBO();
        assertEquals(signIn.loginIntoAccount(arg0, arg1), arg0);
    }

    @Then("^home page loads, user check few emails and delete them$")
    public void homePageLoadsUserCheckFewEmailsAndDeleteThem() {
        assertTrue(homePage.deleteCheckedEmails(CHECKBOX_AMOUNT));
    }

    @Then("^user click on Undo button and emails are not deleted$")
    public void userClickOnUndoButton() {
        assertTrue(homePage.undoEmailDeletion().matches("^[^ .]+ .+\\.$"));
    }
}
