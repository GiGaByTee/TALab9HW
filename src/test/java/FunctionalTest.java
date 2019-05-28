import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import util.DriverManager;
import util.Listener;
import util.readers.CSVReaders;
import util.readers.JsonReader;

import java.io.FileNotFoundException;
import java.io.IOException;


@Listeners(Listener.class)
public class FunctionalTest {
    private CSVReaders csvReaders = new CSVReaders();
    private JsonReader jsonReader = new JsonReader();
    private static Logger LOG = Logger.getLogger(FunctionalTest.class.getName());

    @BeforeMethod
    public void setURL() throws IOException {
        DriverManager.getWebDriver().get("https://www.gmail.com");
        LOG.info("Web application launched");
        Assert.assertEquals(DriverManager.getWebDriver().getTitle(), "Gmail");

    }

    @AfterMethod
    public void driverTearDown() {
        DriverManager.closeDriver();
        LOG.info("Browser closed");
    }

    @DataProvider(parallel = true)
    public Object[] user() throws FileNotFoundException {
        return jsonReader.getData();
    }

    @Test
    public void takeScreenshotTest() {
        Assert.assertEquals(true, false);
    }
}
