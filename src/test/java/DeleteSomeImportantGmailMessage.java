import business.AutorizationBO;
import business.MarkAndDeleteImportantMessageBO;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.readers.UserData;

public class DeleteSomeImportantGmailMessage extends FunctionalTest {
    private static Logger LOG = Logger.getLogger(DeleteSomeImportantGmailMessage.class.getName());


    @Test(dataProvider = "user")
    public void chooseSomeImportantMessagesAndDeleteThem(UserData userData) throws InterruptedException {
        AutorizationBO autorizationBO = new AutorizationBO();
        MarkAndDeleteImportantMessageBO markAndDeleteImportantMessageBO = new MarkAndDeleteImportantMessageBO();

       autorizationBO.userEnterEmailAndClickNextButtton(userData.getUserEmail());
        Assert.assertTrue(autorizationBO.verifyUserEnterCorrectEmail() , "Gmail Password Page is visible");
        autorizationBO.userEnterPasswordAndClickNextButton(userData.getPassword());
        Assert.assertTrue(autorizationBO.verifyLogInSuccessful(), "User autorize successful");

        markAndDeleteImportantMessageBO.chooseImportantMessages();
        Assert.assertTrue(markAndDeleteImportantMessageBO.messagesMarkedAsImportant(), "Messages is marked");
        markAndDeleteImportantMessageBO.clickImportantButton();
        markAndDeleteImportantMessageBO.deleteSomeImportantMessages();
        Assert.assertTrue(markAndDeleteImportantMessageBO.messagesDeleted() , "Conversation moved to Trash.");
    }
}
