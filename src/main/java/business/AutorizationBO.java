package business;

import org.apache.log4j.Logger;
import org.testng.Assert;
import pom.LoginPage;

public class AutorizationBO {
    private LoginPage loginPage = new LoginPage();
    private static Logger LOG = Logger.getLogger(AutorizationBO.class.getName());


    public void userEnterEmailAndClickNextButtton(String email){
        LOG.info("User enter email" + email+ " in the login text box");
        loginPage.typeLoginAndSubmit(email);
        loginPage.clickNextButtonInGmailPage();
    }

    public void userEnterPasswordAndClickNextButton(String password){
        LOG.info("Password enter password" + password+ "in the Password text box");
        loginPage.typePassword(password);
        loginPage.clickButtonOnPasswordPage();
    }

    public boolean verifyLogInSuccessful()
    {
       return loginPage.userLogInSuccessful();
    }

    public boolean verifyUserEnterCorrectEmail(){
        return loginPage.verifyUserEnterCorrectEmail();
    }




}
