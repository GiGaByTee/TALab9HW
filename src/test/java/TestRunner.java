import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DriverManager;

@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"src/test/java/stepDefinition"}
//        format = {
//                "pretty",
//                "html:target/cucumber-reports/cucumber-pretty",
//                "json:target/cucumber-reports/CucumberTestReport.json",
//                "rerun:target/cucumber-reports/rerun.txt"}
)
public class TestRunner {

    private static Logger LOG = Logger.getLogger(TestRunner.class.getName());

    @Before
    public void initializeTest() {
        DriverManager.getWebDriver().get("https://www.gmail.com");
    }

    @After
    public void driverTearDown(Scenario scenario) {
        DriverManager.closeDriver();
        LOG.info("Browser closed");
    }
}